package game.ui;

import game.model.CellMatrix;
import game.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * @Author zxs
 * @Date 2019/10/30 10:34
 * @ClassName GameOfLifeFrame
 * @Description 游戏框架
 * @Version 1.0
 **/
public class GameOfLifeFrame extends JFrame {

    private JButton selectFileBtn = new JButton("选择文件");
    private JButton startGameBtn = new JButton("开始游戏");
    private JLabel genSpeed = new JLabel("进化速度：",JLabel.CENTER);
    private JTextField generationSpeed = new JTextField("200");
    private JLabel lifeCount = new JLabel("生命数量：",JLabel.CENTER);
    private JTextField countLife = new JTextField("0");
    private JLabel generation = new JLabel("进化层次：",JLabel.CENTER);
    private JTextField generationCount = new JTextField("0");
    /**
     * 是否开始/结束标志
     */
    private boolean isStart = false;
    private boolean isEnd = false;
    /**
     * 默认时间间隔
     */
    private static int TIME_INTERVAL = 200;
    private int duration = TIME_INTERVAL;
    /**
     * 进化次数
     */
    private int generationNum = 0;

    private JPanel btnPanel = new JPanel(new GridLayout());
    private JPanel gridPanel = new JPanel(new GridLayout());
    /**
     * 宫格矩阵
     */
    private JTextField[][] textMatrix;
    /**
     * 数组矩阵
     */
    private CellMatrix cellMatrix;

    public GameOfLifeFrame() {
        setTitle("生命游戏");

        // 按钮监听器
        selectFileBtn.addActionListener(new OpenFileListener());
        startGameBtn.addActionListener(new StartGameListener());

        // 加入面板
        btnPanel.add(selectFileBtn);
        btnPanel.add(startGameBtn);
        btnPanel.add(genSpeed);
        btnPanel.add(generationSpeed);
        btnPanel.add(lifeCount);
        btnPanel.add(countLife);
        btnPanel.add(generation);
        btnPanel.add(generationCount);
        btnPanel.setBackground(Color.white);
        // 设置状态为不可更改
        countLife.setEnabled(false);
        generationCount.setEnabled(false);

        getContentPane().add(btnPanel, "North");
//        add(btnPanel);
//        add(gridPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 50, 1100, 900);
        setVisible(true);
    }


    private class OpenFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser(".\\src\\game\\mod");
            fileChooser.setDialogTitle("请选择初始配置文件");
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                isStart = false;
                isEnd = true;
                startGameBtn.setText("开始游戏");
                String filepath = fileChooser.getSelectedFile().getPath();
                cellMatrix = Utils.initMatrixFromFile(filepath);
                initGridLayout();
                showMatrix();
                countLife.setText(String.valueOf(cellMatrix.getTransformNum()));
                generationSpeed.setText(String.valueOf(cellMatrix.getDuration()));
                gridPanel.updateUI();
            }
        }
    }

    /**
     * 创建显示的gridlayout布局
     */
    private void initGridLayout() {
        int rows = cellMatrix.getHeight();
        int cols = cellMatrix.getWidth();
        gridPanel = new JPanel();
        // 宫格数量设置
        gridPanel.setLayout(new GridLayout(rows, cols));
        textMatrix = new JTextField[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                JTextField text = new JTextField();
                // 去掉边框
                //text.setBorder(BorderFactory.createEmptyBorder());
                text.setBorder(BorderFactory.createLineBorder(new Color(231,239,236)));
                textMatrix[y][x] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }

    /**
     * Panel上显示宫格
     */
    private void showMatrix() {
        int[][] matrix = cellMatrix.getMatrix();
//        System.out.println(matrix.length+" : "+matrix[0].length);
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    textMatrix[y][x].setBackground(new Color(0, 0, 0));
                } else {
                    textMatrix[y][x].setBackground(Color.WHITE);
                }
            }
        }
    }

    /**
     * 开始按钮监听器
     */
    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isStart && cellMatrix != null) {
                //获取时间
                try {
                    duration = Integer.parseInt(generationSpeed.getText().trim());
                } catch (NumberFormatException e1) {
                    duration = TIME_INTERVAL;
                }
                new Thread(new GameControlTask()).start();
                isStart = true;
                isEnd = false;
                startGameBtn.setText("暂停游戏");
            } else {
                isStart = false;
                isEnd = true;
                startGameBtn.setText("开始游戏");
            }
        }
    }

    /**
     * 游戏控制
     */
    private class GameControlTask implements Runnable {
        @Override
        public void run() {
            while (!isEnd) {
                cellMatrix.transform();
                generationCount.setText(String.valueOf(generationNum++));
                countLife.setText(String.valueOf(cellMatrix.countLifeNum()));
                showMatrix();
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
