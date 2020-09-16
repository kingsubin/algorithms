package soup.algorithms.boj;

import java.io.*;

// # 1로 만들기
public class boj_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp[2] = 1; dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
