package pl.sda.rafal.zientara.programowanie2.lesson2.henioSimulation;

public class RunnableMain {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("YOLO");
        }
    }
}
