package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 키패드누르기 {
    @Test
    public void correct() {
        Assertions.assertEquals("LRLLLRLLRRL",
                solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftFinger = 10;
        int rightFinger = 12;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                leftFinger = num;
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                rightFinger = num;
            } else {
                if (num == 0) num = 11;
                int left = Math.abs(leftFinger - num) / 3 + Math.abs(leftFinger - num) % 3;
                int right = Math.abs(rightFinger - num) / 3 + Math.abs(rightFinger - num) % 3;
                if (left > right) {
                    answer += "R";
                    rightFinger = num;
                } else if (left < right) {
                    answer += "L";
                    leftFinger = num;
                } else {
                    if ("right".equals(hand)) {
                        answer += "R";
                        rightFinger = num;
                    } else {
                        answer += "L";
                        leftFinger = num;
                    }
                }
            }
        }


        return answer;
    }
}
