public class Test {
    public static void main(String[] args) {
        Admin a = new Admin();
        if (a.isConnect("Admin","Admin")) {
            a.insertTeacher("Progger","1234","Михаил","Алексеев","Кандидат","Доцент",5);
            a.insertTeacher("WebPoz","qwerty","ЕвГений","Панасенков","Доктор","Профессор",10);
            a.insertTeacher("Ka_Iya","1234","Валентин","Кальтенбруннер","Доктор","Преподаватель",7);

            a.insertSubject("Math",128);
            a.insertSubject("Java",256);
            a.insertSubject("English",64);

            a.insertGroups("90001995",24);
            a.insertGroups("90001996",22);
            a.insertGroups("90001997",20);
        }
        else
            System.out.println("Admin no connected");
        System.out.println();

        Teacher[] teachers = new Teacher[3];
        for (int i = 0; i < teachers.length; i++)
            teachers[i] = new Teacher(i);

        if(teachers[0].isConnect("Progger","1234") && teachers[1].isConnect("WebPoz","qwerty") && teachers[2].isConnect("Ka_Iya","1234"))
            for (Teacher t : teachers) {
                t.set();
                t.printInfo();
            }
        else
            System.out.println("Teacher no connected");
        System.out.println();

        Groups[] groups = new Groups[3];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Groups(i);
            groups[i].set();
            groups[i].printInfo();
        }
        System.out.println();

        Subject[] subjects = new Subject[3];
        for (int i = 0; i < groups.length; i++) {
            subjects[i] = new Subject(i);
            subjects[i].set();
            subjects[i].printInfo();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < 3; i++)
            System.out.println("Преподаватель " + teachers[i].getSurname() + " " + teachers[i].getName() + " проводит занятия по " + subjects[i].getName() + " с " + groups[i].getName());
    }
}