package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// # 2xn 타일링 2
public class boj_11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
