package com.rewan.orangehrm.tests;

import com.rewan.orangehrm.base.BaseTest;
import com.rewan.orangehrm.pages.AddUserPage;
import com.rewan.orangehrm.pages.AdminPage;
import com.rewan.orangehrm.pages.DashboardPage;
import com.rewan.orangehrm.pages.LoginPage;
import com.rewan.orangehrm.pages.UserManagementPage;
import com.rewan.orangehrm.utils.ConfigReader;
import com.rewan.orangehrm.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagementTest extends BaseTest {

    @Test
    public void verifyAdminCanCreateUser() {

        // Step 1: Login with admin credentials
        LoginPage adminLoginPage = new LoginPage();

        DashboardPage dashboardPage = adminLoginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password")
        );

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login."
        );

        // Step 2: Click on Admin
        AdminPage adminPage = dashboardPage.openAdminPage();

        Assert.assertTrue(
                adminPage.isAdminPageDisplayed(),
                "Admin page is not displayed."
        );

        // Step 3: Click on Add button
        AddUserPage addUserPage = adminPage.clickOnAddButton();

        Assert.assertTrue(
                addUserPage.isAddUserPageDisplayed(),
                "Add User page is not displayed."
        );

        // Test Data
        String username = DataGenerator.generateUsername();
        String password = DataGenerator.generatePassword();

        // Step 4 & 5: Fill user details and click Save
        UserManagementPage userManagementPage = addUserPage.createUser(
                "ESS",
                "Orange Test",
                "Enabled",
                username,
                password
        );

        // Step 6: Assert that account successfully created
        userManagementPage.searchByUsername(username);

        Assert.assertTrue(
                userManagementPage.isUserDisplayed(username + username),
                "Created user is not displayed in the table."
        );

        // Step 7 & 8: Click on Admin Profile then Logout
        LoginPage loginPage = dashboardPage.logout();

        // Step 9: Login with the newly created user
        DashboardPage newDashboardPage = loginPage.login(
                username + username,
                password
        );

        // Step 10: Assert that account successfully opened
        Assert.assertTrue(
                newDashboardPage.isDashboardDisplayed(),
                "New user failed to login."
        );
    }
}