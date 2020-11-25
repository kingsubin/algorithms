package soup.algorithms.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj_15650 {
    static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numbers = new int[10];
    static boolean[] visited = new boolean[10];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        func(0);
        bw.flush();
        bw.close();
    }

    static void func(int index) throws IOException {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.append(numbers[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (index != 0 && numbers[index-1] > i) continue;

            numbers[index] = i;
            visited[i] = true;
            func(index + 1);
            visited[i] = false;
        }
    }
}
