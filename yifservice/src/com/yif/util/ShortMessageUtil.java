package com.yif.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;


public class ShortMessageUtil {

	private static Logger _log = Logger.getLogger(ShortMessageUtil.class);

	/**
	 * @param phoneNum
	 * @param msg
	 */
	public static void sendVerificationCode(String phoneNum, String msg){
		sendMsg(phoneNum,msg,false);
	}

	/**
	 * @param phoneNum //手机号码。多个以英文逗号隔开
	 * @param content  //发送内容（1-500 个汉字，建议300字符内）UTF-8编码
	 */
	public static boolean sendNotice(String phoneNum, String content) {
		return sendMsg(phoneNum,content,true);
	}

	/**
	 * 
	 * @param phoneNum //手机号码。多个以英文逗号隔开
	 * @param content  //发送内容（1-500 个汉字，建议300字符内）UTF-8编码
	 * @param IsSign   //是否需要签名
	 * @return
	 */
	public static boolean sendMsg(String phoneNum, String content,boolean IsSign){
		boolean sendIsSuccess = true;
		try{
			String sign="";
			if(IsSign){//可选
				sign = "平安资本";
			}
			StringBuffer sb = new StringBuffer("http://web.cr6868.com/asmx/smsservice.aspx?");
			sb.append("name=18210856101");
			sb.append("&pwd=A5C2E39AEC5D128F03564DD12DCC");//   FFCA96B0D4C190FD478C1C6C2E77
			sb.append("&mobile="+phoneNum);
			sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
			sb.append("&stime=");
			sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
			sb.append("&type=pt&extno=");
			URL url = new URL(sb.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			url.openStream();// 发送
			//InputStream is =url.openStream();
			//String returnSt = StringUtil.convertStreamToString(is);
		}catch(Exception e){
			_log.error("sendNotice 短信通道异常" + e);
			sendIsSuccess = false;
		}
		return sendIsSuccess;
	}

	public static void main(String[] args) {
		//ShortMessageUtil.sendNotice("15210028381,18210856101", "短信通道 测试test创瑞");
		//ShortMessageUtil.sendVerificationCode("18600708269", "尊敬的用户，您的验证码为：205670，有效时间半小时，工作人员不会向您索取，请勿泄漏【平安资本】");
	}
	
	//先注了
		/*public static void sendVerificationCode(String phoneNum, String msg){
			try{
				URI uri = new URIBuilder()
		        .setScheme("http")
		        .setHost("dx.106xxt.com")
		        .setPath("/Service.asmx/sendsms")
		        .setParameter("zh", "1034575712")
		        .setParameter("mm", "hard2Guess")
		        .setParameter("hm", phoneNum)
		        .setParameter("nr", msg)
		        .setParameter("dxlbid", "28")
		        .setParameter("extno", "28")
		        .build();

				HttpGet httpGet = new HttpGet(uri);
				CloseableHttpClient httpclient = HttpClients.createDefault();
				CloseableHttpResponse response = httpclient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				response.getAllHeaders();
			} catch(Exception e){
				_log.error("sendVerificationCode 短信通道异常" + e);
			}

		 }*/
}
