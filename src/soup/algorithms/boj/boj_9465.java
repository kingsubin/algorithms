package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st, st2;
    static int[][] dp;
    static int[][] val;
    static int t;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());

            val = new int[3][n];
            for (int j = 0; j < n; j++) {
                val[1][j] = Integer.parseInt(st.nextToken());
                val[2][j] = Integer.parseInt(st2.nextToken());
            }

            dp = new int[3][n];
            dp[1][0] = val[1][0]; dp[2][0] = val[2][0];

            for (int j = 1; j < n; j++) {
                dp[0][j] = Math.max(Math.max(dp[0][j-1], dp[1][j-1]), dp[2][j-1]);
                dp[1][j] = Math.max(dp[0][j-1], dp[2][j-1]) + val[1][j];
                dp[2][j] = Math.max(dp[0][j-1], dp[1][j-1]) + val[2][j];
            }

            System.out.println(Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]));
        }

    }
}
