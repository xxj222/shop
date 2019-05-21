package com.ayit.my.shop.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.plugin2.message.GetAppletMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpClientUtil {

    private static final String POST = "post";
    private static final String GET = "get";
    private static final String connection = "keep-alive";
    private static final String userAgent = "login_remember_name=; login_remember_me=false; theme-skin=metro-light-blue; JSESSIONID=5BB9AD898E3764425D32B627B707F310; userInfo=\"1031586735@qq.com:123\"\n";


    public static String doPOST(String url,String cookie,BasicNameValuePair... params) {
        return createRequest(url,cookie,POST,params);
    }

    public static String doPost(String url,BasicNameValuePair... params){
        return createRequest(url,null,POST,params);
    }

    public static String doGET(String url) {
        return createRequest(url,null,GET);
    }

    public static String doGET(String url,String cookie) {
        return createRequest(url,cookie, GET);
    }

    public static String createRequest(String url, String cookie, String requestMethod, BasicNameValuePair... params) {

        //        创建httpClient客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
//   创建响应结果
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        String result = null;

        try {

            if (GET.equals(requestMethod)) {

                HttpGet httpGet = new HttpGet(url);
                //       设置长链接
                httpGet.setHeader("Connection", connection);
//        设置代理'
                httpGet.setHeader("User-Agent", userAgent);
//        设置cookie
                httpGet.setHeader("Cookie", cookie);
//                响应结果
                httpResponse = httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();

            } else if (POST.equals(requestMethod)) {
                HttpPost httpPost = new HttpPost(url);
                //       设置长链接
                httpPost.setHeader("Connection", connection);
//        设置代理'
                httpPost.setHeader("User-Agent", userAgent);
//        设置cookie
                httpPost.setHeader("Cookie", cookie);


                if(params != null && params.length > 0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                }
                 httpResponse = httpClient.execute(httpPost);
                 httpEntity = httpResponse.getEntity();

            }
            try {
                result = EntityUtils.toString(httpEntity);
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


        return  result;

}


//
//
//    private static void get(){
////        创建httpClient客户端
//        CloseableHttpClient httpClient = HttpClients.createDefault();
////        创建Http请求
//        HttpGet httpGet = new HttpGet("http://localhost:8080/content/page?draw=1&start=0&length=10");
////       设置长链接
//        httpGet.setHeader("Connection","keep-alive");
////        设置代理'
//        httpGet.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
////        设置cookie
//        httpGet.setHeader("Cookie","login_remember_name=; login_remember_me=false; theme-skin=metro-light-blue; JSESSIONID=5BB9AD898E3764425D32B627B707F310; userInfo=\"1031586735@qq.com:123\"\n");
//
//        CloseableHttpResponse httpResponse = null;
////        请求并获取响应结果
//        try {
////            请求并获得响应结果
//            httpResponse =  httpClient.execute(httpGet);
//            HttpEntity httpEntity = httpResponse.getEntity();
////            输出请求结果
//            System.out.println(EntityUtils.toString(httpEntity));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(httpResponse != null){
//                try {
//                    httpResponse.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(httpClient != null){
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }
//
//    public static void post(){
////        创建Httpclient客户端
//        CloseableHttpClient httpClient = HttpClients.createDefault();
////        创建HttpPost请求
//        HttpPost httpPost = new HttpPost("http://localhost:8080/content/page");
//
//        //       设置长链接
//        httpPost.setHeader("Connection","keep-alive");
////        设置代理'
//        httpPost.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
////        设置cookie
//        httpPost.setHeader("Cookie","login_remember_name=; login_remember_me=false; theme-skin=metro-light-blue; JSESSIONID=5BB9AD898E3764425D32B627B707F310; userInfo=\"1031586735@qq.com:123\"\n");
////        创建HttpPost参数
//        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//        params.add(new BasicNameValuePair("draw","1"));
//        params.add(new BasicNameValuePair("start","0"));
//        params.add(new BasicNameValuePair("length","10"));
////        创建响应对象
//        CloseableHttpResponse httpResponse = null;
//        try {
////            设置httpPost的参数
//            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
//            httpResponse = httpClient.execute(httpPost);
//            HttpEntity httpEntity = httpResponse.getEntity();
////            输出请求结果
//            System.out.println(EntityUtils.toString(httpEntity));
//
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if(httpResponse != null){
//                try {
//                    httpResponse.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(httpClient != null){
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//
//    }
//
//
}



