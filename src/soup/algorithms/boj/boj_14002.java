package soup.algorithms.boj;
import java.util.Scanner;

public class boj_14002 {
    static int[] arr;
    static int[] dp;
    static int[] v;

    // 출력 함수
    static void print(int p) {
        if (p == 0) return;
        print(v[p]);
        System.out.print(arr[p] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n+1]; // dp
        v = new int[n+1]; // 역추적

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    v[i] = j; // 찾아간 값의 index를 배열에 저장
                }
            }
        }

        int ans = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
                index = i; // ans의 index 뽑기
            }
        }

        System.out.println(ans);
        print(index); // ans의 index부터 재귀 시작
        System.out.println();

    }
}