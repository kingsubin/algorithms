package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] dp;
    static StringTokenizer st;
    static final long mod = 1000000000L;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new long[k+1][n+1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}