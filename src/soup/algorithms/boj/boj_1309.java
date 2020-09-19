package soup.algorithms.boj;

import java.io.*;

public class boj_1309 {
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 9901;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];

        dp[0][2] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];

            dp[i][0] %= mod;
            dp[i][1] %= mod;
            dp[i][2] %= mod;
        }

        int ans = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
        System.out.println(ans);
    }
}