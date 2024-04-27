package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.*;

public class 압축 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(new int[]{11, 1, 27, 15}, solution("KAKAO"));
        Assertions.assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, solution("TOBEORNOTTOBEORTOBEORNOT"));
        Assertions.assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, solution("ABABABABABABABAB"));
    }

    public int[] solution(String msg) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i + "", idx++);
        }

        int num = 0;
        while (num < msg.length()) {
            String word = "";
            while (num < msg.length()) {
                if (!map.containsKey(word + msg.charAt(num))) break;
                else word += msg.charAt(num);
                num++;
            }
            list.add(map.get(word));
            if (num < msg.length()) {
                map.put(word + msg.charAt(num), idx++);
            }
        }

        answer = new int[list.size()];
        IntStream.range(0, list.size()).forEach(cnt->{
            answer[cnt] = list.get(cnt);
        });



        return answer;
    }

}
