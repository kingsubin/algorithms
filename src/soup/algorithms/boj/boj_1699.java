package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최솟값을 i로 초기화 , i를 넘을 수 없음
            for (int j = 1; j*j <= i; j++) {
                if (dp[i] > dp[i-j*j] + 1) {
                    dp[i] = dp[i-j*j] + 1;
                }
            }
        }

        System.out.println(dp[n]);
    }
}