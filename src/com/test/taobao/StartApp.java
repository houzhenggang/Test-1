package com.test.taobao;

import java.io.IOException;

public class StartApp {

	/**
	 * @param args
	 */
	public void testStartApp(){
		try {
			Runtime.getRuntime().exec("am start -n com.taobao.taobao/com.taobao.tao.welcome.Welcome");
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
