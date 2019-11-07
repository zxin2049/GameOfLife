package game.model;

import java.util.Arrays;

/**
 * @Author zxs
 * @Date 2019/10/30 11:46
 * @ClassName CellMatrix
 * @Description 数组矩阵
 * @Version 1.0
 **/
public class CellMatrix {

    /**
     * 矩阵高度
     */
    private int height;
    /**
     * 矩阵宽度
     */
    private int width;
    /**
     * 执行速度
     */
    private int duration;
    /**
     * 总的变化次数
     */
    private int transformNum = 0;
    /**
     * 矩阵状态（1或0死）
     */
    private int[][] matrix;

    public CellMatrix(int height, int width, int duration, int transformNum, int[][] matrix) {
        this.height = height;
        this.width = width;
        this.duration = duration;
        this.transformNum = transformNum;
        this.matrix = matrix;
    }

    /**
     * 上一个状态到下一个状态的转移
     * 根据规则可以总结得出两条规则:
     * 1. 对于周围活着的细胞为3的情况,下一个状态该细胞总是为活
     * 2. 对于周围活着的细胞为2的情况,下一个状态与上一状态相同
     */
    public void transform() {
        int[][] nextMatrix = new int[height][width];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                nextMatrix[y][x] = 0;
                int nearNum = findLifedNum(y, x);
                //等于3，则下一状态总是活
                if (nearNum == 3) {
                    nextMatrix[y][x] = 1;
                } else if (nearNum == 2) {//等于2，则与上一状态一样
                    nextMatrix[y][x] = matrix[y][x];
                }
            }
        }
        matrix = nextMatrix;
    }

    /**
     * 计算矩阵生命数量
     */
    public int countLifeNum(){
        int num=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==1){
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * 计算元素周围生命数量
     * @param y
     * @param x
     * @return
     */
    public int findLifedNum(int y, int x) {
        int num = 0;
        //左边
        if (x != 0) {
            num += matrix[y][x - 1];
        }
        //左上角
        if (x != 0 && y != 0) {
            num += matrix[y - 1][x - 1];
        }
        //上边
        if (y != 0) {
            num += matrix[y - 1][x];
        }
        //右上
        if (x != width - 1 && y != 0) {
            num += matrix[y - 1][x + 1];
        }
        //右边
        if (x != width - 1) {
            num += matrix[y][x + 1];
        }
        //右下
        if (x != width - 1 && y != height - 1) {
            num += matrix[y + 1][x + 1];
        }
        //下边
        if (y != height - 1) {
            num += matrix[y + 1][x];
        }
        //左下
        if (x != 0 && y != height - 1) {
            num += matrix[y + 1][x - 1];
        }
        return num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]) + "\n");
        }
        return sb.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDuration() {
        return duration;
    }

    public int getTransformNum() {
        return transformNum;
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
