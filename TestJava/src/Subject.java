import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Subject {
    private String name;
    private int hours;
    private int value;

    public String getName() {
        return name;
    }

    public Subject(int value) {
        this.value = value;
    }

    public void set(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT * FROM Subject");
            while(resSet.next())
            {
                if(value != 0){
                    value--;
                    continue;
                }
                name = resSet.getString("name");
                hours = resSet.getInt("hours");
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
        return "Subject{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                '}';
    }
    public void printInfo(){
        System.out.println(toString());
    }
}
