package pl.rex89m.MySQL;

import java.sql.*;
import java.util.HashMap;

public class MySQLConnect{

    private int id;

    private static Connection connection;

    private static HashMap<Integer, Connection> connectionHashMap = new HashMap<>();

    //Get

    public Object get (String nazwa_kolumny, String nazwa_Tabelki, String Where, Object walue){
        Object value = null;
        PreparedStatement statement;
        try {
            statement = connectionHashMap.get(id).prepareStatement("SELECT `"+nazwa_kolumny+"` FROM `"+nazwa_Tabelki+"` WHERE `"+Where+"`='"+walue+"'");
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
    //is

    public Boolean is(String nazwa_kolumny, String nazwa_Tabelki, String Where, Object value1, Object value2) {
        String rezult ="";
        PreparedStatement statement;
        try {
            statement = connectionHashMap.get(id).prepareStatement("SELECT `"+nazwa_kolumny+"` FROM `"+nazwa_Tabelki+"` WHERE `"+Where+"`='"+value1+"'");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                rezult = result.getString(nazwa_kolumny);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rezult.equals(value2)) {
            return true;
        }else{
            return false;
        }
    }

    public Boolean is(String nazwa_kolumny, String nazwa_Tabelki, String Where, Object value1, String value2, Boolean equalsIgnoreCase) {
        String rezult ="";
        PreparedStatement statement;
        try {
            statement = connectionHashMap.get(id).prepareStatement("SELECT `"+nazwa_kolumny+"` FROM `"+nazwa_Tabelki+"` WHERE `"+Where+"`='"+value1+"'");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                rezult = result.getString(nazwa_kolumny);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (equalsIgnoreCase) {
            if (rezult.equalsIgnoreCase(value2)){
                return true;
            }
            else {
                return false;
            }
        }else {
            if (rezult.equals(value2)) {
                return true;
            }else{
                return false;
            }
        }
    }

    //Insert, set

    public void add(String nazwa_Tabelki, Object value1, String value2){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `"+nazwa_Tabelki+"` "+value1+" VALUES "+value2+"");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update

    public void update(String nazwa_kolumny, String nazwa_Tabelki, Object value1,String Where, String value2){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `"+nazwa_Tabelki+"` SET `"+nazwa_kolumny+"` = '"+value1+"' WHERE (`"+Where+"` = '"+value2+"')");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }











    public Connection getcon(){
        return connectionHashMap.get(id);
    }

    public static void connect(int id) {
        try {
            MySQL mySQL = MySQL.get(id);

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + mySQL.getHost() + ":"+mySQL.getPort()+"/" + mySQL.getDB(), mySQL.getUser(), mySQL.getPass());
           // System.out.println(ChatColor.GREEN + "!!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("!!!");
        }
        if (!connectionHashMap.containsKey(id)) {
            connectionHashMap.put(id, connection);
        }
    }

    public Boolean isid(int id){
        for (Integer integer: connectionHashMap.keySet()){
            if (integer==id){
                return true;
            }
        }
        return false;
    }

    public MySQLConnect(int id){
        if (!isid(id)){
            throw new IllegalArgumentException("Nie ma takiego id");
        }else{
            this.id = id;
            connect(id);
        }
    }
    public MySQLConnect(int id, String user, String host, String DB, String pass, int port){
        new MySQL(id, user, host, DB, pass, port);
        this.id = id;
        connect(id);
    }
    public MySQLConnect(int id, String user, String host, String DB, String pass){
        new MySQL(id, user, host, DB, pass, 3306);
        this.id = id;
        connect(id);
    }
}
