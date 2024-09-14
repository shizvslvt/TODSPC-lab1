package lab1.todspclabv2;

public class R1 implements Runnable {
    private final double a;
    private final double h;
    private final double start;
    private final double end;
    private final Function f;
    private double threadSum;

    public R1(double a, double h, double start, double end, Function f) {
        this.a = a;
        this.h = h;
        this.start = start;
        this.end = end;
        this.f = f;
        this.threadSum = 0.0;
    }

    @Override
    public void run() {
        for (double i = start; i < end; i++) {
            double xi = a+i*h;
            threadSum += f.calculate(xi);
        }
    }

    public double getThreadSum() {
        return threadSum;
    }
}
