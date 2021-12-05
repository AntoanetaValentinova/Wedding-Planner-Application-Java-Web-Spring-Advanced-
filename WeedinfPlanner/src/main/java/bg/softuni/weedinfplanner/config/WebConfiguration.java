package bg.softuni.weedinfplanner.config;

import bg.softuni.weedinfplanner.web.interceptors.StatisticInterceptor;
import bg.softuni.weedinfplanner.web.interceptors.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private final StatisticInterceptor statisticInterceptor;
    private final UserInterceptor userInterceptor;

    public WebConfiguration(StatisticInterceptor statisticInterceptor, UserInterceptor userInterceptor) {
        this.statisticInterceptor = statisticInterceptor;
        this.userInterceptor = userInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.userInterceptor);
        registry.addInterceptor(this.statisticInterceptor);
    }
}
