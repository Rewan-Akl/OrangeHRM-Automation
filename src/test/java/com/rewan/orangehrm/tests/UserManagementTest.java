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
    public void verifyAdminCanCreateUser() throws InterruptedException {

        // Step 1: Login with admin credentials
        LoginPage loginPage = new LoginPage();

        DashboardPage dashboardPage = loginPage.login(
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
        // Step 3: Click on the add button
        AddUserPage addUserPage = adminPage.clickOnAddButton();

        Assert.assertTrue(
                addUserPage.isAddUserPageDisplayed(),
                "Add User page is not displayed."
        );

//        // Step 4: Select User Role
//        addUserPage.selectUserRole("ESS");
//
//        // Step 5: Select Employee Name
//        addUserPage.selectEmployeeName("Orange Test");
//
//        // Step 6: Select Status
//        addUserPage.selectStatus("Enabled");
//
//        // Step 7: Enter Username
//        addUserPage.enterUsername("orange.test01");
//
//        // Step 8: Enter Password
//        addUserPage.enterPassword("testPass$12");
//
//        // Step 9: Enter Confirm Password
//        addUserPage.enterConfirmPassword("testPass$12");
            String username = DataGenerator.generateUsername();
            String password = DataGenerator.generatePassword();

        UserManagementPage userManagementPage = addUserPage.createUser(
                "ESS",
                "Orange Test",
                "Enabled",
                username,
                password
        );
        userManagementPage.searchByUsername(username);

        Assert.assertTrue(
                userManagementPage.isUserDisplayed(username + username),
                "Created user is not displayed in the table."
        );
    }
}