import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 신고결과받기 {

    public static void main(String[] args) throws IOException {
        String[] a = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] b = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int c = 2;
        int [] result = solution(a, b, c);
        for(int i : result)
            System.out.println(i);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> idx = new HashMap<>();
        Map<String, HashSet<String>> setMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            idx.put(name, i);
            setMap.put(name, new HashSet<>());
        }

        for (String s : report) {
            String[] str = s.split(" ");
            String user = str[0];
            String user2 = str[1];
            setMap.get(user2).add(user);
        }
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> result = setMap.get(id_list[i]);
            if (result.size() >= k){
                for(String s : result)
                    answer[idx.get(s)]++;
            }
        }
        return answer;
    }

}
