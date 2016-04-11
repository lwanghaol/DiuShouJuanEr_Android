package com.bili.diushoujuaner.model.action;

import com.bili.diushoujuaner.model.action.respon.ActionRespon;
import com.bili.diushoujuaner.model.apihelper.request.ContactInfoReq;
import com.bili.diushoujuaner.model.callback.ActionStringCallbackListener;
import com.bili.diushoujuaner.utils.entity.FriendVo;
import com.bili.diushoujuaner.utils.entity.PartyVo;

import java.util.List;

/**
 * Created by BiLi on 2016/4/2.
 */
public interface IContactAction {

    List<PartyVo> getPartyVoList();

    void getContactList(final ActionStringCallbackListener<ActionRespon<List<FriendVo>>> actionStringCallbackListener);

    void getContactFromLocal(final long userNo, final ActionStringCallbackListener<ActionRespon<FriendVo>> actionStringCallbackListener);

    void getContactFromApi(ContactInfoReq contactInfoReq, final ActionStringCallbackListener<ActionRespon<FriendVo>> actionStringCallbackListener);

}
