package me.murphy.common.base;

import android.content.Context;

import me.murphy.common.baserx.RxBus;
import me.murphy.common.baserx.RxManager;

/**
 * des:基类presenter
 * Created by murphy
 * on 2016.07.11:55
 */
public abstract class BasePresenter<T extends BaseView, E extends BaseModel> {
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        mModel.onCreate();
        this.onStart();
    }

    public void onStart() {

    }

    public void onDestroy() {
        mRxManage.clear();
        RxBus.getInstance().unregister(this);
    }
}
