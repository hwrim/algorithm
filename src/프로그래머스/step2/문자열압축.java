package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 문자열압축 {
    @Test
    public void correct() {
        Assertions.assertEquals(7, solution("aabbaccc"));
        Assertions.assertEquals(9, solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8, solution("abcabcdede"));
        Assertions.assertEquals(14, solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17, solution("xababcdcdababcdcd"));
    }

    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String word = s.substring(0, i);
            int cnt = 1;
            String result = "";
            String last = "";
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (word.equals(s.substring(j, j + i))) {
                    cnt++;
                } else {
                    result += word;
                    if (cnt != 1) {
                        result = cnt + result;
                    }
                    word = s.substring(j, j + i);
                    cnt = 1;
                }
            }
            result += word + last;
            if (cnt != 1) {
                result = cnt + result;
            }
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
