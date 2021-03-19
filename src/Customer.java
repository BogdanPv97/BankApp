public class Customer {

    String firstName;
    String lastName;
    String ssn;
    Account account;

    public Customer(String firstName, String lastName, String ssn,Account account){
        this.firstName=firstName;
        this.lastName=lastName;
        this.ssn=ssn;
        this.account=account;
    }

    Account getAccount(){
        return account;
    }

    public String toString(){
        return "Customer INFO:\n"+
                "First name: "+firstName+"\n"+
                "LastName: "+lastName+"\n"+
                "ssn: "+ssn+"\n"+
                account;
    }
    public String basicInfo(){
        return "Customer INFO:\n"+
                "First name: "+firstName+"\n"+
                "LastName: "+lastName+"\n"+
                "ssn: "+ssn+"\n"+
                "Account: "+ account.getAccountNum();
    }
}
