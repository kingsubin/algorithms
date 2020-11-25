package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Pair> q = new LinkedList<>();
    static int[][] a;
    static boolean[][] v;
    static int n, m, size;
    static List<Integer> sizeList = new ArrayList<>();
    static int[] lx = {-1, 1, 0, 0};
    static int[] ly = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { // 시작 부분
                if (a[i][j] == 1 && !v[i][j]) {
                    v[i][j] = true;
                    q.offer(new Pair(i, j));

                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        size++;

                        for (int k = 0; k < 4; k++) {
                            int dx = p.x + lx[k];
                            int dy = p.y + ly[k];

                            if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                                if (!v[dx][dy] && a[dx][dy] == 1) {
                                    v[dx][dy] = true;
                                    q.offer(new Pair(dx, dy));
                                }
                            }

                        }
                    }
                    sizeList.add(size);
                    size = 0;
                }
            }
        }

        if (sizeList.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
        } else {
            Collections.sort(sizeList);
            System.out.println(sizeList.size());
            System.out.println(sizeList.get(sizeList.size() - 1));
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
