import java.util.ArrayList;

public class Bank {

    private ArrayList<Customer> customers=new ArrayList<Customer>();


    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    Customer getCustomer(int account){
        return customers.get(account);
    }

    ArrayList<Customer> getCustomer(){
        return customers;
    }
}
