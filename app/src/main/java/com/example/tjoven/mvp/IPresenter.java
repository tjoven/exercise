package com.example.tjoven.mvp;

public interface IPresenter<V extends IView> {
    void attachView(V v);
    V getView();
}
