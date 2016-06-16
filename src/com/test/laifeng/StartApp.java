package com.test.laifeng;

import java.io.IOException;

public class StartApp {

	/**
	 * @param args
	 */
	public void testStartApp(){
		try {
			Runtime.getRuntime().exec("am start -n com.youku.crazytogether/com.youku.crazytogether.app.modules.splash.activity.SplashscreenActivity");
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
