package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GUI {

    JFrame window;
    JComponent gameWindow;
    JComponent buttonField;
    JComponent textField;

//kek
    public GUI(int gridSizeX, int gridSizeY){
        window = new JFrame("Game");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(3);

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

    private JPanel createGameField(int gameX, int gameY){
        JPanel gameGrid = new JPanel(new GridLayout(gameX,gameY));


        return new JPanel();
    }

    public abstract void upButtonPressed();
    public abstract void downButtonPressed();
    public abstract void leftButtonPressed();
    public abstract void rightButtonPressed();
    public abstract void useButtonPressed();

}
