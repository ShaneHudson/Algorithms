import java.util.Random;


public class QuickSort implements Sort {

    private Random rand;
    private double[] numbers;

    public QuickSort(double[] list)
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
        partition(0, numbers.length-1);
    }

    private void partition(int left, int right)
    {
        //int pivotIndex = Math.abs(rand.nextInt() % numbers.length);
        int pivotIndex = (left + right) / 2;
        double pivot = numbers[pivotIndex];
        int i = left;
        int j = right;
        while (i <= j)
        {
            while (numbers[i] < pivot)
            {
                i++;
            }
            while (numbers[j] > pivot)
            {
                j--;
            }

            if (i <= j)
            {
                swap(numbers,i,j);
                i++;
                j--;
            }
        }

        if(j > left)
            partition(left,j);

        if(i < right)
            partition(i, right);

    }

    private void swap(double[] list, int i, int j) {
        double left = list[i];
        list[i] = list[j];
        list[j] = left;
    }
}
