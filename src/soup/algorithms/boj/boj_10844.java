package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 쉬운 계단 수
public class boj_10844 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long mod = 1000000000L;
    static long[][] dp = new long[101][10];

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j+1];
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
                }
                dp[i][j] %= mod;
            }
        }

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i];
        }
        ans %= mod;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
