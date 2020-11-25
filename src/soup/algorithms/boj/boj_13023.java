package soup.algorithms.boj;

import java.util.*;

class Edge {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class boj_13023{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람의 수
        int m = sc.nextInt(); // 관계의 수
        boolean[][] a = new boolean[n][n]; // 인접행렬
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n]; // 인접리스트
        ArrayList<Edge> edges = new ArrayList<Edge>(); // 간접리스트
        for (int i=0; i<n; i++) { // 인접리스트 배열 초기화
            g[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) { // 그래프 그리기
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from, to)); // 간접리스트에 표시
            edges.add(new Edge(to, from));
            a[from][to] = a[to][from] = true; // 인접행렬 표시
            g[from].add(to); // 인접리스트 표시
            g[to].add(from);
        }
        m *= 2; // 양방향 관계로 표시했으니 2배 해서 돌아야함
        for  (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                int A = edges.get(i).from; // i
                int B = edges.get(i).to;

                int C = edges.get(j).from; // j
                int D = edges.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue; // 같은 값 제외
                }
                if (!a[B][C]) continue; // B와 C의 관계 체크
                for (int E : g[D]) { // D의 인접리스트를 돌며 같은 값이 없으면 연결된것이 맞음
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}