/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jdb
 */
public class QuickSort_jdb implements Sort {

    private double[] numbers;
    
    public QuickSort_jdb()
    {
    }

    public void setData (double[] a)
    {
        numbers = a;
    }

    public void sort()
    {
        quickSort(numbers,0, numbers.length-1);
    }
    
    public double[] getNumbers()
    {
        return numbers;
    }

    //  Quicksort elements first to last of array a
    //
    public static void quickSort(double a[], int first, int last) {
        int i = first;
        int j = last;
        double pivot = a[(i + j) / 2];
        while (i <= j) {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;
            if (i <= j) {
                double temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (j > first)
            quickSort(a,first,j);
        if (i < last)
            quickSort(a,i,last);
    }
}
