package com.funmed.funmeddoctor.utils;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tony on 2017/8/15.
 */

public class Tools {

    /**
     * dip 转换为 px
     * @param dp
     * @param context
     * @return
     */
    public static int dp2px(int dp, Context context)
    {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + .5f);
    }

    /**
     * 像素 转成 dip
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * px 转成 sp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue)
    {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue)
    {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static String formatThreeFloat(float val)
    {
        DecimalFormat df = new DecimalFormat("########.000");
        String ret = "0";
        try {
            ret = String.valueOf(Float.parseFloat(df.format(val)));
            String[] ar = ret.split("\\.");
            if (ar.length == 1) {
                ret = ret + ".000";
            } else {
                int length = ar[1].length();
                if (length == 1) {
                    ret = ret + "00";
                } else if (length == 2) {
                    ret = ret + "0";
                }
            }
        } catch (Exception e) {
            // 不退出
        }
        return ret;
    }

    public static String formatFloat_ex2(float val)
    {
        DecimalFormat df = new DecimalFormat("########.00");
        String ret = String.valueOf(Float.parseFloat(df.format(val / 100)));
        String[] ar = ret.split("\\.");
        if (ar.length == 1) {
            ret = ret + ".00";
        } else {
            if (ar[1].length() == 1)
            {
                ret = ret + "0";
            }
        }
        return ret;
    }

    public static String formatFloat_ex0(float val)
    {
        DecimalFormat df = new DecimalFormat("########.00");
        float v = Float.parseFloat(df.format(val / 100));
        int iv = (new BigDecimal(v).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
        String ret = String.valueOf(iv);
        return ret;
    }

    public static String formatFloat_ex(float val)
    {
        DecimalFormat df = new DecimalFormat("########.000");
        String ret = String.valueOf(Float.parseFloat(df.format(val)));
        String[] ar = ret.split("\\.");
        if (ar[1].equals("0")) {
            ret = ret.replace(".0", "");
        }
        return ret;
    }

    public static String formatFloat_ex4(float val)
    {
        DecimalFormat df = new DecimalFormat("########.0000");
        return String.valueOf(Float.parseFloat(df.format(val)));
    }

    /*
     * 手机号校验的正则表达式
     */
    private static String num = "^[1]{1}(([358]{1}[0-9]{1})|([4]{1}[57]{1})|([7]{1}[0678]{1}))[0-9]{8}$";

    /**
     * 验证手机号
     * @param mobPhnNum
     * @return
     */
    public static boolean matchNum(String mobPhnNum)
    {
        // 判断手机号码是否是11位
        if (mobPhnNum.length() == 11)
        {
            if (mobPhnNum.matches(num)) // 判断手机号码是否符合中国移动的号码规则
            {
                return true;
            }
            else // 都不合适
            {
                return false;
            }
        }
        else// 不是11位
        {
            return false;
        }
    }

    /**
     * 禁止Edittext弹出软件盘，光标依然正常显示。
     */
    public static void disableShowSoftInput(EditText editText)
    {
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            editText.setInputType(InputType.TYPE_NULL);
        }
        else
        {
            Class<EditText> cls = EditText.class;
            Method method;
            try
            {
                method = cls.getMethod("setShowSoftInputOnFocus",boolean.class);
                method.setAccessible(true);
                method.invoke(editText, false);
            }
            catch (Exception e)
            {
            }
            try
            {
                method = cls.getMethod("setSoftInputShownOnFocus",boolean.class);
                method.setAccessible(true);
                method.invoke(editText, false);
            }
            catch (Exception e)
            {
            }
        }
    }

    /**
     * 重新计算ListView的高度
     * @param listView
     */

    public static void setListViewHeightBasedOnChildren(ListView listView)
    {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
        {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 计算BMI值
     * @param weight
     * @param height
     * @return
     */
    public static Map<String,String> calculateBMI(double weight, double height)
    {
        Map<String,String> resultMap = new HashMap<>();
        double bmi = Tools.decimalData_1(weight/((height/100)*(height/100)));
        if(bmi < 18.5)
        {
            resultMap.put("bmi",bmi+"");
            resultMap.put("advice","体重过轻");
            resultMap.put("sum","补充营养");
        }
        else if(bmi >= 18.5 && bmi < 24.99)
        {
            resultMap.put("bmi",bmi+"");
            resultMap.put("advice","正常体重");
            resultMap.put("sum","继续保持");
        }
        else if(bmi >= 25 && bmi < 28)
        {
            resultMap.put("bmi",bmi+"");
            resultMap.put("advice","体重偏重");
            resultMap.put("sum","注意饮食");
        }
        else if(bmi >= 28 && bmi < 32)
        {
            resultMap.put("bmi",bmi+"");
            resultMap.put("advice","肥胖");
            resultMap.put("sum","注意减肥");
        }
        else
        {
            resultMap.put("bmi",bmi+"");
            resultMap.put("advice","非常肥胖");
            resultMap.put("sum","注意锻炼、健身");
        }
        return resultMap;
    }

    /**
     * 四舍五入保留一位小数
     * @param data
     * @return
     */
    public static double decimalData_1(double data)
    {
        java.math.BigDecimal bigDec = new java.math.BigDecimal(data);
        double total = bigDec.setScale(1, java.math.BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return total;
    }


    /**
     * 把流转换为字节
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inputStream) throws Exception
    {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1)
        {
            bout.write(buffer, 0, len);
        }
        bout.close();
        inputStream.close();
        return bout.toByteArray();
    }

}
