package soup.algorithms.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// # 소수 구하기
public class boj_1929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i*i <= n; i++) {
            for (int j = i*2; j <= n; j+=i) {
                prime[j] = false;
            }
        }

        for (int i = m; i <= n ; i++) {
            if (prime[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}
