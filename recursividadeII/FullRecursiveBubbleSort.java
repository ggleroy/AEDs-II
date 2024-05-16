public class FullRecursiveBubbleSort {
    
    public static void bubbleSortRecursive(int[] array, int n) {
        if (n == 1) {
            return;
        }

        innerRecursive(array, 0, n);

        bubbleSortRecursive(array, n - 1);
    }

    private static void innerRecursive(int[] array, int current, int end) {
        if (current < end - 1) {
            if (array[current] > array[current + 1]) {

                int temporary = array[current];
                array[current] = array[current + 1];
                array[current + 1] = temporary;
            }
            innerRecursive(array, current + 1, end);
        }
    }
}
