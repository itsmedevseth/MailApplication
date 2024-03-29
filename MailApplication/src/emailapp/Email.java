package emailapp;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner s = new Scanner(System.in);//Scanner class
    //setting Variables as private not give directly


    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacicy =500;
    private String alter_email;


    // Constructor to receive first name, last name
    public Email(String fname, String lname)
    {
        this.fname = fname;
        this.lname =lname;
        System.out.println("New Employee: " + this.fname+" "+this.lname);
        //Calling methods
        this.dept = this.setDept();//Department;
        this.password=this.gernerat_password(8);
        this.email=this.generate_email();//email generation

    }
    //Generate mail method
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".Company.com";

    }

    //asking for dept
    private  String setDept()
    {
        System.out.println("Department codes  \n1 for sales \n2 for Development \n3 for Accounting  \n0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "sales";
                case 2:
                    return "Department";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");

            }

        }while (!flag);
        return null;
        }
        //Generate Random password method

        private String gernerat_password(int length) {
            Random r = new Random();
            String capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String small_chars = "abcdefghijklmnopqrstuvwxyz";
            String numbers ="0123456789";
            String Symbols="!@#$%&?";
            String values=capital_chars+small_chars+numbers+Symbols;
            String password="";
            for(int i=0; i<length;i++)
            {
                password =password+values.charAt(r.nextInt(values.length()));

            }
            return password;
    }
    //Change password method
        public void  set_password() {
            boolean flag = false;
            do {
                System.out.println("Do you want to change your password! (Y/N");
                char choice = s.next().charAt(0);
                if (choice == 'Y' || choice == 'y') {
                    flag = true;
                    System.out.println("Enter Current password : ");
                    String temp = s.next();
                    if (temp.equals(this.password)) {
                        System.out.println("Enter new password :");
                        this.password = s.next();
                        System.out.println("Password change successfully");
                    } else {
                        System.out.println("Incorrect password");
                    }
                } else if (choice == 'N' || choice == 'n') {
                    flag = true;
                    System.out.println("Password changed option cancelled!");
                } else {
                    System.out.println("Enter valid choice");
                }
            }
                while (!flag) ;
            }

        // set mailbox capacity method
        public void set_mailCap(){
            System.out.println("Current capacity = "+this.mailCapacicy+ " mb ");
            System.out.println("Enter new mailbox capacity : ");
            this.mailCapacicy=s.nextInt();
            System.out.println("Mailbox capacity is successfully changed");

        }
        //set alternate mail
        public void alternate_email(){
            System.out.println("Enter new alternate mail : ");
            this.alter_email=s.next();
            System.out.println("Alternate email is set : ");
        }
        //Display user information method
    public void getInfo(){
        System.out.println("New : " +this.fname+""+this.lname);
        System.out.println("Department : " +this.dept);
        System.out.println("Email : "+this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mailbox capacity : "+this.mailCapacicy +"mb");
        System.out.println("Alternate mail : "+this.alter_email);
    }

        //Store in file
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("E:\\MailApplication\\info.txt");
            in.write("first name: " + this.fname);
            in.append("\nLast name: " + this.lname);
            in.append("\nEmail:" + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity " + this.mailCapacicy);
            in.append("\nAlternate mail" + this.alter_email);
            in.close();
            System.out.println("Data Store");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        //Reading file
        public void read_file()
        {
            try {
                FileReader f1= new FileReader("E:\\MailApplication\\info.txt");
                int i;
                while ((i=f1.read())!=-1)
                {
                    System.out.print((char) i);
                }
                System.out.println();
                f1.close();

            }catch (Exception e){
                System.out.println(e);
            }
            }
        }


