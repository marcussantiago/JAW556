/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcu
 */
public class Continue_Dispatcher implements Dispatcher {
    
    /**
     *
     * @param request
     * @return
     */
    @Override
    public String execute(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        String nextPage = "/jsp/titles.jsp";
        
        return nextPage;
    }
    
}
