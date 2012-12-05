package com.epam.ha.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import com.epam.ha.pages.YandexHomePage;

public class YandexSearchSteps extends ScenarioSteps {
    
    public YandexSearchSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void open_home_page() {
        getPages().currentPageAt(YandexHomePage.class);
    }

    @Step
    public void searchFor(String term) {
        YandexHomePage page = (YandexHomePage) getPages().currentPageAt(YandexHomePage.class);
        page.searchFor(term);
    }
}