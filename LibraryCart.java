package project;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

    public class LibraryCart {
    private int AmountOfBooks;
    private int CustPoints;
    private int totalCartPrice;
    ArrayList<String> CartBooks = new ArrayList<>();
    
    public void BookElements(){
        //  ONLY selected book elements from files reads to arraylist 
        //for(Cartbook)
            // if book.(gettermethod for selection javafx).(checking if checkbox is selected)
        String fileName = "bookFile.txt";
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String book;
            while ((book = bufferedReader.readLine()) != null) {
                CartBooks.add(book);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
        }
        System.out.println(CartBooks);
    }
    
    public void Checkout(Book book, Customer customer) 
    {
        CustPoints = customer.getPoints();
        //for(){ // take the books from the file using while loop
            // check if the book is selected using javaFX
                // if book.(gettermethod for selection javafx).(checking if checkbox is selected)
                        //if it is selected then get the price of the book and add to the subtotal
                        totalCartPrice += book.getBookPrice();
                        System.out.println("Added to Cart: " + book.getBookName());
                        if(customer.myState.equals(Gold())){
                            totalCartPrice -= (totalCartPrice * 0.20); // discount of 20%
                        }
            // javaFX buy button or redeem points button
            // if selected is redeem points
                        redeemPoints(customer, totalCartPrice);
       // }
            
        customer.setPoints(CustPoints += totalCartPrice * 10); // every dollar spent 10 points added to cust points
            
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
        
    public ArrayList<String> AddToCart(Book book)
    {
        //implement javaFX add book button
        // adds to the file
        Books.add(book);
        //totalCartPrice += book.getBookPrice();
        return CartBooks;
    }
    
    public ArrayList<String> RemovefromCart(Book book)
    {
        // removes selected BOOKS it  the file
        //if(book is selected)
        BookElements();
        CartBooks.remove(book);  
        //totalCartPrice -= book.getBookPrice();
        String bookToRemove = "example";
        CartBooks.remove(bookToRemove);

      // write the updated data to the file
        FileWriter writer = new FileWriter("bookFile.txt");
        for (String line : CartBooks) {
            writer.write(line + "\n");
      }
        writer.close();
        return CartBooks;
    }
    
    public ArrayList<String> getBooksinCart()
    {// only selected books to display
        return CartBooks;
    }
}

