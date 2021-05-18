import java.sql.*;

public class Teacher extends Person {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String academic_degree;
    private String administrative_position;
    private int work_experience;
    private int value;

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public Teacher(int value) {
        this.value = value + 1;
    }

    public void set(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT * FROM Person");
            while(resSet.next())
            {
                if(value != 0){
                    value--;
                    continue;
                }
                login = resSet.getString("login");
                password = resSet.getString("password");
                name = resSet.getString("name");
                surname = resSet.getString("surname");
                academic_degree = resSet.getString("academic_degree");
                administrative_position = resSet.getString("administrative_position");
                work_experience = resSet.getInt("work_experience");
                System.out.println("Teacher set");
                break;
            }

            resSet.close();
            statement.close();
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", academic_degree='" + academic_degree + '\'' +
                ", administrative_position='" + administrative_position + '\'' +
                ", work_experience=" + work_experience +
                '}';
    }
    public void printInfo(){
        System.out.println(toString());
    }
}