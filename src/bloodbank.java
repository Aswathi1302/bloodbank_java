import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class bloodbank {
    public static void main(String[] args) {
        String donername,place,bloodgroup;
        int bid,phone,age;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
        int choice;
        while (true)
        {
            System.out.println("Select the option");
            System.out.println("1.Add Food");
            System.out.println("2.View all Food");
            System.out.println("3.Search Food");
            System.out.println("4.update food");
            System.out.println("5.Delete dood ");
            System.out.println("6.Exit ");
            System.out.println("*****************");
            System.out.println("ENTER YOUR CHOICE:--");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the blood id");
                    bid=sc.nextInt();
                    System.out.println("Enter the Doner name");
                    donername=sc.next();
                    System.out.println("Enter the place");
                    place=sc.next();
                    System.out.println("Enter the blood group");
                    bloodgroup=sc.next();
                    System.out.println("Enter the age");
                    age=sc.nextInt();
                    System.out.println("Enter the phone");
                    phone=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
                        String sql="INSERT INTO `bloodbank`(`bid`, `donername`, `place`, `bloodgroup`, `age`, `phone`) VALUES (?,?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,bid);
                        stmt.setString(2,donername);
                        stmt.setString(3,place);
                        stmt.setString(4,bloodgroup);
                        stmt.setInt(5,age);
                        stmt.setInt(6,phone);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfully.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }

                    break;
                case  2:
                    System.out.println("view all details of blood table");
                    break;
                case 3:
                    System.out.println("Search blood details");
                    break;
                case  4:
                    System.out.println("update of blood table");
                    break;
                case 5:
                    System.out.println("Delete details");
                    break;
                case  6:
                    System.exit(0);
                    break;
            }
        }

    }
}
