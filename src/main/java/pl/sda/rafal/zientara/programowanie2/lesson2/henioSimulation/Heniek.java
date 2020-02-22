package pl.sda.rafal.zientara.programowanie2.lesson2.henioSimulation;

import java.util.concurrent.atomic.AtomicInteger;

public class Heniek implements DownloadProcess.onProgressListener{

    private int count;
    private AtomicInteger finishedCount = new AtomicInteger();
    private AtomicInteger errorCount = new AtomicInteger();


    public void startThreads(int count){
        this.count = count;
        for (int i = 0; i < count; i++) {
            DownloadProcess downloadProcess = new DownloadProcess();
            downloadProcess.setListener(this);
            Thread thread = new Thread(downloadProcess);
            thread.start();
        }
    }

    public static void main(String[] args) {
        Heniek heniek = new Heniek();
        heniek.startThreads(10000);
    }

    @Override
    public void finished() {
        int finished = finishedCount.incrementAndGet();
        if(finished == count){
            System.out.println("Wszystko pobrane!");
            checkFinish();
        }
    }

    @Override
    public void onError() {
        errorCount.incrementAndGet();
        checkFinish();
    }

    private void checkFinish() {
       int finished = finishedCount.get();
       int errorCounter = errorCount.get();

       if(finished + errorCounter == count){
           System.out.printf("Udało się pobrać: %d/%d", finished, count);
           System.out.println();
           System.out.println("Pobrano: " + finished);
           System.out.println("Nie udało się pobrać: " + errorCounter);
       }
    }
}
