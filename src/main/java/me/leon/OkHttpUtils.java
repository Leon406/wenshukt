package me.leon;



import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * <p>description：</p>
 * <p>author：Leon</p>
 * <p>date：2019/9/17 0017</p>
 * <p>e-mail：deadogone@gmail.com</p>
 */
public class OkHttpUtils {
    private static OkHttpUtils INSTANCE = new OkHttpUtils();
    private final OkHttpClient client;

    private OkHttpUtils() {

        client =   new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
    }

    public static OkHttpUtils getInstance() {
        return INSTANCE;
    }

    public <T> T get(String url, Class<T> clazz, Map<String, String> headers) throws IOException {

        Request.Builder builder = new Request.Builder()
                .url(url);
        makeHeader(headers, builder);
        Request request = builder.build();

        return (T) GsonUtil.INSTANCE.fromJson(client.newCall(request).execute().body().string(), clazz);
    }
    public String getBody(String url, Map<String, String> headers) throws IOException {

        Request.Builder builder = new Request.Builder()
                .url(url);
        makeHeader(headers, builder);
        Request request = builder.build();
        return client.newCall(request).execute().body().string();
    }

    public <T> T get(String url, Class<T> clazz) throws IOException {
        return get(url, clazz, null);
    }

    private void makeHeader(Map<String, String> headers, Request.Builder builder) {
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * post请求带参数 带请求头
     *
     * @param url     网址
     * @param clazz   class字节码
     * @param json    json字符串
     * @param headers 请求头 header map
     * @param <T>     泛型T
     * @return T
     * @throws IOException io异常
     */
    public <T> T post(String url, String json, Class<T> clazz, Map<String, String> headers) throws IOException {

        Request.Builder builder = new Request.Builder()
                .url(url);
        if (json != null && json.length() > 0) {
            builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json));
        }

        builder.build();
        makeHeader(headers, builder);
        Request request = builder.build();
        String result = client.newCall(request).execute().body().string();
        System.out.println(result);
        return (T) GsonUtil.INSTANCE.fromJson(result, clazz);
    }

    /**
     * post请求带参数 带请求头
     *
     * @param url     网址
     * @param clazz   class字节码
     * @param headers 请求头 header map
     * @param <T>     泛型T
     * @return T
     * @throws IOException io异常
     */
    public <T> T postString(String url, String data, Class<T> clazz, Map<String, String> headers) throws IOException {

        Request.Builder builder = new Request.Builder()
                .url(url);
        if (data != null && data.length() > 0) {
            builder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), data));
        }

        builder.build();
        makeHeader(headers, builder);
        Request request = builder.build();
        String result = client.newCall(request).execute().body().string();
        System.out.println(result);
        return (T) GsonUtil.INSTANCE.fromJson(result, clazz);
    }

    /**
     * post请求带参数
     *
     * @param url   网址
     * @param clazz class字节码
     * @param json  json字符串
     * @param <T>   泛型T
     * @return T
     * @throws IOException io异常
     */
    public <T> T post(String url, String json, Class<T> clazz) throws IOException {
        return post(url, json, clazz, null);
    }

    /**
     * post请求无参数
     *
     * @param url   网址
     * @param clazz class字节码
     * @param <T>   泛型T
     * @return T
     * @throws IOException io异常
     */
    public <T> T post(String url, Class<T> clazz) throws IOException {
        return post(url, null, clazz, null);
    }

    public <T> T uploadFile(String url, String file, Class<T> clazz, Map<String, String> headers) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(url);
        if (file != null && file.length() > 0) {
            File uploadFile = new File(file);
            if (uploadFile.exists()) {
                builder.post(RequestBody.create(MediaType.parse("application/octet-stream"), uploadFile));
            }
        }

        builder.build();
        makeHeader(headers, builder);
        Request request = builder.build();
        return (T) GsonUtil.INSTANCE.fromJson(client.newCall(request).execute().body().string(), clazz);
    }
}
