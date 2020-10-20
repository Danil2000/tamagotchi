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
        System.out.println(name);
        userExist = checkUser(name);
        System.out.println(userExist);
        if(userExist == false){
            createTable(name);
        }
        else {
            System.out.println("user exist");
        }
    }
    public void createTable(String name)  {
        try {
            //stmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
            stmt.execute("insert into 'users'('name') values('"+ name +"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean checkUser(String name) throws SQLException {
       rs = stmt.executeQuery("select id from users");
       while (rs.next()) {
           if (name.equals(rs.getString("name"))) {
               return true;
           }
       }
       return false;
    }
}
