package me.kingsubin.studyrepo.algorithm.programmers;

/*
 1 <= d.length <= 100
 1 <= d.val <= 100,000
 1 <= budget <= 10,000,000
 돈을 정확하게 줘야함.
 몇개의 부서에 지원할수있는지 최댓값
 */

import java.util.Arrays;

public class Level1_예산 {
    public static int solution(int[] d, int budget) {
        int ans = 0;

        Arrays.sort(d);
        for (int j : d) {
            if (budget < j) {
                return ans;
            }

            budget -= j;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;

        int ans = solution(d, budget);
        System.out.println(ans);
    }
}
