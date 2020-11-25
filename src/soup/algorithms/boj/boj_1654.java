package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] len;
    static int k, n;
    static long next;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        len = new long[k];
        for (int i = 0; i < k; i++) {
            len[i] = Long.parseLong(br.readLine());
        }

        long avg = len[0];
        long min = 0;
        long max = len[len.length-1];

        func(avg, min, max);
        System.out.println(avg);
    }

    static void func(long avg, long min, long max) {
        while (true) {
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += len[i] / avg;
            }

            if (cnt == n+1) {
                next = avg;
            }

            if (cnt == n) {
                func((avg + next) / 2, avg, next);
                return;
            }

            if (cnt < n) {
                max = avg;
                avg = (min + max) / 2;
            }

            if (cnt > n) {
                min = avg;
                avg = (min + max) / 2;
            }
        }
    }

}
