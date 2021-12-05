package bg.softuni.weedinfplanner.model.service;

public class StatisticServiceModel {
    private Long authenticatedRequests;
    private Long anonymousRequests;
    private Long indexPageViews;
    private Long allOffersPageViews;
    private Long loginPageViews;
    private Long registerPageViews;
    private Long weddingPageViews;
    private Long weddingChecklistPageViews;
    private Long weddingBudgetPageViews;
    private Long weddingGuestsPageViews;
    private Long myOffersPageViews;
    private Long addOfferPageViews;

    public StatisticServiceModel() {
    }

    public Long getAuthenticatedRequests() {
        return authenticatedRequests;
    }

    public StatisticServiceModel setAuthenticatedRequests(Long authenticatedRequests) {
        this.authenticatedRequests = authenticatedRequests;
        return this;
    }

    public Long getAnonymousRequests() {
        return anonymousRequests;
    }

    public StatisticServiceModel setAnonymousRequests(Long anonymousRequests) {
        this.anonymousRequests = anonymousRequests;
        return this;
    }

    public Long getIndexPageViews() {
        return indexPageViews;
    }

    public StatisticServiceModel setIndexPageViews(Long indexPageViews) {
        this.indexPageViews = indexPageViews;
        return this;
    }

    public Long getAllOffersPageViews() {
        return allOffersPageViews;
    }

    public StatisticServiceModel setAllOffersPageViews(Long allOffersPageViews) {
        this.allOffersPageViews = allOffersPageViews;
        return this;
    }

    public Long getLoginPageViews() {
        return loginPageViews;
    }

    public StatisticServiceModel setLoginPageViews(Long loginPageViews) {
        this.loginPageViews = loginPageViews;
        return this;
    }

    public Long getRegisterPageViews() {
        return registerPageViews;
    }

    public StatisticServiceModel setRegisterPageViews(Long registerPageViews) {
        this.registerPageViews = registerPageViews;
        return this;
    }

    public Long getWeddingPageViews() {
        return weddingPageViews;
    }

    public StatisticServiceModel setWeddingPageViews(Long weddingPageViews) {
        this.weddingPageViews = weddingPageViews;
        return this;
    }

    public Long getWeddingChecklistPageViews() {
        return weddingChecklistPageViews;
    }

    public StatisticServiceModel setWeddingChecklistPageViews(Long weddingChecklistPageViews) {
        this.weddingChecklistPageViews = weddingChecklistPageViews;
        return this;
    }

    public Long getWeddingBudgetPageViews() {
        return weddingBudgetPageViews;
    }

    public StatisticServiceModel setWeddingBudgetPageViews(Long weddingBudgetPageViews) {
        this.weddingBudgetPageViews = weddingBudgetPageViews;
        return this;
    }

    public Long getWeddingGuestsPageViews() {
        return weddingGuestsPageViews;
    }

    public StatisticServiceModel setWeddingGuestsPageViews(Long weddingGuestsPageViews) {
        this.weddingGuestsPageViews = weddingGuestsPageViews;
        return this;
    }

    public Long getMyOffersPageViews() {
        return myOffersPageViews;
    }

    public StatisticServiceModel setMyOffersPageViews(Long myOffersPageViews) {
        this.myOffersPageViews = myOffersPageViews;
        return this;
    }

    public Long getAddOfferPageViews() {
        return addOfferPageViews;
    }

    public StatisticServiceModel setAddOfferPageViews(Long addOfferPageViews) {
        this.addOfferPageViews = addOfferPageViews;
        return this;
    }
}
