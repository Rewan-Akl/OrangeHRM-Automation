package com.rewan.orangehrm.tests;

import com.rewan.orangehrm.base.BaseTest;
import com.rewan.orangehrm.pages.*;
import com.rewan.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableEmployeeTest extends BaseTest {

    @Test
    public void verifyAdminCanDisableEmployee() {

        // Step 1: Login with admin credentials
        LoginPage loginPage = new LoginPage();

        DashboardPage dashboardPage = loginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password")
        );

        // Step 2: Click on Admin
        AdminPage adminPage = dashboardPage.openAdminPage();

        // Step 3: Search employee and click Edit
        UserManagementPage userManagementPage =
                adminPage.openUserManagementPage();

        userManagementPage.searchByUsername(
                ConfigReader.getProperty("employee.username")
        );

        EditUserPage editUserPage =
                userManagementPage.clickOnEditButton(
                        ConfigReader.getProperty("employee.username")
                );

        // Step 4: Disable employee
        editUserPage.disableEmployee();

        // Step 5: Save
        editUserPage.clickOnSaveButton();

        // Step 6: Logout
        loginPage = editUserPage.logout();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page is not displayed after logout."
        );

        // Step 7: Login with employee credentials
        loginPage.login(
                ConfigReader.getProperty("employee.username"),
                ConfigReader.getProperty("employee.password")
        );

        // Step 8: Validate account disabled message
        Assert.assertEquals(
                loginPage.getAccountDisabledMessage(),
                "Account disabled",
                "Incorrect disabled account message."
        );
    }
}