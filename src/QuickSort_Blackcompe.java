import java.util.Random;

public class QuickSort_Blackcompe implements Sort {

    private Random rand;
    private double[] numbers;

    public QuickSort_Blackcompe()
    {
    }

    public void setData(double[] list)
    {
        rand = new Random();
        numbers = list;
    }


    public double[] getNumbers()
    {
        return numbers;
    }

    public void sort()
    {
        quicksort(numbers,0, numbers.length-1);
    }

    public static void quicksort( double[] a, int p, int r ) {
        if ( p < r ) {
            int q = randomizedPartition( a, p, r );
            quicksort( a, p, q );
            quicksort( a, q + 1, r );
        }
    }

    private static int randomizedPartition(double[] a, int p, int r) {
        int i = p + new Random().nextInt(r-p) + 1;
        swap(a, p, i);
        return partition(a, p, r);
    }

    private static int partition( double[] a, int p, int r ) {
        double pivot = a[p];
        int i = p-1;
        int j = r+1;
        while(true) {
            do j--; while(a[j] > pivot); //grow greater region
            do i++; while(a[i] < pivot); //grow lesser region
            if(i < j)
                swap(a, i, j);
            else
                return j;
        }
    }

    private static void swap( double[] a, int i, int j ) {
        double tmp = a[ i ];
        a[ i ] = a[ j ];
        a[ j ] = tmp;
    }

}