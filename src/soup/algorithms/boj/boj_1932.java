package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];

    static void go(int index, int n, int m) {
        if (index == m) { // index가 증가해서 검색이 끝나면 출력
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m-1) System.out.print(' '); // 마지막이 아니라면 공백
            }
            System.out.println(); // 뽑았으면 줄 넘기기
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i]) continue; // 사용한 수면 넘어가기
            c[i] = true; // 사용했다고 체크
            a[index] = i; // 수에 넣기
            go(index+1, n, m); // 다음 인덱스에 대하여 재귀
            c[i] = false; // 초기화
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1~n
        int m = Integer.parseInt(st.nextToken()); // m 개
        go(0, n , m);
    }
}
