package com.apps;

import java.util.ArrayList;

public class BookRentalSystem {
  
  public static ArrayList<Book> library = new ArrayList<>();
  
  
  public static void addBooks() {
    library.add(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
    library.add(new FictionBook("To Kill a Mockingbird", "Harper Lee", 1960));
    library.add(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
    library.add(new NonFictionBook("Guns, Germs, and Steel", "Jared Diamond ", 1997));
    
    System.out.println("Books Added...");
    
    rentBooks();
  }
  
  public static void rentBooks() {
    library.get(0).rent();
    library.get(2).rent();
  }
  
  public static void main(String[] args) {
    
    addBooks();
    
    for(Book books : library) {
      books.display();
    }

   }
}
