package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i =(int)((System.currentTimeMillis()/1000)%3600);
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("maynard1" + i + "@gmail.com").setPassword( "Maynard@gmail1234"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("maynard1@gmail.com").setPassword ("Maynard@gmail1234"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());


    }

}
