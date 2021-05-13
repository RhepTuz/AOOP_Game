package Base;

import Sokoban.Levels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GUI {

    private JFrame window;
    private JComponent gameWindow;
    private JComponent buttonField;
    private JComponent textField;

//kek
    public GUI(int gridSizeX, int gridSizeY) throws IOException {
        window = new JFrame("Game");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(3);
        window.setResizable(false);

        gameWindow = createGameField(gridSizeX,gridSizeY);

        buttonField = createButtonField();

        window.add(BorderLayout.SOUTH,buttonField);
        window.add(BorderLayout.CENTER,gameWindow);


        window.pack();
        window.setVisible(true);

    }

    private JPanel createButtonField(){
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton useButton = new JButton("Use");

        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 1;
        con.gridy = 0;
        buttons.add(upButton,con);

        con.gridx = 0;
        con.gridy = 1;
        buttons.add(leftButton,con);

        con.gridx = 1;
        con.gridy = 1;
        buttons.add(useButton,con);

        con.gridx = 2;
        con.gridy = 1;
        buttons.add(rightButton,con);

        con.gridx = 1;
        con.gridy = 2;
        buttons.add(downButton,con);


        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upButtonPressed();
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightButtonPressed();
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downButtonPressed();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftButtonPressed();
            }
        });

        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useButtonPressed();
            }
        });

        return buttons;

    }

    public void changeScreen(JLabel[][] level){
        gameWindow.removeAll();

        for(int i = 0; i < level.length; i++){
            for(int j = 0; j < level[0].length; j++){

                gameWindow.add(level[i][j]);

            }
        }
        window.pack();

    }

    private JPanel createGameField(int gameX, int gameY) throws IOException {
        JPanel gameGrid = new JPanel(new GridLayout(gameX,gameY));
        return gameGrid;
    }

    public JComponent getComponent(int index){
        return (JComponent) gameWindow.getComponent(index);
    }


    public abstract void upButtonPressed();
    public abstract void downButtonPressed();
    public abstract void leftButtonPressed();
    public abstract void rightButtonPressed();
    public abstract void useButtonPressed();

}
