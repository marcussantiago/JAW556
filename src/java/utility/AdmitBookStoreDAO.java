package utility;

import java.util.*;
import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Book;

/**
 *
 * @author marcu
 */
public class AdmitBookStoreDAO {

    private Connection con;

    /**
     *
     */
    public AdmitBookStoreDAO() {
//        try {
//            // Load the Driver class file
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            System.err.println("Getting Connection!");
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BooksDB",
//                    "user1", "password");
//
//            if (con != null) {
//                System.err.println("Got Connection!");
//            }// end if
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }// end catch

        //Using the DataSource
        try{
          InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/BooksDBpool");
            con = ds.getConnection();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }// end of Contructor

    // get info on all courses taught by a lecturer

    /**
     *
     * @return
     * @throws SQLException
     */
        public List getAllBooks() throws SQLException {
        System.out.println("inside getAllBooks");
        Statement statement = con.createStatement();
        ResultSet rs = null;
        List list = new ArrayList();

        rs = statement.executeQuery("SELECT * FROM USER1.TBooks ");
        String isbn = "";
        String title = "";
        String author = "";
        double price = 0.00;
        while (rs.next()) {
            System.out.println("rs has records");
            isbn = rs.getString(1);
            title = rs.getString(2);
            author = rs.getString(3);
            price = rs.getDouble(4);
            list.add(new Book(isbn, title, author, price));
        }
        return list;
    } // end getAllBooks

}
