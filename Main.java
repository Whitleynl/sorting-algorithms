
public class Main {
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


    public static void main(String[] args) {
        System.out.print("Selection Sort: ");
        Integer[] A = { 5, 3, 2, 1, 4};
        selectionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }

        Integer[] B = { 5, 3, 2, 1, 4};
        System.out.print("Insertion Sort: ");
        insertionSort(B);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }

        Integer[] C = { 5, 3, 2, 1, 4};
        System.out.print("ShellSort: ");
        shellSort(C);
        for (int i = 0; i < C.length; i++) {
            System.out.println(C[i]);
        }

        Integer[] D = { 5, 3, 2, 1, 4};
        System.out.print("QuickSort: ");
        quickSort(D, 0, D.length - 1);
        for (int i = 0; i < D.length; i++) {
            System.out.println(D[i]);
        }
    }
}