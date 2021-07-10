//package com.webtest.core;
//
//import java.io.IOException;
//import java.util.List;
//
//import com.webtest.utils.MailUtil;
//import org.testng.ITestContext;
//import org.testng.ITestNGMethod;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//public class WebTestListener extends TestListenerAdapter{
//
//	@Override
//	public void onFinish(ITestContext context) {
//		super.onFinish(context);
//		ITestNGMethod[] methods = this.getAllTestMethods();
//		System.out.println("һ��ִ���ˣ�"+methods.length);
//		List <ITestResult> faillist=this.getFailedTests();
//		int len = faillist.size();
//		System.out.println("ʧ�ܵĲ�������"+len+"��");
//		String text="";
//		for(int i=0;i<len;i++) {
//			ITestResult tr=faillist.get(i);
//			System.out.println(tr.getInstanceName()+":"+tr.getName()+"ʧ����"+"\n");
//			text+=tr.getInstanceName()+":"+tr.getName()+"ʧ����"+"\n";
//
//		}
//		System.out.println(text);
//		MailUtil send = new MailUtil();
//		try {
//			send.MailUtil(text);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//	}
//
//
////	public void onTestFailure(ITestResult result) {
////		super.onTestFailure(result);
////		List fail = this.getFailedTests();
////		for(int i = 0; i < fail.size();i++) {
////			ITestResult itr = (ITestResult) fail.get(i);
////			messages += itr.getInstanceName()+":"+itr.getName()+"ʧ��\n";
////		}
////		try {
////			new MailUtil(messages).sendMessage();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
//
//
////	@Override
////	public void onTestFailure(ITestResult tr) {
////		super.onTestFailure(tr);
////
////		// ʧ�ܵĲ�����������
////		BaseTest test = (BaseTest) tr.getInstance();
////		try {
////			new SeleniumScreenShot(test.getDriver()).screenShot();
////		} catch (IOException e) {
////			e.printStackTrace();
////		};
////	}
//
//}
