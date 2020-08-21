package pl.rex89m.MySQL;

import java.sql.Connection;
import java.util.HashMap;

public class MySQL {

    private int id;

    private Connection connection;

    private String host;

    private String pass;

    private int port;

    private String user;

    private String DB;

    public int getId() {
        return id;
    }

    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    static HashMap<Integer, MySQL> mySQLHashMap = new HashMap<>();

    public MySQL(int id, String user, String host,String DB, String pass, int port){
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.user = user;
        this.DB = DB;
        this.id = id;
        if (!mySQLHashMap.containsKey(id)){
            mySQLHashMap.put(id, this);
        }
    }

    public static MySQL get(int id){
        return mySQLHashMap.get(id);
    }

}
