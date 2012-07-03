import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

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
    
    private double[] sortedList = {5, 3, 2, 3};
    
    private String data;
    private Sort algorithm;


    private Random rand;

    public Logic()  {

    }

    public void start() {
        Sort sort = algorithm;
        sortedList = parseData(data);
        sort.setData(sortedList);
        this.startTime = System.nanoTime();
        this.running = true;
        sort.sort();
        sortedList = sort.getNumbers();
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
        this.data = data;
    }
    
    private double[] parseData(String data)
    {
        int count = 0;
        StringTokenizer st = new StringTokenizer(data, ",");
        double[] result = new double[st.countTokens()];
        while(st.hasMoreTokens())
        {
            result[count] = Double.parseDouble(st.nextToken());
            count++;
        }
        return result;
    }
    
    public double[] getSorted()
    {
        return sortedList;
    }
    
    public void setAlgorithm(String algorithm)
    {
        switch(algorithm)
        {
            case "Insertion Sort - jdb":
                this.algorithm = new InsertionSort_jdb();
                break;
            //case "Insertion Sort - Shane Hudson":
            //    this.algorithm = new InsertionSort();
            //    break;
            case "Quick Sort - Shane Hudson":
                this.algorithm = new QuickSort();
                break;
            case "Quick Sort - jdb":
                this.algorithm = new QuickSort_jdb();
                break;
            case "Quick Sort - Blackcompe":
                this.algorithm = new QuickSort_Blackcompe();
                break;
        }
    }
}
