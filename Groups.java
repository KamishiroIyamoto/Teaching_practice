import java.sql.*;

public class Groups{
    private String name;
    private int quantity;
    private int value;

    public String getName() {
        return name;
    }

    public Groups(int value) {
        this.value = value;
    }

    public void set(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT * FROM Groups");
            while(resSet.next())
            {
                if(value != 0){
                    value--;
                    continue;
                }
                name = resSet.getString("name");
                quantity = resSet.getInt("quantity");
                System.out.println("Group set");
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
        return "Groups{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    public void printInfo(){
        System.out.println(toString());
    }
}
