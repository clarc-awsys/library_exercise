package com.apps;

public class Book {
  /** Holds title value of the book.*/
  private String thisTitle;
  /** Holds author value of the book.*/
  private String thisAuthor;
  /** Holds year published value of the book.*/
  private int yearPublished;
  /** Holds rent status of the book.*/
  private boolean thisIsRented;
  /**
   * @return if book is rented.
   */
  public boolean isRented() {
    return thisIsRented;
  }
  /**
   * @param isRented
   */
  public void setRented(final boolean isRented) {
    thisIsRented = isRented;
  }


  /**
   * This is the default constructor.
   * @param title
   * @param author
   * @param yearPublish
   */
  public Book(final String title, final String author, final int yearPublish) {
    thisTitle = title;
    thisAuthor = author;
    this.yearPublished = yearPublish;
    setRented(false);
  }
  /**
   * Sets the thisIsRented to true.
   */
  public void rent() {
    System.out.println(thisTitle + " is rented.");
    setRented(true);
  }
  /**
   * Prints the details of the book.
   */
  public void display() {
    System.out.println(thisTitle + " " + thisAuthor + " " + yearPublished);
  }

}
