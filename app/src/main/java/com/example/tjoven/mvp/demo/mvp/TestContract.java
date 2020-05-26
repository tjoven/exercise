package com.example.tjoven.mvp.demo.mvp;
import com.example.tjoven.mvp.IPresenter;
import com.example.tjoven.mvp.IView;
import com.example.tjoven.mvp.demo.api.TestResponse;

public interface TestContract {
    interface TestPresenter extends IPresenter<TestView>{
        void requestData(String id);
    }

    interface TestView extends IView<TestPresenter> {
        void updataView(TestResponse response);
    }
}
