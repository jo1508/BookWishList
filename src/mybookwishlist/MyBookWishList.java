/*
 Book Wish List Java FX Desktop UI on SQL Server DB
 * @author Johan
 *
 */
package mybookwishlist;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyBookWishList extends Application {

    Pane mainLayout = new Pane();
    Scene mainScene = new Scene(mainLayout, 800, 600);
    Pane secondLayout = new Pane();
    Scene secondScene = new Scene(secondLayout, 800, 600);

    ManageBooks mb = new ManageBooks();
    CaptureBook cb = new CaptureBook();

    @Override

    public void start(Stage primaryStage) {
        mainScene.getStylesheets().add(MyBookWishList.class.getResource("booksCSS.css").toExternalForm());
        secondScene.getStylesheets().add(MyBookWishList.class.getResource("booksCSS.css").toExternalForm());
        //First pane layout defined here
        //Text 
        Text bookTitleText = new Text("Book Title");
        Text bookAuthorText = new Text("Book Author");
        Text bookAcquiredText = new Text("Book Acquired");
        Text dateAcquiredText = new Text("Date Acquired");
        dateAcquiredText.setVisible(false);
        //Text Field
        TextField bookTitleInput = new TextField("Enter Book Name");
        TextField bookAuthorInput = new TextField("Enter Author Name");

        //Dates
        DatePicker dateAcquiredInput = new DatePicker();
        dateAcquiredInput.setVisible(false);

        //Button
        Button addBookBtn = new Button("Add Book To Wish List");
        addBookBtn.setDisable(true);
        addBookBtn.setMinWidth(250);
        Button closeBtn = new Button("Close");
        closeBtn.setMinWidth(250);
        Button showListBtn = new Button("Show Books");
        showListBtn.setMinWidth(250);
        Button backBtn = new Button("Back");
        backBtn.setMinWidth(250);

        //Radio Buttons
        RadioButton acquiredRB = new RadioButton();

        setStyle(bookTitleText, bookAuthorText, bookAcquiredText,
                dateAcquiredText, bookTitleInput, bookAuthorInput,
                dateAcquiredInput, acquiredRB, addBookBtn, closeBtn, showListBtn,
                backBtn);

        setEvents(bookTitleInput, bookAuthorInput, dateAcquiredText,
                dateAcquiredInput, acquiredRB, addBookBtn, closeBtn, showListBtn,
                backBtn,primaryStage, mainScene, secondScene);

        mainLayout.getChildren().addAll(bookTitleText, bookAuthorText,
                bookAcquiredText, dateAcquiredText, bookTitleInput,
                bookAuthorInput, dateAcquiredInput, acquiredRB, addBookBtn,
                closeBtn, showListBtn);
        secondLayout.getChildren().addAll(backBtn);

        primaryStage.setTitle("Book Wish List");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    //Define event handlers in the below method for Textfield, Buttons etc. 
    private void setEvents(TextField bookTitleInput, TextField bookAuthorInput,
            Text dateAcquiredText, DatePicker dateAcquiredInput,
            RadioButton acquiredRB, Button addBookBtn, Button closeBtn,
            Button showListBtn, Button backBtn, Stage primaryStage, Scene mainScene, Scene secondScene) {
        bookTitleInput.setOnKeyPressed((KeyEvent e) -> {
            //Press enter go to next input field
            if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB) {
                bookAuthorInput.clear();
                bookAuthorInput.requestFocus();

            }
        });

        bookTitleInput.setOnMouseClicked((MouseEvent e) -> {
            if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {

                bookTitleInput.clear();
                bookAuthorInput.clear();
                addBookBtn.setDisable(true);

            }

        });

        bookTitleInput.setOnKeyTyped((KeyEvent e) -> {
            bookAuthorInput.clear();
            if (bookAuthorInput.getText().length() > 0) {
                addBookBtn.setDisable(false);
            } else {
                addBookBtn.setDisable(true);

            }

        });
        bookAuthorInput.setOnMouseClicked((MouseEvent e) -> {
            if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {

                bookAuthorInput.clear();

            }

        });

        bookAuthorInput.setOnKeyTyped((KeyEvent e) -> {
            if (bookTitleInput.getText().length() > 0 && bookAuthorInput.getText().length() > 0) {
                addBookBtn.setDisable(false);
            }
        });

        acquiredRB.setOnAction((ActionEvent e) -> {
            {
                if (acquiredRB.isSelected()) {
                    dateAcquiredText.setVisible(true);
                    dateAcquiredInput.setVisible(true);
                } else {
                    dateAcquiredText.setVisible(false);
                    dateAcquiredInput.setVisible(false);

                }
            }

        });
        addBookBtn.setOnAction((ActionEvent e) -> {
            if (bookTitleInput.getText().length() > 0 && bookAuthorInput.getText().length() > 0) {
                mb.setBook(bookTitleInput.getText());
                mb.setAuthor(bookAuthorInput.getText());
                System.out.println(mb.getBook());
                System.out.println(mb.getAuthor());

                if (acquiredRB.isSelected()) {
                    mb.setAcquiredDate(dateAcquiredInput.getValue().toString());
                    cb.AddBook(true, mb.getBook(), mb.getAuthor(), true, mb.getAcquiredDate());
                } else {

                    cb.AddBook(true, mb.getBook(), mb.getAuthor(), false, null);
                }   

            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Title and author required");
                alert.show();
            }
            
        });
        closeBtn.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        showListBtn.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(secondScene);
        });
        backBtn.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(mainScene);
        });
    }

//Define the CSS styling of the UI in below method
    private void setStyle(Text bookTitleText, Text bookAuthorText,
            Text bookAcquiredText, Text dateAcquiredText,
            TextField bookTitleInput, TextField bookAuthorInput,
            DatePicker dateAcquiredInput, RadioButton acquiredRB,
            Button addBookBtn, Button closeBtn, Button showListBtn,
            Button backBtn) {
        //Text CSS
        bookTitleText.getStyleClass().add("customText");
        bookAuthorText.getStyleClass().add("customText");
        bookAcquiredText.getStyleClass().add("customAcquiredText");
        dateAcquiredText.getStyleClass().add("customAcquiredText");

        bookTitleText.setLayoutY(40); //Title Y coordinate
        bookTitleText.setLayoutX(100);// Title X coordinate

        bookAuthorText.setLayoutY(40); //Author Text Y Coordinate
        bookAuthorText.setLayoutX(500);//Author Text X Coordinate

        bookAcquiredText.setLayoutY(125); //Author Text Y Coordinate
        bookAcquiredText.setLayoutX(100);//Author Text X Coordinate

        dateAcquiredText.setLayoutY(150); //Author Text Y Coordinate
        dateAcquiredText.setLayoutX(100);//Author Text X Coordinate

        //TextField CSS
        bookTitleInput.getStyleClass().add("customText");
        bookAuthorInput.getStyleClass().add("customText");
        dateAcquiredInput.getStyleClass().add("customInputAcquiredText");

        bookTitleInput.setLayoutY(50);//Book name input Y coordinate
        bookTitleInput.setLayoutX(100);//Book name inpute X coordinate

        bookAuthorInput.setLayoutY(50); //Author name input Y coordinate
        bookAuthorInput.setLayoutX(500); //Author name input Y coordinate

        dateAcquiredInput.setLayoutY(135); //Author name input Y coordinate
        dateAcquiredInput.setLayoutX(200); //Author name input Y coordinate

        //Button CSS
        addBookBtn.getStyleClass().add("customButtonText");
        addBookBtn.setLayoutY(425);// Add book button Y coordinate
        addBookBtn.setLayoutX(150);// Add book button X coordinate

        showListBtn.getStyleClass().add("customButtonText");
        showListBtn.setLayoutY(425);// Add book button Y coordinate
        showListBtn.setLayoutX(450);// Add book button X coordinate

        closeBtn.getStyleClass().add("customCloseButtonText");
        closeBtn.setLayoutY(525);// Add book button Y coordinate
        closeBtn.setLayoutX(300);// Add book button X coordinate

        backBtn.getStyleClass().add("customButtonText");
        backBtn.setLayoutY(425);// Add book button Y coordinate
        backBtn.setLayoutX(300);// Add book button X coordinate
        //RadioButton CSS
        acquiredRB.setLayoutY(110);
        acquiredRB.setLayoutX(230);

    }

}
