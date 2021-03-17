package me.kingsubin.studyrepo.algorithm.programmers;

/*
 1 ≦ n ≦ 16
 arr1, arr2 는 길이 n 인 정수배열
 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
 */
public class Level1_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[] binaryMap = new int[n];
        for (int i = 0; i < n; i++) {
            binaryMap[i] = arr1[i] | arr2[i];
        }

        for (int i = 0; i < n; i++) {
            StringBuilder ans = new StringBuilder();
            int remainder = binaryMap[i];

            for (int j = 0; j < n; j++) {
                if (remainder % 2 == 1) {
                    ans.insert(0, '#');
                } else {
                    ans.insert(0, ' ');
                }

                remainder /= 2;
            }

            answer[i] = ans.toString();
        }

        return answer;
    }

    // 출력
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] solution = solution(n, arr1, arr2);

        for (String s : solution) {
            System.out.println(s);
        }
    }
}
