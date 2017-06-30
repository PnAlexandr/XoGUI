package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    private StartNewGameWindow startNewGameWindow;
    private Map map;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("TicTacToe");
        setResizable(false);
        JButton btnGameNew = new JButton("New Game");
        btnGameNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        JButton btnGameExit = new JButton("Exit Game");
        btnGameExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        map = new Map();

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnGameNew);
        panelBottom.add(btnGameExit);
        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        startNewGameWindow = new StartNewGameWindow(this);
        setVisible(true);
    }

    void startNewGame(int mode, int sizeFieldX, int sizeFieldY, int winLength) {
        map.startNewGame(mode,sizeFieldX,sizeFieldY,winLength);
    }
}
