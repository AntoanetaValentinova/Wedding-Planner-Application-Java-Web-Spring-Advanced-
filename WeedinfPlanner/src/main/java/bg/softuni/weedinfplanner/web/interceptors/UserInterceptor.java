package bg.softuni.weedinfplanner.web.interceptors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(isUserLogged()) {
            addToModelDetails(request.getSession());
        }
        return true;
    }

    private void addToModelDetails(HttpSession session) {
        String loggedUsername = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        session.setAttribute("loggedUsername",loggedUsername);
    }

    public static boolean isUserLogged() {
        try{
            return !SecurityContextHolder.getContext().getAuthentication()
                    .getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }
}
