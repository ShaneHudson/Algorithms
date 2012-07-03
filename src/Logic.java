import java.io.Console;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: shanehudson
 * Date: 03/07/2012
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class Logic {

    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;


    private Random rand;

    public Logic()  {

        double[] list;

        rand = new Random();
        //list = new int[]{9, 34, 344342, 3432, 3,3,3,32,231, 3, 2, 4};
        list = new double[100000];
        for (int i = 0; i < 100000; i++)
        {
            list[i] = rand.nextDouble() * 10000;
        }
        System.out.println(Arrays.toString(list));
        Sort sort = new QuickSort(list);
        start();
        sort.sort();
        list = sort.getNumbers();
        stop();
        System.out.println(Arrays.toString(list));
        System.out.println(getElapsedTime() + " nanoseconds");
    }

    public void start() {
        this.startTime = System.nanoTime();
        this.running = true;
    }


    public void stop() {
        this.stopTime = System.nanoTime();
        this.running = false;
    }

    // elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.nanoTime() - startTime);
        }
        else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }

    public void setData(String data)
    {
        System.out.println(data);
    }
    
    public void setAlgorithm(String algorithm)
    {
        System.out.println(algorithm);
    }
}
