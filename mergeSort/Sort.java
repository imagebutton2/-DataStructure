//πÈ≤¢≈≈–Ú

public class Sort {
 public static void mergeSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = n >> 1;
        mergeInternal(array, 0, n - 1);

    }

    private static void mergeInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeInternal(array, low, mid);
        mergeInternal(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid + 1 && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= high) {
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = array[start++];
        }
        for (i = 0; i < temp.length; i++) {
            array[i + low] = temp[i];
        }
    }


}