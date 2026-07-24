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

        // Step 2: Navigate to My Timesheet page
        MyTimesheetPage myTimesheetPage = dashboardPage.openTimePage();

        Assert.assertTrue(
                myTimesheetPage.isMyTimesheetPageDisplayed(),
                "My Timesheet page is not displayed."
        );

        // Step 3: Open the timesheet for editing
        EditTimesheetPage editTimesheetPage = myTimesheetPage.clickOnEditButton();

        // Remove any existing timesheet row
        editTimesheetPage.deleteExistingRow();

        // Step 4: Select Project
        editTimesheetPage.selectProject(
                "Apache",
                "Apache Software Foundation - ASF - Phase 1"
        );

        // Step 5: Select Activity
        editTimesheetPage.selectActivity("Bug Fixes");

        // Step 6: Enter working hours for three days
        editTimesheetPage.logHours("08:00");

        // Step 7: Save the timesheet
        editTimesheetPage.clickOnSaveButton();

        // Step 8: Verify total logged hours
        Assert.assertEquals(
                editTimesheetPage.getTotalHours(),
                "24:00",
                "Total hours are incorrect."
        );

        // Wait until the Submit button becomes visible
        editTimesheetPage.waitForSubmitButton();

        // Step 9: Submit the timesheet
        editTimesheetPage.clickOnSubmitButton();

        // Step 10: Logout from employee account
        loginPage = editTimesheetPage.logout();

        // Verify that the Login page is displayed
        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page is not displayed after logout."
        );

        // Step 11: Login with admin credentials
        dashboardPage = loginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password")
        );

        // Step 12: Navigate to Employee Timesheet page
        TimePage timePage = dashboardPage.openEmployeeTimesheetPage();

        // Step 13: Search for the employee
        timePage.searchEmployee(
                "Orange",
                "Orange Test"
        );

        // Step 14: Open the employee's timesheet
        EmployeeTimesheetPage employeeTimesheetPage =
                timePage.clickOnViewButton();

        // Step 15: Approve the timesheet
        employeeTimesheetPage.clickOnApproveButton();

        // Step 16: Logout from admin account
        loginPage = employeeTimesheetPage.logout();

        // Step 17: Login again with employee credentials
        dashboardPage = loginPage.login(
                ConfigReader.getProperty("employee.username"),
                ConfigReader.getProperty("employee.password")
        );

        // Step 18: Navigate to My Timesheet page
        myTimesheetPage = dashboardPage.openTimePage();

        // Step 19: Verify that the timesheet status is Approved
        Assert.assertTrue(
                myTimesheetPage.getStatus().contains("Approved"),
                "Timesheet was not approved."
        );
    }
}