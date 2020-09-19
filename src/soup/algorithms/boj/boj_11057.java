package soup.algorithms.boj;

import java.io.*;

public class boj_11057 {
    static int[][] dp;
    static final int mod = 10007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i];
        }
        System.out.println(ans % mod);
    }
}