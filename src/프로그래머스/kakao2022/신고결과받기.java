package 프로그래머스.kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 신고결과받기 {


    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{2,1,1,0},
                solution(new String[]{"muzi", "frodo", "apeach", "neo"}
                ,new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
                ,2));
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> hMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            hMap.put(name, new HashSet<>());
            map.put(name, i);
        }

        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            hMap.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = hMap.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[map.get(name)]++;
                }
            }
        }
        return answer;
    }
}
