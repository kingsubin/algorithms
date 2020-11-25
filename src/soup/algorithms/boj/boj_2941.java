package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans;
    static String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String s = str;

        for (int i = 0; i < 8; i++) {
            s = s.replaceAll(strs[i], "0");
        }

        System.out.println(s.length());
    }

}
