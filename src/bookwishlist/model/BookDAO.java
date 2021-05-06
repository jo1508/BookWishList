/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookwishlist.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Johan
 *
 *
 */
public class BookDAO {

    Database connectURL = Database.getDb();

    public void AddBook(Book book) {
        connectURL.Connect(false);

        try {
            Connection newConnection
                    = DriverManager.getConnection(connectURL.getConnectionURL());  //driver needs string of db connection url
            PreparedStatement pstmt = newConnection.prepareStatement(
                    "SET NOCOUNT ON INSERT "
                    + "INTO books ("
                    + "Book_Title,"
                    + "Book_Author,"
                    + "Acquired,"
                    + "Date_Acquired,"
                    + "Date_Added)"
                    + "VALUES "
                    + "(?,?,?,?,getDate())");
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setBoolean(3, book.IsAcquired());
            pstmt.setString(4, book.getAcquiredDate());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
