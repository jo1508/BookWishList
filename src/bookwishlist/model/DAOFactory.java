package bookwishlist.model;
/**
 *
 * @author Johan
 */
public class DAOFactory {
    
    
    public static BookDAO getBookDao() {
    return new BookDAO();
}
}
