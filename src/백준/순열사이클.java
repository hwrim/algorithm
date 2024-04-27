package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 순열사이클 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int ts = Integer.parseInt(br.readLine());
        while (ts-- > 0) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int v = Integer.parseInt(st.nextToken());
                list.get(i).add(v);
            }
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int i : list.get(start)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }


    static String src = "2\n" +
            "8\n" +
            "3 2 7 8 1 4 5 6\n" +
            "10\n" +
            "2 1 3 4 5 6 7 9 10 8";
}
