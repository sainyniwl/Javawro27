package pl.sda.rafal.zientara.programowanie2.lesson2;

import java.util.concurrent.atomic.AtomicInteger;
    class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
            System.out.println("YEah");
        }
    }
public class Threads extends Thread{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); //gdy chcemy odpalić, który wątek aktualnie chodzi
        //AtomicInteger //może działać na wielu wątkach

        MyThread thread = new MyThread();
        thread.start(); //start odpala wątek


    }
}
