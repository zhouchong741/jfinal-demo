package com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by xxx on 2017/4/27.
 */
public class FormatUtil {
    public static String createParaString(Map<String, String> params) {
        java.util.List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            // String value = URLEncoder.encode(params.get(key));

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
}
