/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import model.Book;
import controller.Tbooks;

/**
 *
 * @author marcu
 */
public class Title_Dispatcher implements Dispatcher {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /**
     * Request information on the list of books titles
     * @param request
     * @return list of books
     */
    @Override
    public String execute(HttpServletRequest request){
        
        
//            AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
            emf = Persistence.createEntityManagerFactory("BookShopPU");
            em =  emf.createEntityManager();
            List books = null;
            String nextPage = "/jsp/error.jsp";
            HttpSession session = request.getSession();
            try {
//                books = dao.getAllBooks();
                books = em.createNamedQuery("Tbooks.findAll", Tbooks.class).getResultList();
                session.setAttribute("Books", books);
                emf.close();
                nextPage = "/jsp/titles.jsp";

            } catch (Exception ex) {
                request.setAttribute("result", ex.getMessage());
                nextPage = "/jsp/error.jsp";
            }        
        
        return nextPage;
    }
    
}
