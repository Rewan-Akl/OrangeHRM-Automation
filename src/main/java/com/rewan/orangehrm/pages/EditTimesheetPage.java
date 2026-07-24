package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditTimesheetPage extends BasePage {

    public EditTimesheetPage() {
        super();
    }

    private final By deleteRowButton =
            By.xpath("//button[.//i[contains(@class,'bi-trash')]]");
    private final By projectInput =
            By.xpath("//input[@placeholder='Type for hints...']");
    private final By activityDropdown =
            By.xpath("//div[contains(@class,'oxd-select-text--active')]");
    private By activityOption(String activity) {
        return By.xpath("//div[@role='option']//span[normalize-space()='" + activity + "']");
    }
    private By projectSuggestion(String project) {
        return By.xpath("//div[@role='listbox']//span[normalize-space()='" + project + "']");
    }
    private By dayInput(int columnIndex) {
        return By.xpath("//table//tbody/tr[1]/td[" + columnIndex + "]//input");
    }
    private final By saveButton =
            By.xpath("//button[@type='submit' and normalize-space()='Save']");
    private final By totalHours =
            By.xpath("//tbody/tr[1]/td[last()]");
    private final By submitButton =
            By.xpath("//button[@type='button' and normalize-space()='Submit']");

    public void deleteExistingRow() {
        click(deleteRowButton);
    }
    public void selectProject(String searchText, String projectName) {
        type(projectInput, searchText);
        click(projectSuggestion(projectName));
    }
    public void selectActivity(String activity) {
        click(activityDropdown);
        click(activityOption(activity));
    }
    public void logHours(String hours) {
        type(dayInput(3), hours);
        type(dayInput(4), hours);
        type(dayInput(5), hours);
    }

    public void clickOnSaveButton() {
        click(saveButton);
    }

    public String getTotalHours() {
        return getText(totalHours);
    }

    public void clickOnSubmitButton() {
        click(submitButton);
    }
    public void waitForSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
    }
}
