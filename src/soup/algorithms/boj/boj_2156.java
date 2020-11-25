package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp;
    static int[] val;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        val = new int[n+1];

        for (int i = 1; i <= n; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = val[1];
        if (n >= 2) {
            dp[2] = val[1] + val[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + val[i]), dp[i-3] + val[i-1] + val[i]);
        }

        long ans = dp[1];
        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
