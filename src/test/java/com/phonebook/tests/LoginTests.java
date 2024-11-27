package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void loginPositiveTest(){
        logger.info("Login with data -->" + UserData.EMAIL + "" + UserData.PASSWORD);
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("maynard1@gmail.com").setPassword ("Maynard@gmail1234"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword("Maynard@gmail1234"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }


}
