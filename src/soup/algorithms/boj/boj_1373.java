package soup.algorithms.boj;

import java.util.Scanner;

// # 2진수 8진수
public class boj_1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String s = sc.nextLine();
        int n = s.length();

        if (n % 3 == 1) {
            sb.append(s.charAt(0));
        } else if (n % 3 == 2) {
            sb.append((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
        }

        for (int i = n%3; i < n; i+=3) {
            sb.append((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
        }

        System.out.println(sb.toString());
    }
}
