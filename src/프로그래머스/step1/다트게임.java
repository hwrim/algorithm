package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 다트게임 {
    @Test
    public void correct() {
        Assertions.assertEquals(37, solution("1S2D*3T"));
        Assertions.assertEquals(9, solution("1D2S#10S"));
        Assertions.assertEquals(3, solution("1D2S0T"));
        Assertions.assertEquals(23, solution("1S*2T*3S"));
        Assertions.assertEquals(5, solution("1D#2S*3S"));
        Assertions.assertEquals(-4, solution("1T2D3D#"));
        Assertions.assertEquals(59, solution("1D2S3T*"));
    }

    public int solution(String dartResult) {
        int answer = 0;
        int[] round = new int[3];
        char[] ch = dartResult.toCharArray();
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            if (ch[i] == '*') {
                if (idx > 0)
                    round[idx - 1] *= 2;
                round[idx] *= 2;
            } else if (ch[i] == '#') {
                round[idx] *= -1;
            } else if (ch[i] == 'S') {
                round[idx] *= 1;
            } else if (ch[i] == 'D') {
                round[idx] *= round[idx];
            } else if (ch[i] == 'T') {
                round[idx] *= round[idx] * round[idx];
            } else {
                idx++;
                round[idx] += Integer.parseInt(String.valueOf(ch[i]));
                if ((i + 1 != ch.length - 1) && (ch[i] == '1' && ch[i + 1] == '0')) {
                    round[idx] = 10;
                    i++;
                }
            }
        }
        answer = round[0] + round[1] + round[2];
        return answer;
    }
}
