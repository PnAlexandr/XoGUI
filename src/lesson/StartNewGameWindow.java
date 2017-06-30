package lesson;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class StartNewGameWindow extends JFrame{
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideFieldSize;
    private JSlider slideWinLength;


    StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameControlsMode();
        addGameControlField();

        JButton btnStartGame = new JButton("New Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame_OnClick();
            }
        });
        add(btnStartGame);

    }
    private void addGameControlsMode() {
        add(new JLabel("Choose gaming mode"));
        humVSAI = new JRadioButton("Human VS AI");
        humVShum = new JRadioButton("Human VS Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        humVSAI.setSelected(true);
        add(humVSAI);
        add(humVShum);
    }

    private void addGameControlField() {
        final String WIN_LEN_PREFIX = "Winning length is: ";
        JLabel lbWinLength = new JLabel(WIN_LEN_PREFIX + MIN_WIN_LENGTH);

        slideWinLength = new JSlider(MIN_WIN_LENGTH, MAX_FIELD_SIZE, MIN_WIN_LENGTH);
        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LEN_PREFIX + slideWinLength.getValue());
            }
        });

        final String FIELD_SIZE_PREFIX = "Field Size is: ";
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose winning length"));
        add(lbWinLength);
        add(slideWinLength);
    }

    private void btnStartGame_OnClick(){
        int gameMode;
        if(humVSAI.isSelected())
            gameMode = Map.GAME_MODE_HVA;
        else if (humVShum.isSelected())
            gameMode = Map.GAME_MODE_HVH;
        else
            throw new RuntimeException("No button selected");

        int sizeFieldX = slideFieldSize.getValue();
        int winLen = slideWinLength.getValue();
        gameWindow.startNewGame(gameMode,sizeFieldX,sizeFieldX,winLen);
        setVisible(false);
    }
}
