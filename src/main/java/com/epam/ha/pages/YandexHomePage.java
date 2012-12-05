package com.epam.ha.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@At("http://www.yandex\\..*")
public class YandexHomePage extends PageObject {

    @FindBy(id="searchInput")
    WebElement query;

//    @FindBy(xpath="//input[@class='b-form-button__input']")
//    WebElement searchButton;// = getDriver().findElement(By.name("btnG"));
    
    public YandexHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String term) {
        query.sendKeys(term);
        getDriver().findElement(By.className("b-form-button__input")).click();
//        searchButton.click();
        waitABit(200);
    }
}