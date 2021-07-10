//package com.webtest.demo;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//
//public class Demo1 {
//    public WebDriver driver;
//    String url = "https://www.baidu.com/";
//
//
//    @DataProvider(name = "Test")
//    public static Object[][] words() throws IOException {
//        return getTestData("E:\\QQfile\\selenium\\src\\main\\java\\com\\webtest\\demo\\", "TestData.xlsx", "Sheet1");
//
//    }
//
//    @Test(dataProvider = "TestData")
//    public void testSearch(String words1, String words2, String result) {
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(url);
//        driver.findElement(By.id("kw")).sendKeys(words1 + " " + words2);
//        driver.findElement(By.id("su")).click();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue(driver.getPageSource().contains(result));
//    }
//
//    @BeforeMethod
//    public void BeforeMethod() {
//        System.setProperty("webdriver.gecko.driver","D:\\demo\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.get(url);
//    }
//
//    @AfterMethod
//    public void AfterMethod() {
//        driver.quit();
//    }
//
//    public static Object[][] getTestData(String filepath,String filename,String SheetName) throws IOException{
//        File file = new File(filepath + "\\" + filename);
//        FileInputStream inputstream = new FileInputStream(file);
//        Workbook wbook = null;
//        String fileExtensionName = filename.substring(filename.indexOf("."));
//        System.out.println(fileExtensionName);
//        if (fileExtensionName.equals(".xlsx")) {
//            wbook = new XSSFWorkbook(inputstream);
//        } else if (fileExtensionName.equals(".xls")) {
//            wbook = new HSSFWorkbook(inputstream);
//        }
//        Sheet sheet = wbook.getSheet(SheetName);
//        // 通过sheetName生成Sheet对象
//        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//        // 获取当前sheet行数，行号和列号都是从０开始
//        List<Object[]> records = new ArrayList<Object[]>();
//        // 使用双循环获取excel文件的所有数据（第一行除外）
//        for (int i = 1; i < rowCount + 1; i++) {
//            Row row = sheet.getRow(i);
//            String fields[] = new String[row.getLastCellNum()];
//            for (int j = 0; j < row.getLastCellNum(); j++) {
//                // 获取单元格数据
//                fields[j] = row.getCell(j).getStringCellValue();
//            }
//            records.add(fields);
//        }
//        Object[][] results = new Object[records.size()][];
//        for (int i = 0; i < records.size(); i++) {
//            results[i] = records.get(i);
//        }
//        return results;
//
//    }
//}
//
