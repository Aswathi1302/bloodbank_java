import java.util.Scanner;

public class bloodbank {
    public static void main(String[] args) {
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
                    System.out.println("Add Details");
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
