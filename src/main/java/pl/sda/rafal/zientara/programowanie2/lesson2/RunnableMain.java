package pl.sda.rafal.zientara.programowanie2.lesson2;

public class RunnableMain {

        static class MyRunnable implements Runnable{
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
                System.out.println("YEah run");
            }
        }
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) { //każdy runable powinien mieć utworzony swój osobny Thread
            MyRunnable runnable = new MyRunnable();
            Thread thread = new Thread(runnable);
            thread.start();
        }

        //jeśli podziedziczymy po thread to nie podziedziczymy po niczym dalej
    }
}
