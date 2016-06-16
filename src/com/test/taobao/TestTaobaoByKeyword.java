package com.test.taobao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;



import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import android.view.KeyEvent;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestTaobaoByKeyword extends UiAutomatorTestCase{

	/**
	 * @author 
	 * @param args
	 */
	
	StartApp startApp = new StartApp();
	
	ArrayList<Map<String , String>> list = new ArrayList<Map<String , String>>();
	
	
	public void tsst_all() throws InterruptedException, UiObjectNotFoundException{
		
		list = GetJson.getAllParam();
		System.out.println("ssss");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				list = GetJson.getAllParam();
				System.out.println("来了？");
			}
		}).start();
		
		while(null==list){
			Thread.sleep(200l);
		}
		
		for(Map<String , String> map : list){
			/*
			tsst_01_Before();
			tsst_02_SearchByKeyword(map.get("keyword"));
			
			//test_03_goodsItems(map.get("archSortType"));
			tsst_04_sortorder(map.get("searchsorttype"));
			//tsst_05_isSelectedBySelect(map.get("startprice"), map.get("endprice"), map.get("isisdmarea"), map.get("dmarea"));
			tsst_06_getSearchedGoods(map.get("goodsfulltitle"), map.get("dmarea"),map.get("ycsellername"));
			tsst_07_timeOfBrowseMainImgs(map.get("browsemainimgtime"));
			tsst_08_timeOfBrowseGoodsComment(map.get("browseappraisetime"),map.get("goodsfulltitle"));
			tsst_09_timeOfBrowsePicDetail(map.get("browsepicdetailtime"));
			tsst_10_timeOfBrowseGoodsParam(map.get("browsegoodstaramtime"));
			tsst_11_timeOfDeepBrowseOtherGoodsCount(map.get("dpothergoodscount"), map.get("dpothergoodsstaytime"));
			tsst_12_ifCollectionGoods(map.get("iscollectiongoods"));
			tsst_13_ifCollectionShop(map.get("iscollectionshop"));
			tsst_14_ifAddIntoShoppingCart();
			tsst_15_ifBuyGoods(); 
			*/
			//test_16_screenshot();
			}	
	}  
	
	//启动淘宝
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
    
	//关键字搜索商品
	public void tsst_02_SearchByKeyword(String keyword) throws InterruptedException,UiObjectNotFoundException{
		Thread.sleep(5000);
		UiObject homeSearchEditText = new UiObject(new UiSelector().className("android.widget.TextView").resourceId("com.taobao.taobao:id/search_icon").descriptionContains("搜索"));	    
		if(homeSearchEditText.exists()==true){
	    	try {
				homeSearchEditText.clickAndWaitForNewWindow();
				Thread.sleep(3000);
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
	    		    	
	    }
		UiObject searchEdit = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/searchEdit"));
		
		if(searchEdit.exists()==true){
			try {
				searchEdit.setText(Utf7ImeHelper.e(keyword));
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		UiObject searchButton = new UiObject(new UiSelector().className("android.widget.Button").resourceId("com.taobao.taobao:id/searchbtn").index(3));
		try {
			searchButton.clickAndWaitForNewWindow();
			Thread.sleep(3000);
		} catch (UiObjectNotFoundException  e) {
			e.printStackTrace();
		}		
		System.out.println("test success");
	}
    
	/*
	//商品类目	
	public void test_03_goodsItems(String whatsItems) throws UiObjectNotFoundException{
	
		if(whatsItems==null){
			
		}else{
			UiObject goodsItems = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/current_inner_sort_text").text("综合排序"));
			goodsItems.click();
			
			UiObject searchItem = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/sort_name").text(whatsItems));
			searchItem.click();
		}
		
	}
	*/
	//商品分类排序方式 销量or流量
	public void tsst_04_sortorder(String searchSortType) throws UiObjectNotFoundException{
		if(Integer.parseInt(searchSortType) == 3){
			UiObject outer = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/outer_sort_container").index(1));
			outer.click();			
		}else{
			
		}
		System.out.println("test success");
	}

	//是否卡价格 卡发货地 卡标签
	public void tsst_05_isSelectedBySelect(String startPrice,String endPrice,String isIsDmArea,String dmArea) throws UiObjectNotFoundException, InterruptedException{
		UiObject selectItem = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/btn_sortbar_filter_text").text("筛选"));
		selectItem.click();
		Thread.sleep(500L);
		
		if((startPrice == null) && (endPrice == null)){
			
		}else{
			
			UiObject editMinPrice = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/min_price").textContains("最低价格"));
			editMinPrice.setText(Utf7ImeHelper.e(startPrice));
			
			UiObject editMaxPrice = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/max_price").textContains("最高价格"));
			editMaxPrice.setText(Utf7ImeHelper.e(endPrice));
			Thread.sleep(500L);
		}
		
		if(Integer.parseInt(isIsDmArea) == 1){
			UiObject moreArea = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/location_expand_btn_icon"));
			moreArea.click();
			
			UiObject sendGoodsArea = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/filter_item").text(dmArea));
			UiScrollable search_listview = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView").resourceId("com.taobao.taobao:id/search_listview").index(0));
			Boolean searchJudge_tag = true;
			while(searchJudge_tag){
				if(sendGoodsArea.exists()==true){
					sendGoodsArea.click();
					UiObject btnConfirm  = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/filter_confirm_btn").text("确认"));
					btnConfirm.click();
					Thread.sleep(500L);
					
					searchJudge_tag = false;
				}else{
					search_listview.swipeUp(40);
					Thread.sleep(100L);
				}
			}
		}
		System.out.println("test success");
	}
	
	//滚动查找目标商品
	public void tsst_06_getSearchedGoods(String goodsFullTitle,String dmArea,String ycsellername) throws UiObjectNotFoundException, InterruptedException{  
//		UiScrollable searchListView = new UiScrollable(new UiSelector().resourceId("com.taobao.taobao:id/decor_content_parent"));
//		UiObject searchedGoods = searchListView.getChildByText(new UiSelector().resourceId("com.taobao.taobao:id/title"),"柯达强势回归 52倍长焦数码相机",true);
		UiDevice device =getUiDevice();
		UiScrollable scrollView = new UiScrollable(new UiSelector().resourceId("com.taobao.taobao:id/decor_content_parent"));
		UiObject searchedGoodsFullName = new UiObject(new UiSelector().text("  "+goodsFullTitle).index(0));
		UiObject searchedGoodsArea = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/area").text(dmArea));
		UiObject sellerNameById = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_main_seller_title"));
		UiScrollable mainPage = new UiScrollable(new UiSelector().className("com.taobao.android.detail.view.widget.main.viewpager.VerticalViewPager").resourceId("com.taobao.taobao:id/mainpages"));
		UiObject sellerNameByText = new UiObject(new UiSelector().className("android.widget.TextView").text(ycsellername));
		Boolean tag = true;
		
		
		if(searchedGoodsFullName.exists()){
			searchedGoodsFullName.click();
			
		}else{
			while(tag){
				if(searchedGoodsFullName.exists()==false){
					Thread.sleep(1000L);
					scrollView.scrollForward(80);
					Thread.sleep(1000L);
				}else{
					Thread.sleep(1500L);					
					searchedGoodsFullName.click();
					
					tag=false;
//					mainPage.scrollIntoView(sellerNameById);
//					while(sellerNameByText.exists()){
//						tag=false;
//					}
//					device.pressBack();
				}	
			} 
		}
		
		
	    
	    Thread.sleep(4000);
	}	
	
	//浏览主图时间
	public void tsst_07_timeOfBrowseMainImgs(String browseMainImgTime ) throws UiObjectNotFoundException, InterruptedException{
		UiDevice device = getUiDevice();
		UiObject img_gallery = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/img_gallery"));
		UiObject big_gallery = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/big_gallery"));
		img_gallery.click();
		Thread.sleep(50L);
		if(Integer.parseInt(browseMainImgTime) == 1){
			big_gallery.swipeLeft(10);
			Thread.sleep(1500L);
			device.pressBack();
		}if(Integer.parseInt(browseMainImgTime) == 2){
			for(int i=0;i<5;i++){
				big_gallery.swipeLeft(10);
				Thread.sleep(1000L);
			}
			device.pressBack();
		}if(Integer.parseInt(browseMainImgTime) == 3){
			for(int i=0;i<5;i++){
				big_gallery.swipeLeft(10);
				Thread.sleep(2000L);
			}
			device.pressBack();
		}else{
			for(int i=0;i<5;i++){
				big_gallery.swipeLeft(10);
				Thread.sleep(4000L);
			}
			device.pressBack();
		}
		System.out.println("test success");
	}
    
	//浏览商品评价
	public void tsst_08_timeOfBrowseGoodsComment(String browseAppraiseTime,String goodsFullTitle ) throws UiObjectNotFoundException, InterruptedException{
		UiDevice device = getUiDevice();
		UiObject mainComment = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_main_comment_count"));
		UiScrollable mainPage = new UiScrollable(new UiSelector().className("com.taobao.android.detail.view.widget.main.viewpager.VerticalViewPager").resourceId("com.taobao.taobao:id/mainpages"));
		UiObject searchedGoodsFullName = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/title").text(goodsFullTitle).index(0));
		mainPage.scrollIntoView(mainComment);
		Thread.sleep(3000L);
		
		
		Boolean comment_tag =true;
		if(mainComment.exists()==true){
			mainComment.click();
			//Thread.sleep(500L);
			comment_tag=false;
		}else{
//			mainPage.swipeUp(500);
//			mainPage.swipeDown(80);
//			Thread.sleep(200L);				
		}
		while(comment_tag){
			
		}
		UiObject mainCommentPage = new UiObject(new UiSelector().className("android.widget.RelativeLayout").resourceId("com.taobao.taobao:id/pagegroup"));
		if(Integer.parseInt(browseAppraiseTime) == 1){
			for(int i =0;i<4;i++){
				mainCommentPage.swipeUp(60);
				Thread.sleep(2000L);
			}
		}if(Integer.parseInt(browseAppraiseTime) == 2){
			for(int i =0;i<6;i++){
				mainCommentPage.swipeUp(40);
				Thread.sleep(2000L);
			}
		}if(Integer.parseInt(browseAppraiseTime) == 3){
			for(int i =0;i<10;i++){
				mainCommentPage.swipeUp(40);
				Thread.sleep(2000L);
			}
		}else{
			for(int i =0;i<12;i++){
				mainCommentPage.swipeUp(40);
				Thread.sleep(4000L);
			}
		}
		device.pressBack();
		System.out.println("test success");
	}
	
	//浏览图文详情
    public void tsst_09_timeOfBrowsePicDetail(String browsePicDetailTime) throws UiObjectNotFoundException, InterruptedException{
		UiObject picDetails = new UiObject(new UiSelector().className("android.widget.TextView").text("图文详情"));				
		UiObject mainPage = new UiObject(new UiSelector().className("com.taobao.android.detail.view.widget.main.viewpager.VerticalViewPager").resourceId("com.taobao.taobao:id/mainpages"));
		
		/*
		Boolean picDetails_tag=true;
		while(picDetails_tag){
			if((picDetails.exists())==false){
				mainPage.swipeUp(40);
				Thread.sleep(200L);				
					//picDetails_tag=false				}				
			}else if(picDetails.exists()){
				
				picDetails.click();
				Thread.sleep(500L);
				picDetails_tag=false;
			}			
		} */
		
		if(Integer.parseInt(browsePicDetailTime)==1){
			for(int i =0;i<6;i++){
				mainPage.swipeUp(40);
				Thread.sleep(5000L);
			}
			//picDetails_tag=false;
		}if(Integer.parseInt(browsePicDetailTime)==2){
			for(int i =0;i<10;i++){
				mainPage.swipeUp(40);
				Thread.sleep(4000L);
			}
			//picDetails_tag=false;
		}if(Integer.parseInt(browsePicDetailTime)==3){
			for(int i =0;i<15;i++){
				mainPage.swipeUp(40);
				Thread.sleep(5000L);
			}
			//picDetails_tag=false;
		}else{
			for(int i =0;i<20;i++){
				mainPage.swipeUp(40);
				Thread.sleep(6000L);
			}
		} 
	}
    //浏览产品参数
    public void tsst_10_timeOfBrowseGoodsParam(String browseGoodsParamTime) throws UiObjectNotFoundException, InterruptedException {
    	UiObject goodsParam01 = new UiObject(new UiSelector().className("android.widget.TextView").text("产品参数"));
    	UiObject goodsParam02 = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_fulldesc_btn_spec"));
    	UiScrollable mainPage = new UiScrollable(new UiSelector().className("com.taobao.android.detail.view.widget.main.viewpager.VerticalViewPager").resourceId("com.taobao.taobao:id/mainpages"));
    	if((goodsParam01.exists())||(goodsParam02.exists())){
    		if(goodsParam01.exists()){
    			goodsParam01.click();
    		}else{
    			goodsParam02.click();
    		}
    	}
    	
    	Thread.sleep(1500L);
    	
    	if(Integer.parseInt(browseGoodsParamTime)==1){
    		Thread.sleep(5000L);
    		for(int i =0;i<5;i++){
				mainPage.scrollForward(60);
				Thread.sleep(2000L);
			}
    	}if(Integer.parseInt(browseGoodsParamTime)==2){
    		Thread.sleep(3000L);
    		for(int i =0;i<5;i++){
    			mainPage.scrollForward(60);
				Thread.sleep(2000L);
			}
    	}if(Integer.parseInt(browseGoodsParamTime)==3){
    		Thread.sleep(6000L);
    		for(int i =0;i<5;i++){
    			mainPage.scrollForward(60);
				Thread.sleep(3000L);
			}
    	}else{
    		Thread.sleep(10000L);
    		for(int i =0;i<5;i++){
    			mainPage.scrollForward(60);
				Thread.sleep(6000L);
			}
    	}
    	System.out.println("test success");
    }
    
    //深度浏览副宝贝数目和时间
    public void tsst_11_timeOfDeepBrowseOtherGoodsCount(String dpOtherGoodsCount,String dpOtherGoodsStayTime) throws UiObjectNotFoundException, InterruptedException{
    	UiObject otherGoods01 = new UiObject(new UiSelector().className("android.widget.TextView").text("店铺推荐"));
    	UiObject otherGoods02 = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_fulldesc_btn_recommend"));
    	UiObject mainPage = new UiObject(new UiSelector().className("com.taobao.android.detail.view.widget.main.viewpager.VerticalViewPager").resourceId("com.taobao.taobao:id/mainpages"));
    	if((otherGoods01.exists())||(otherGoods01.exists())){
    		if(otherGoods01.exists()){
    			otherGoods01.click();
    		}else{
    			otherGoods02.click();
    		}
    	}
    	
    	Thread.sleep(3000L);
    	if(Integer.parseInt(dpOtherGoodsCount)==1){
    		mainPage.swipeUp(40);
    		Thread.sleep(5000L);
    	}if(Integer.parseInt(dpOtherGoodsCount)==2){
    		mainPage.swipeUp(40);
    		Thread.sleep(10000L);
    		
    		mainPage.swipeUp(40);
    		Thread.sleep(10000L);
    	}else{
    		mainPage.swipeUp(40);
    		Thread.sleep(10000L);
    		
    		mainPage.swipeUp(40);
    		Thread.sleep(10000L);
    		
    		mainPage.swipeUp(40);
    		Thread.sleep(10000L);
    	}
    	System.out.println("test success");
    }
    
    //是否收藏主宝贝
    public void tsst_12_ifCollectionGoods(String isCollectionGoods) throws UiObjectNotFoundException, InterruptedException{
    	UiObject fav = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/fav"));
    	if(Integer.parseInt(isCollectionGoods)==1){
    		
    	}else{
    		fav.click();
    		Thread.sleep(1000L);
    	}
    	System.out.println("test success");
    }
    
    //是否收藏店铺
    public void tsst_13_ifCollectionShop(String isCollectionShop) throws UiObjectNotFoundException, InterruptedException{
    	UiDevice device = getUiDevice();
    	UiObject ll = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/ll_icon"));
    	if(Integer.parseInt(isCollectionShop)==1){
    		
    	}else{
    		ll.click();
    		Thread.sleep(5000L);
    	}
    	device.pressBack();
//    	device.pressBack();
//    	device.pressBack();
//    	device.pressBack();
//    	device.pressBack();
//    	device.pressBack();
    	System.out.println("test success");
    }
    
    //是否添加购物车
    public void tsst_14_ifAddIntoShoppingCart() throws UiObjectNotFoundException, InterruptedException{
    	UiObject main_sys_button = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_main_sys_button").text("加入购物车"));
    	UiObject goodsModel = new UiObject(new UiSelector().className("android.widget.TextView").index(0).clickable(true).enabled(true));
    	UiObject editGoodsNum = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/detail_sku_sn_numtv"));
    	UiObject confirm = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/confirm"));
    	main_sys_button.click();
    	Thread.sleep(1000L);
    	goodsModel.click();
    	Thread.sleep(1000L);
    	confirm.click();
    	Thread.sleep(1000L);
    	
    }
        
    public void tsst_15_ifBuyGoods() throws UiObjectNotFoundException, InterruptedException{
    	UiObject buyNow = new UiObject(new UiSelector().text("立即购买"));
    	UiObject confirmBuy = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/btn_confirm").text("提交订单"));
    	UiDevice device = getUiDevice();
    	buyNow.click();
    	Thread.sleep(2000L);
    	
    	confirmBuy.click();
    	Thread.sleep(2000L);
    	
    	for(int i=0;i<8;i++){
    		device.pressBack();
    	}
    	
    	
    }
    
    //截取订单二维码
    public void test_16_screenshot() throws InterruptedException, UiObjectNotFoundException{
    	double devicewidth = 0;
    	double deviceheigth =0;
    	try {
			//Runtime.getRuntime().exec("am start -n com.tencent.mtt/com.tencent.mtt.SplashActivity");
			//Runtime.getRuntime().exec("am start -n com.qihoo.browser/com.qihoo.browser.activity.SplashActivity");
    		Runtime.getRuntime().exec("am start -n com.browser2345/com.browser2345.StartBrowserActivity");
    		sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Thread.sleep(1500L);
//    	
//    	UiObject editText01 = new UiObject(new UiSelector().className("android.widget.TextView").resourceId("com.qihoo.browser:id/tp"));
//    	UiObject editText02 = new UiObject(new UiSelector().resourceId("com.qihoo.browser:id/n4").text("搜索或输入网址"));
//        UiObject btnSearch = new UiObject(new UiSelector().resourceId("com.qihoo.browser:id/xp").text("前往"));
        
//    	UiObject editText02 = new UiObject(new UiSelector().className("android.widget.LinearLayout").index(0).clickable(true).enabled(true).focusable(false).focused(false).longClickable(false).checkable(false));
//    	UiObject editText01 = new UiObject(new UiSelector().className("android.widget.TextView").text("搜索或输入网址"));
//        UiObject btnSearch = new UiObject(new UiSelector().text("搜索"));
        
    	UiObject editText01 = new UiObject(new UiSelector().resourceId("com.browser2345:id/urlbar_urltext"));
    	UiObject editText02 = new UiObject(new UiSelector().resourceId("com.browser2345:id/url"));
    	UiObject btnSearch = new UiObject(new UiSelector().resourceId("com.daohang2345:id/browser_go_btn"));
    	UiObject myTaobao = new UiObject(new UiSelector().className("android.view.View").textContains("我的淘宝").index(0));
    	UiObject scanscreen = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/textView3").text("扫一扫"));
    	UiObject selectPic = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/btn_album"));
    	UiObject localAlbum = new UiObject(new UiSelector().resourceId("android.widget.TextView").text("本地"));
    	
    	UiObject showMenu = new UiObject(new UiSelector().resourceId("com.browser2345:id/btn_show_menu"));
    	UiObject contentLayout = new UiObject(new UiSelector().resourceId("com.browser2345:id/content_layout"));
    	UiObject screen = new UiObject(new UiSelector().className("android.widget.Button").resourceId("com.browser2345:id/menu_5"));
    	UiObject cropFull = new UiObject(new UiSelector().resourceId("com.browser2345:id/button_cropFull"));
    	UiObject cropSave = new UiObject(new UiSelector().resourceId("com.browser2345:id/button_saveGraffiti"));
    	UiObject screenAlertDialog = new UiObject(new UiSelector().textContains("确定"));
    	UiObject open2345Album = new UiObject(new UiSelector().text("2345Screenshot"));
    	UiObject selectKuaitu = new UiObject(new UiSelector().className("android.widget.LinearLayout").index(0)).getFromParent(new UiSelector().resourceId("android:id/resolver_list"));
    	UiObject selectKuaituAlways = new UiObject(new UiSelector().text("始终"));
    	
    	File file = new File("/sdcard/Android/data/");
    	UiDevice device = getUiDevice();
    	devicewidth =UiDevice.getInstance().getDisplayWidth();
    	deviceheigth =UiDevice.getInstance().getDisplayHeight();
    	
    	editText01.click();
    	Thread.sleep(1500L);
    	if(editText02.exists()){
    		long print=Configurator.getInstance().getKeyInjectionDelay();
    		System.out.println(print);
    		//editText02.clearTextField();
    		//editText02.setText(Utf7ImeHelper.e("https://www.taobao.com"));
    		//Configurator.getInstance().setKeyInjectionDelay(1000);
//    		device.click(devicewidth/2, (deviceheigth/5)*4);
//    		editText02.setText("https://www.taobao.com");
    		editText02.click();
    		inputTaobao();
    		    
    		//Thread.sleep(2000L);
    		//btnSearch.click();
        	Thread.sleep(8000L);
        	//myTaobao.click();
    	}else{
    		System.out.println("is not exists");
    	}
    	//点击我的淘宝
    	
    	device.click((int)DoubleArith.mul(DoubleArith.div(270, 600, 4), devicewidth),(int)DoubleArith.mul(DoubleArith.div(80, 800, 4), deviceheigth));
    	System.out.println("screen width:"+devicewidth);
    	System.out.println("screen heigth"+deviceheigth);
    	Thread.sleep(4000L);
    	//点击已购买到的宝贝
	    device.click((int)DoubleArith.mul(DoubleArith.div(500, 1080, 4), devicewidth), (int)DoubleArith.mul(DoubleArith.div(250, 1920, 4), deviceheigth));
	    Thread.sleep(8000L);
	    
//	    device.click((int)DoubleArith.mul(DoubleArith.div(400, 1080, 4), devicewidth), (int)DoubleArith.mul(DoubleArith.div(760, 1920, 4), deviceheigth));
//	    UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_1);
//	    UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
	    //点击切换二维码登陆标识
	    
	    device.click((int)DoubleArith.mul(DoubleArith.div(450, 600, 4), devicewidth),(int)DoubleArith.mul(DoubleArith.div(180, 800, 3), deviceheigth));
	    sleep(3000);
	    device.drag(300, 400, 200, 400, 20);
	    Thread.sleep(8000L);
	    //用2345截屏功能截屏
	    showMenu.click();
	    sleep(2500);
	    
	    contentLayout.swipeLeft(40);
	    Thread.sleep(5000);
	    
	    screen.click();
	    sleep(2500);
	    
	    cropFull.click();
	    sleep(2500);
	    
	    cropSave.click();
	    sleep(2500);
	    
        
	    //device.click(1000, 400);
	    //打开淘宝扫码
	    tsst_01_Before();
	    Thread.sleep(5000);
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
	    
	    //已登录后,点击我的淘宝
	    device.click((int)DoubleArith.mul(DoubleArith.div(270, 600, 4), devicewidth),(int)DoubleArith.mul(DoubleArith.div(80, 800, 4), deviceheigth));
	    sleep(5000);
	    device.click(270, 105);
	    sleep(10000);
	    //点击付款
	    device.click(460, 280);
	    sleep(10000);
	    //点击添加网银
	    device.click(150, 243);
	    sleep(7000);
	    //选择银行卡
	    device.click(290, 320);
	    sleep(8000);
	    //选择储蓄卡
	    device.click(100, 345);
	    sleep(5000);
	    //点击下一步
	    device.click(100, 425);
	    sleep(5000);
	    //选择民生银行
	    device.click(400, 410);
	    sleep(5000);
	    //点击下一步
	    device.click(100, 470);
	    sleep(5000);
	    //点击网上银行支付
	    device.click(118, 380);
	    sleep(5000);
	    //点击下一步
	    device.click(100, 420);
	    sleep(7000);
	    //登陆到网上银行付款
	    device.click(150, 345);
	    sleep(10000);
	    
	  //用2345截屏功能截屏
	    showMenu.click();
	    sleep(2500);
	    
	    contentLayout.swipeLeft(40);
	    sleep(5000);
	    
	    screen.click();
	    sleep(2500);
	    
	    cropFull.click();
	    sleep(2500);
	    
	    cropSave.click();
	    sleep(2500);
	    
	    
//	    for(int i=0;i<7;i++){
//	    	device.pressBack();
//	    }
    }
    
    public void est_04_scanGoods() throws UiObjectNotFoundException, InterruptedException{
		UiScrollable goodsListView = new UiScrollable(new UiSelector().className("android.widget.ListView").resourceId("com.taobao.taobao:id/mainpage"));
		
	    goodsListView.scrollToEnd(20);
	    Thread.sleep(3000);
	    
	    
	}
	public void est_05_opreateForMerchant() throws UiObjectNotFoundException, InterruptedException{
		UiDevice device = getUiDevice();
		UiObject btnCommunication = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/ll_icon").description("联系客服"));
		btnCommunication.click();
		Thread.sleep(3000);
		
		UiObject btnBack = new UiObject(new UiSelector().className("android.widget.ImageButton").description("转到上一层级"));
		btnBack.click();
		Thread.sleep(2000);
		
		UiObject btnMerchant = new UiObject(new UiSelector().resourceId("com.taobao.taobao:id/tv_title").text("店铺"));
		btnMerchant.clickAndWaitForNewWindow();
		Thread.sleep(3000);
		
		UiScrollable merchantListview = new UiScrollable(new UiSelector().resourceId("com.taobao.taobao:id/shop_homepage_container_fl"));
	    merchantListview.scrollForward();
	    Thread.sleep(2000);
	    device.pressBack();
	    device.pressBack();
	    device.pressBack();
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
    
	//double乘法解决精度问题
	
}
