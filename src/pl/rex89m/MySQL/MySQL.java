package pl.rex89m.MySQL;

import java.sql.Connection;
import java.util.HashMap;

public class MySQL {

    int id;

    Connection connection;

    String host;

    String pass;

    int port;

    String user;

    public int getId() {
        return id;
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


    static public void MySQL(){

    }

}
