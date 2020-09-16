package soup.algorithms.boj;

import java.io.*;

// # 골드바흐 파티션
public class boj_17103 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] prime = new boolean[1000001];
    static int ans;

    public static void main(String[] args) throws IOException {
        // 1. 1,000,001 이하의 소수 담기
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }
        for (int i = 2; i*i < prime.length; i++) {
            for (int j = i*2; j < prime.length; j+=i) {
                prime[j] = false;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 2; j <= n/2; j++) {
                if (prime[j] && prime[n-j]) {
                    ans++;
                }
            }

            bw.write(ans + "\n");
            ans = 0;
        }

        bw.flush();
        bw.close();
    }
}
