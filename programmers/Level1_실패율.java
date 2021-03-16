package me.kingsubin.studyrepo.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
 1 <= N <= 500 (스테이지번호)
 1 <= stages.length <= 200,000 (사람수)
 1 <= stages.val <= N+1 (실패한 스테이지)

 N+1 은 마지막까지 클리어했다는 뜻
 실패율이 높은순서로 정렬, 실패율이 같다면 낮은 라운드부터 정렬

 */
class Stage {
    int stage;
    double failure;

    public Stage(int stage, double failure) {
        this.stage = stage;
        this.failure = failure;
    }
}

public class Level1_실패율 {
    public static int[] solution(int N, int[] stages) {
        int[] ans = new int[N];

        // 총 시도한 사람 수
        int people = stages.length;

        // 각 스테이지에서 실패한 사람 수 구하기
        int[] failPersonCountForStage = new int[N+2];
        for (int stage : stages) {
            failPersonCountForStage[stage]++;
        }

        // 각 스테이지에 대한 실패율 구하기
        double[] failure = new double[N+2];
        for (int i = 1; i < N+1; i++){
            if (people == 0) {
                failure[i] = 0;
            } else {
                failure[i] = (double) failPersonCountForStage[i] / people;
            }
            people -= failPersonCountForStage[i];
        }

        // ans1. 실패율이 높은 순서대로 스테이지 번호를 정렬
        // ans2. 실패율이 같다면 스테이지 번호가 낮은 순서로 정렬
        Stage[] stage = new Stage[N];
        for (int i = 0; i < stage.length; i++){
            stage[i] = new Stage(i+1, failure[i+1]);
        }

        Arrays.sort(stage, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2){
                return Double.compare(s2.failure, s1.failure);
            }
        });

        for(int i = 0; i < ans.length; i++){
            ans[i] = stage[i].stage;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        int[] solution = solution(N, stages);
        for (int a : solution) {
            System.out.print(a + " ");
        }
    }
}