package db.mysql.process;

/**
 * db.mysql
 * Created by ASUS on 2017/7/16.
 * 10:37
 */
public class MysqlTypeSwitch implements TypeSwitch {
    public String transfer(String typeName) {
        typeName = typeName.replaceAll(" UNSIGNED", "");
        switch (typeName) {
            case "VARCHAR":
                return "String";
            case "CHAR":
                return "String";
            case "TEXT":
                return "String";
            case "INTEGER":
                return "Long";
            case "BIGINT":
                return "Long";
            case "TINYINT":
                return "Integer";
            case "SMALLINT":
                return "Integer";
            case "MEDIUMINT":
                return "Integer";
            case "INT":
                return "Integer";
            case "FLOAT":
                return "Float";
            case "DOUBLE":
                return "Double";
            case "DECIMAL":
                return "java.math.BigDecimal";
            case "DATE":
                return "java.time.LocalDate";
            case "TIME":
                return "java.time.LocalTime";
            case "TIMESTAMP":
                return "java.time.LocalDateTime";
            case "MEDIUMTEXT":
                return "String";
            case "LONGTEXT":
                return "String";
            case "DATETIME":
                return "java.time.LocalDateTime";
            case "BIT":
                return "Integer";
            default:
                throw new IllegalArgumentException(typeName + " no such typeName,please edit db.mysql.process.TypeSwitch");
        }
    }

    @Override
    public String isBetween(String typeName) {
        typeName = typeName.replaceAll(" UNSIGNED", "").toUpperCase();
        switch (typeName) {
            case "VARCHAR":
                return "no";
            case "CHAR":
                return "no";
            case "TEXT":
                return "no";
            case "INTEGER":
                return "yes";
            case "BIGINT":
                return "yes";
            case "TINYINT":
                return "yes";
            case "SMALLINT":
                return "yes";
            case "MEDIUMINT":
                return "yes";
            case "INT":
                return "yes";
            case "FLOAT":
                return "yes";
            case "DOUBLE":
                return "yes";
            case "DECIMAL":
                return "yes";
            case "DATE":
                return "yes";
            case "TIME":
                return "yes";
            case "TIMESTAMP":
                return "yes";
            case "MEDIUMTEXT":
                return "no";
            case "LONGTEXT":
                return "no";
            case "DATETIME":
                return "yes";
            case "BIT":
                return "yes";
            case "INT8":
                return "yes";
            case "INT4":
                return "yes";
            case "INT2":
                return "yes";
            case "BOOL":
                return "no";
            case "FLOAT4":
                return "yes";
            case "FLOAT8":
                return "yes";
            case "BIGSERIAL":
                return "yes";
            case "SERIAL":
                return "yes";
            default:
                throw new IllegalArgumentException(typeName + " no such typeName,please edit db.mysql.process.TypeSwitch");
        }
    }

    @Override
    public String changeType(String typeName) {
        return null;
    }
}
