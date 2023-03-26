package Project;
import java.util.ArrayList;
public class Owner extends User {
    private ArrayList<Customer> customers; 
    private Owner instance;

    private Owner(){
        customers = new ArrayList<Customer>();
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void AddCustomer(Customer a){
        customers.add(a);
    }
    public void RemoveCustomer(Customer a){
        customers.remove(a);
    }
    public Owner getInstance(){
        if(instance == null) instance = new Owner();
        return instance; 
    }
    //need to test*
    public boolean FindAssociatedCust(Customer c){
        boolean found = false; 
        for(Customer s: customers){
            if(s.getPassword().equals(c.getPassword()) && s.getUsername().equals(c.getUsername())){
                found = true;
                System.out.println(c+"is your Customer");
            }
            else{
                System.out.println("No Customer found with credentials of "+c); 
            }
        }
        return found;
    }
} 
