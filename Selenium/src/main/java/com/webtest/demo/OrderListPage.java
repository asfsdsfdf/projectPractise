package com.webtest.demo;

import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderListPage {

    public WebDriver driver;
    String url ="http://localhost:8088/book/info/10";
    @Test
    public void test50() throws InterruptedException {
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout_btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("toShopping")).click();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[4]/div/h1")).getText(),"订单列表");
    }
    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        Thread.sleep(1000);
    }
    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

}
