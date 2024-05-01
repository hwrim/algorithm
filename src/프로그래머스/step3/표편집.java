package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 표편집 {
    @Test
    public void correct() {
        Assertions.assertEquals("OOOOXOOO", solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        Assertions.assertEquals("OOXOXOOO", solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        // u 현재에서 위에 행 선택
        // d 현재에서 아래 행 선택
        // c 현재 삭제 후, 아래 행 / 마지막이면 위에 행 선택
        // z 최근 삭제 행 복구 / 현재 선택 행은 안됨
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for (int i = 0; i < cmd.length; i++) {
            char command = cmd[i].charAt(0);
            if (command == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if (command == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            } else if (command == 'C') {
                stack.add(k);
                size--;
                if (k == size) k--;
            } else if (command == 'Z') {
                if (stack.pop() <= k)
                    k++;
                size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), "X");
        }
        answer = sb.toString();
        return answer;
    }
}
