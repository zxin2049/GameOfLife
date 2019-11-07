package game.util;

import game.model.CellMatrix;

import java.io.*;
import java.util.Arrays;

/**
 * @Author zxs
 * @Date 2019/10/30 15:01
 * @ClassName Utils
 * @Description 工具方法类
 * @Version 1.0
 **/
public class Utils {

    /**
     * 从文件路径初始化CellMatrix对象
     * @param path 路径
     * @return  从文件获取的矩阵
     */
    public static CellMatrix initMatrixFromFile(String path) {
        /**
         * 复杂图形预留空间
         */
        int heightPre=150;
        int weightPre=50;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = reader.readLine();
            String[] array = line.split(" ");
            int mode = Integer.parseInt(array[0]);
            int width = Integer.parseInt(array[1]);
            int height = Integer.parseInt(array[2]);
            // 进化速度
            int duration = Integer.parseInt(array[3]);
            // 生命个数
            int totalNum = Integer.parseInt(array[4]);
            int[][] matrix = null;
            // 简单模式 - 直接进入
            if (mode==0) {
                matrix = new int[height][width];
                for (int i = 0; i < height; i++) {
                    line = reader.readLine();
                    array = line.split(" ");
                    for (int j = 0; j < array.length; j++) {
                        matrix[i][j] = Integer.parseInt(array[j]);
                    }
                }
            } else {
                // 复杂模式
                // 预留变化空间（四个方向各加50空格）
                height=height+150;
                width=width+100;
                matrix=textTransform(width,height,reader,matrix);
            }

            CellMatrix cellMatrix = new CellMatrix(height, width, duration, totalNum, matrix);
            return cellMatrix;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 复杂文本转换
     * @param width
     * @param height
     * @return
     */
    public static int[][] textTransform(int width,int height,BufferedReader reader,int[][] matrix) throws IOException {
        matrix = new int[height][width];
        // 全部填充0
       for (int k=0;k<matrix.length;k++) {
           Arrays.fill(matrix[k], 0);
       }

        String line=null;
        String[] array=null;
        for (int i = 100; i < height+100-150; i++) {
            line = reader.readLine();
//            System.out.println(line.toString());
            if (line.isEmpty()){
                continue;
            }
            array = line.split("");
            for (int j = 0; j < array.length; j++) {
                if (!".".equals(array[j])){
                    matrix[i][j+100] = Integer.parseInt((array[j]));
                }
            }
        }
        return matrix;
    }

}
