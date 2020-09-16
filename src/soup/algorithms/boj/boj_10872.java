package soup.algorithms.boj;

import java.util.Scanner;

// 팩토리얼 
public class boj_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = fac(n);

        System.out.println(ans);
    }

    static int fac (int n) {
        if (n <= 1) return 1;
        else return n * fac(n-1);
    }
}
