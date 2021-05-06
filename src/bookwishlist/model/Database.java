/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookwishlist.model;

/**
 *
 * @author Johan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {

    String connectionUrl = "jdbc:sqlserver://";
    Connection exportConn;

    private Database() {

    }
    private final static Database db = new Database();

    public static Database getDb() {
        return db;

    }

    void Connect(boolean connectNow) {
        if (connectNow == true) {

            connectionUrl = "jdbc:sqlserver://localhost\\jn;"
                    + "databaseName=Java_Books;integratedSecurity=true";

        } else {
            
            Scanner input = new Scanner(System.in);
            String host;
            String instance;
            String port;
            String database;
            String prompt;
            String user;
            String password;
            //Build connection URL with user input
            //Host IP
            System.out.println("Enter Host:");
            host = input.next();
            connectionUrl += host;

            //SQL Instance
            System.out.println("Enter Instance (No Instance: 0)");
            instance = input.next();
            if (instance.equals("0")) {

                connectionUrl += "";
            } else {
                connectionUrl += '\\' + instance;
            }

            //Port Number
            System.out.println("Enter Port Number(No Port: 0)");
            port = input.next();
            if (port.equals("0")) {

                connectionUrl += "";
            } else {
                connectionUrl += ':' + port;
            }

            //Database name
            System.out.println("Enter Database Name (No database: 0)");
            database = input.next();
            if (database.equals("0")) {

                connectionUrl += "";
            } else {
                connectionUrl += ";database=" + database;
            }

            //SQL details
            System.out.println("Is there a SQL Username (Yes/No)?");
            prompt = input.next();

            if (prompt.equalsIgnoreCase("Yes")) {
                System.out.println("Enter SQL Username:");
                user = input.next();
                connectionUrl += ";user=" + user;
                System.out.println("Enter SQL User Password:");
                password = input.next();
                connectionUrl += ";password=" + password;
            } else {
                connectionUrl += ";integratedSecurity=true";

            }
        }
        //System.out.println(connectionUrl.substring(connectionUrl.indexOf("//") + 2));
        System.out.println(connectionUrl);
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            exportConn = con;
            System.out.println("Connected!");

        } catch (SQLException e) {
            e.getErrorCode();
            System.out.println("Failed to connect, please check details.");
        }

    }

    public String getConnectionURL() {
        return connectionUrl;
    }
}
