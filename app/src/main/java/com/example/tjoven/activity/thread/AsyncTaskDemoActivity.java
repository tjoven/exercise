package com.example.tjoven.activity.thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

public class AsyncTaskDemoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AsyncTaskDemo().execute("");//串行
        new AsyncTaskDemo().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");//并行
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    class AsyncTaskDemo extends AsyncTask<String,Integer,Object>{

        @Override
        protected Object doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            publishProgress();
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onCancelled(Object o) {
            super.onCancelled(o);
        }
    }
}
