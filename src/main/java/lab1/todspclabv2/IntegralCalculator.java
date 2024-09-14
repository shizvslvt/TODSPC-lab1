package lab1.todspclabv2;

import java.util.ArrayList;


public class IntegralCalculator {
    int numThreads;

    public IntegralCalculator(int numThreads) {
        this.numThreads = numThreads;
    }

    public double calculate(double a, double b, long n, Function f) {
        double h = (b-a)/n;
        double sum = (f.calculate(a) + f.calculate(b)) / 2;

        ArrayList<R1> tasks = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();


        long step = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            long start = i*step;
            long end = (i+1)*step;


            R1 task = new R1(a, h, start, end, f);
            tasks.add(task);

            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (R1 task : tasks) {
            sum += task.getThreadSum();
        }
        var result = sum*h;
        return result;
    }
}
