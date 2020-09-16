package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// # 1, 2, 3 더하기
public class boj_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
