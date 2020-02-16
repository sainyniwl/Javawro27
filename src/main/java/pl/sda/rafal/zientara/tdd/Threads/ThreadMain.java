package pl.sda.rafal.zientara.tdd.Threads;

public class ThreadMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        MyThread thread = new MyThread();
        thread.start();
    }

    static class MyThread extends Thread {

        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName());
            System.out.println("YOLO");
        }
    }
}

