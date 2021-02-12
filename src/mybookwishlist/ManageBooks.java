/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybookwishlist;


/**
 *
 * @author Johan
 */
public class ManageBooks {
  private String book;
  private String author;
  private boolean acquired;
  String acquiredDate;
  String getBook() {

        return book;

    }

  void setBook(String setBook) {

        this.book = setBook;

    }

  String getAuthor() {

        return author;

    }
  void setAuthor(String setAuthor) {

        this.author = setAuthor;

    }
  
  boolean getAcquired() {

        return acquired;

    }

   void setAcquired(boolean setAcquired) {

        this.acquired = setAcquired;

    }
   
     String getAcquiredDate() {

        return acquiredDate;

    }

   void setAcquiredDate(String setAcquiredDate) {

        this.acquiredDate = setAcquiredDate;

    }

    
}
