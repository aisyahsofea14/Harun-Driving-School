
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ClassLicenseApp
{
    public static void displayMenu()
    {
        System.out.println("                        LICENSE TABLE                          \n");
        System.out.println("     TYPE                  CODE                PRICE(RM)         ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("MOTORCYCLE              -B >500cc                800             ");
        System.out.println("                        -B2 <250cc               500             ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("CAR                     -D(MANUAL)               1800            ");
        System.out.println("                        -DA(AUTO)                2000            ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("LORRY                   -E <7500KG               1900            ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("*Transportation charges if needed (option) must add on RM50.00.  ");
    }

    public static void main(String[] args) throws IOException
    {
        try
        {
            FileWriter file1 = new FileWriter("receipt.txt");
            BufferedWriter bw1 = new BufferedWriter(file1);
            PrintWriter output = new PrintWriter(bw1);

            int maxSize = 100;
            classLicense[] cs = new classLicense[maxSize];
            int i = 0;

            int totStudCar = 0;
            int totStudMotor = 0;
            int totStudLorry = 0;
            double totalSales = 0;
            DecimalFormat df = new DecimalFormat("0.00");

            Scanner Sc = new Scanner(System.in);
            displayMenu();

            System.out.println("\nDo you want to register? (Yes/No): ");
            String answer = Sc.nextLine();

            while (answer.equalsIgnoreCase("yes"))
            {
                System.out.println("Enter Name : ");
                String name = Sc.nextLine();

                System.out.println("Enter IC Number : ");
                String icNo = Sc.nextLine();

                System.out.println("Enter Telephone Number : ");
                String telNo = Sc.nextLine();

                System.out.println("Enter Age : ");
                int age = Sc.nextInt();
                Sc.nextLine();

                System.out.println("Enter Address : ");
                String address = Sc.nextLine();

                System.out.println("Enter Type (Car/Motorcycle/Lorry): ");
                String type = Sc.nextLine();
                while (!type.equalsIgnoreCase("Car")
                        && !type.equalsIgnoreCase("Motorcycle")
                        && !type.equalsIgnoreCase("Lorry"))
                {
                    System.out.println("Invalid type. Please re-enter Type (Car/Motorcycle/Lorry): ");
                    type = Sc.nextLine();
                }

                System.out.println("Enter Code (D/DA/B/B2/E) : ");
                String code = Sc.nextLine();
                while (!code.equalsIgnoreCase("D")
                        && !code.equalsIgnoreCase("DA")
                        && !code.equalsIgnoreCase("B")
                        && !code.equalsIgnoreCase("B2")
                        && !code.equalsIgnoreCase("E"))
                {
                    System.out.println("Invalid code. Please re-enter Code (D/DA/B/B2/E): ");
                    code = Sc.nextLine();
                }

                System.out.println("Do you need transportation (Yes/No) : ");
                String transport = Sc.nextLine();

                Student stud = new Student(name, icNo, telNo, age, address, type);
                classLicense license = null;

                if (type.equalsIgnoreCase("Car"))
                {
                    license = new Car(transport, stud, code);
                    totStudCar++;
                }
                else if (type.equalsIgnoreCase("Motorcycle"))
                {
                    license = new Motorcycle(transport, stud, code);
                    totStudMotor++;
                }
                else if (type.equalsIgnoreCase("Lorry"))
                {
                    license = new Lorry(transport, stud, code);
                    totStudLorry++;
                }

                if (license != null && i < maxSize)
                {
                    cs[i++] = license;
                    totalSales += license.totalPayment();
                }

                System.out.println("\nDo you want to register? (Yes/No): ");
                answer = Sc.nextLine();
            }

            System.out.println("\nPress ST For Staff Otherwise Press Anything: ");
            String staff = Sc.nextLine();

            if (staff.equalsIgnoreCase("ST"))
            {
                System.out.println("\n----------RECEIPT FOR TOTAL STUDENTS & SALES----------");
                System.out.println("Number of students choose car : " + totStudCar);
                System.out.println("Number of students choose motorcycle : " + totStudMotor);
                System.out.println("Number of students choose lorry : " + totStudLorry);
                System.out.println("Number of students  : " + (totStudCar + totStudMotor + totStudLorry));
                System.out.println("Total sales  : RM " + df.format(totalSales));
            }
            else
            {
                System.out.println("Thank You, please wait for further information through messages <3");
            }

            for (int j = 0; j < i; j++)
            {
                if (cs[j] != null)
                {
                    output.println("**********************************************************");
                    output.println("                 OFFICIAL RECEIPT :                       ");
                    output.println("**********************************************************");
                    output.println("Student Information : \n" + cs[j].getStudent().toString());
                    output.println("Code : " + cs[j].getCode());
                    output.println("Transport  : " + cs[j].getTransport());
                    output.println("\nBill Info : \n" + cs[j].toString());
                    output.println("**********************************************************");
                }
            }

            output.close();
            Sc.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        finally
        {
            System.out.println("System End Here, Thank you!");
        }
    }
}
