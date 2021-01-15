package com.napt.ui.gap.pages;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.TextBoxes;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.utils.StepUtils;
import org.openqa.selenium.StaleElementReferenceException;

public class Search {

    public void closeOfferDialog(){
        if(StepUtils.MEW()){
            Clicks.clickIfPresent("search.openOfferDialogBtn");
            Clicks.clickIfPresent("search.closeOfferDialogBtn");
        }else{
            try{
                Clicks.clickIfPresent("home_page.closeBtnOnModalDialog");
            }catch(StaleElementReferenceException sere){
                Clicks.clickIfPresent("home_page.closeBtnOnModalDialog");
            }

        }

    }

    public void searchOnHome(String searchCriteria) {
        closeOfferDialog();
        if(StepUtils.MEW()){
            Wait.secondsUntilElementPresentAndClick("search.homePageMagnifier",5);
            Clicks.javascriptClick("search.homePageMagnifier");
            TextBoxes.typeTextNEnter("search.homePageSearchBox", searchCriteria);
        }else{
            TextBoxes.typeTextNEnter("search.homePageSearchBox", searchCriteria);
            StepUtils.shouldBeOnPage("search");
        }

    }

    public void selectRandomSearchResult()throws Exception{
        //closeOfferDialog();
        if(StepUtils.MEW()){
            Wait.secondsUntilElementToBeClickable("search.searchResults",10);
            //Clicks.scrollToLazyLoadElement("search.searchResults");
            Clicks.clickRandomElement("search.searchResults", webElement -> webElement.isDisplayed());
            StepUtils.shouldBeOnPage("product_page");
        }else{
            Clicks.randomJavascriptClick("search.searchResults");
            StepUtils.shouldBeOnPage("product_page");
        }

    }
}
