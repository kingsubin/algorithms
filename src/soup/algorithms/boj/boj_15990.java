package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// # 1, 2, 3 더하기 5
public class boj_15990 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long mod = 1000000009L;
    static long[][] dp = new long[100001][4];

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 100001; i++) {
            if (i-1 >= 0) {
                dp[i][1] = dp[i-1][2] + dp[i-1][3];
                if (i == 1) {
                    dp[i][1] = 1;
                }
            }
            if (i-2 >= 0) {
                dp[i][2] = dp[i-2][1] + dp[i-2][3];
                if (i == 2) {
                    dp[i][2] = 1;
                }
            }
            if (i-3 >= 0) {
                dp[i][3] = dp[i-3][1] + dp[i-3][2];
                if (i == 3) {
                    dp[i][3] = 1;
                }
            }
            dp[i][1] %= mod;
            dp[i][2] %= mod;
            dp[i][3] %= mod;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(String.valueOf((dp[n][1] + dp[n][2] + dp[n][3]) % mod)).append("\n");
        }

        bw.flush();
        bw.close();
    }
}
