import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner keyboard=new Scanner(System.in);
    Bank bank=new Bank();
    boolean exit;

    public static void main(String[] args){
        Menu menu=new Menu();
        menu.runMenu();
    }

    public void runMenu(){
        printHeader();
        while(!exit){
            printMenu();
            int choice=getInput();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("Welcome to the banking app");
        System.out.println("--------------------------");
    }

    private void printMenu() {
        System.out.println("Please select an option:");
        System.out.println("------------------------");
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit amount");
        System.out.println("3. Withdraw amount");
        System.out.println("4. Check account balance");
        System.out.println("0. Exit");
    }

    private int getInput() {
        int choice=-1;
        System.out.println("Enter your choice!");
do {
    try {
        choice = Integer.parseInt(keyboard.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Please enter a number");
    }
    if (choice < 0 || choice > 4)
        System.out.println("Please enter a valid number");
}while(choice < 0 || choice > 4);

return choice;
    }

    private void performAction(int choice) {

        switch(choice){
            case 1:
                createAccount();
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdraw();
                break;
            case 4:
                displayBalance();
                break;
            case 0:
                System.out.println("Thank you for using our application");
                System.exit(0);
                break;
            default:
                System.out.println("Error has occurred!!");
                break;

        }

    }

    private void displayBalance() {
        int account=selectAccount();
        if(account>=0)
            System.out.println(bank.getCustomer(account).getAccount());
        else
            System.out.println("Invalid account entered");
    }

    private void makeWithdraw() {
        int account=selectAccount();
        if(account>=0) {
            System.out.println("Enter the amount: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount=0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }
    }

    private void makeDeposit() {
        int account=selectAccount();
        if(account>=0) {
            System.out.println("Enter the amount: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount=0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private int selectAccount() {
        ArrayList<Customer> customers=bank.getCustomer();
        if(customers.size() <=0){
            System.out.println("No customers");
            return -1;
        }
        for(int i=0;i<customers.size();i++){
            System.out.println(i+1 +") "+customers.get(i).basicInfo());
        }
        int account=0;
        try{
            account=Integer.parseInt(keyboard.nextLine())-1;
        }catch(NumberFormatException n){
            account=-1;
        }
        return 0;
    }

    private void createAccount() {
        String firstName, lastName, ssn, accountType="";
        double initialDeposit=0;
        boolean isValid=false;
        while(!isValid){
            System.out.println("Please enter account type(saving/checking): ");
            accountType=keyboard.nextLine();
            if(accountType.equalsIgnoreCase("saving") || accountType.equalsIgnoreCase("checking"))
                isValid=true;
            else
                System.out.println("Invalid selection --- please enter saving/checking");
        }

        System.out.print("Please enter your first name: ");
        firstName=keyboard.nextLine();

        System.out.print("Please enter your last name: ");
        lastName=keyboard.nextLine();

        System.out.print("Please enter your SSN: ");
        ssn=keyboard.nextLine();

        System.out.print("Enter the amount you want to deposit");
        try {
            initialDeposit = Double.parseDouble(keyboard.nextLine());
        }catch(NumberFormatException e){
            System.out.println("enter a number:");
        }
        if(accountType.equalsIgnoreCase("checking")) {
            if (initialDeposit < 100)
                System.out.println("Minimum amount for checking account is 100$");
            else
                System.out.println(initialDeposit + " was added to your account");
        }
        else if(accountType.equalsIgnoreCase("savings")){
            if(initialDeposit<200)
                System.out.println("Minimum amount for saving account is 200$");
            else
                System.out.println(initialDeposit+" was added to your savings account");
        }
        Account account;
        if(accountType.equalsIgnoreCase("checking"))
            account=new Checking(initialDeposit);
        else
            account=new Saving(initialDeposit);
        Customer customer=new Customer(firstName, lastName, ssn, account);
        bank.addCustomer(customer);
    }


}
