package com.webtest.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderCreatePage {
    public WebDriver driver;
    String url ="http://localhost:8088/book/info/10";
    @Test
    public void test17(){

        driver.findElement(By.className("toShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/list");
    }

    @Test
    public void test18(){

        driver.findElement(By.className("toCart")).click();
        String sentence=driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/ul/li/div/form/div/div[1]/div/div[1]/div/div[1]/p")).getText();
        Assert.assertEquals(sentence,"登录支付宝账户付款");
    }
    @Test
    public void test19(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_newBtn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/ul/li/div/form/div/div[1]/div/div[2]/div/div[1]/div")).getText(),"请填写支付宝账户");
    }
    @Test
    public void test20(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.name("payPasswd_rsainput")).sendKeys("111111");
        String username=driver.findElement(By.id("J_tLoginId")).getText();
        Assert.assertEquals(username,":ynkltg9762@sandbox.com");
    }
    @Test
    public void test21(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_tLoginId")).sendKeys("ynkltg9762@sandbox.com");
        String password=driver.findElement(By.name("payPasswd_rsainput")).getText();
        Assert.assertEquals(password,"111111");
    }

    @Test
    public void test22(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_tLoginId")).sendKeys("lynkltg9762@sandbox.com");
        driver.findElement(By.name("payPasswd_rsainput")).sendKeys("111111");
        Assert.assertEquals(driver.findElement(By.id("J_tLoginId")).getText(),"lynkltg9762@sandbox.com");
    }
    @Test
    public void test23(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_tLoginId")).sendKeys("ynkltg9762@sandbox.com");
        driver.findElement(By.name("payPasswd_rsainput")).sendKeys("1111111");
        Assert.assertEquals(driver.findElement(By.name("payPasswd_rsainput")).getText(),"111111");
    }
    @Test
    public void test24(){
        driver.findElement(By.className("toCart")).click();
        driver.findElement(By.id("J_tLoginId")).sendKeys("ynkltg9762@sandbox.com");
        driver.findElement(By.name("payPasswd_rsainput")).sendKeys("111111");
        Assert.assertEquals(driver.findElement(By.name("payPasswd_rsainput")).getText(),"111111");
        Assert.assertEquals(driver.findElement(By.id("J_tLoginId")).getText(),"lynkltg9762@sandbox.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/ul/li/div/form/div/div[1]/div/div[2]/div/div[5]/div[2]/a/span"))
                .click();
    }
    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout_btn")).click();
    }
    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

}
