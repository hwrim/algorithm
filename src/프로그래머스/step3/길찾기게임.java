package 프로그래머스.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 길찾기게임 {
    @Test
    public void correct() {
        Assertions.assertArrayEquals(
                new int[][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}},
                solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}})
        );
    }


    static class Node {

        private int x;
        private int y;
        private int num;
        private Node right;
        private Node left;

        public Node(int x, int y, int num, Node right, Node left) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.right = right;
            this.left = left;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }
    }
    static int[][] answer;
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        Node[] tree = new Node[nodeinfo.length];

        for(int i =0; i<nodeinfo.length; i++){
            tree[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }

//        for(Node n : tree){
//            System.out.println(n);
//        }
//        System.out.println();
        Arrays.sort(tree,new Comparator<Node>(){
            public int compare(Node a , Node b){
                if(a.y==b.y){
                    return a.x-b.x;
                }
                return b.y-a.y;
            }
        } );

//        for(Node n : tree){
//            System.out.println(n);
//        }
        Node start = tree[0];

        // 이진트리 생성
        for (int i = 1; i < tree.length; i++) {
            binaryTree(start, tree[i]);
        }

        answer = new int[2][nodeinfo.length];

        //전위 순회
        preorder(start);
        //순회 초기화
        idx = 0;
        //후위 순회
        postorder(start);

        return answer;
    }

    public void binaryTree(Node parent, Node child){
        if(parent.x<child.x){
            if(parent.right == null){
                parent.right = child;
            }else{
                binaryTree(parent.right, child);
            }
        }else{
            if(parent.left == null){
                parent.left = child;
            }else{
                binaryTree(parent.left, child);
            }
        }
    }

    public void preorder(Node root){
        if(root != null){
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;

        }
    }
}
