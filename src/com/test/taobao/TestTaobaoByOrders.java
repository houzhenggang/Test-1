package com.test.taobao;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestTaobaoByOrders extends UiAutomatorTestCase {
	StartApp startApp = new StartApp();
	public void test_01_Before() throws InterruptedException{
		startApp.testStartApp();
		
		UiObject warmToast = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/TBDialog_buttons_OK"));
	    if(warmToast.exists()==true){
	    	try {
				warmToast.click();
				Thread.sleep(3000);
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}	    	
	    }
	}
    
	public void test_02_byOrders() throws InterruptedException, UiObjectNotFoundException{
		UiObject homeSearchEditText = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/home_searchedit"));	    
		if(homeSearchEditText.exists()==true){
	    	try {
				homeSearchEditText.clickAndWaitForNewWindow();
				Thread.sleep(3000);
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
	    		    	
	    }
		String searchedGoods = "化妆品收纳盒 实木有盖镜防尘宜家公主桌面整理箱柜 中号化妆盒 http://item.taobao.com/item.htm?ut_sk=1.VGyvJnJ9vaEDAI7VEay/ibyi_21380790_1460548965.TaoPassword-QQ.1&id=520757487159&sourceType=item&price=158.00&suid=74297535-2473-4A42-A584-E8DDEA35EA5B&sm=fdabf6";
		homeSearchEditText.longClick();
		
		UiObject btnLook = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/contacts_clipwatcher_access").text("立即查看"));
		btnLook.clickAndWaitForNewWindow(2000);
	}

}
