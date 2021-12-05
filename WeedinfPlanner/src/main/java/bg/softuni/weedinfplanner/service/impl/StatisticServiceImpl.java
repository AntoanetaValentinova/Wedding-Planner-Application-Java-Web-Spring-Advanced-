package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Statistic;
import bg.softuni.weedinfplanner.model.service.StatisticServiceModel;
import bg.softuni.weedinfplanner.repository.StatisticRepository;
import bg.softuni.weedinfplanner.service.StatisticService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;
    private final ModelMapper modelMapper;

    public StatisticServiceImpl(StatisticRepository statisticRepository, ModelMapper modelMapper) {
        this.statisticRepository = statisticRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void onRequest(Principal userPrincipal, String requestURI) {
        Statistic statistic = statisticRepository.findById(1L).orElse(null);
        if(statistic!=null) {
            if (userPrincipal==null) {
                statistic.setAnonymousRequests(statistic.getAnonymousRequests()+1);
            } else {
                statistic.setAuthenticatedRequests(statistic.getAuthenticatedRequests()+1);
            }

            switch (requestURI) {
                case "/offers": statistic.setAllOffersPageViews(statistic.getAllOffersPageViews()+1); break;
                case "/offers/add": statistic.setAddOfferPageViews(statistic.getAddOfferPageViews()+1); break;
                case "/": statistic.setIndexPageViews(statistic.getIndexPageViews()+1); break;
                case "/login": statistic.setLoginPageViews(statistic.getLoginPageViews()+1); break;
                case "/register": statistic.setRegisterPageViews(statistic.getRegisterPageViews()+1); break;
                case "/supplier-profile/my-offers": statistic.setMyOffersPageViews(statistic.getMyOffersPageViews()+1); break;
                case "/wedding-budget": statistic.setWeddingBudgetPageViews(statistic.getWeddingBudgetPageViews()+1); break;
                case "/wedding-checklist": statistic.setWeddingChecklistPageViews(statistic.getWeddingChecklistPageViews()+1); break;
                case "/wedding-guests": statistic.setWeddingGuestsPageViews(statistic.getWeddingGuestsPageViews()+1); break;
                case "/wedding": statistic.setWeddingPageViews(statistic.getWeddingPageViews()+1); break;
            }
            this.statisticRepository.save(statistic);
        }
    }

    @Override
    public StatisticServiceModel getStatistic() {
        Statistic statistic = this.statisticRepository.findById(1L).orElseThrow(() -> new ObjectNotFoundException());
        return this.modelMapper.map(statistic,StatisticServiceModel.class);
    }
}
