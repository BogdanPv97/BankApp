public class Account {
    private double balance=0;
    private double interest=0.2;
    private int accountNum;
    private static int noOfAccounts=100000;

    public Account(){
        accountNum = noOfAccounts++;
    }

    public void withdraw(double amount){
        if(balance<amount)
            System.out.println("Insufficient funds");
        else
            balance-=amount;
        System.out.println("You have withdrawn $"+amount);
        System.out.println("Your balance is $"+balance);
    }

    public void deposit(double amount){

        if(amount<0)
            System.out.println("Invalid amount entered!");
        else {
            checkInterest();
            amount=amount+(amount*interest);
            balance += amount;
        }
        System.out.println("Your balance is $"+balance);
    }

    public void checkInterest(){
        if(balance>10000)
            interest=0.05;
        else
            interest=0.02;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
