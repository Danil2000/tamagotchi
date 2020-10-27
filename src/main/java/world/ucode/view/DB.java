package world.ucode.view;

import world.ucode.Controlers.GameController;
import world.ucode.Controlers.PetController;

import java.sql.*;

public class DB {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private boolean userExist = false;

    public void getConnection(String name) throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:Tamagotchi.s3db");
        stmt = con.createStatement();
        checkUser(name);
    }
    public void createTable(String name)  {
        System.out.println();
        PetController pet = Main.loader2.getController();
        System.out.println("ofiof");
        try {
            stmt.execute("insert into users('name', 'health', 'happiness', 'thirst', 'hunger', 'cleanliness', 'pet_image') values('"+ name +"', 0, 0, 0, 0, 0, '" + pet.index +"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void checkUser(String name) throws SQLException {
       rs = stmt.executeQuery("select * from users");
       int index = 0;
       while (rs.next()) {
           index++;
           if (name.equals(rs.getString("name"))) {
               getData(name);
               return;
           }
       }
        createTable(name);
    }
    public void updateTable(String name) throws SQLException {
        String sql = "update users  set health = ?," + "happiness = ?," + "thirst = ?, " + "hunger = ?,"
                + "cleanliness = ? where name = ?;";
        if(GameController.health >= 0 && GameController.cleanless >= 0 &&
                GameController.hunger >= 0 && GameController.thirst >= 0 &&
                GameController.happiness >= 0) {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(6, name);
            pstmt.setDouble(1, GameController.health);
            pstmt.setDouble(2, GameController.happiness);
            pstmt.setDouble(3, GameController.thirst);
            pstmt.setDouble(4, GameController.hunger);
            pstmt.setDouble(5, GameController.cleanless);
            pstmt.executeUpdate();
        }
        else {
            System.out.println("looser");
            return;
        }
    }

    public void getData(String name) throws SQLException {
        String sql = "select * from users where name = '" + name + "';";
        rs = stmt.executeQuery(sql);
        GameController.health = rs.getDouble("health");
        GameController.happiness = rs.getDouble("happiness");
        GameController.thirst = rs.getDouble("thirst");
        GameController.hunger = rs.getDouble("hunger");
        GameController.cleanless = rs.getDouble("cleanliness");
        GameController game = Main.loader3.getController();
        game.setProgressBars(GameController.health, GameController.happiness, GameController.thirst, GameController.cleanless, GameController.hunger);
        game.img.setImage(PetController.imgs[rs.getInt("pet_image")]);
        System.out.println(rs.getInt("pet_image"));
    }


}
