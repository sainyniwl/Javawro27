package pl.sda.rafal.zientara.programowanie2.lesson2;

public class RunnableMain {

    public static void main(String[] args) {
        Thread thread = new Thread();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println();
            System.out.println(Thread.currentThread().getName());
            System.out.println("YOLO Runnable");
        }
    }
}
