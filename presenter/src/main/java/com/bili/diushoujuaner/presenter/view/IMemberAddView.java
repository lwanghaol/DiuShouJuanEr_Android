package com.bili.diushoujuaner.presenter.view;

import com.bili.diushoujuaner.presenter.base.IBaseView;
import com.bili.diushoujuaner.utils.entity.vo.FriendVo;
import com.bili.diushoujuaner.utils.entity.vo.MemberVo;

import java.util.List;

/**
 * Created by BiLi on 2016/3/13.
 */
public interface IMemberAddView extends IBaseView {

    void showContactList(List<FriendVo> friendVoList);

    void showMemberVoList(List<MemberVo> memberVoList);

}
