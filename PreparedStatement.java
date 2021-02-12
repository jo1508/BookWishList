import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

 
 StringBuilder sb = new StringBuilder();
        if (addBook == true) {
            try {
                PreparedStatement stmt = exportConn.prepareStatement("INSERT INTO wishlist.books (BookID,Book_Name,Book_Author) SELECT " + bookName + "," + bookAuthor );
                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    sb.append(String.format("| %-10s", metadata.getColumnName(i) + ", "));
                }
                System.out.println();
                while (rs.next()) {
                    String row = "";
                    for (int i = 1; i <= columnCount; i++) {
                        row += rs.getString(i) + ", ";
                    }
                    System.out.println(row);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        

            if (assessments == true) {
                try {
                    PreparedStatement stmt = exportConn.prepareStatement("select * from ");
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (assessments == true) {
                try {
                    PreparedStatement stmt = exportConn.prepareStatement("select * from  ");
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }