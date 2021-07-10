package com.webtest.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderPage {

    public WebDriver driver;
    String url ="http://localhost:8088/book/info/10";
    @Test
    public void test15(){
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("checkout_btn")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/creation");
    }

    @Test
    public void test16(){

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.id("checkout_btn")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/creation");
    }
    @Test
    public void test26(){

        driver.findElement(By.xpath("/html/body/div[4]/form/div[5]/dl/select")).click();
        driver.findElement(By.xpath("/html/body/div[4]/form/div[5]/dl/select/option[2]")).click();
        driver.findElement(By.id("checkout_btn")).click();
        driver.findElement(By.className("toCart")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/h1[4]")).getText(),"打开微信扫一扫");

    }//*[@id="orderForm"]
    @Test
    public void test43(){

        driver.findElement(By.xpath("/html/body/div[4]/form/div[1]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/info?bookId=10&buyNum=1");
    }

    @Test
    public void test49(){

        driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/table/tbody/tr[1]/td[1]/a/img")).click();
        Assert.assertEquals(driver.getTitle(),"书籍详情");
    }
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
    }
    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }


}
