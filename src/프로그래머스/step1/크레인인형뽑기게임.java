package 프로그래머스.step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 크레인인형뽑기게임 {

    @Test
    public void correct() {
        Assertions.assertEquals(4,
                solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //스택을 사용해야함
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[i][move - 1]);
                    }else{
                        if (stack.peek() == board[i][move - 1]) {
                            stack.pop();
                            answer+=2;
                        }else{
                            stack.push(board[i][move - 1]);
                        }
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }


}
