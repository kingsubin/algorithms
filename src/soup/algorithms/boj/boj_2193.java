package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 이친수
public class boj_2193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] dp = new long[91][2];

    public static void main(String[] args) throws Exception {
        dp[1][1] = 1;

        for (int i = 2; i <= 90; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
