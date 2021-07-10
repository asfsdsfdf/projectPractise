package com.webtest.report;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.webtest.utils.MailUtil;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import freemarker.template.*;

public class GenerateReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        // TODO Auto-generated method stub
        try {
            //freemaker的配置
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setClassForTemplateLoading(this.getClass(),"/templates");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //freemaker的模板文件
            Template temp = cfg.getTemplate("overview.ftl");

            Map context = new HashMap();

            for (ISuite suite : suites) {
                Map<String, ISuiteResult> suiteResults = suite.getResults();
                for (ISuiteResult suiteResult : suiteResults.values()) {
                    ReporterData data = new ReporterData();
                    ITestContext testContext = suiteResult.getTestContext();
                    // 把数据填入上下文
                    context.put("overView", data.testContext(testContext));//测试结果汇总信息
                    IResultMap passedTests = testContext.getPassedTests();//测试通过的测试方法
                    IResultMap failedTests = testContext.getFailedTests();//测试失败的测试方法
                    IResultMap skippedTests = testContext.getSkippedTests();//测试跳过的测试方法

                    context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
                    context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
                    context.put("skip", data.testResults(skippedTests, ITestResult.FAILURE));

                }
            }
            // 输出流
            OutputStream out=new FileOutputStream("C:\\Users\\huangshuyuan\\Desktop\\bookstore\\report\\testReport.html");
            Writer writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));//解决乱码问题
            // 转换输出
            temp.process(context,writer);
            writer.flush();

            InputStream inputStream = new FileInputStream("C:\\Users\\huangshuyuan\\Desktop\\bookstore\\report\\testReport.html");
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();

            new MailUtil(text).send();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}