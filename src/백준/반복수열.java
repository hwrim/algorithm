package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (true) {
            int result = 0;
            int num = list.get(list.size() - 1);
            while (num != 0) {
                result += Math.pow(num % 10, x);
                num /= 10;
            }
            if (list.contains(result)) {
                System.out.println(list.indexOf(result));
                break;
            }
            list.add(result);
        }
    }

    static String src = "57 2";
}
