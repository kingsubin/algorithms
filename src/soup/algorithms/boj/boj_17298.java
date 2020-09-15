package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// #17298_오큰수
public class boj_17298 {
    static Stack<Integer> s = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
            }

            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                nge[s.pop()] = arr[i];
            }

            s.push(i);
        }

        while (!s.isEmpty()) {
            nge[s.pop()] = -1;
        }

        for (int val : nge) {
            sb.append(val + " ");
        }
        System.out.println(sb.toString());
    }
}
