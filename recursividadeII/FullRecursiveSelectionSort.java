public class FullRecursiveSelectionSort {

    public static void recursiveSelectionSort(int[] array, int position, int n) {
        if (position == n) {
            return;
        }

        int minPosition = findMinPosition(array, position, position + 1);

        int temporary = array[position];
        array[position] = array[minPosition];
        array[minPosition] = temporary;

        recursiveSelectionSort(array, position + 1, n);
    }

    private static int findMinPosition(int[] array, int minPosition, int current) {
        if (current == array.length) {
            return minPosition;
        }

        if (array[current] < array[minPosition]) {
            minPosition = current;
        }

        return findMinPosition(array, minPosition, current + 1);
    }
}
