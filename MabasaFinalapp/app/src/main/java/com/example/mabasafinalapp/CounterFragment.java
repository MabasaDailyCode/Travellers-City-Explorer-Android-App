package com.example.mabasafinalapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {
    private TextView tv;
    private Handler handler;
    private TimerCounterThread thread;
    private Button bt_start, bt_stop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.counter_fragment, container, false);
        tv = v.findViewById(R.id.textView);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                int timeCounter = msg.arg1;
                tv.setText(timeCounter/1000.0f+"");
                return true;
            }
        });
        bt_start = (Button) v.findViewById(R.id.btn_start);
        bt_stop= (Button) v.findViewById(R.id.btn_stop);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread=new TimerCounterThread(handler);
                thread.start();
                v.setEnabled(false);
                bt_stop.setEnabled(true);
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.stopTimer();
                v.setEnabled(false);
                bt_start.setEnabled(true);
            }
        });

        return v;

    }
}
