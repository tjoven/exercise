package com.example.tjoven.mvp;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    WeakReference<V> viewRef;
    @Override
    public void attachView(V iView) {
        this.viewRef = new WeakReference(iView);
    }

    @Override
    public V getView() {
        return viewRef.get();
    }
}
