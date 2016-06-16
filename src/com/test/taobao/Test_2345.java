package com.test.taobao;

import java.io.IOException;

import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class Test_2345 extends UiAutomatorTestCase {
	StartApp startApp = new StartApp();
	
	public static void main(String[] args) throws IOException {
		String jarName = "testTaobao";
    	String testClass = "com.test.taobao.Test_2345";
    	String testName = "test_03_ss";
    	String androidId = "1";
    	
    	new UiAutomatorHelper(jarName,testClass,testName,androidId);
//    	String workspace,className,jarName,androidId,sdkPath;
//    	workspace = "D:\\adt bundle\\workspace\\MotherWorld";
//    	className = "com.motherworld.Test_2345";
//    	jarName = "MotherWorld";
//    	androidId = "1";
//    	sdkPath = "D:\\adt bundle\\adt-bundle-windows-x86_64-20140321\\adt-bundle-windows-x86_64-20140321\\sdk";
//    	CtsHelper cts = new CtsHelper(workspace,className,jarName,androidId,sdkPath);
//    	cts.setDevices("");
//    	cts.runTest();

	}
	
	
	public  void test_02_StartApp() throws IOException{
	       Runtime.getRuntime().exec(" am start -n com.browser2345/com.browser2345.StartBrowserActivity");
	       
	    }
	public void test_03_ss() throws UiObjectNotFoundException, InterruptedException, IOException{
		try {
			Runtime.getRuntime().exec("rm -r /storage/emulated/legacy/2345Browser/2345Screenshot");
			System.out.println("rm Success!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		UiDevice device = getUiDevice();
		double devicewidth = 0;
    	double deviceheigth =0;
		devicewidth =UiDevice.getInstance().getDisplayWidth();
    	deviceheigth =UiDevice.getInstance().getDisplayHeight();
    	
    	UiObject editText01 = new UiObject(new UiSelector().resourceId("com.browser2345:id/urlbar_urltext"));
    	UiObject editText02 = new UiObject(new UiSelector().resourceId("com.browser2345:id/url"));
    	UiObject btnSearch = new UiObject(new UiSelector().resourceId("com.daohang2345:id/browser_go_btn"));
    	UiObject myTaobao = new UiObject(new UiSelector().className("android.view.View").textContains("我的淘宝").index(0));
    	UiObject scanscreen = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/textView3").text("扫一扫"));
    	UiObject selectPic = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/btn_album"));
    	UiObject localAlbum = new UiObject(new UiSelector().resourceId("android.widget.TextView").text("本地"));
    	
    	UiObject showMenu = new UiObject(new UiSelector().resourceId("com.browser2345:id/btn_show_menu"));
    	UiScrollable contentLayout = new UiScrollable(new UiSelector().resourceId("com.browser2345:id/content_layout"));
    	UiObject screen = new UiObject(new UiSelector().textContains("截图涂"));
    	UiObject cropFull = new UiObject(new UiSelector().resourceId("com.browser2345:id/button_cropFull"));
    	UiObject cropSave = new UiObject(new UiSelector().resourceId("com.browser2345:id/button_saveGraffiti"));
    	UiObject screenAlertDialog = new UiObject(new UiSelector().textContains("确"));
    	UiObject open2345Album = new UiObject(new UiSelector().text("2345Screenshot"));
    	UiObject selectKuaitu = new UiObject(new UiSelector().className("android.widget.LinearLayout").index(0)).getFromParent(new UiSelector().resourceId("android:id/resolver_list"));
    	UiObject selectKuaituAlways = new UiObject(new UiSelector().text("始终"));
    	
    	UiObject myTaobao_web_a = new UiObject(new UiSelector().description("我的淘宝 Link").index(0));
    	UiObject myTaobao_web_b = new UiObject(new UiSelector().description("我的淘宝").index(0));
    	UiObject myBuyedGoods_web_a = new UiObject(new UiSelector().description("已买到的宝贝 Link").index(2));
    	UiObject myBuyedGoods_web_b = new UiObject(new UiSelector().description("已买到的宝贝").index(2));
    	UiObject waitPay = new UiObject(new UiSelector().descriptionContains("待付款"));
		Runtime.getRuntime().exec(" am start -n com.browser2345/com.browser2345.StartBrowserActivity");
		Thread.sleep(3000);
		UiObject uo_01 = new UiObject(new UiSelector().resourceId("com.browser2345:id/urlbar_urltext"));
		uo_01.click();
		Thread.sleep(1000);
		editText02.click();
		inputTaobao();
		//btnSearch.click();
		//sleep(2000);
		
//		UiObject uo_02 = new UiObject(new UiSelector().resourceId("com.browser2345:id/urlname").text("淘宝网 - 淘！我喜欢"));
//		uo_02.click();
		Thread.sleep(8000);
		
		UiObject ob_03_a = new UiObject(new UiSelector().description("亲，请登录 Link"));
		UiObject ob_03_b = new UiObject(new UiSelector().description("免费注册 Link"));
		if(ob_03_a.exists()&&ob_03_b.exists()){
			ob_03_a.clickAndWaitForNewWindow();
			Thread.sleep(5000);
			UiObject warnOfPassword = new UiObject(new UiSelector().descriptionContains("密码登录在这里"));
			UiObject warnOfErweima = new UiObject(new UiSelector().descriptionContains("扫码登录送淘金币"));
			
			if(warnOfPassword.exists()){
				System.out.println("当前登陆方式为二维码登陆");
				//device.drag(((int)DoubleArith.mul(DoubleArith.div(300, 600, 4), devicewidth)), ((int)DoubleArith.mul(DoubleArith.div(400, 800, 3), deviceheigth)), ((int)DoubleArith.mul(DoubleArith.div(200, 600, 4), devicewidth)), ((int)DoubleArith.mul(DoubleArith.div(400, 800, 3), deviceheigth)), 20);
			    Thread.sleep(7000L);
			}else{
				Thread.sleep(4000);
				warnOfErweima.click();
				System.out.println("当前登陆方式为密码登陆");
				device.click((int)DoubleArith.mul(DoubleArith.div(450, 600, 4), devicewidth),(int)DoubleArith.mul(DoubleArith.div(180, 800, 4), deviceheigth));
				//device.drag(((int)DoubleArith.mul(DoubleArith.div(300, 600, 4), devicewidth)), ((int)DoubleArith.mul(DoubleArith.div(400, 800, 3), deviceheigth)), ((int)DoubleArith.mul(DoubleArith.div(200, 600, 4), devicewidth)), ((int)DoubleArith.mul(DoubleArith.div(400, 800, 3), deviceheigth)), 20);
				sleep(3000);
			    
			}
			
		    showMenu.click();
		    sleep(2500);
		    
		    contentLayout.swipeLeft(20);
		    Thread.sleep(2000);
		    
		    //screen.click();
		    device.click(85, 700);
		    sleep(2500);
		    
		    cropFull.click();
		    sleep(3500);
		    
		    cropSave.click();
		    sleep(3500);
		    
		    //打开淘宝扫码
		    tsst_01_Before();
		    Thread.sleep(8000);
		    scanscreen.click();
		    Thread.sleep(3000);
		    if(screenAlertDialog.exists()){
		    	screenAlertDialog.click();
		    	sleep(1500);
		    }else{
		    	
		    }
		    
		    sleep(1500);
		    selectPic.click();
		    sleep(2500);
		    
		    if(selectKuaituAlways.exists()){
		    	selectKuaitu.click();
		    	sleep(2000);
		    	selectKuaituAlways.click();
		    	sleep(2000);
		    }else{
		    	
		    }
		    //选择相册
		    device.click((int)DoubleArith.mul(DoubleArith.div(100, 600, 4), devicewidth), (int)DoubleArith.mul(DoubleArith.div(150, 800, 4), deviceheigth));
		    sleep(6000);
		    //选择点击图片
		    device.click(100, 150);
		    sleep(1000);
		    device.click((int)DoubleArith.mul(DoubleArith.div(100, 600, 4), devicewidth), (int)DoubleArith.mul(DoubleArith.div(150, 800, 4), deviceheigth));
		    Thread.sleep(15000);
		    //确认登陆
		    device.click(300, 635);
		    Thread.sleep(4000);
		    try {
				Runtime.getRuntime().exec("rm -r /storage/emulated/legacy/2345Browser/2345Screenshot");
				System.out.println("rm Success!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		    try {
	    		Runtime.getRuntime().exec("am start -n com.browser2345/com.browser2345.StartBrowserActivity");
	    		sleep(3000);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			
		}
		if(myTaobao_web_a.exists()){
	    	myTaobao_web_a.click();
		    sleep(5000);
	    }else{
	    	myTaobao_web_b.click();
		    sleep(5000);
	    }
	    if(myBuyedGoods_web_a.exists()){
	    	myBuyedGoods_web_a.click();
		    sleep(10000);
	    }else{
	    	myBuyedGoods_web_b.click();
		    sleep(10000);
	    }
	    //waitPay.clickAndWaitForNewWindow(8000);
	    //点击付款
	    UiObject payNow = new UiObject(new UiSelector().descriptionContains("立即付款"));
	    if(payNow.exists()){
	    	payNow.clickAndWaitForNewWindow();
	    	sleep(5000);
	    }else{
	    	System.out.println("立即付款不存在");
	    	device.click(460, 280);
	    	sleep(10000);
	    }
	    
	    
	    //点击添加网银
	    UiObject addPayType = new UiObject(new UiSelector().descriptionContains("添加快捷/网银付款"));
	    if(addPayType.exists()){
	    	addPayType.click();
	    	sleep(7000);
	    }else{
	    	device.click(150, 243);
	    	sleep(7000);
	    }
	    
	    //选择银行卡
	    UiObject selectCardType = new UiObject(new UiSelector().descriptionContains("按卡种选"));
	    if(selectCardType.exists()){
	    	selectCardType.click();
	    	sleep(8000);
	    }else{
		    device.click(290, 320);
		    sleep(8000);
	    }

	   
	    //选择储蓄卡
	    UiObject chuxuka_a = new UiObject(new UiSelector().description("储蓄卡"));
	    UiObject chuxuka_b = new UiObject(new UiSelector().description("储蓄卡 Link"));
	    
	    if(chuxuka_a.exists()||chuxuka_b.exists()){
	    	if(chuxuka_a.exists()){
	    		chuxuka_a.click();
	    		sleep(5000);
	    	}else{
	    		chuxuka_b.click();
	    		sleep(5000);
	    	}
	    	
	    }else{
	    	device.click(100, 345);
	    	sleep(5000);
	    }
	    
	    
	    //点击下一步
	    UiObject nextStep = new UiObject(new UiSelector().descriptionContains("下一"));
	    if(nextStep.exists()){
	    	nextStep.click();
	    	sleep(5000);
	    }else{
	    	device.click(100, 425);
	    	sleep(5000);
	    }
	    
	    
	    //选择民生银行
	    UiObject minshengBank = new UiObject(new UiSelector().descriptionContains("中国民生银行"));
	    if(minshengBank.exists()){
	    	minshengBank.click();
	    	sleep(5000);
	    }else{
	    	device.click(400, 410);
		    sleep(5000);
	    }
	    
	    //点击下一步
	    if(nextStep.exists()){
	    	nextStep.click();
	    	sleep(5000);
	    }else{
	        device.click(100, 470);
	        sleep(5000);
	    }
	    //点击网上银行支付
	    UiObject onlineBank = new UiObject(new UiSelector().descriptionContains(" 网上银行(需开通网银) "));
	    if(onlineBank.exists()){
	    	onlineBank.click();
	    	sleep(5000);
	    }else{
	    	device.click(118, 380);
		    sleep(5000);
	    }
	    
	    //点击下一步
	    if(nextStep.exists()){
	    	nextStep.click();
	    	sleep(5000);
	    }else{
	        device.click(100, 420);
	        sleep(7000);
	    }
	    //登陆到网上银行付款
	    UiObject loginOnlineBank = new UiObject(new UiSelector().descriptionContains("登录到网上银行付款"));
	    if(loginOnlineBank.exists()){
	    	loginOnlineBank.click();
	    	sleep(10000);
	    }else{
	    	device.click(150, 345);
	    	sleep(10000);
	    }
	    	    
	    
	  //用2345截屏功能截屏
	    showMenu.click();
	    sleep(2500);
	    
	    contentLayout.swipeLeft(40);
	    sleep(5000);
	    
//	    screen.click();
//	    sleep(2500);
	    device.click(85, 700);
	    sleep(2500);
	    
	    cropFull.click();
	    sleep(2500);
	    
	    cropSave.click();
	    sleep(2500);
	}

        
	    /*--------------------------------------------*/
	    //已登录后,点击我的淘宝
	    //device.click((int)DoubleArith.mul(DoubleArith.div(270, 600, 4), devicewidth),(int)DoubleArith.mul(DoubleArith.div(80, 800, 4), deviceheigth));
	    

	    
	    
	    
	
	
	public void tsst_01_Before() throws InterruptedException{
		startApp.testStartApp();
		UiObject warmToast = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/TBDialog_buttons_OK"));
	    if(warmToast.exists()==true){
	    	try {
				warmToast.click();
				Thread.sleep(5000);
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}	    	
	    }
	    System.out.println("test success");
	}
	
	public void inputTaobao(){
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_PERIOD);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_T);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_O);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_B);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_O);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_PERIOD);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_C);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_O);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_M);
        sleep(500);
        UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_ENTER);
        sleep(5000);
	}
    
}
