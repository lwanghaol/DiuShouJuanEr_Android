package com.bili.diushoujuaner.model.preferhelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.bili.diushoujuaner.utils.StringUtil;
import com.bili.diushoujuaner.utils.entity.dto.CustomSession;

/**
 * Created by BiLi on 2016/3/10.
 */
public class CustomSessionPreference {

    private static String FILENAME = "ACCESS_TOKEN";
    private static Context mContext;
    private static CustomSessionPreference customSessionPreference;
    private static CustomSession customSession;

    public static void initialize(Context context){
        mContext = context;
        customSessionPreference = new CustomSessionPreference();
    }

    public static synchronized CustomSessionPreference getInstance(){
        if(customSessionPreference == null){
            throw new NullPointerException("CustomSessionPreference was not initialized!");
        }
        return customSessionPreference;
    }

    public void saveCustomSession(CustomSession customSession){
        SharedPreferences preferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (!StringUtil.isEmpty(customSession.getAccessToken())) {
            editor.putString("accessToken", customSession.getAccessToken());
        }
        if (!StringUtil.isEmpty(customSession.getLastTime())) {
            editor.putString("lastTime", customSession.getLastTime());
        }
        if (customSession.getUserNo() != null) {
            editor.putLong("userNo", customSession.getUserNo());
        }
        if(!StringUtil.isEmpty(customSession.getPassWord())){
            editor.putString("passWord", customSession.getPassWord());
        }
        editor.apply();
        this.customSession = null;
    }

    public CustomSession getCustomSession(){
        if(customSession == null){
            SharedPreferences preferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
            customSession = new CustomSession();

            customSession.setAccessToken(preferences.getString("accessToken", ""));
            customSession.setLastTime(preferences.getString("lastTime", ""));
            customSession.setUserNo(preferences.getLong("userNo", 0));
            customSession.setPassWord(preferences.getString("passWord",""));
        }

        return customSession;
    }

    public boolean isLogined(){
        CustomSession customSession = getCustomSession();
        if(customSession == null || customSession.getAccessToken().trim().length() <= 0){
            return false;
        }
        return true;
    }

    public void clear(){
        SharedPreferences preferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        customSession = null;
    }

}
