import java.io.*;
import java.util.*;


public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int myRank = 1;
        int [] ranks = new int [scores.length];
        ranks[0] = myRank;
        for (int i = 1; i < scores.length; i++){
            if (scores[i] != scores[i-1]){
                myRank += 1;
            }

            ranks[i] = myRank;

        }

        int scoresLength = scores.length;
        System.out.println(scoresLength);
        int aliceLength = alice.length;

        int finalRank = 0;

        int [] finalRanks = new int[alice.length];


        boolean changed = false;

        int rank = 1;
        int start = scoresLength -1;
        for (int i = 0; i < aliceLength; i++){
            changed = false;
            rank = 1;
            for (int j = start; j >= 0; j--) {

                if (alice[i] == scores[j]) {
                    finalRank = ranks[j];
                    start = j;
                    changed = true;
                    break;
                } else if (alice[i] < scores[j]){
                    finalRank = ranks[j] +1;
                    start = j;
                    changed = true;
                    break;
                }

            }

            if (!changed){
                finalRank = 1;
            }

            finalRanks[i] = finalRank;
        }

        return finalRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
