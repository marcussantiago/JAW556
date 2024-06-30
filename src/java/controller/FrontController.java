package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import dispatchers.*;
//import model.Book;
import controller.Tbooks;
import model.CartItem;
//import utility.AdmitBookStoreDAO;

/**
 *
 * @author marcu
 */
public class FrontController extends HttpServlet {
   
    private final HashMap actions = new HashMap();

    //Initialize global variables

    /**
     *
     * @param config
     * @throws javax.servlet.ServletException
     */
        public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        actions.put("add_to_cart", new AddToCart_Dispatcher());
        actions.put("titles", new Title_Dispatcher());
        actions.put("checkout", new Checkout_Dispatcher());
        actions.put("view_cart", new ViewCart_Dispatcher());
        actions.put("continue", new Continue_Dispatcher());
        actions.put("update_cart", new UpdateCart_Dispatcher());
                
    }

    //Process the HTTP Get request

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("doGet()");
        doPost(request, response);

    }

    //Process the HTTP Post request

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String requestedAction = request.getParameter("action");
        //HttpSession session = request.getSession();
        if (requestedAction == null){
            requestedAction = "titles";
        }
        //AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        //String nextPage = "";

        //Get the dispatchers from the actions map
        
        Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
        String page = dispatcher.execute(request);
         this.dispatch(request, response, page);
        
        
//        if (requestedAction == "titles") { 
//        //moved the code to dispatcher
//            Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//            
//        } else if (requestedAction.equals("add_to_cart")) {
//              Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//
//        } else if (requestedAction.equals("checkout")) {
//          Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//        } else if (requestedAction.equals("continue")) {
//          Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//        } else if (requestedAction.equals("update_cart")) {
//            Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//     
//        } else if (requestedAction.equals("view_cart")) { 
//              Dispatcher dispatcher = (Dispatcher) actions.get(requestedAction);
//            
//            String page = dispatcher.execute(request); 
//            this.dispatch(request, response, page);
//        }
    }

//    private Book getBookFromList(String isbn, HttpSession session) {
//        List list = (List) session.getAttribute("Books");
//        Book aBook = null;
//        for (int i = 0; i < list.size(); i++) {
//            aBook = (Book) list.get(i);
//            if (isbn.equals(aBook.getIsbn())) {
//                break;
//            }
//        }
//        return aBook;
//    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    //Get Servlet information

    /**
     *
     * @return
     */
        public String getServletInfo() {
        return "controller.FrontController Information";
    }


}