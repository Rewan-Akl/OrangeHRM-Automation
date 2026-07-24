package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class EmployeeTimesheetPage extends BasePage {

    private final By approveButton =
            By.xpath("//button[normalize-space()='Approve']");

    public void clickOnApproveButton() {
        click(approveButton);
    }
}