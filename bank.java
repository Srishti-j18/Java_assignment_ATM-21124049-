import java.util.HashMap;
import java.util.Scanner;

//creation of bank class
public class bank {
    public int IFSC_Code;

    //Constructor of bank class
    bank(int ifcsCode) {
        this.IFSC_Code = ifcsCode;
    }

    //creation of a hashmap for creating a database for customers which stores integer as a key
    // which holds the account number of customer and
    // a built-in datatype "Key" as value, Key contains three variables, (int, int, String)
    //where first int stores the password of account number, second int stores the balance of account
    //and string stores the name of account holder
    public HashMap<Integer, Key> mp = new HashMap<>();

    //IntroduceTheAccount method tells the user information about a particular account when credentials are entered,
    //like the name of account holder, the account number, password of account ,the balance of account and the ifsc code.
    public void IntroduceTheAccount(int acc) {
        if (this.mp.containsKey(acc)) {
            System.out.println("The name of Account holder is: " + this.mp.get(acc).s);
            System.out.println("The Account Number is: " + acc);
            System.out.println("The password of account is: " + this.mp.get(acc).x);
            System.out.println("The balance of account is: " + this.mp.get(acc).y);
            System.out.println("The IFSC code of bank is: " + this.IFSC_Code);
        }
    }

    //SearchForAccount method allows user to search for their account in database after entering the account number
    // and password
    public int SearchForAccount(int acc, int pass) {
        if (this.mp.containsKey(acc)) {
            if (this.mp.get(acc).x == pass) {
                return 0;
            }
        }
        return -1;
    }

    //after logging into the account Menu method directs us to the functionality of ATM like BankBalance,
    //DepositMoney, DebitMoney and Exit.
    public void Menu(int acc, int i, int money) {
        switch (i) {
            case 1:
                this.BankBalance(acc);
                break;
            case 2:
                this.DepositMoney(acc, money);
                break;
            case 3:
                this.debitMoney(acc, money);
                break;
            case 4:
                this.Exit();
                break;
            default:
                break;
        }
    }

    //login method allows user to login to their account and do all the functionality
    public void login(int acc, int pass) {
        //Here the account of user is introduced
        this.IntroduceTheAccount(acc);
        System.out.println("Type 1 for balance enquiry.");
        System.out.println("Type 2 for depositing money.");
        System.out.println("Type 3 for withdrawing money.");
        System.out.println("Type 4 for exit.");
        System.out.println("Enter your choice: ");
        Scanner st = new Scanner(System.in);
        //Asking user for input as int to do the functionality user asked
        int i = st.nextInt();

        //Exception defined if the user enters the value other than 1,2,3,4
        try{
            if(i != 1 && i!= 2)
            {
                if(i!=3 && i!=4)
                {
                    throw new MyException();
                }
            }
        }
        catch(MyException e)
        {
            System.out.println("Exception: Please enter valid values i.e. 1,2,3,4.");
        }

        //loop will ask for functionality to be done as long as user does not ask for exit
        while (true) {
            if (i == 4) {
                this.Exit();
                break;
            }
            int money;
            //if money has to be deposited or withdrawn then asking user to input the money
            if (i == 2) {
                System.out.println("Enter the money you want to deposit: ");
                money = st.nextInt();
            } else if (i == 3) {
                System.out.println("Enter the money you want to withdraw: ");
                money = st.nextInt();
            } else {
                money = 0;
            }
            //now the value of account number , the choice made and the money is sent to the Menu method
            this.Menu(acc, i, money);
            System.out.println("Type 1 for balance enquiry.");
            System.out.println("Type 2 for depositing money.");
            System.out.println("Type 3 for withdrawing money.");
            System.out.println("Type 4 for exit.");
            System.out.println("Enter your choice: ");
            i = st.nextInt();
            try{
                if(i != 1 && i!= 2 )
                {
                    if(i!= 3 && i!= 4)
                    {
                        throw new MyException();
                    }
                }
            }
            catch(MyException e)
            {
                System.out.println("Exception: Please enter valid values i.e. 1,2,3,4.");
            }
        }

    }

    //BankBalance method is used to check the balance of the account number taken as a parameter
    public void BankBalance(int acc) {
        System.out.println("The bank balance of account is : " + this.mp.get(acc).y);
    }

    //DepositMoney method is used to deposit the money into the account number taken as a parameter
    public void DepositMoney(int acc, int money) {

        System.out.println("The money you want to deposit is: " + money);

        this.mp.get(acc).y += money;

        System.out.println("Your new balance is: " + this.mp.get(acc).y);
    }

    //debitMoney method is used to withdraw money from the account number taken as a parameter
    public void debitMoney(int acc, int money) {
        if (this.mp.get(acc).y < money) {
            System.out.println("Error, You cannot withdraw money more than your bank balance");
            return;
        }

        this.mp.get(acc).y -= money;

        System.out.println("Your new balance is: " + this.mp.get(acc).y);
    }

    //Exit method exit the transaction process
    public void Exit() {
        System.out.println("You have exit the transaction process.");
        System.out.println("Thanks for using our service.");
    }

    //createAccount method is used to create a new account with the password and name taken as a parameter from user
    public void createAccount(int account_num, int password, String name) {
        this.mp.put(account_num, new Key(password, 0, name));
        System.out.println("Your account has been created successfully.");
    }
}
