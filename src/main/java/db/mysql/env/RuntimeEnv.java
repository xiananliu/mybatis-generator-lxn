package db.mysql.env;

import com.alibaba.fastjson.JSON;
import db.mysql.model.ProducerParam;
import db.mysql.process.MysqlCommon;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;

/**
 * db.mysql
 *
 * @author ASUS
 * @date 2017/10/20 16:21
 */
public class RuntimeEnv {
    public static ProducerParam pp;

    public static MysqlCommon mc;

//    public static final String storagePath = System.getProperty("user.home").replaceAll("\\\\","/")+"/";
    public static final String ppEnv = "ppEnv.json";
    public static String storagePath = null;

    static {
        String path = RuntimeEnv.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = path.lastIndexOf(File.separator) + 1;
        storagePath = path.substring(firstIndex, lastIndex);
        System.out.println("配置文件路径："+storagePath+ppEnv);
    }


    /**
     * 绝对路径转相对路径
     * @param absolute
     * @return
     */
    public static String getRelativizePath(String absolute){
        Path path1 = new File(absolute).toPath();
        Path path2 = new File(storagePath).toPath();
        return path2.relativize(path1).toString();
    }



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
