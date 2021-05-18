import java.sql.*;

public class Admin extends Person{
    public void insertTeacher(String login, String password, String name, String surname, String academic_degree, String administrative_position, int work_experience){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            statement.execute("Insert into Person (login, password, name, surname, academic_degree, administrative_position, work_experience) values ('" + login + "', '" + password + "', '" + name + "', '" + surname + "', '" + academic_degree + "', '" + administrative_position + "', '" + work_experience + "')");
            System.out.println("Teacher added");

            statement.close();
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void insertSubject(String name, int hours){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            statement.execute("Insert into Subject (name, hours) values ('" + name + "', '" + hours + "')");
            System.out.println("Subject added");

            statement.close();
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void insertGroups(String name, int quantity){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            statement.execute("Insert into Groups (name, quantity) values ('" + name + "', '" + quantity + "')");
            System.out.println("Group added");

            statement.close();
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
