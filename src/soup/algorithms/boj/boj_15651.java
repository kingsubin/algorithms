package soup.algorithms.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj_15651 {
    static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numbers = new int[10];
    static boolean[] v = new boolean[10];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        func(0);
        bw.flush();
        bw.close();
    }

    static void func(int k) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.append(numbers[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            numbers[k] = i;
            v[i] = true;

            func(k + 1);
            v[i] = false;
        }

    }
}
