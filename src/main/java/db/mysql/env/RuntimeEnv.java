package db.mysql.env;

import com.alibaba.fastjson.JSON;
import db.mysql.model.ProducerParam;
import db.mysql.process.MysqlCommon;

import java.io.*;

/**
 * db.mysql
 *
 * @author ASUS
 * @date 2017/10/20 16:21
 */
public class RuntimeEnv {
    public static ProducerParam pp;

    public static MysqlCommon mc;

    public static final String storagePath = System.getProperty("user.home").replaceAll("\\\\","/")+"/";

    public static final String ppEnv = "ppEnv.json";

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void storage()  {
        try {
            if (RuntimeEnv.pp != null) {
                System.out.println(storagePath);
                File file = new File(storagePath + ppEnv);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter writer = new FileWriter(file);
                writer.write(JSON.toJSONString(RuntimeEnv.pp, true));
                writer.flush();
                writer.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void reader() throws IOException {
        File file = new File(storagePath + ppEnv);
        if (!file.exists()) {
            RuntimeEnv.pp = new ProducerParam();
            storage();
            return;
        }
        FileReader reader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        char buff[] = new char[2048];
        while (reader.read(buff) != -1) {
            stringBuilder.append(buff);
        }
        RuntimeEnv.pp = JSON.parseObject(stringBuilder.toString(), ProducerParam.class);
        reader.close();
    }
}
