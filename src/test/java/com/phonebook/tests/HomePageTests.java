package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{


    @Test
    public void isHomeComponentPresentTest(){
//        driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        Assert.assertTrue(isHomeComponentPresent());

    }


}
