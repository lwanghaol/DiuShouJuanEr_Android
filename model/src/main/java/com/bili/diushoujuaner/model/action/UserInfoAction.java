package com.bili.diushoujuaner.model.action;

import com.bili.diushoujuaner.model.action.respon.ActionRespon;
import com.bili.diushoujuaner.model.apihelper.ApiRespon;
import com.bili.diushoujuaner.model.apihelper.api.ApiAction;
import com.bili.diushoujuaner.model.apihelper.callback.ApiCallbackListener;
import com.bili.diushoujuaner.model.callback.ActionCallbackListener;
import com.bili.diushoujuaner.model.databasehelper.DBManager;
import com.bili.diushoujuaner.model.databasehelper.dao.User;
import com.bili.diushoujuaner.model.preferhelper.CustomSessionPreference;
import com.bili.diushoujuaner.utils.Constant;
import com.bili.diushoujuaner.utils.GsonParser;
import com.bili.diushoujuaner.utils.response.UserRes;
import com.google.gson.reflect.TypeToken;

/**
 * Created by BiLi on 2016/3/13.
 */
public class UserInfoAction {

    private static UserInfoAction userInfoAction;

    public static synchronized UserInfoAction getInstance(){
        if(userInfoAction == null){
            userInfoAction = new UserInfoAction();
        }
        return userInfoAction;
    }

    public void getUserInfo(final ActionCallbackListener<ActionRespon<User>> actionCallbackListener){
        //先展示本地数据
        actionCallbackListener.onSuccess(ActionRespon.getActionRespon(Constant.ACTION_LOAD_LOCAL_SUCCESS, Constant.RETCODE_SUCCESS, DBManager.getInstance().getUser(CustomSessionPreference.getInstance().getCustomSession().getUserNo())));
        //TODO 增加判断，看是否需要进行全量拿取，开发阶段允许全量拿取
        ApiAction.getInstance().getUserInfo(new ApiCallbackListener() {
            @Override
            public void onSuccess(final String data) {
                ApiRespon<UserRes> result = GsonParser.getInstance().fromJson(data, new TypeToken<ApiRespon<UserRes>>() {
                }.getType());
                if(result.getIsLegal()){
                    DBManager.getInstance().saveUser(result.getData());
                    actionCallbackListener.onSuccess(ActionRespon.getActionRespon(result.getMessage(), result.getRetCode(), DBManager.getInstance().getUser(CustomSessionPreference.getInstance().getCustomSession().getUserNo())));
                }else{
                    actionCallbackListener.onSuccess(ActionRespon.getActionRespon(result.getMessage(), result.getRetCode(), (User)null));
                }
            }

            @Override
            public void onFailure(int errorCode) {
                actionCallbackListener.onFailure(errorCode);
            }
        });
    }
}
