package com.example.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondFragment extends Fragment {

    private static final String TAT = "SecondFragment";
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAT,"onAttach");
    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(TAT,"onAttachFragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAT,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAT,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAT,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAT,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAT,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAT,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAT,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAT,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAT,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAT,"onDetach");
    }
}
