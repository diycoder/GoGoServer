package com.yif.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wzhoufeng 1039580989@163.com
 * Date: 14-5-31
 * Time: 下午10:37
 * Version: 1.0.0.0
 * To change this template use File | Settings | File Templates.
 */
public class ActionUtils {

    private static ActionUtils actionUtils = new ActionUtils();
    public static ActionUtils getInstance(){
             return actionUtils;
    }

    /**
     * 获取参数，如果有多个则获取第一位的参数.没有则返回null
     * @param key 页面传递参数名称
     */
    public String getParamValueFirst(String key,HttpServletRequest request){
        Map<String,String[]> paramByMap = request.getParameterMap();
        return paramByMap.get(key)==null?"":paramByMap.get(key)[0];
    }
    /**
     * 获取请求中每个字段对应的第一个参数,适用于表单提交
     * @return Map<String,String>
     */
    public Map<String,String> getParamValueFirstMap(HttpServletRequest request){
        Map<String,String[]> paramByMap = request.getParameterMap();
        Map<String,String> resMap=new HashMap<String,String>();
        for(String key : paramByMap.keySet()){
            resMap.put(key, paramByMap.get(key)==null?"":paramByMap.get(key)[0]);
        }
        return resMap;
    }



    /**
     * 一般批量操作的时候用此参数类型
     * @param name 根据指定的字段名进行封装
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public final ArrayList<Map> getParamByArrayList(String name,HttpServletRequest req){
        Map<String,String[]>  map = (Map<String,String[]>)req.getParameterMap();
        ArrayList<Map> list=new ArrayList<Map>();
        try{
    	   int count=map.get(name).length;
           for(int i = 0;i<count;i++){
               Map tmp=new HashMap();
               for(String key : map.keySet()){

                   if(map!=null && map.get(key).length>i){
                       tmp.put(key,map.get(key)[i]);
                   }

               }
               list.add(tmp);
           }
       }catch(Exception e){
       }
        return list;
    }
}
