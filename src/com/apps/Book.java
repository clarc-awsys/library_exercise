package com.apps;

public class Book {
  private String title;
  private String author;
  private int yearPublished;
  private boolean isRented;
  
  
  
  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getAuthor() {
    return author;
  }



  public void setAuthor(String author) {
    this.author = author;
  }



  public int getYearPublished() {
    return yearPublished;
  }



  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }



  public boolean isRented() {
    return isRented;
  }



  public void setRented(boolean isRented) {
    this.isRented = isRented;
  }



  public Book (String title, String author, int yearPublish) {
    setRented(false);
  }
  
  public void rent() {
    setRented(true);
  }

}
