/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybookwishlist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Johan
 

            pstmt = conn.prepareStatement("INSERT into WM_CLIENT_INFO (CLIENT_NAME, CLIENT_TEL, CLIENT_CITY, CLIENT_REF)"
                                           + "VALUES (?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            pstmt.setString(3, city);
            pstmt.setString(4, ref);
            pstmt.executeUpdate();
   */

public class CaptureBook {
 ConnectURL conUrl = new ConnectURL();
    Connection con;
    DriverManager driver;
     void AddBook(boolean addBook, String bookName, String bookAuthor, boolean acquired, String acquiredDate  ) {
      StringBuilder sb = new StringBuilder();
        if (addBook == true) {
            conUrl.Connect(addBook);
            try (Connection con = driver.getConnection(conUrl.connectionUrl)) { //driver needs string of db connection url
                PreparedStatement pstmt = con.prepareStatement("SET NOCOUNT ON INSERT INTO books (Book_Name,Book_Author, Acquired,Date_Acquired,Date_Added) VALUES (?,?,?,?,GetDate())");
                pstmt.setString(1, bookName);
                pstmt.setString(2, bookAuthor);
                pstmt.setBoolean(3, acquired);
                pstmt.setString(4, acquiredDate);
                pstmt.execute();
               
            } 
            catch (SQLException e) {    
                e.printStackTrace();
            }
        }

    }

}
