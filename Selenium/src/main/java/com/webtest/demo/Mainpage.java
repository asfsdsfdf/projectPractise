package com.webtest.demo;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mainpage {
    public WebDriver driver;
    String url = "http://localhost:8088/";
    @Test
    public void test1() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[2]/a")).click();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "http://localhost:8088/index/category/2");
        driver.quit();
    }
    @Test
    public void test2() {
        driver.findElement(By.className("carousel-inner")).click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void test3() {
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[3]/ul/li[1]/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[2]/a")).click();
        String FirstHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) {                //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
            System.out.println(driver.getCurrentUrl());     //打印是否为新窗口
            System.out.println("书籍详情");

            Assert.assertEquals(driver.findElement(By.id("book_detail")).getText(), "书籍详情");
        }


    }
    @Test
    public void test4() {

        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/ul/li[1]/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[2]/a")).click();
        String FirstHandle = driver.getWindowHandle();     //首先得到最先的窗口 权柄
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) {                //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
            System.out.println(driver.getCurrentUrl());     //打印是否为新窗口
            Assert.assertEquals(driver.findElement(By.id("book_detail")).getText(), "书籍详情");

    }
    }

    @Test
    public void test27(){

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[2]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/book/list?cateId=2");

    }

    @Test
    public void test39(){

        driver.findElement(By.xpath("/html/body/div[6]/div/dl[1]/dd[1]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/");
    }
    @Test
    public void test40(){

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/a/img")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/");
    }

    @Test
    public void test44(){

        driver.findElement(By.id("keywords")).sendKeys("java");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/button")).click();
        Assert.assertEquals(driver.findElement(By.className("search_word")).getText(),"java");
    }
    @Test
    public void test45(){

        driver.findElement(By.id("keywords")).sendKeys("!@#$#@$%$");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/button")).click();
        Assert.assertEquals(driver.findElement(By.className("red")).getText(),"0");
    }
    @Test
    public void test46(){

        driver.findElement(By.id("keywords")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/button")).click();
        Assert.assertEquals(driver.findElement(By.className("search_word")).getText(),"java");
    }
    @Test
    public void test47(){
        driver.findElement(By.id("keywords")).sendKeys("agfdghgfcdvfbghytrfesddtrtewea243457643245675643524331eqwfwsrg54352qewdafesgrzey5434rwfsgrhdt5y4twefsgdbfnxtj6y5etgvbfdngfxytjryegdbfngmkyuu6ryegdhfgnyk7u65y4tesgdfhtrsy5e4atwfqasdgrhezy534twf");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/button")).click();
        Assert.assertEquals(driver.findElement(By.className("red")).getText(),"0");
    }
    @Test
    public void test48(){
        driver.get("http://localhost:8088");
        driver.findElement(By.className("title")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8088/");
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
