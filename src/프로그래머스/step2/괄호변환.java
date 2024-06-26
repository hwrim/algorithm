package 프로그래머스.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 괄호변환 {
    @Test
    public void correct() {
        Assertions.assertEquals("(()())()", solution("(()())()"));
        Assertions.assertEquals(")(", solution("()"));
        Assertions.assertEquals("()))((()", solution("()(())()"));
    }

    static int idx = 0;

    public String solution(String p) {
        String answer = "";

        if ("".equals(p)) {
            return p;
        }

        boolean flag = dfs(p);
        String u = p.substring(0,idx);
        String v = p.substring(idx);

        if (flag) {
            return u + solution(v);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(solution(v));
        sb.append(')');

        for (int i = 1; i < u.length()-1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private static boolean dfs(String p) {
        boolean flag = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '(') {
                stack.add(ch);
                left++;
            } else {
                right++;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                    flag = false;
                }
            }
            if (left == right) {
                idx = i + 1;
                break;
            }
        }


        return flag;
    }
//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//  4-3. ')'를 다시 붙입니다.
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//  4-5. 생성된 문자열을 반환합니다.

}
