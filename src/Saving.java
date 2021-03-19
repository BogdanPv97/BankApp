public class Saving extends Account{
    private static String accountType="Saving";

    Saving(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.checkInterest();
    }

    public String toString(){
        return "Account type: "+accountType+" account"+"\n"+
                "Account number: "+this.getAccountNum()+"\n"+
                "Balance: "+this.getBalance()+"\n"+
                "Interest Rate: "+this.getInterest()+"\n";
    }
}
