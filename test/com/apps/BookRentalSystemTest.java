package com.apps;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class BookRentalSystemTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  String actualOutput = outContent.toString(); 

  @BeforeEach
  void setup() {
    BookRentalSystem.clearLibrary();
    outContent.reset();
    System.setOut(new PrintStream(outContent));

  }
  
  @Order(1)
  @Test
  void testBookCreation_CheckIfBookIsNotNullAndBooksAreNotRented_ReturnsTrueAndFalse() {
    Book book = new FictionBook("Duterte Manifesto", "Khuey Garces", 2016);
    assertNotNull(book, "Object is Null");
    assertFalse(book.isRented(), "Should return false");
  }
  @Order(2)
  @Test
  void testRent_CheckIfStatusChangesToTrue_ReturnsTrue() {
    Book book = new NonFictionBook("Life of Pi", "Mr. Parker", 2016);
    book.rent();
    assertTrue(book.isRented(), "isRented must be true");
  }
  @Order(3)
  @Test
  void testAddBook_CheckIfSizeIsCorrect_ReturnsSize() {
    BookRentalSystem.addBooks(new FictionBook("Duterte Manifesto", "Khuey Garces", 2016));
    BookRentalSystem.addBooks(new NonFictionBook("Life of Pi", "Mr. Parker", 2016));
    assertEquals(2, BookRentalSystem.getLibrarySize(), "Size must be 2");
  }
  @Order(4)
  @Test
  void testRentBook_CheckIfBookIsRented_ReturnsTrueAndFalse() {
    BookRentalSystem.addBooks(new FictionBook("Duterte Manifesto", "Khuey Garces", 2016));
    BookRentalSystem.addBooks(new NonFictionBook("Life of Pi", "Mr. Parker", 2016));
    BookRentalSystem.rentBooks(0);
    assertTrue(BookRentalSystem.getLibrary().get(0).isRented());
    assertFalse(BookRentalSystem.getLibrary().get(1).isRented());
  }
  @Order(5)
  @Test
  void testRentBook_RentAnInvalidIndex_ReturnsTrue() {
    BookRentalSystem.addBooks(new FictionBook("Duterte Manifesto", "Khuey Garces", 2016));
    BookRentalSystem.addBooks(new NonFictionBook("Life of Pi", "Mr. Parker", 2016));
    BookRentalSystem.rentBooks(2);
    String actualOutput = outContent.toString();
    
    assertTrue(actualOutput.contains("Index out of bounds."));
  }
  @Order(6)
  @Test
  void testDisplayBooks_CheckIfOutputMatchesBookDetails_ReturnsTrue() {
    
    BookRentalSystem.addBooks(new FictionBook("Duterte Manifesto", "Khuey Garces", 2016));
    BookRentalSystem.addBooks(new NonFictionBook("Life of Pi", "Mr. Parker", 2016));
    
    for(Book book : BookRentalSystem.getLibrary()) {
      book.display();
    }
    
    String output = outContent.toString();
    
    assertTrue(output.contains("Duterte Manifesto"));
    assertTrue(output.contains("Life of Pi"));
  }
  @Order(7)
  @Test
  void testRentBooks_CheckIfRentedBookIsTrue_ReturnsTrue() {
    BookRentalSystem.addBooks(new FictionBook("Duterte Manifesto", "Khuey Garces", 2016));
    BookRentalSystem.addBooks(new NonFictionBook("Life of Pi", "Mr. Parker", 2016));
    BookRentalSystem.rentBooks(0);
   
    String output = outContent.toString();
    assertTrue(output.contains("Duterte"));
  }
  
  @Test
  void testMain_ReturnsVoid() {
    BookRentalSystem.main(null);
  }
  

}
