package pl.sda.rafal.zientara.tdd.programowanie2.lesson2.henioSimulation;

import java.util.concurrent.atomic.AtomicInteger;

public class Heniek implements DownloadProcess.OnProgressListener{

    private int count;
    private AtomicInteger finishedCount = new AtomicInteger();
    private AtomicInteger errorCount = new AtomicInteger();

    private void startThreads(int count){
        this.count = count;
        for (int i = 0; i < count; i++) {
            DownloadProcess proc = new DownloadProcess();
            proc.setListener(this);
            Thread thread = new Thread(proc);
            thread.start();
        }
    }

    public static void main(String[] args) {
        Heniek henk = new Heniek();
        henk.startThreads(10000);
    }

    @Override
    public void finished() {
        finishedCount.incrementAndGet();
        checkFinish();
        }


    @Override
    public void onError() {
        errorCount.incrementAndGet();
        checkFinish();
    }

    private void checkFinish() {
        int finished = finishedCount.get();
        int errors = errorCount.get();
        if (finished + errors == count) {
            System.out.printf("Udało się pobrać %d/%d", finished, count);
        }
    }
}
