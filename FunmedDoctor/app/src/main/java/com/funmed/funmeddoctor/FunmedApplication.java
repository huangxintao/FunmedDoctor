package com.funmed.funmeddoctor;

import android.support.multidex.MultiDexApplication;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by tony on 2017/7/26.
 */

public class FunmedApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG=true;
        PlatformConfig.setWeixin("wx6ac15f4414cb6980", "f0803d7eb02152ff0f97989ec63e5b35");
//        PlatformConfig.setSinaWeibo("2454898079", "cf24aaed90dd25ef59cfbd77c00da9b7","sns.whalecloud.com");
//        PlatformConfig.setQQZone("1105703060", "6kOhPBuI1IGeUB3c");
        UMShareAPI.get(this);
    }
}
