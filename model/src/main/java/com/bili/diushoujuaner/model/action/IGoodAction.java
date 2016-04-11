package com.bili.diushoujuaner.model.action;

import com.bili.diushoujuaner.model.action.respon.ActionRespon;
import com.bili.diushoujuaner.model.callback.ActionStringCallbackListener;

/**
 * Created by BiLi on 2016/4/2.
 */
public interface IGoodAction {

    void getGoodAdd(long recallNo, final ActionStringCallbackListener<ActionRespon<String>> actionStringCallbackListener);

    void getGoodRemove(long recallNo, final ActionStringCallbackListener<ActionRespon<String>> actionStringCallbackListener);
}
