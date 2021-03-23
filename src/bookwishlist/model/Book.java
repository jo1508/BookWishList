/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookwishlist.model;

import java.time.LocalTime;

/**
 *
 * @author jn
 */
public class Book {

    private String author;
    private String title;
    private LocalTime addedDate;
    private boolean acquired;
    private String acquiredDate;

    public Book() {

    }

    public Book(String author, String title, LocalTime addedDate, boolean acquired, String acquiredDate) {
        this.author = author;
        this.title = title;
        this.addedDate = addedDate;
        this.acquired = acquired;
        this.acquiredDate = acquiredDate;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

 
    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public boolean IsAcquired() {
        return acquired;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

}
