package project;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


    public class LibraryCart {
    private int AmountOfBooks;
    private int CustPoints;
    private int totalCartPrice;
    ArrayList<Book> CartBooks = new ArrayList<>();
    
    
    public void Checkout(Book book, Customer cust) 
    {
        CustPoints = cust.getPoints();
        //for(){ // take the books from the file using while loop
            // check if the book is selected using javaFX
                // if book.(gettermethod for selection javafx).(checking if checkbox is selected)
                        //if it is selected then get the price of the book and add to the subtotal
        
        int size = CartBooks.size();
        for(int i=0; i<size; i++){
            totalCartPrice += book.getBookPrice();
            System.out.println("Added to Cart: " + book.getBookName());
                        
            // javaFX buy button or redeem points button
            // if selected is redeem points
            redeemPoints(cust, totalCartPrice);
       // }
        }
        cust.setPoints(CustPoints += totalCartPrice * 10); 
            
    }
    
    public void redeemPoints(Customer customer, int totalPrice){
        int redeemedPts = CustPoints/100; // pay w points so converting cash
        int pointsLeft = 0;
        int size = CartBooks.size();
            for(int i=0; i < size; i++) { 
                if(redeemedPts >= totalPrice) {
                    pointsLeft = (redeemedPts - totalPrice)*100;
                    customer.setPoints(pointsLeft);
                }
                //  totalCartPrice -= redeemedPts;
                else if(redeemedPts < totalCartPrice){
                      System.out.println("You do not have enough points!");
                }
        }
            
    }
        
    public ArrayList<Book> AddToCart(Book book) throws IOException
    {
        //implement javaFX add book button after selecting 

        CartBooks.add(book);
        try (FileWriter writer = new FileWriter("bookFile.txt")) {
            for (Book line : CartBooks) {
                writer.write(line + "\n");
            } 
        }
        return CartBooks;
        
    }
    
    public ArrayList<Book> RemovefromCart(Book book) throws IOException
    {
        // removes selected BOOKS it  the file
        //if(book is selected)
        // if purhcase or redeem points 
        CartBooks.remove(book);  
        try ( // write the updated data to the file
                FileWriter writer = new FileWriter("bookFile.txt")) {
            for (Book line : CartBooks) {
                writer.write(line + "\n");
            } 
        }
        return CartBooks;
    }
    
    public ArrayList<Book> getBooksinCart()
    {
        return CartBooks;
    }
}

