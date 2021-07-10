package com.webtest.demo;

import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bookpage {

    public WebDriver driver;
    String url="http://localhost:8088/book/info/10";
    @Test
    public void test5 () {

        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div/a/img")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/info/10");


    }
    @Test
    public void test6 (){

        int  i;
        for(i=0;i<15;i++)
        {
            driver.findElement(By.xpath("//*[@id=\"num_add\"]")).click();
        }
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/info?bookId=10&buyNum=10");
    }


    @Test
    public void test7 (){
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[3]/ul/li[1]/a/img")).click();
        String FirstHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) {                //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
            System.out.println(driver.getCurrentUrl());
            driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[1]/div/ul/li[1]/p[1]/a/img")).click();
            String SecondHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
            for (String win1Handle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
                if (win1Handle.equals(SecondHandle)) {                //如果为 最先的窗口 权柄跳出
                    continue;
                }
            }
        }
        driver.quit();
    }

    @Test
    public void test8(){

        driver.findElement(By.className("add_cart")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/page/login");

    }
    @Test
    public void test9() {

        driver.findElement(By.className("buy_now")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8088/page/login");
    }

    @Test
    public void test10(){

        driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[2]/ul/li[2]/a")).click();
        String commit =driver.findElement(By.id("book_comment_content")).getText();
        Assert.assertEquals(commit,"商品评论");

    }

    @Test
    public void test11(){

        driver.findElement(By.className("add_cart")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/cart/addition?bookId=10&buyNum=1");

    }

    @Test
    public void test12() throws InterruptedException {
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/info?bookId=10&buyNum=1");
    }

    @Test
    public void test13() throws InterruptedException {

        driver.findElement(By.className("add_cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.id("loginButton")).click();
            String sentence = driver.findElement(By.className("success_text")).getText();
            Assert.assertEquals(sentence, "商品已成功添加到购物车中！");

    }

    @Test
    public void test14() throws InterruptedException {

        driver.findElement(By.className("buy_now")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(3000);
        String sentence = driver.findElement(By.xpath(
                "/html/body/div[4]/form/div[1]/h1")).getText();
        Assert.assertEquals(sentence,"收货人信息");
    }

    @Test
    public void test41(){

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/a/img")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/#");
    }
    @Test
    public void test42(){

        for(int i=0;i<15;i++) {
            driver.findElement(By.xpath("//*[@id=\"num_sub\"]")).click();
        }
        driver.findElement(By.className("buy_now")).click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/order/info?bookId=10&buyNum=1");

    }

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }
    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }


}