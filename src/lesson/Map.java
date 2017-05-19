package lesson;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pavlovan on 19.05.2017.
 */
public class Map extends JPanel {
    Map(){
        setBackground(Color.BLACK);
    }
    void startNewGame(int mode,int sizeFieldX,int sizeFieldY,int winLength){
        System.out.println("mode= "+ mode);
        System.out.println("sizeX="+ sizeFieldX);
        System.out.println("win_len="+winLength);
    }
}
