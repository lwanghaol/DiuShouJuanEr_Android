package com.bili.diushoujuaner.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bili.diushoujuaner.R;
import com.bili.diushoujuaner.activity.RecallDetailActivity;
import com.bili.diushoujuaner.adapter.RecallAdapter;
import com.bili.diushoujuaner.adapter.viewholder.ViewHolder;
import com.bili.diushoujuaner.base.BaseFragment;
import com.bili.diushoujuaner.callback.IMainFragmentOperateListener;
import com.bili.diushoujuaner.callback.IMainOperateListener;
import com.bili.diushoujuaner.event.RecallGoodEvent;
import com.bili.diushoujuaner.model.tempHelper.GoodTemper;
import com.bili.diushoujuaner.model.tempHelper.RecallTemper;
import com.bili.diushoujuaner.utils.Common;
import com.bili.diushoujuaner.utils.Constant;
import com.bili.diushoujuaner.utils.response.RecallDto;
import com.bili.diushoujuaner.presenter.presenter.HomeFragmentPresenter;
import com.bili.diushoujuaner.presenter.view.IHomeView;
import com.bili.diushoujuaner.widget.CustomListViewRefresh;
import com.bili.diushoujuaner.widget.TintedBitmapDrawable;
import com.bili.diushoujuaner.widget.waveswipe.WaveSwipeRefreshLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by BiLi on 2016/3/2.
 */
public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements WaveSwipeRefreshLayout.OnRefreshListener, IHomeView, View.OnClickListener, IMainFragmentOperateListener,CustomListViewRefresh.OnLoadMoreListener {

    @Bind(R.id.customListViewRefresh)
    CustomListViewRefresh customListViewRefresh;
    @Bind(R.id.waveSwipeRefreshLayout)
    WaveSwipeRefreshLayout waveSwipeRefreshLayout;
    @Bind(R.id.ivNavHead)
    SimpleDraweeView ivNavHead;
    @Bind(R.id.layoutTip)
    RelativeLayout layoutTip;
    @Bind(R.id.ivTip)
    ImageView ivTip;

    private List<RecallDto> recallDtoList;
    private RecallAdapter recallAdapter;
    private IMainOperateListener iMainOperateListener;
    private String ivNavHeadUrl;
    private Handler handler;
    private boolean goodstatus = false;
    private boolean isGoodStatusInited = false;
    private CustomRunnable customRunnable;
    private long goodRecallNo;

    class CustomRunnable implements Runnable{
        @Override
        public void run() {
            // 重置，允许再次进行点击，并发送请求
            isGoodStatusInited = false;
            getRelativePresenter().executeGoodChange(goodstatus, goodRecallNo);
        }
    }

    public static HomeFragment instantiation(int position){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void beforeInitView() {
        recallDtoList = new ArrayList<>();
        handler = new Handler();
        customRunnable = new CustomRunnable();
    }

    @Override
    public void setViewStatus() {
        EventBus.getDefault().register(this);

        showPageHead("首页", R.mipmap.icon_recall_add, null);
        ivNavHead.setOnClickListener(this);

        ivTip.setImageDrawable(new TintedBitmapDrawable(getResources(),R.mipmap.icon_nodata, ContextCompat.getColor(context, R.color.COLOR_BFBFBF)));

        recallAdapter = new RecallAdapter(getContext(), recallDtoList);
        customListViewRefresh.setAdapter(recallAdapter);
        customListViewRefresh.setCanLoadMore(true);
        customListViewRefresh.setOnLoadMoreListener(this);
        customListViewRefresh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RecallTemper.addRecallDto(recallAdapter.getItem(position));

                Intent intent = new Intent(getContext(), RecallDetailActivity.class);
                intent.putExtra(RecallDetailActivity.TAG, recallAdapter.getItem(position).getRecallNo());
                startActivity(intent);
            }
        });

        waveSwipeRefreshLayout.setColorSchemeColors(Color.WHITE, Color.WHITE);
        waveSwipeRefreshLayout.setWaveColor(ContextCompat.getColor(context, R.color.COLOR_THEME));
        waveSwipeRefreshLayout.setOnRefreshListener(this);

        Common.displayDraweeView(ivNavHeadUrl, ivNavHead);

        basePresenter = new HomeFragmentPresenter(this, getContext());
        getRelativePresenter().showRecallFromCache();
        getRelativePresenter().getRecallList(Constant.REFRESH_DEFAULT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivNavHead:
                iMainOperateListener.showMainMenu();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        recallAdapter.notifyDataSetChanged();
    }

    public void setMainOperateListener(IMainOperateListener iMainOperateListener) {
        this.iMainOperateListener = iMainOperateListener;
    }

    @Override
    public void onRefresh() {
        customListViewRefresh.setListViewStateRefresh();
        getRelativePresenter().getRecallList(Constant.REFRESH_INTENT);
    }

    @Override
    public void onLoadMore() {
        getRelativePresenter().getMoreRecallList();
    }

    @Override
    public void showRecallList(List<RecallDto> recallDtoList) {
        if(recallDtoList.isEmpty()){
            layoutTip.setVisibility(View.VISIBLE);
            customListViewRefresh.setVisibility(View.GONE);
        }else{
            layoutTip.setVisibility(View.GONE);
            customListViewRefresh.setVisibility(View.VISIBLE);
        }
        if(recallDtoList.size() < 20){
            customListViewRefresh.setListViewStateComplete();
        }else{
            customListViewRefresh.setListViewStateFinished();
        }
        recallAdapter.refresh(recallDtoList);
    }

    @Override
    public void showMoreRecallList(List<RecallDto> recallDtoList) {
        if(recallDtoList.isEmpty()){
            customListViewRefresh.setListViewStateComplete();
            return;
        }
        if(recallDtoList.size() < 20){
            customListViewRefresh.setListViewStateComplete();
        }else{
            customListViewRefresh.setListViewStateFinished();
        }
        recallAdapter.add(recallDtoList);
    }

    @Override
    public void setRefreshingEnd() {
        waveSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setLoadMoreEnd() {
        customListViewRefresh.setListViewStateFinished();
    }

    @Override
    public void showHead(String url) {
        ivNavHeadUrl = url;
        if(ivNavHead != null){
            Common.displayDraweeView(ivNavHeadUrl, ivNavHead);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecallGoodEvent(RecallGoodEvent recallGoodEvent){
        if(!isGoodStatusInited){
            isGoodStatusInited = true;
            goodstatus = GoodTemper.getGoodStatus(recallAdapter.getItem(recallGoodEvent.getPosition()).getRecallNo());
            goodRecallNo = recallAdapter.getItem(recallGoodEvent.getPosition()).getRecallNo();
        }
        if(GoodTemper.getGoodStatus(recallAdapter.getItem(recallGoodEvent.getPosition()).getRecallNo())){
            GoodTemper.setGoodStatus(recallAdapter.getItem(recallGoodEvent.getPosition()).getRecallNo(), false);
            getRelativePresenter().removeGoodDtoFromTemper(recallGoodEvent.getPosition());
        }else{
            GoodTemper.setGoodStatus(recallAdapter.getItem(recallGoodEvent.getPosition()).getRecallNo(), true);
            getRelativePresenter().addGoodDtoToTemper(recallGoodEvent.getPosition());
        }
        recallAdapter.notifyDataSetChanged();
        handler.removeCallbacks(customRunnable);
        handler.postDelayed(customRunnable, 1500);
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }
}
