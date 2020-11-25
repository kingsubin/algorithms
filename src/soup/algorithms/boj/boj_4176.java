package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4176 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Node> qF = new LinkedList<>();
    static Queue<Node> qJ = new LinkedList<>();
    static String[][] a;
    static int[][] fire;
    static boolean[][] v;
    static int row, col, nx, ny;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        a = new String[row][col];
        fire = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                a[i][j] = str.substring(j, j+1);
                if (a[i][j].equals("F")) {
                    qF.offer(new Node(i, j));
                    fire[i][j] = 1; // 초기 불 1로 설정
                } else if (a[i][j].equals("J")) {
                    qJ.offer(new Node(i, j));
                }
            }
        }

        // F에 대한 qF BFS
        while (!qF.isEmpty()) {
            Node n = qF.poll();

            for (int i = 0; i < 4; i++) {
                nx = n.x + dx[i];
                ny = n.y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!(a[nx][ny].equals("#")) && fire[nx][ny] == 0) {
                        fire[nx][ny] = fire[n.x][n.y] + 1;
                        qF.offer(new Node(nx, ny));
                    }
                }
            }
        }

        // J에 대한 qJ BFS
        int cnt = 2; // 초기 2로 설정
        while (!qJ.isEmpty()) {
            Node n = qJ.poll();

            for (int i = 0; i < 4; i++) {
                nx = n.x + dx[i];
                ny = n.y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!(a[nx][ny].equals("#")) && cnt < fire[nx][ny]) {
                        a[nx][ny] = String.valueOf((cnt+1));
                        qJ.offer(new Node(nx, ny));
                    }
                }
            }
        }

        // 나갈때 수 찾기
        int ans = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0 || i == row) {
                    if (Integer.parseInt(a[i][j]) > ans) {
                        ans = Integer.parseInt(a[i][j]);
                    }
                } else {
                    if (Integer.parseInt(a[i][0]) > ans) {
                        ans = Integer.parseInt(a[i][j]);
                    }
                    if (Integer.parseInt(a[i][col]) > ans) {
                        ans = Integer.parseInt(a[i][j]);
                    }
                }
            }
        }

        System.out.println(ans-1);
    }

    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
