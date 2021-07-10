package com.webtest.demo;

import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayPage {
    public WebDriver driver;
    String url="http://localhost:8088/book/info/10";
    @Test
    public void test25() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ccb702-1\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("J_authSubmit")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h1")).getText(),"502 Bad Gateway");

    }//*[@id="ch-0"]
    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        Thread.sleep(1000);
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.id("checkout_btn")).click();
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_tLoginId")).sendKeys("ynkltg9762@sandbox.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"payPasswd_rsainput\"]")).sendKeys("111111");
        Thread.sleep(3000);
        driver.findElement(By.id("J_newBtn")).click();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

}
