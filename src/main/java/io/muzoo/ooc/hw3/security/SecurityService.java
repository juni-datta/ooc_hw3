package io.muzoo.ooc.hw3.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityService {

    private UserService userService;

    public boolean isAuthorized(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object usernameObject = session.getAttribute("username");
        return usernameObject != null && usernameObject instanceof String && userService.checkIfUserExists((String) usernameObject);


    }
}
