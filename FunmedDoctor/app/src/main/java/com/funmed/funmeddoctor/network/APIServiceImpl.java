package com.funmed.funmeddoctor.network;

import android.os.Build;
import android.support.compat.BuildConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tony on 2017/7/17.
 */

public class APIServiceImpl {
    /**
     * retrofit客户端
     */
    private static Retrofit sRetrofit;
    //    private final static String BASEURL = "http://192.168.1.44:8080/mobile/";

    /**
     * 终端表示
     */
    private static final String UA = "MingShiD/" + BuildConfig.VERSION_NAME + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " +
            Build.MODEL + " Build/" + Build.ID + "; " + Locale.getDefault().getLanguage() + "-" +
            Locale.getDefault().getCountry().toLowerCase() + ")";

    //    public static String UA = System.getProperties().getProperty("http.agent");
    private APIServiceImpl() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIServiceImpl getInstance() {
        return APIServiceHolder.INSTANCE;
    }

    /**
     * @return okhttp client
     */
    public static OkHttpClient createClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
//                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("User-Agent", UA)
                                .addHeader("Time-Strap", String.valueOf(System.currentTimeMillis()))
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();
    }

    private Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
    }

    /**
     * @param clazz 需要实例化的接口
     * @param <T>   需要实例化的接口
     * @return 实例化以后的接口
     */
    public <T> T createService(Class<T> clazz) {
        return sRetrofit.create(clazz);
    }


    private static class APIServiceHolder {
        /**
         * 单例类辅助内部类实例
         */
        private static final APIServiceImpl INSTANCE = new APIServiceImpl();
    }
}
