package com.utils;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xxx on 2017/4/27.
 */
public class WechatUtil {

    public static Map<String, String> getJsConfig(String url) {
        //1、获取AccessToken
        String accessToken = getAccessToken();

        //2、获取Ticket
        String jsapi_ticket = getTicket(accessToken);

        Map<String, String> map = new HashMap<>();
        map.put("jsapi_ticket",jsapi_ticket);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("noncestr", UUID.randomUUID().toString().substring(0, 20));
        map.put("url", url);
        map.put("signature", DigestUtils.sha1Hex(FormatUtil.createParaString(map)));
        return map;
    }

    public static String getAccessToken() {
        String access_token = "";
        String grant_type = "client_credential";//获取access_token填写client_credential
        String AppId = "wx5c866c2a2daa9146";//第三方用户唯一凭证
        String secret = "bb9df56f1f765d46694452d424c5d037";//第三方用户唯一凭证密钥，即appsecret
        //这个url链接地址和参数皆不能变
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grant_type + "&appid=" + AppId + "&secret=" + secret;

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");

            JSONObject demoJson = JSONObject.fromObject(message);
            System.out.println("JSON字符串：" + demoJson);
            access_token = demoJson.getString("access_token");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public static String getTicket(String access_token) {
        String ticket = null;
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";//这个url链接和参数不能变
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.fromObject(message);
            System.out.println("JSON字符串：" + demoJson);
            ticket = demoJson.getString("ticket");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
