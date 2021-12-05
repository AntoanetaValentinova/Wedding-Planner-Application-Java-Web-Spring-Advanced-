package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistic extends BaseEntity{
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

    public Statistic() {
    }

    @Column
    public Long getAuthenticatedRequests() {
        return authenticatedRequests;
    }

    public Statistic setAuthenticatedRequests(Long authenticatedRequests) {
        this.authenticatedRequests = authenticatedRequests;
        return this;
    }

    @Column
    public Long getAnonymousRequests() {
        return anonymousRequests;
    }

    public Statistic setAnonymousRequests(Long anonymousRequests) {
        this.anonymousRequests = anonymousRequests;
        return this;
    }

    @Column(name="index_page_views")
    public Long getIndexPageViews() {
        return indexPageViews;
    }

    public Statistic setIndexPageViews(Long indexPageViews) {
        this.indexPageViews = indexPageViews;
        return this;
    }

    @Column(name="all_offers_page_views")
    public Long getAllOffersPageViews() {
        return allOffersPageViews;
    }

    public Statistic setAllOffersPageViews(Long allOffersPageViews) {
        this.allOffersPageViews = allOffersPageViews;
        return this;
    }

    @Column(name="login_page_views")
    public Long getLoginPageViews() {
        return loginPageViews;
    }

    public Statistic setLoginPageViews(Long loginPageViews) {
        this.loginPageViews = loginPageViews;
        return this;
    }

    @Column(name="register_page_views")
    public Long getRegisterPageViews() {
        return registerPageViews;
    }

    public Statistic setRegisterPageViews(Long registerPageViews) {
        this.registerPageViews = registerPageViews;
        return this;
    }

    @Column(name="wedding_page_views")
    public Long getWeddingPageViews() {
        return weddingPageViews;
    }

    public Statistic setWeddingPageViews(Long weddingPageViews) {
        this.weddingPageViews = weddingPageViews;
        return this;
    }

    @Column(name="wedding_checklist_page_views")
    public Long getWeddingChecklistPageViews() {
        return weddingChecklistPageViews;
    }

    public Statistic setWeddingChecklistPageViews(Long weddingChecklistPageViews) {
        this.weddingChecklistPageViews = weddingChecklistPageViews;
        return this;
    }

    @Column(name="wedding_budget_page_views")
    public Long getWeddingBudgetPageViews() {
        return weddingBudgetPageViews;
    }

    public Statistic setWeddingBudgetPageViews(Long weddingBudgetPageViews) {
        this.weddingBudgetPageViews = weddingBudgetPageViews;
        return this;
    }

    @Column(name="wedding_guests_page_views")
    public Long getWeddingGuestsPageViews() {
        return weddingGuestsPageViews;
    }

    public Statistic setWeddingGuestsPageViews(Long weddingGuestsPageViews) {
        this.weddingGuestsPageViews = weddingGuestsPageViews;
        return this;
    }

    @Column(name="my_offers_page_views")
    public Long getMyOffersPageViews() {
        return myOffersPageViews;
    }

    public Statistic setMyOffersPageViews(Long myOffersPageViews) {
        this.myOffersPageViews = myOffersPageViews;
        return this;
    }

    @Column(name="add_offer_page_views")
    public Long getAddOfferPageViews() {
        return addOfferPageViews;
    }


    public Statistic setAddOfferPageViews(Long addOfferPageViews) {
        this.addOfferPageViews = addOfferPageViews;
        return this;
    }
}
