
package coe528project;
import java.util.*;
import java.io.*;
/**
 *
 * @author nadia
 */
public class FileManager {
    
    // get all the customer data from the book arraylist and copy it to the customer.txt file
    public void CopyToCustomerFile(ArrayList<Customer> customers) throws IOException{
        //create new customer.txt file
        FileWriter customerFile = new FileWriter("customers.txt", true);
        //iterate through all the customers in the araylist
        //copy all the customer info into the file
        for(Customer customer: customers){
            String custInfo = "Username: " + customer.getUsername() + "Password: " + customer.getPassword() + "Status: " + customer.getStatus() + "Points:  " + customer.getPoints() + "\n";
            customerFile.write(custInfo);
        }
        //close the file
        customerFile.close();
    }
    
    // get all the data from the book arraylist and copy it to the book.txt file
    public void CopyToBookFile(ArrayList<Book> books) throws IOException{
        // create new book.txt file
        FileWriter bookFile = new FileWriter("books.txt", true);
        //iterate through all the books in the arraylist
        //copy all the elements of the books into the file
        for(Book book: books){
            String bookElements = "Title: " + book.getBookName() + " Price: " + book.getBookPrice() + "\n";
            bookFile.write(bookElements);
        }
        //close the file
        bookFile.close();
    }    
    
    
    // empty the customer file
    // method will be used when we want to overwrite the existing file with then updated list of customers
    public void EmptyCustomerFile() throws IOException{
        FileWriter customerFile = new FileWriter("customers.txt", false);
        customerFile.close();
    }
    
    
    // empty the book file
    // method will be used when we want to overwrite the existing file with then updated list of customers
    public void EmptyBookFile() throws IOException{
        FileWriter bookFile = new FileWriter("books.txt", false);
        bookFile.close();
    }
   
}
