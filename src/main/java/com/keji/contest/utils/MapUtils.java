package com.luglobal.contest.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZHAOZENGJIE004 on 2017/12/22.
 */
public class MapUtils {


    public static String getString(Map param, String key){
       if (CollectionUtils.isEmpty(param)){
           return null;
       }
        return JSON.toJSONString(param.get(key));
    }


    public static Map toMap(Object obj)throws Exception{
        Class type = obj.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        if (obj instanceof Map) {
            return (Map)obj;
        }
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(obj, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                }
            }
        }
        return returnMap;
    }

    public static Map<String, String> convertStringToMap(String mapAsString) {
        Map<String, String> map = new HashMap<String, String>();


        String[] keyValuePairs = mapAsString.split(",");
        for (String keyValuePair : keyValuePairs) {
            String[] keyValue = keyValuePair.split(":");
            map.put(keyValue[0].trim(), keyValue.length > 1 ? keyValue[1].trim() : "");
        }

        return map;
    }

}
