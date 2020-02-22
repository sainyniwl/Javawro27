package pl.sda.rafal.zientara.tdd.programowanie2.lesson2;

public class ThreadsMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread thread = new MyThread();
        thread.start();
        thread.run();
    }


    static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
            System.out.println("asasfafw");
        }

    }
}
