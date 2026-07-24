package com.rewan.orangehrm.tests;

import com.rewan.orangehrm.base.BaseTest;
import com.rewan.orangehrm.pages.*;
import com.rewan.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimesheetManagementTest extends BaseTest {

    @Test
    public void verifyAdminCanApproveTimesheet() {

        // Step 1: Login with employee credentials
        LoginPage loginPage = new LoginPage();

        DashboardPage dashboardPage = loginPage.login(
                ConfigReader.getProperty("employee.username"),
                ConfigReader.getProperty("employee.password")
        );

        // Step 2: Click on Time
        MyTimesheetPage myTimesheetPage = dashboardPage.openTimePage();

        Assert.assertTrue(
                myTimesheetPage.isMyTimesheetPageDisplayed(),
                "My Timesheet page is not displayed."
        );

        // Step 3: Open timesheet (Edit)
        EditTimesheetPage editTimesheetPage = myTimesheetPage.clickOnEditButton();

        // Delete existing row
        editTimesheetPage.deleteExistingRow();

        // Step 4: Select Project
        editTimesheetPage.selectProject(
                "Apache",
                "Apache Software Foundation - ASF - Phase 1"
        );
        // Step 5.2: Select Activity
        editTimesheetPage.selectActivity("Bug Fixes");

        // Step 5.3: Log hours for three days
        editTimesheetPage.logHours("08:00");

        // Step 6: Click on Save
        editTimesheetPage.clickOnSaveButton();

        // Step 7: Assert that total is 24:00
        Assert.assertEquals(
                editTimesheetPage.getTotalHours(),
                "24:00",
                "Total hours are incorrect.");

        editTimesheetPage.waitForSubmitButton();

        // Step 8: Click on Submit
        editTimesheetPage.clickOnSubmitButton();

        // Step 9 & 10: Logout
        loginPage = editTimesheetPage.logout();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page is not displayed after logout."
        );

        // Step 11: Login with admin credentials
        dashboardPage = loginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password")
        );

        // Step 12: Click on Time
        TimePage timePage = dashboardPage.openEmployeeTimesheetPage();

        // Step 13: Search employee name
        timePage.searchEmployee(
                "Orange",
                "Orange Test"
        );

        // Step 13: Click on View
        EmployeeTimesheetPage employeeTimesheetPage =
                timePage.clickOnViewButton();

        // Step 14: Click on Approve
        employeeTimesheetPage.clickOnApproveButton();

        loginPage = employeeTimesheetPage.logout();

        dashboardPage = loginPage.login(
                ConfigReader.getProperty("employee.username"),
                ConfigReader.getProperty("employee.password")
        );
        myTimesheetPage = dashboardPage.openTimePage();

        Assert.assertTrue(
                myTimesheetPage.getStatus().contains("Approved"),
                "Timesheet was not approved."
        );

    }
}
