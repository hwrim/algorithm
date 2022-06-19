package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    @Test
    public void correct() {
        Assertions.assertEquals("mislav",
                solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                        new String[]{"stanko", "ana", "mislav"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String a : participant)
            map.put(a, map.getOrDefault(a, 0) + 1);
        for (String a : completion)
            map.put(a, map.get(a) - 1);
        for(String a : map.keySet()){
            if (map.get(a) != 0) {
                answer = a;
                break;
            }
        }
        return answer;
    }

}
