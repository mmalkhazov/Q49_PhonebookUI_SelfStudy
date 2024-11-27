package com.phonebook.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyListener implements WebDriverListener {

    Logger logger= LoggerFactory.getLogger(MyListener.class);

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("The Test has the problem");
        logger.info("==========================================");

        logger.info("Method -->" + method.getName());
        logger.info("==========================================");

        logger.info("Target exception -->" + e.getTargetException());
        logger.info("==========================================");

        logger.info("Target exception -->" + target.toString());
        logger.info("==========================================");


    }

    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);

        logger.info("The locator will find " + locator);
        logger.info("==========================================");
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);

        logger.info("The locator is " + locator);
        logger.info("==========================================");

    }

    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);

        logger.info("Before fine elements " + locator);
        logger.info("==========================================");
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);

        logger.info("List size is " + result.size());
        logger.info("==========================================");
    }
}