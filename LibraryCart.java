package project;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import javafx.scene.control.CheckBox;

    public class LibraryCart {
    private int AmountOfBooks;
    private int CustPoints;
    private int totalCartPrice;
    
    public void Checkout(Book book, Customer customer)
    {
        
        for(Book b: Owner.CartBooks){
            
        }
            
        System.out.println("Added to Cart: " + book.getBookName());
        int bookPrice = book.getBookPrice(); 
        customer.setPoints(getPoints() += bookPrice * 10); // every dollar spent 10 points added to cust points
         
         
    }
     
    public ArrayList<Book> AddToCart(Book book)
    {
        //implement javaFX add book button
        CartBooks.add(book);
        totalCartPrice += book.getBookPrice();
        return CartBooks;
    }
    
    public ArrayList<Book> RemovefromCart(Book book)
    {
        
        CartBooks.remove(book);  
        totalCartPrice -= book.getBookPrice();
        return CartBooks;
    }
    
    public ArrayList<Book> getBooksinCart()
    {
        return CartBooks;
    }
}

