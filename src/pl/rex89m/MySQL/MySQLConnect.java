package pl.rex89m.MySQL;

import java.sql.*;
import java.util.HashMap;

public class MySQLConnect{

    private int id;

    private static Connection connection;

    private static HashMap<Integer, Connection> connectionHashMap = new HashMap<>();

    public Object MySQLget (String nazwa_Tabelki, String nazwa_kolumny, String Where, Object walue){
        Object value = null;
        PreparedStatement statement;
        try {
            statement = connectionHashMap.get(id).prepareStatement("SELECT "+nazwa_kolumny+" FROM "+nazwa_Tabelki+" WHERE "+Where+"='"+walue+"'");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                value = result.getObject(nazwa_kolumny);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void connect(int id) {
        try {
            MySQL mySQL = MySQL.get(id);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + mySQL.getHost() + ":3306/" + mySQL.getDB(), mySQL.getUser(), mySQL.getPass());
           // System.out.println(ChatColor.GREEN + "!!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (!connectionHashMap.containsKey(id)) {
            connectionHashMap.put(id, connection);
        }
    }

    public MySQLConnect(int id){
        this.id = id;
        connect(id);
    }
    public MySQLConnect(int id, String user, String host, String DB, String pass, int port){
        new MySQL(id, user, host, DB, pass, port);
        this.id = id;
        connect(id);
    }
}
