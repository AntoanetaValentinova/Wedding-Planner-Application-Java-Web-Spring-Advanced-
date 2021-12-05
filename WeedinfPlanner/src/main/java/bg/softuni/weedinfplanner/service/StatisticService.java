package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.service.StatisticServiceModel;

import java.security.Principal;

public interface StatisticService {
    void onRequest(Principal userPrincipal, String requestURI);

    StatisticServiceModel getStatistic();
}
