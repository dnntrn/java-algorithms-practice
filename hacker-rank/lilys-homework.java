import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        LinkedHashMap hm = new LinkedHashMap();
        LinkedHashMap hm2 = new LinkedHashMap();

        int[] arrCopy1 = new int[arr.length];
        int[] incArr = new int[arr.length];
        int[] arrCopy2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
             hm.put(arr[i], i);
             hm2.put(arr[i], i);
             incArr[i] = arr[i];
             arrCopy1[i] = arr[i];
             arrCopy2[i] = arr[i];
        }




        int[] decArrCopy = new int[arr.length];

        Arrays.sort(incArr);

        for (int i = 0; i< incArr.length; i++){
            System.out.print(incArr[i]);
        }




        int count2 = 0;
        for (int i = incArr.length - 1; i >= 0; i--) {

            decArrCopy[count2] = incArr[i];
            count2 += 1;
        }



        for (int i = 0; i< decArrCopy.length; i++){
            System.out.print(decArrCopy[i]);
        }


        int x = checkSwaps(arrCopy1, incArr, hm);

        int y = checkSwaps(arrCopy2, decArrCopy, hm2);
        System.out.println(x);
        System.out.println(y);


        if (x < y){
            return x;
        }


        return y;


    }

    static int checkSwaps(int [] ogArr, int [] compareArr, LinkedHashMap hm){
        int countSwaps = 0;
        int swapIndex;

        int switchInd;
        for (int i = 0; i < ogArr.length; i++){
            if (ogArr[i] != compareArr[i] ){
                countSwaps += 1;

                swapIndex= (int)hm.get(compareArr[i]);


                hm.put(compareArr[i],i);
                hm.put(ogArr[i],swapIndex);
                ogArr[swapIndex] = ogArr[i];
                ogArr[i] = compareArr[i];
            }

        }

        return countSwaps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
