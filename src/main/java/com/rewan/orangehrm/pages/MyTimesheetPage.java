package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class MyTimesheetPage extends BasePage {

    private final By myTimesheetHeader =
            By.xpath("//h6[normalize-space()='My Timesheet']");

    private final By editButton =
            By.xpath("//button[normalize-space()='Edit']");

    private final By status =
            By.xpath("//p[contains(normalize-space(),'Status:')]");

    public boolean isMyTimesheetPageDisplayed() {
        return isDisplayed(myTimesheetHeader);
    }

    public EditTimesheetPage clickOnEditButton() {
        click(editButton);
        return new EditTimesheetPage();
    }

    public String getStatus() {
        return getText(status);
    }
}