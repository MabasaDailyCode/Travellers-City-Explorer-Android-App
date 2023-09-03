package com.example.mabasafinalapp;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.atomic.AtomicBoolean;

public class TimerCounterThread extends Thread {
    private Handler handler;
    private AtomicBoolean isRunning;
    private int timeCounter = 0;
    public TimerCounterThread(Handler handler){
        this.handler = handler;
        isRunning=new AtomicBoolean(false);
        timeCounter = 0;
    }
    @Override
    public void run() {
        isRunning.set(true);
        while (isRunning.get()){
            try{
                Thread.sleep(10);
                timeCounter+=10;
                sendTimerCounter();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void stopTimer(){
        isRunning.set(false);
        sendTimerCounter();
    }
    private void sendTimerCounter(){
        Message msg = handler.obtainMessage();
        msg.arg1=timeCounter;
        handler.sendMessage(msg);
    }

}
