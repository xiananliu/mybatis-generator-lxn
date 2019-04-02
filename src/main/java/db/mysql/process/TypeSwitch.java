package db.mysql.process;

/**
 * @author mymx.jlh
 * @version 1.0.0 2018/2/13 10:13
 */
public interface TypeSwitch {

    String transfer(String typeName);

    String isBetween(String typeName);

    String changeType(String typeName);

}
