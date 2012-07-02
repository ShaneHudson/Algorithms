import java.util.Arrays;
import java.util.Random;
/**
 * This project is a collection of algorithms and data structures created to show the differences
 * and to have a complete collection of how tasks can be solved using multiple methods.
 *
 * This project includes code that is not my own for comparison reasons, all such will be credited.
 * Author: Shane Hudson
 * Date: 2012.03.17
 */
public class Base {

    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    
    private Random rand;


    public static void main(String[] args) {
        Base program = new Base();
    }

    public Base()
    {
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

    //elaspsed time in milliseconds
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

}
