package com.apps;

import java.util.ArrayList;

public final class BookRentalSystem {
  private BookRentalSystem() {
    super();
  }
  /**
   * Stores the books you have.
   */
  private static ArrayList<Book> library = new ArrayList<>();
  /**
   * @return returns the library ArrayList.
   */
  public static ArrayList<Book> getLibrary() {
    return library;
  }
  /**
   * Adds the books in the library ArrayList.
   */
  public static void addBooks() {
    final int[] year = {1954, 1960, 2000, 1997};
    final int three = 3;
    library.add(new FictionBook(
        "The Lord of the Rings", "J.R.R. Tolkien", year[0]));
    library.add(new FictionBook(
        "To Kill a Mockingbird", "Harper Lee", year[1]));
    library.add(new NonFictionBook(
        "The Tipping Point", "M. Gladwell", year[2]));
    library.add(new NonFictionBook(
        "Guns, Germs, and Steel", "Jared Diamond ", year[three]));
    System.out.println("Books Added...");
    rentBooks();
  }
  /**
   * @param book
   */
  public static void addBooks(final Book book) {
    library.add(book);
  }
  /**
   * @param index
   */
  public static void rentBooks(final int index) {
    if ((index < getLibrarySize()) && (index >= 0)) {
      library.get(index).rent();
    } else {
      System.out.println("Index out of bounds.");
    }
  }
  /**
   * Sets the isRent value to true for the chosen books.
   */
  public static void rentBooks() {
    library.get(0).rent();
    library.get(2).rent();
    System.out.println("Books rented: ");
    for (Book book : library) {
      if (book.isRented()) {
        book.display();
      }
    }
  }
  /**
   * Clears your ArrayList library.
   */
  public static void clearLibrary() {
     library.clear();
  }
  /**
   * @return size of library.
   */
  public static int getLibrarySize() {
    return library.size();
  }
  /**
   * This is the main function.
   * @param args
   */
  public static void main(final String[] args) {
    addBooks();
   }
}
