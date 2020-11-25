package soup.algorithms.boj;

import java.util.Scanner;

public class boj_17478 {
    static StringBuilder sb = new StringBuilder();
    static String base = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String str = "\"재귀함수가 뭔가요?\"";
    static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String ans = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String ans2 = "라고 답변하였지.";
    static String bar = "____";
    static String q = str + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n";
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sb.append(base + "\n");
        sb.append(q);

        func(1);

        System.out.println(sb.toString());
    }

    static void func(int n) {
        String nBar = "";
        for (int i = 0; i < n; i++) {
            nBar += bar;
        }

        if (n < N) {
            sb.append(nBar + str + "\n");
            sb.append(nBar + str2 + "\n");
            sb.append(nBar + str3 + "\n");
            sb.append(nBar + str4 + "\n");

            func(n + 1);
        } else {
            sb.append(nBar + str + "\n");
            sb.append(nBar + ans + "\n");

            for (int i = n; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    sb.append(bar);
                }
                sb.append(ans2 + "\n");
            }
        }

    }

}
