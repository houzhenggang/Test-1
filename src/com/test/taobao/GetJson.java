package com.test.taobao;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetJson {

	/**
	 * @param args
	 */
	static String apiUrl = "http://www.ytaot.com/index.php";
	
	public static ArrayList<Map<String, String>> getAllParam(){
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(apiUrl + "?m=shuadan&c=login&a=api&login_password=123456&username=haha");
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			HttpResponse paramResponse = httpClient.execute(httpGet);
			//System.out.println(EntityUtils.toString(paramResponse.getEntity()));
			String resultString = EntityUtils.toString(paramResponse.getEntity());
			//resultString = resultString.substring(1, resultString.length()-1);
			JSONArray jsonArray = JSONArray.fromObject(resultString);
			int iSize = jsonArray.size();
			for (int i = 0; i < iSize; i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Map<String ,String> map = parseJSON2Map(jsonObj.toString());
			list.add(map);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	//json转map
	public static Map<String, String> parseJSON2Map(String jsonStr){
	    Map<String, String> map = new HashMap<String, String>();
	    //最外层解析
	    JSONObject json = JSONObject.fromObject(jsonStr);
	    for(Object k : json.keySet()){
	      Object v = json.get(k); 
	      //如果内层还是数组的话，继续解析
	      if(v instanceof JSONArray){
	        List<Map<String, String>> list = new ArrayList<Map<String,String>>();
	        Iterator<JSONObject> it = ((JSONArray)v).iterator();
	        while(it.hasNext()){
	          JSONObject json2 = it.next();
	          list.add(parseJSON2Map(json2.toString()));
	        }
	        map.put(k.toString(), list.toString());
	      } else {
	        map.put(k.toString(), v.toString());
	      }
	    }
	    return map;
	  }
	
	public static void main(String[] args) {
		ArrayList<?> list = getAllParam();
		System.out.println(list.get(0).toString());
	}

}
