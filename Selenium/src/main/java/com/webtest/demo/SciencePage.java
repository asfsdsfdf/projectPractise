package com.webtest.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SciencePage {

    public WebDriver driver;
    String url="http://localhost:8088/book/list?cateId=2";
    @Test
    public void test28(){
        driver.get("http://localhost:8088/book/list?cateId=2");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/ul/li[1]/div/p/a[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?cateId=2");
    }
    @Test
    public void test29(){
        driver.get("http://localhost:8088/book/list?cateId=2");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/ul/li[1]/a/img")).click();
        String FirstHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) {                //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
            System.out.println(driver.getCurrentUrl());

            Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8088/book/info/1");
        }
    }
    @Test
    public void test30(){
        driver.get("http://localhost:8088/book/list?keywords=&cateId=2&page=1");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[1]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?keywords=&cateId=2&page=1");
    }

    @Test
    public void test31(){
        driver.get("http://localhost:8088/book/list?keywords=&cateId=2&page=1");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[8]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?keywords=&cateId=2&page=2");
    }

    @Test
    public void test32(){
        driver.get("http://localhost:8088/book/list?keywords=&cateId=2&page=1");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[3]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?keywords=&cateId=2&page=2");

    }
    @Test
    public void test33(){
        driver.get("http://localhost:8088/book/list?keywords=&cateId=2&page=6");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/ul/li[8]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?keywords=&cateId=2&page=6");
    }
    @Test
    public void test34(){

        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/ul/li[1]/div/p/a[1]")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/cart/addition?bookId=1&buyNum=1");
    }

    @Test
    public void test35(){
        driver.get("http://localhost:8088/book/info/10");
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/div[2]/span[1]/a[1]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/#");
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
