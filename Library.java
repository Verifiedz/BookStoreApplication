/**
 *
 * @author Abdul Rafae Adil
 */
package Project;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();
    private Library instance;
    private String name;

    Library(String name){
        this.name = name;
    }

    public Library getInstance(){
        if(instance == null) instance = new Library(name);
        return instance;
    }

    public void addBook(Book s){
        books.add(s);
    }

    public void removeBook(Book s){
        books.remove(s);
    }

    public Book getBookItem(){
        for(Book nm:books){
            if(nm != null){
                return nm;
            }
        }
        return null;
    
    }
}