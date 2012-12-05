package com.epam.ha.teststories;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.epam.ha.steps.YandexSearchSteps;

@RunWith(ThucydidesRunner.class)
public class SearchingOnYandexHamstersStory {
	 	@Managed
	    public WebDriver webdriver;

	    @ManagedPages(defaultUrl = "http://www.yandex.com")
	    public Pages pages;
	    
	    @Steps
	    public YandexSearchSteps steps;

	    @Test
	    public void searching_for_hamsters_should_find_the_wikipedia_entry() {
	        steps.open_home_page();
	        steps.searchFor("hamsters");
	   }
}
