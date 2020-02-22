package pl.sda.rafal.zientara.programowanie2.lesson2.henioSimulation;

public class ThreadsMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

    }

    static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println("YOLO");
            System.out.println(Thread.currentThread().getName());
            System.out.println("YOLO");
        }
    }
}
