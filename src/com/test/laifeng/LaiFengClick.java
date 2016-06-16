package com.test.laifeng;

import java.util.ArrayList;
import java.util.List;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LaiFengClick extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public void test_01_startApp(){
		StartApp startApp = new StartApp();
		startApp.testStartApp();
	}
	
	public void s02_clickLike() throws UiObjectNotFoundException, InterruptedException{
//		UiObject nickName = new UiObject(new UiSelector().text("桃子bb"));
//		nickName.click();
//		Thread.sleep(3000L);
		
		UiObject search = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/homeSearch"));
		search.click();
		
		UiObject editSearch = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_title").text("注定"));
		editSearch.click();
		
		UiObject searchedUser = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_name").text("注定twins"));
		searchedUser.click();
		
		
		UiObject btnFollow = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/textViewFollow"));
		if(btnFollow.exists()){
			btnFollow.click();
		}else{
			
		}
		UiObject comment = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/playTalkView"));
		comment.click();
		
		for(int i =0;i<500000;i++){
			
			
			UiObject editBox = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/editBox"));
			editBox.setText("nice");
			
			UiObject sendbox = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/btnSendBox"));
			sendbox.click();
			Thread.sleep(20L);
		}
		
				
		
//		UiObject myAttention = new UiObject(new UiSelector().text("RY-小火柴"));
//		myAttention.click();
//		Thread.sleep(1000L);
//		
//		UiObject liveing = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/user_edit_data").text("直播中"));
//		liveing.click();
//		Thread.sleep(1000L);
		
		UiObject clickLike = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/playPraiseView"));
		for(int i=0;i<500000;i++){
			
				UiObject talkView = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/playTalkView"));
				talkView.click();
				
				
				UiObject editBox = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/editBox"));
                editBox.setText("nice");
                
				UiObject sendBox = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/btnSendBox"));
				sendBox.click();
				Thread.sleep(50L);
               
//			clickLike.click();
//			Thread.sleep(20L);
			}
			
			
		}
	
	public void s_03_attention() throws UiObjectNotFoundException, InterruptedException{
		
		UiObject loginBySina = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/login_path_weibo"));
		loginBySina.click();
		Thread.sleep(1000L);
		
		UiObject accountName = new UiObject(new UiSelector().resourceId("loginName"));
		accountName.setText("lueanp678@126.com");
		
		UiObject password = new UiObject(new UiSelector().resourceId("loginPassword"));
		password.setText("asd123123a");
		Thread.sleep(5000L);
		
		UiObject loginAction = new UiObject(new UiSelector().resourceId("loginAction"));
		loginAction.click();
		Thread.sleep(1500L);
		
		UiObject search = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/homeSearch"));
		search.click();
		
		UiObject editSearch = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_title").text("twins"));
		editSearch.click();
		
		UiObject searchedUser = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_name").text("注定twins"));
		searchedUser.click();
		
		
		UiObject btnFollow = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/textViewFollow"));
		btnFollow.click();
		
		UiObject exitRoom = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/imageViewExit"));
		exitRoom.click();
		
		UiDevice device = getUiDevice();
		device.pressBack();
		
		UiObject btnMine = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/id_rb_mine"));
		btnMine.click();
		
		
		UiObject set = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/my_setting_layout"));
		set.click();
		
		UiObject logout = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/logout_layout"));
		logout.click();
		
		UiObject sureLogout = new UiObject(new UiSelector().text("确定"));
		sureLogout.click();
	}
    
	
	public void test_04_loginByQQ() throws UiObjectNotFoundException, InterruptedException{
		
		Long[] aaa = {3454009121l, 3442494441l, 3442270655l, 3453338376l, 2046000790l, 3453749705l, 3453627782l };
		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < aaa.length; i++) {

			UiObject loginByQQ = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/login_path_qq"));
			loginByQQ.click();
			Thread.sleep(1000L);
			
			UiObject changeAccount = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnRightText"));
			changeAccount.click();
			
			UiObject addAcount = new UiObject(new UiSelector().text("添加帐号"));
			UiObject scrollView = new UiObject(new UiSelector().className("android.widget.LinearLayout").resourceId("com.tencent.mobileqq:id/name"));
			boolean tag = true;
			while(tag){
				if(addAcount.exists()){
					addAcount.click();
					Thread.sleep(500L);
					tag=false;
				}else{				
					scrollView.swipeUp(40);
					Thread.sleep(50L);
				}
			}
			
			
			
			
			
			UiObject qqAcount = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/account"));
			qqAcount.setText(aaa[i].toString());
			
			UiObject qqPassword = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/password"));
			qqPassword.setText("123456++");
			
			UiObject btnQQLogin = new UiObject(new UiSelector().text("登 录"));
			btnQQLogin.click();
			Thread.sleep(1000L);
			
			
			UiObject letLogin = new UiObject(new UiSelector().text("授权并登录"));
			if(letLogin.exists()){
				letLogin.click();
				Thread.sleep(1000L);
			}else{
				
			}
			
			
		
			UiObject search = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/homeSearch"));
			search.click();
			
			UiObject editSearch = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_title").text("注定"));
			editSearch.click();
			
			UiObject searchedUser = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/found_search_item_name").text("注定twins"));
			searchedUser.click();
			
			
			UiObject btnFollow = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/textViewFollow"));
			btnFollow.click();
			
			UiObject exitRoom = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/imageViewExit"));
			exitRoom.click();
			
			UiDevice device = getUiDevice();
			device.pressBack();
			
			UiObject btnMine = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/id_rb_mine"));
			btnMine.click();
			
			
			UiObject set = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/my_setting_layout"));
			set.click();
			
			UiObject logout = new UiObject(new UiSelector().resourceId("com.youku.crazytogether:id/logout_layout"));
			logout.click();
			
			UiObject sureLogout = new UiObject(new UiSelector().text("确定"));
			sureLogout.click();
		}
		
	}
}
