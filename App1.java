import java.util.Arrays;

public class App1 {
    public static void main(String[] args) {
        
        int[] testMassive = {3, 21, 5, 63, 21, 13, 5, 7, 6, 9, 0};

        System.out.println(Arrays.toString(testMassive));
        
        mergeSort(testMassive, testMassive.length);

        System.out.println(Arrays.toString(testMassive));
    }

    private static void mergeSort(int[] arr, int size) {

        if(size<2) return;
        
        int mid = size/2;
        int[] lArr = new int[mid];
        int[] rArr = new int[size - mid];

        for (int i = 0; i < mid; i++){
            lArr[i] = arr[i];
        }

        for (int i = mid; i < size; i++){
            rArr[i - mid] = arr[i];
        }

        mergeSort(lArr, mid);
        mergeSort(rArr, size - mid);

        mergeArr(arr, lArr, rArr, mid, size - mid);
    }

    public static void mergeArr(int[] arr, int[] lArr, int[] rArr, int left, int right) {
        
        int i = 0, j = 0, k = 0;

        while(i < left && j < right){
            if(lArr[i]<=rArr[j]) arr[k++] = lArr[i++];
            else arr[k++] = rArr[j++];
        }

        while(i < left){
            arr[k++] = lArr[i++];
        }

        while(j < right){
            arr[k++] = rArr[j++];
        }         
    }
}