package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1149 {
    static int[][] dp;
    static int[][] val; // 페인트 가격
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        val = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            val[i][0] = Integer.parseInt(st.nextToken()); // R
            val[i][1] = Integer.parseInt(st.nextToken()); // G
            val[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        dp[0][0] = val[0][0]; dp[0][1] = val[0][1]; dp[0][2] = val[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + val[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + val[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + val[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
    }
}