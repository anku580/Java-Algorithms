import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class CountSort{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of Array to be sorted");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the Array to be sorted");
        int[] arr = new int[n];
        String[] integerStrings = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(integerStrings[i]);
        }
        int k = 60;

        countingSort(arr, k);

        System.out.println("Sorted Array :- ");
        System.out.println(Arrays.toString(arr));

    }

    static void countingSort(int[] input, int k) {
        // create buckets
        int count[] = new int[k + 1];

        for (int i : input) {
            count[i]++;
        }

        int ndx = 0;
        for (int i = 0; i < count.length; i++) {
            while (0 < count[i]) {
                input[ndx++] = i;
                count[i]--;
            }
        }
    }

}
