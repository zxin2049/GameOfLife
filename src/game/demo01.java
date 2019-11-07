package game;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zxs
 * @Date 2019/10/29 14:41
 * @ClassName demo01
 * @Description TODO
 * @Version 1.0
 **/
public class demo01 {

    public int checkLoc(int[][] board, int i, int j){
        int count = 0;
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for(int x = top; x <= bottom; x++){
            for(int y = left; y <= right; y++){
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1) : (count == 3 ? -2 : 0);
    }

    public void startGameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = checkLoc(board, i, j);
            }
        }
        /*
        1——保持1
        -1——1转0
        0——保持0
        -2——0转1
         */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }


    public static void main(String[] args) {


        demo01 game = new demo01();

//        int [][] borad = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//        int [][] borad = {{0,1,0,1},{0,0,1,0},{1,1,1,0},{0,0,0,1}};
        int [][] borad = {{1,0,1,1,1,0,1,1,1,0},{0,1,0,0,0,1,0,0,0,1},
                {0,0,0,1,0,0,0,1,0,0},{1,0,1,1,1,0,1,1,1,0},{1,0,1,1,1,0,1,1,1,0},
                {0,1,0,0,0,1,0,0,0,1},{0,0,0,1,0,0,0,1,0,0},{1,0,1,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,1,1,1,0},{0,1,0,0,0,1,0,0,0,1}};

        System.out.println("输入：");
        for (int i=0;i<borad[0].length;i++) {
            System.out.println(Arrays.toString(borad[i]));
        }
        System.out.println();

        for (int i=0;i<10;i++) {
            game.startGameOfLife(borad);
            List list = Arrays.asList(borad);
            System.out.println("输出：");
            for (int j=0;j<borad[0].length;j++) {
                System.out.println(Arrays.toString(borad[j]));
            }
        }

    }

}
