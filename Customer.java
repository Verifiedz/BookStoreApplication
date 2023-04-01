/**
 *
 * @author Saad
 */
package Project;
import java.util.Scanner;
public class Customer extends User {
    private int Cpoints; 
    private State myState; 
    private String intial = null; 
    public Customer(){
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getPoints(){
        return Cpoints;
    }
    public void setPoints(int s ){
        Cpoints =s;
    }
    public void SetUsername(String s){
        username = s;
    }
    public void SetPassword(String s){
        
        if(intial == null){ 
            password = s;
            intial = "LockedPassword";
        }
        
    }
    public void ChangePassword(Customer s, String k, String p) throws IllegalAccessError{
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        if(s.getPassword() ==k){
            intial = null;
            s.SetPassword(p);
        }
        else{
            while(counter<3){
                    System.out.println("Im sorry incorrect password--> enter password again");
                     k = scan.next();
                     if(s.getPassword() ==k){
                        intial = null;
                        s.SetPassword(p);
                        counter = 2;
                    }
                    counter++;
            }
            if(s.getPassword()!=p) throw new IllegalAccessError("Surpassed Allowed Attempts: Try again later");
        }
        System.out.println("Password was Successfully changed");

    }
    // need to fix this*
    public void setStatus(){
        if(Cpoints>=1000) myState = new Gold();
        else myState = new Silver();
    }
    
    //return the state of the customer
    public State getStatus(){
        return myState;
    }
    
    @Override
    public String toString(){
        String clist ="Username:"+getUsername()+"\n"+"Password:"+getPassword()+"\n"+"Points:"+getPoints();
        System.out.println(clist);
        System.out.println();
        return clist;
    }
}
