package lesson;

import javax.swing.*;  // Среда подтянула библиотеку
import java.awt.*;

class GameWindow extends JFrame {  // Унаследывали JFrame
   private static final int WINDOW_WIDTH =507; //  Высота окна
   private static final int WINDOW_HEIGHT =557; // Ширина окна
   private static final int WINDOW_POS_X =507;
   private static final int WINDOW_POS_Y =507;

   private  StartNewGameWindow stertNewGemrWindow;
   private  Map map;


   // Константы БОЛЬШИМИ БУКВАМИ
   GameWindow(){                    // Обевили констркутор пустой
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //  Действие при  нажатий на крестик
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT); // Размеры окна
        setLocation(WINDOW_POS_X,WINDOW_POS_Y); // Положение Окна
        setTitle("TicTacToe"); //Титилы
       setResizable(false); //Запрет полного Экрана
       JButton btnGameNew=new JButton("New Game"); //Венгерская Нотация
       JButton btnGameExit=new JButton("Exit Game"); //

       map = new Map();

       JPanel panelBottom =new JPanel(); //  Конструктор  JPanel
       panelBottom.setLayout(new GridLayout(1, 2));//  Создаем панель из 1 строкии 2 кнопок
       panelBottom.add(btnGameNew);
       panelBottom.add(btnGameExit);// Кнопки
       add(map,BorderLayout.CENTER);
       add(panelBottom,BorderLayout.SOUTH);













        stertNewGemrWindow =new StartNewGameWindow(this); // Сложно

        setVisible(true); // Вы помните
   }
}
