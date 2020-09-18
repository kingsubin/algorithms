package soup.algorithms.boj;

import java.io.*;

public class boj_15988 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[1000001];
    static final long mod = 1000000009L;

    public static void main(String[] args) throws IOException {
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            dp[i] %= mod;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}