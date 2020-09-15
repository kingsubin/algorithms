package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// #17299 오등큰수
public class boj_17299 {
    public static void main(String[] args) throws Exception {
        Stack<Integer> s = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ngf = new int[n];
        int[] F = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            F[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
            }

            while (!s.isEmpty() && F[arr[s.peek()]] < F[arr[i]]) {
                ngf[s.pop()] = arr[i];
            }

            s.push(i);
        }

        while (!s.isEmpty()) {
            ngf[s.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(ngf[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
