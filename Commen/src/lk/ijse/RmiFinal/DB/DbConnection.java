package lk.ijse.RmiFinal.DB;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    public DbConnection() throws SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        FileReader fileReader=new FileReader("/home/buddhika/Documents/new_RMI Final/Commen/src/lk/ijse/RmiFinal/DB/property.properties");
        Properties properties=new Properties();
        properties.load(fileReader);
        String ip=properties.getProperty("ip");
        String port=properties.getProperty("port");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String db=properties.getProperty("db");
        String jdbcUrl = "jdbc:mysql://" + ip + ":" + port + "/" + db;

        connection= DriverManager.getConnection(jdbcUrl,user,password);
    }

    public static DbConnection getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (dbConnection==null){
            dbConnection=new DbConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
