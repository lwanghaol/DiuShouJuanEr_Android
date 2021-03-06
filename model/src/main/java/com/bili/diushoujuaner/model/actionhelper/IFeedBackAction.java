package com.bili.diushoujuaner.model.actionhelper;

import com.bili.diushoujuaner.model.actionhelper.respon.ActionResponse;
import com.bili.diushoujuaner.model.apihelper.request.FeedBackReq;
import com.bili.diushoujuaner.model.callback.ActionStringCallbackListener;

/**
 * Created by BiLi on 2016/4/6.
 */
public interface IFeedBackAction {

    void getFeedBackAdd(FeedBackReq feedBackReq, ActionStringCallbackListener<ActionResponse<Void>> actionStringCallbackListener);

}
