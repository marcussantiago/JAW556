/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author marcu
 */
public interface Dispatcher {

    /**
     *
     * @param request
     * @return
     */
    public String execute (HttpServletRequest request);
    
}
