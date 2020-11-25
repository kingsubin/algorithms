package soup.algorithms.boj;

import java.util.Scanner;

public class boj_9663 {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static boolean[] v1, v2, v3;

    public static void main(String[] args) {
        n = sc.nextInt();

        v1 = new boolean[n];
        v2 = new boolean[n*2 - 1];
        v3 = new boolean[n*2 - 1];

        func(0);
        System.out.println(ans);
    }

    static void func(int k) {
        // base condition
        if (k == n) {
            ans++;
            return;
        }

        // recursion
        for (int i = 0; i < n; i++) {
            if (v1[i] || v2[k+i] || v3[k-i+n-1]) continue;

            v1[i] = true;
            v2[k+i] = true;
            v3[k-i+n-1] = true;

            func(k+1);
            v1[i] = false;
            v2[k+i] = false;
            v3[k-i+n-1] = false;
        }
    }
}
