package com.hui.example.yizhi.presenter;

import com.hui.example.yizhi.bean.WeixinChoiceItemBean;
import com.hui.example.yizhi.bean.WeixinChoiceListBean;
import com.hui.example.yizhi.contract.WeiXinContract;
import com.hui.example.yizhi.model.WeiXinModel;

import io.reactivex.functions.Consumer;

import static com.hui.example.yizhi.app.MvpApp.mApp;

public class WeiXinPresenter extends WeiXinContract.WeiXinPresenter {
    private int mCurrentPage;
    private final int mPageStrip = 20;
    private String mDttype;

    private boolean isLoading;


    public static WeiXinPresenter newInstance() {
        return new WeiXinPresenter();
    }

    @Override
    public void loadLatestList() {
        mCurrentPage=1;
        mRxManager.register(mIModel.getWeiXinChoiceList(mCurrentPage,mPageStrip,mDttype,mApp.JU_HE_APP_KEY).subscribe(new Consumer<WeixinChoiceListBean>() {
            @Override
            public void accept(WeixinChoiceListBean weixinChoiceListBean) throws Exception {
                if (mIView == null)
                    return;
                if (weixinChoiceListBean.getError_code().equals("0")) {
                    mCurrentPage++;
                    mIView.updateContentList(weixinChoiceListBean.getResult().getList());
                } else {
                    mIView.showNetWorkError();
                }

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView!=null){
                    if (mIView.isVisiable())
                        mIView.showToast("NetWork Error!");
                    mIView.showNetWorkError();
                }
            }
        }));
    }

    @Override
    public void loadMoreList() {
        if (!isLoading) {
            isLoading = true;
            mRxManager.register(mIModel.getWeiXinChoiceList(mCurrentPage, mPageStrip, mDttype,
                    mApp.JU_HE_APP_KEY).subscribe
                    (new Consumer<WeixinChoiceListBean>() {

                        @Override
                        public void accept(WeixinChoiceListBean wangyiNewsListBean) throws
                                Exception {
                            isLoading = false;
                            if (mIView == null)
                                return;

                            if (wangyiNewsListBean.getError_code().equals("0")) {
                                mCurrentPage++;
                                mIView.updateContentList(wangyiNewsListBean.getResult().getList());
                            } else {
                                mIView.showLoadMoreError();
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            isLoading = false;
                            if (mIView == null)
                                return;
                            mIView.showLoadMoreError();
                        }
                    }));
        }
    }

    @Override
    public void OnItemClick(int position, WeixinChoiceItemBean item) {

    }

    @Override
    protected WeiXinContract.WeiXinModel getModel() {
        return WeiXinModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
