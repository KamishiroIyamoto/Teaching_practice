import java.io.*;
import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Admin a = new Admin();
        if (a.isConnect("Admin","Admin")) {
            System.out.println();
            String[] arr;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Teacher.txt"));
                String line = reader.readLine();
                while (line != null) {
                    arr = line.split(" ");
                    if(arr.length == 7) {
                        boolean check = true;
                        for (String str : arr)
                            if(str.equals("") || str.equals("0")){
                                System.out.println("Поля не должный быть пустыми!");
                                check = false;
                            }
                        if(check) {
                            try {
                                a.insertTeacher(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], Integer.parseInt(arr[6]));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else
                        System.out.println("Количество полей не равно 7!");
                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();

            try {
                BufferedReader reader = new BufferedReader(new FileReader("Subject.txt"));
                String line = reader.readLine();
                while (line != null) {
                    arr = line.split(" ");
                    if(arr.length == 2) {
                        boolean check = true;
                        for (String str : arr)
                            if(str.equals("") || str.equals("0")){
                                System.out.println("Поля не должный быть пустыми!");
                                check = false;
                            }
                        if(check) {
                            try {
                                a.insertSubject(arr[0], Integer.parseInt(arr[1]));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else
                        System.out.println("Количество полей не равно 2!");
                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();

            try {
                BufferedReader reader = new BufferedReader(new FileReader("Groups.txt"));
                String line = reader.readLine();
                while (line != null) {
                    arr = line.split(" ");
                    if(arr.length == 2) {
                        boolean check = true;
                        for (String str : arr)
                            if(str.equals("") || str.equals("0")){
                                System.out.println("Поля не должный быть пустыми!");
                                check = false;
                            }
                        if(check) {
                            try {
                                a.insertGroups(arr[0], Integer.parseInt(arr[1]));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else
                        System.out.println("Количество полей не равно 2!");
                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Admin no connected");
        System.out.println();

        int s1 = -1, s2 = 0, s3 = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:db.db");

            Statement statement = co.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT * FROM Person");
            while(resSet.next())
                s1++;
            resSet.close();

            resSet = statement.executeQuery("SELECT * FROM Subject");
            while(resSet.next())
                s2++;
            resSet.close();

            resSet = statement.executeQuery("SELECT * FROM Groups");
            while(resSet.next())
                s3++;
            resSet.close();

            statement.close();
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(s1 == s2 && s1 == s3) {
            Teacher[] teachers = new Teacher[s1];
            for (int i = 0; i < teachers.length; i++)
                teachers[i] = new Teacher(i);
            for (Teacher t : teachers) {
                t.set();
                t.printInfo();
            }
            System.out.println();

            Subject[] subjects = new Subject[s2];
            for (int i = 0; i < subjects.length; i++) {
                subjects[i] = new Subject(i);
                subjects[i].set();
                subjects[i].printInfo();
            }
            System.out.println();

            Groups[] groups = new Groups[s3];
            for (int i = 0; i < groups.length; i++) {
                groups[i] = new Groups(i);
                groups[i].set();
                groups[i].printInfo();
            }
            System.out.println();
            System.out.println();

            try(FileWriter writer = new FileWriter("result.txt", true)) {
                for (int i = 0; i < s1; i++) {
                    System.out.println("Преподаватель " + teachers[i].getSurname() + " " + teachers[i].getName() + " проводит занятия по " + subjects[i].getName() + " с " + groups[i].getName());
                    writer.write("Преподаватель " + teachers[i].getSurname() + " " + teachers[i].getName() + " проводит занятия по " + subjects[i].getName() + " с " + groups[i].getName() + "\n");
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
        else
            System.out.println("Невозможно составить расписание!");
    }
}
