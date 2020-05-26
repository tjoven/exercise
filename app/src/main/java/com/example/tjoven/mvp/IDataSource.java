package com.example.tjoven.mvp;

public interface IDataSource {
    void sendRequest(IDataSourceListener listener);

    public interface IDataSourceListener<T> {
        void onRequestStart();

        void onData(T var1);

        void onError(boolean var1, Object var2);
    }
}
