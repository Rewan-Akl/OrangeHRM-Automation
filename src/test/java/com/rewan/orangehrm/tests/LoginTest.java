package com.rewan.orangehrm.tests;

import com.rewan.orangehrm.base.BaseTest;
import com.rewan.orangehrm.pages.DashboardPage;
import com.rewan.orangehrm.pages.LoginPage;
import com.rewan.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyAdminCanLogin() {

        LoginPage loginPage = new LoginPage();

        DashboardPage dashboardPage = loginPage.login(
                ConfigReader.getProperty("admin.username"),
                ConfigReader.getProperty("admin.password")
        );

        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
}