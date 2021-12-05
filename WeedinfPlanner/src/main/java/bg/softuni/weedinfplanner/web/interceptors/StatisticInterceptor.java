package bg.softuni.weedinfplanner.web.interceptors;

import bg.softuni.weedinfplanner.service.StatisticService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StatisticInterceptor implements HandlerInterceptor {
    private final StatisticService statisticService;

    public StatisticInterceptor(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.statisticService.onRequest(request.getUserPrincipal(),request.getRequestURI());
        return true;
    }
}
