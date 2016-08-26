package com.yif.util;

import java.util.List;

import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.RandomStringUtils;

public class BaiduTranslationUtils {
	private static String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";
	 
    private static String api_key = "jJO62_qzPqJ0NGTKcOjw";
    
    private static String appid = "20160201000010212";
    
    public static String translation(String from,String to, String q) throws Exception {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);
        if(StringUtil.isEmpty(from)){
        	from="auto";
        }
        if(StringUtil.isEmpty(to)){
        	to="auto";
        }
        
        String salt = RandomStringUtils.randomNumeric(8);
//        q="day";
        q = "测试";
       q=new String(q.getBytes("UTF-8"), "UTF-8");
        
        String sign = SecurityUtil.md5abc(appid+q+salt+api_key);

        method.setQueryString(new NameValuePair[] {
                new NameValuePair("from", from),
                new NameValuePair("to", to),
                new NameValuePair("appid", appid),
                new NameValuePair("salt", salt),
                new NameValuePair("sign", sign),
                // 多条内容用\n分隔
                new NameValuePair("q", q) });
 
        client.executeMethod(method);
        String response = new String(method.getResponseBodyAsString());
        System.out.println(response);
        method.releaseConnection();
        String content = "";
        Gson gson = new Gson();
        BaiduTrans bt = gson.fromJson(response, BaiduTrans.class);
        for (TransResult tr : bt.getTrans_result()) {
        	content = content+tr.getDst();
        }
        return content;
    }
    
    
    class BaiduTrans {
        private String from;
        private String to;
        private List<TransResult> trans_result;
 
        public String getFrom() {
            return from;
        }
 
        public void setFrom(String from) {
            this.from = from;
        }
 
        public String getTo() {
            return to;
        }
 
        public void setTo(String to) {
            this.to = to;
        }
 
        public List<TransResult> getTrans_result() {
            return trans_result;
        }
 
        public void setTrans_result(List<TransResult> trans_result) {
            this.trans_result = trans_result;
        }
    }
    
    class TransResult {
        public String getSrc() {
            return src;
        }
 
        public void setSrc(String src) {
            this.src = src;
        }
 
        public String getDst() {
            return dst;
        }
 
        public void setDst(String dst) {
            this.dst = dst;
        }
 
        private String src;
        private String dst;
    }
}
