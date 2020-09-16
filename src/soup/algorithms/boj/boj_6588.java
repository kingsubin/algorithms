package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # 골드바흐의 추측
public class boj_6588 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int a, b, n;
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }
        for (int i = 2; i*i < prime.length; i++) {
            for (int j = i*2; j < prime.length; j+=i) {
                prime[j] = false;
            }
        }


        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    a = i;
                    b = n-a;
                }

                if (prime[b]) {
                    bw.write(n + " = " + a + " + " + b +"\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
