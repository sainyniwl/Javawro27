package pl.sda.rafal.zientara.tdd.threads;

public class RunnableMain {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("YOLO Runnable");
        }
    }
}
