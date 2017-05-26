package lesson;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class StartNewGameWindow extends JFrame {
     private static final int WINDOW_WIDTH =350; //  Высота окна
     private static final int WINDOW_HEIGHT =230; // Ширина окна
     private static final int MIN_WIN_LENGTH =3;
     private static final int MIN_FIELD_SIZE =3;
     private static final int MAX_FIELD_SIZE =507;
     //private static final int WINDOW_POS_Y =507;

     GameWindow gameWindow;
     JRadioButton humVSAI;
     JRadioButton humVShum;
     JSlider sliderFiledSize;
     JSlider sliderWinLength;


     StartNewGameWindow(GameWindow gameWindow){
         this.gameWindow=gameWindow;
         setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
         Rectangle gameWindowBounds =gameWindow.getBounds();// примаугольник  игры
         int pos_x = (int) gameWindowBounds.getCenterX()-WINDOW_WIDTH / 2;
         int pos_y = (int) gameWindowBounds.getCenterX()-WINDOW_HEIGHT / 2;//положение
         setLocation(pos_x,pos_y);
         setResizable(false);
         setTitle("Создание игры");
         setLayout(new GridLayout(10,1));
         addGameControlsMode();
         addGameControlField();

     }
     void  addGameControlsMode(){
         add(new JLabel("Choose gaming mode"));// Надпись  в окошке
         humVSAI=new JRadioButton("Human VS AI");//  Добовляем кнопки выбора
         humVShum =new JRadioButton("Humn VS Human");
         add(humVSAI);
         add(humVShum);//Добовляем кнопки выбора
         ButtonGroup gameMode = new ButtonGroup();
         gameMode.add(humVSAI);
         gameMode.add(humVShum);
         humVSAI.setSelected(true);
         add(humVShum);
         add(humVShum);//переключатель




     }
     void addGameControlField(){ //слайдеры
         final String WIN_LEN_PREFIX="Winning length is";
         JLabel lbWinLength =new JLabel(WIN_LEN_PREFIX+MIN_WIN_LENGTH);// Значения выигрыша
         add(lbWinLength);
         sliderWinLength=new JSlider(MIN_WIN_LENGTH,MIN_FIELD_SIZE,MIN_WIN_LENGTH);
         sliderWinLength.addChangeListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 lbWinLength.setText(WIN_LEN_PREFIX+sliderWinLength.getValue());//показания сладера

             }
         });
         add(sliderWinLength);
         final String FILED_SIZE_PREFIX="Winning length is";
         JLabel lbFieldSize =new JLabel(FILED_SIZE_PREFIX+MIN_WIN_LENGTH);// Значения выигрыша
         add(lbWinLength);
         sliderFiledSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
         sliderFiledSize.addChangeListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 int currentVale=sliderFiledSize.getValue();
                 lbFieldSize.setText(FILED_SIZE_PREFIX+currentVale);
                 sliderWinLength.setMaximum(currentVale);
             }
         });
         add(sliderFiledSize);
     }
}
