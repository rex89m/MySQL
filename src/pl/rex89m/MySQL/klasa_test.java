package pl.rex89m.MySQL;

import java.sql.SQLException;

public class klasa_test {

    static MySQLConnect mySQLConnect = new MySQLConnect(1, "skyblockdb", "31.42.14.111", "SkyBlock","Mateusz14",3306);

    public static void main(String[] args) {

        try {
            System.out.println(mySQLConnect.getcon().isReadOnly());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
