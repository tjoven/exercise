package com.example.tjoven.mvp;

public interface IView<P extends  IPresenter>{
    P getPresenter();
}
