import java.util.Arrays;
import java.util.Random;

public class Main {

    public static Integer[] createList(int size) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }


   static <E> void swap(E[] A, int i, int j) {
        E temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static <E extends Comparable<? super E>>

    void selectionSort(E[] A) {
        for (int i = 0; i < A.length; i++) {
            int lowIndex = i;
            for (int j = A.length - 1; j > i; j--) {
                if (A[j].compareTo(A[lowIndex]) < 0) {
                    lowIndex = j;
                }
            }
            swap(A, i, lowIndex);
        }
    }

    static <E extends Comparable<? super E>>

    void insertionSort(E[] A) {
       for (int i = 1; i < A.length; i++) {
           for ( int j = i; j > 0 && A[j].compareTo(A[j - 1]) < 0; j--) {
               swap(A, j, j - 1);
           }
       }
    }


    static <E extends Comparable<? super E>> void shellSort(E[] A) {
        for (int i = A.length / 2; i >= 1; i /= 2) {
            for (int j = 0; j < i; j++) {
                insertionSort2(A, j, i);
            }
        }
    }

    static <E extends Comparable<? super E>>
    void insertionSort2(E[] a, int start, int increment) {
        for (int i = start + increment; i < a.length; i += increment) {
            for (int j = i; (j >= increment) && (a[j].compareTo(a[j - increment]) < 0); j -= increment) {
                E temp = a[j];
                a[j] = a[j - increment];
                a[j - increment] = temp;
            }
        }
    }

    static <E extends Comparable<? super E>>
    void quickSort(E[] A, int i, int j) {
       int pivotIndex = (i + j) / 2;
       swap(A, pivotIndex, j);
         int k = partition(A, i - 1, j, A[j]);
            swap(A, k, j);
            if ((k - i) > 1) {
                quickSort(A, i, k - 1);
            }
            if ((j - k) > 1) {
                quickSort(A, k + 1, j);
            }
    }

    private static <E extends Comparable<? super E>> int partition(E[] A, int l, int r, E pivot) {
        do {
            while (A[++l].compareTo(pivot) < 0);
            while ((r != 0) && (A[--r].compareTo(pivot) > 0));
            swap(A, l, r);
        } while (l < r);
        swap(A, l, r);
        return l;
        }

    static <E extends Comparable<? super E>>
    void mergeSort(E[] A, E[] temp, int l, int r) {
       int mid = (l + r) / 2;
         if (l == r) return;
         mergeSort(A, temp, l, mid);
         mergeSort(A, temp, mid + 1, r);
         for(int i = l; i <= r; i++) {
             temp[i] = A[i];
         }
             int i1 = l;
             int i2 = mid + 1;
             for (int curr = l; curr <= r; curr++) {
                 if (i1 == mid + 1)
                     A[curr] = temp[i2++];
                  else if (i2 > r) {
                     A[curr] = temp[i1++];
                 } else if (temp[i1].compareTo(temp[i2]) < 0) {
                     A[curr] = temp[i1++];
                 } else {
                     A[curr] = temp[i2++];
                 }
             }
         }



    public static void main(String[] args) {

        Integer[] unsorted = createList(100000);
        System.out.println("List Size: " + unsorted.length);
        System.out.println(" ");

        Integer[] A = Arrays.copyOf(unsorted, unsorted.length);
        long selectStartTime = System.nanoTime();
        selectionSort(A);
        long selectEndTime = System.nanoTime();
        System.out.println("Selection Sort Time: " + ((selectEndTime - selectStartTime) / 1000000) + " milliseconds");
        System.out.println("Selection Sort Time: " + ((selectEndTime - selectStartTime) / 1000) + " microseconds\n");



        Integer[] B = Arrays.copyOf(unsorted, unsorted.length);
        long insertStartTime = System.nanoTime();
        insertionSort(B);
        long insertEndTime = System.nanoTime();
        System.out.println("Insertion Sort Time: " + ((insertEndTime - insertStartTime) / 1000000) + " milliseconds");
        System.out.println("Insertion Sort Time: " + ((insertEndTime - insertStartTime) / 1000) + " microseconds\n");

        Integer[] C = Arrays.copyOf(unsorted, unsorted.length);
        long shellStartTime = System.nanoTime();
        shellSort(C);
        long shellEndTime = System.nanoTime();
        System.out.println("Shell Sort Time: " + ((shellEndTime - shellStartTime) / 1000000) + " milliseconds");
        System.out.println("Shell Sort Time: " + ((shellEndTime - shellStartTime) / 1000) + " microseconds\n");

        Integer[] D = Arrays.copyOf(unsorted, unsorted.length);
        long quickStartTime = System.nanoTime();
        quickSort(D, 0, D.length - 1);
        long quickEndTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + ((quickEndTime - quickStartTime) / 1000000) + " milliseconds");
        System.out.println("Quick Sort Time: " + ((quickEndTime - quickStartTime) / 1000) + " microseconds\n");


        Integer[] E = Arrays.copyOf(unsorted, unsorted.length);
        Integer[] temp = Arrays.copyOf(E, E.length);
        long mergeStartTime = System.nanoTime();
        mergeSort(E, temp, 0, E.length - 1);
        long mergeEndTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + ((mergeEndTime - mergeStartTime) / 1000000) + " milliseconds");
        System.out.println("Merge Sort Time: " + ((mergeEndTime - mergeStartTime) / 1000) + " microseconds\n");
    }
}