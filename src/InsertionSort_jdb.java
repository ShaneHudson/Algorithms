/**
 * Created by IntelliJ IDEA.
 * User: shanehudson
 * Date: 17/03/2012
 * Time: 01:30
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort_jdb implements Sort {

    private double[] numbers;

    public InsertionSort_jdb(double[] a)
    {
        numbers = a;
    }

    public void sort()
    {
        insertionSort(numbers,numbers.length-1);
    }

    public double[] getNumbers()
    {
        return numbers;
    }

    // Sort elements 0 to n of array a into
    // increasing order.
    //
    public static void insertionSort(double a[], double n)
    {
        int i, j;
        double x;

        for (j = 1; j <= n; j++) {
            x = a[j];
            i = j - 1;
            while (i >= 0 && a[i] > x) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = x;
        }
    }
}
