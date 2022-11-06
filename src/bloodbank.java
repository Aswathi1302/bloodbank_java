import java.sql.*;
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
            System.out.println("1.Add Blood details");
            System.out.println("2.View Blood details");
            System.out.println("3.Search Blood details");
            System.out.println("4.update blood details");
            System.out.println("5.Delete blood details");
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
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
                        String sql="SELECT  `bid`, `donername`, `place`, `bloodgroup`, `age`, `phone` FROM `bloodbank` ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while ((rs.next())) {
                            String getbid = rs.getString(("bid"));
                            String getdonername= rs.getString(("donername"));
                            String getplace = rs.getString(("place"));
                            String getbloodgroup = rs.getString(("bloodgroup"));
                            String getage = rs.getString(("age"));
                            String getphone = rs.getString(("phone"));
                            System.out.println("Blood id=" + getbid);
                            System.out.println("Doner Name=" + getdonername);
                            System.out.println("place=" + getplace);
                            System.out.println("bloodgroup=" + getbloodgroup);
                            System.out.println("age=" + getage);
                            System.out.println("phone=" + getphone);
                            System.out.println("\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 3:
                    System.out.println("Search blood details");
                    System.out.println("Enter the  Blood id:");
                    bid=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
                        String sql = "SELECT `donername`, `place`, `bloodgroup`, `age`, `phone` FROM `bloodbank` WHERE `bid`="+String.valueOf(bid);
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while ((rs.next())) {
                            String getdonername= rs.getString(("donername"));
                            String getplace = rs.getString(("place"));
                            String getbloodgroup = rs.getString(("bloodgroup"));
                            String getage = rs.getString(("age"));
                            String getphone = rs.getString(("phone"));
                            System.out.println("Doner Name=" + getdonername);
                            System.out.println("place=" + getplace);
                            System.out.println("bloodgroup=" + getbloodgroup);
                            System.out.println("age=" + getage);
                            System.out.println("phone=" + getphone);
                            System.out.println("\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case  4:
                    System.out.println("update of blood table");
                    System.out.println("Enter the bid:");
                    bid=sc.nextInt();
                    System.out.println("Enter the name to be updated:--");
                    donername=sc.next();
                    System.out.println("Enter the place to be updated:--");
                    place=sc.next();
                    System.out.println("Enter blood group to be updated:--");
                    bloodgroup=sc.next();
                    System.out.println("Enter Age to be updated:--");
                    age=sc.nextInt();
                    System.out.println("Enter mobile number to be updated:--");
                    phone=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
                        String sql="UPDATE `bloodbank` SET `donername`='"+donername+"',`place`='"+place+"',`bloodgroup`='"+bloodgroup+"',`age`='"+String.valueOf(age)+"',`phone`='"+String.valueOf(phone)+"' WHERE `bid`="+String.valueOf(bid);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);

                        System.out.println("Data updated  successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 5:
                    System.out.println("Delete details");
                    System.out.println("Enter the blood id to be deleted:");
                    bid=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank1","root","");
                        String sql ="DELETE FROM `bloodbank` WHERE `bid`="+String.valueOf(bid);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case  6:
                    System.exit(0);
                    break;
            }
        }

    }
}
