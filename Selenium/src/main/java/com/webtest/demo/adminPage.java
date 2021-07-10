package com.webtest.demo;

import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class adminPage {


    public WebDriver driver;
    String url="http://localhost:8088/admin";
    @Test
    public void test36() {
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/admin");
    }
    @Test
    public void test37(){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[5]/div[1]/h4/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[5]/div[2]/div/ul/li[1]/a")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/svg/text[1]/tspan")).getText(),"书籍访问量前8名");
    }
    @Test
    public void test38(){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[7]/div[1]/h4/a")).click();
        driver.findElement(By.xpath(" /html/body/div[1]/div[2]/div[7]/div[2]/div/ul/li[1]/a")).click();
        String FirstHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) {                //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
            System.out.println(driver.getCurrentUrl());
        }
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088");
    }

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        driver.get(url);
        Thread.sleep(3000);
    }
    @AfterMethod
    public void AfterTest() {

        driver.quit();
    }

}
