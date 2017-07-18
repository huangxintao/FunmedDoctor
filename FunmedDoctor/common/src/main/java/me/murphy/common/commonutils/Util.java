package me.murphy.common.commonutils;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.murphy.common.baseapp.BaseApplication;

/**
 * Created by murphy on 16/11/29.
 */

public class Util {
    /**
     * 判断字符串是否不为空
     *
     * @param value String 需要判断的字符串
     * @return 如果输入字符串为 null "null" 和 "" 则均返回 false
     */
    public static boolean isNotNull(final String value) {
        return (value != null && !"".equalsIgnoreCase(value) && !"null".equalsIgnoreCase(value));
    }

    /**
     * 判断字符串是否为空
     *
     * @param value 需要判断的字符串
     * @return 如果输入字符串为 null "null" 和 "" 则均返回 true
     */
    public static boolean isNull(final String value) {
        return !isNotNull(value);
    }

    /**
     * 替换空格(url)
     *
     * @param str
     * @return
     */
    public static String replaceBlank(final String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将R文件中的字符串资源提取出来
     *
     * @param id
     * @return
     */
    public static String getResourceString(final int id) {
        return BaseApplication.getAppContext().getResources().getString(id);
    }

    public static int getDimenResource(int resId) {
        return BaseApplication.getAppContext().getResources().getDimensionPixelOffset(resId);
    }

    public static Drawable getDrawable(int resId) {
        return ContextCompat.getDrawable(BaseApplication.getAppContext(), resId);
    }

    public static int getColor(int resId) {
        return ContextCompat.getColor(BaseApplication.getAppContext(), resId);
    }

    /**
     * 拨打某个电话(只打开拨打界面)
     *
     * @param phone
     * @param context
     */
    public static void Call(final String phone, final Context context) {
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
    }

    /**
     * 调用系统短信发送短信
     *
     * @param phone
     * @param body
     * @param context
     */
    public static void SendSms(final String phone, final String body, final Context context) {
        Intent phoneIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:" + phone));
        phoneIntent.setType("vnd.android-dir/mms-sms");
        phoneIntent.putExtra("sms_body", body);
        phoneIntent.putExtra("address", phone);// 必须，不然没有号码
        context.startActivity(phoneIntent);
    }

}
