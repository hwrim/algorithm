package 프로그래머스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    @Test
    public void correct() {
        Assertions.assertEquals("TCMA",
                solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}
                        , new int[]{5, 3, 2, 7, 5}));
    }

    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int val = choices[i] - 4;
            char[] ch = survey[i].toCharArray();
            if (val < 0) {
                map.put(ch[0], map.getOrDefault(ch[0], 0) + Math.abs(val));
            } else {
                map.put(ch[1], map.getOrDefault(ch[1], 0) + val);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');

        return sb.toString();
    }
}
