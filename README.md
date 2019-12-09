# GameOfLife
生命游戏

## 简介

[维基百科][https://zh.wikipedia.org/wiki/%E5%BA%B7%E5%A8%81%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F]

康威生命游戏（英语：Conway's Game of Life），又称康威生命棋，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。



## 规则

生命游戏中，对于任意细胞，规则如下：

- 每个细胞有两种状态 - 存活或死亡，每个细胞与以自身为中心的周围八格细胞产生互动（如图，黑色为存活，白色为死亡）
- 当前细胞为存活状态时，当周围的存活细胞低于2个时（不包含2个），该细胞变成死亡状态。（模拟生命数量稀少）
- 当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
- 当前细胞为存活状态时，当周围有超过3个存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
- 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）



## 分类

- 稳定状态

  1. 板凳

     ![img](screenshot\180px-Game_of_life_block.dvg.png)

  2. 面包

     ![img](screenshot\180px-Game_of_life_loaf.svg.png)

  3. 蜂巢

     ![img](screenshot\180px-Game_of_life_loaf.svg.png)

  4. 大船

     ![img](screenshot\180px-Game_of_life_5x5_ship.svg.png)

  5. 小船

     ![img](screenshot\180px-Game_of_life_boat.svg.png)

  6. 小花

     ![img](screenshot\Game_of_life_flower.svg.png)

  7. 池塘

     ![img](screenshot\180px-Game_of_life_6x6_pond.svg.png)

  8. 蛇

     ![img](screenshot\Conways_game_of_life_snake.png)

  9. 航空母舰

     ![img](screenshot\Conways_game_of_life_aircraft_carrier.png)

  10. 独木舟

      ![img](screenshot\Conways_game_of_life_canoe.png)

  11. 芒果

      ![img](screenshot\Conways_game_of_life_mango.png)

  12. 鸭子

      ![img](screenshot\Conways_game_of_life_duck.png)

- 震荡状态

  1. 信号灯（周期=2轮）

     ![img](screenshot\Game_of_life_blinker.gif)

  2. 蟾蜍（周期=2轮）

     ![img](screenshot\Game_of_life_toad.gif)

  3. 红绿灯（周期=2轮）

     ![img](screenshot\180px-TrafficLight.gif)

  4. 烽火（周期=2轮）

     ![img](screenshot\Game_of_life_beacon.gif)

  5. 脉冲星（周期=3轮）

     ![img](screenshot\Game_of_life_pulsar.gif)

  6. 慨影（周期=15轮）

     ![img](screenshot\I-Column.gif)

- 会移动的震荡状态

  1. 滑翔机（4轮）

     ![img](screenshot\Game_of_life_animated_glider.gif)

  2. 太空船（4轮）

     ![img](screenshot\Game_of_life_animated_LWSS.gif)

- 持续繁殖模式

  1. 高斯帕滑翔机

     ![img](screenshot\Gospers_glider_gun.gif)

  2. 播种机

     ![img](screenshot\Conways_game_of_life_breeder_animation.gif)

  3. 



## 拓展

### 兰顿蚂蚁

**兰顿蚂蚁**（英语：Langton's ant）是[细胞自动机](https://zh.wikipedia.org/wiki/細胞自動機)的例子。它由[克里斯托夫·兰顿](https://zh.wikipedia.org/w/index.php?title=克里斯托夫·兰顿&action=edit&redlink=1)在1986年提出，它由黑白格子和一只“蚂蚁”构成[[1\]](https://zh.wikipedia.org/wiki/兰顿蚂蚁#cite_note-1)，是一个二维[图灵机](https://zh.wikipedia.org/wiki/图灵机)。兰顿蚂蚁拥有非常简单的逻辑和复杂的表现。在2000年兰顿蚂蚁的[图灵完备性](https://zh.wikipedia.org/wiki/圖靈完備性)被证明。兰顿蚂蚁的想法后来被推广，比如使用多种颜色。



![11000步后的图像](screenshot\LangtonsAnt.png)

### 规则

在平面上的正方形格被填上黑色或白色。在其中一格正方形有一只“蚂蚁”。它的头部朝向上下左右其中一方。

- 若蚂蚁在白格，右转90度，将该格改为黑格，向前移一步；
- 若蚂蚁在黑格，左转90度，将该格改为白格，向前移一步。



### 行为模式

若从全白的背景开始，在一开始的数百步，蚂蚁留下的路线会出现许多对称或重复的形状，然后会出现类似混沌的假随机，至约一万步后会出现以104步为周期无限重复的“高速公路”朝固定方向移动[[2\]](https://zh.wikipedia.org/wiki/兰顿蚂蚁#cite_note-2)。在目前试过的所有起始状态，蚂蚁的路线最终都会变成高速公路，但尚无法证明这是无论任何起始状态都会导致的必然结果。

![img](screenshot\LangtonsAntAnimated.gif)



# 程序截图

![img](screenshot/mainpage.png)

![img](screenshot/高斯帕滑翔机.gif)
