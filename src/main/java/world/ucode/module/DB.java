package world.ucode.module;

import java.sql.*;

public class DB {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private boolean userExist = false;

    public void getConnection(String name) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:Tamagotchi.s3db");
        stmt = con.createStatement();
        checkUser(name);
        //checkUser(name);
    }
    public void createTable(String name)  {
        try {
            //stmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
            stmt.execute("insert into 'users'('name', 'health', 'happiness', 'thirst', 'hunger', 'cleanliness') values('"+ name +"', 0, 0, 0, 0, 0);");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void checkUser(String name) throws SQLException {
       rs = stmt.executeQuery("select * from users");
       while (rs.next()) {
           if (name.equals(rs.getString("name"))) {
               System.out.println("user exist");
               return;
           }
       }
        createTable(name);
    }
}
