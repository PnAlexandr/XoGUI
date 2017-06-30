package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Pavlovan on 19.05.2017.
 */
public class Map extends JPanel {
    static final int GAME_MODE_HVA=0;
    static final int GAME_MODE_HVH=1;

    int [][] filed;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;
    private int cellWidth;
    private int celHeig;
    private boolean initialized;
    private boolean gameOver;


    Map(){
        setBackground(Color.GRAY);
    }
    void  startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        filed = new int[fieldSizeX][fieldSizeY];
        initialized = true;
        gameOver = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
               // update(e);
                repaint();
            }
        });
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
       render(g);
    }
    private void render(Graphics g){
        if(!initialized) return;
        int panelWidth = getWidth();
        int panelHeight=getHeight();
        cellWidth=panelWidth/fieldSizeX;
        celHeig=panelHeight/fieldSizeY;
        g.setColor(Color.BLACK);
        for (int i = 0; i <=fieldSizeY ; i++) {
            int y = i*celHeig;
            g.drawLine(0,y,panelWidth,y);
            
        }
        
       // System.out.println("Ширина"+panelWidth+"Длина"+panelHeight);

    }
}
