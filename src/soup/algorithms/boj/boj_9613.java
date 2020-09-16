package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # GCD 합
public class boj_9613 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long ans = 0;

            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    ans += gcd(arr[j], arr[k]);
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
