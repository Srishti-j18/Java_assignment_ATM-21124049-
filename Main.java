// Java Group Project
//Team Members:
//Member-1: Srishti Jaiswal    Roll No: 21124049
//Member-2: Riya Singh     Roll No: 21124044
//Member-3: Nitu Kumari     Roll No:21124035


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //object made of bank class
        bank b1 = new bank(12234);

        //Database created with some account numbers and their password, balance and account holder name
        b1.mp.put(1, new Key(101, 100002, "Riya"));
        b1.mp.put(2, new Key(102, 20004, "Aayush"));
        b1.mp.put(3, new Key(103, 30005, "Sristhi"));
        b1.mp.put(4, new Key(104, 40056, "Nitu"));
        b1.mp.put(5, new Key(105, 50003, "Aditi"));
        b1.mp.put(6, new Key(106, 60004, "Ayushi"));
        b1.mp.put(7, new Key(107, 70005, "Sruthi"));
        b1.mp.put(8, new Key(108, 80005, "Rohan"));
        b1.mp.put(9, new Key(109, 30002, "Akshil"));
        b1.mp.put(10, new Key(110, 45630, "Suhail"));

        //Process starts...
        Scanner sc = new Scanner(System.in);
        System.out.println("........Welcome to our service.......");
        System.out.println("Enter 1 to create a new account \nEnter 2 to login to an existing one");
        System.out.println("Enter your choice: ");

        //Asking user for input to perform task either by creating a new account or by logging into an existing one
        int a = sc.nextInt();

        //loop runs until and unless we have the value of 'a' equals to 1 or 2
        // and exception is defined if some other value id entered
        while(a != 1 && a != 2)
        {
            try{
                throw new MyException();
            }
            catch(MyException e)
            {
                System.out.println("Exception: Please enter either 1 or 2.");
            }
            System.out.println("Enter Your choice again: ");
            a = sc.nextInt();
        }

        //If user enter the value of 'a' as 1 then an account is created
        if (a == 1) {
            int b = b1.mp.size();
            System.out.println("Please enter your name: ");
            String st = sc.next();
            System.out.println("Please enter the password of your account you want to create: ");

            int pass = sc.nextInt();
            int e = pass;
            int res = 0;
            while(e >0)
            {
                e = e/10;
                res++;
            }

            //loop runs until we enter a password of 3 or less than 3 digit password
            while(res >3)
            {
                //exception is thrown if the number of digit of password is greater than 3
                try{
                    throw  new MyException();
                }
                catch(MyException ex){
                    System.out.println("Exception: The password should be upto 3 digit only.");
                }
                System.out.println("Enter the password again: ");
                pass = sc.nextInt();
                e = pass;
                res = 0;
                while(e >0)
                {
                    e = e/10;
                    res++;
                }
            }


            b1.createAccount(b + 1, pass, st);

            //after creating account user is asked for either logging into same or exit the transaction
            System.out.println("Enter 1 to login to account \nEnter 2 to exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();


            while(ch != 1 && ch!= 2)
            {
                //exception is thrown for invalid input i.e. if the user enters anything other 1 and 2
                try{
                    throw new MyException();
                }
                catch(MyException exe)
                {
                    System.out.println("Exception: Please enter values 1 or 2.");
                }

                System.out.println("Enter your choice again: ");
                ch = sc.nextInt();
            }

            if (ch == 1) {
                // b1.IntroduceTheAccount(b + 1);
                b1.login(b + 1, pass);
            } else if (ch == 2) {
                b1.Exit();
            }
        } else if (a == 2) {
            System.out.println("Enter your account number: ");
            int acc = sc.nextInt();
            System.out.println("Enter your password");
            int pass = sc.nextInt();
            if (b1.SearchForAccount(acc, pass) == 0) {
                b1.login(acc, pass);
            } else {
                System.out.println("Entered credentials doesn't exist :(");
            }
        }
        sc.close();
    }
}
