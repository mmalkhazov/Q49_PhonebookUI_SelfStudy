package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("maynard1@gmail.com").setPassword ("Maynard@gmail1234"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Karl")
                .setLastName("Adam")
                .setPhone("12345678901")
                .setEmail("karl@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Maynard"));
    }

    @AfterMethod
    public void postCondition(){
            deleteContact();
        }


}



