import java.sql.*;

public abstract class Person {
    public boolean isConnect(String login, String password) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            if(statement.executeQuery("Select count(*) from Person where login = '" + login + "' and password = '" + password + "'").getInt(1) > 0)
                System.out.println(this.getClass() + " connected");
            else
                return false;

            statement.close();
            co.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}