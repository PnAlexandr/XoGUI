package lesson;

import javax.swing.*;  // Среда подтянула библиотеку

 class GameWindow extends JFrame {  // Унаследывали JFrame
   private static final int WINDOW_WIDTH =507; //  Высота окна
   private static final int WINDOW_HEIGHT =557; // Ширина окна
   private static final int WINDOW_POS_X =507;
   private static final int WINDOW_POS_Y =507;
   // Константы БОЛЬШИМИ БУКВАМИ
   GameWindow(){                    // Обевили констркутор пустой
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //  Действие при  нажатий на крестик
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT); // Размеры окна
        setLocation(WINDOW_POS_X,WINDOW_POS_Y); // Положение Окна
        setVisible(true); // Вы помните
   }
}
