package db.mysql.process;

/**
 * @author mymx.jlh
 * @version 1.0.0 2018/2/13 10:16
 */
public class PostgreTypeSwitch implements TypeSwitch {
    @Override
    public String transfer(String typeName) {
        typeName = typeName.replaceAll(" UNSIGNED", "").toUpperCase();
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
                return "String";
            case "INT8":
                return "Long";
            case "INT4":
                return "Integer";
            case "INT2":
                return "Integer";
            case "BOOL":
                return "Boolean";
            case "FLOAT4":
                return "Float";
            case "FLOAT8":
                return "Double";
            case "BIGSERIAL":
                return "Long";
            case "SERIAL":
                return "Integer";
            default:
                return "Object";
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
                return "no";
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
                return "no";
        }
    }

    @Override
    public String changeType(String typeName) {
        typeName = typeName.replaceAll(" UNSIGNED", "").toUpperCase();
        switch (typeName) {
            case "TINYINT":
                return "int";
            case "SMALLINT":
                return "int";
            case "MEDIUMINT":
                return "int";
            case "DOUBLE":
                return "DECIMAL";
            case "MEDIUMTEXT":
                return "TEXT";
            case "LONGTEXT":
                return "TEXT";
            case "BIT":
                return "BIT";
            case "BOOL":
                return "BOOLEAN";
            case "BIGSERIAL":
                return "BIGINT";
            case "SERIAL":
                return "int";
            default:
                return typeName;
        }
    }
}