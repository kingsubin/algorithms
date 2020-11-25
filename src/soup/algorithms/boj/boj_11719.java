package soup.algorithms.boj;

import java.io.*;

public class boj_11719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;

    public static void main(String[] args) throws IOException {
        while (( str = br.readLine()) != null ) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }
}
