/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookwishlist.controller;


/**
 *
 * @author Johan
 */
public class ManageBooks {
  private String book;
  private String author;
  private boolean acquired;
  private String acquiredDate;
  
  public String getBook() {

        return book;

    }

  public void setBook(String setBook) {

        this.book = setBook;

    }

  public String getAuthor() {

        return author;

    }
  public void setAuthor(String setAuthor) {

        this.author = setAuthor;

    }
  
  public boolean isAcquired() {

        return acquired;

    }

   public void setAcquired(boolean setAcquired) {

        this.acquired = setAcquired;

    }
   
     public String getAcquiredDate() {

        return acquiredDate;

    }

   public void setAcquiredDate(String setAcquiredDate) {

        this.acquiredDate = setAcquiredDate;

    }

    
}
