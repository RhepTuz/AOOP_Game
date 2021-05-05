package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    JFrame window;
    JComponent gameWindow;
    JComponent buttonField;
    JComponent textField;


    public GUI(){
        window = new JFrame("Game");
        window.setLayout(new BorderLayout());

        gameWindow = new JPanel();
        gameWindow.setLayout(new GridBagLayout());

        buttonField = createButtonField();
        buttonField.setLayout(new GridBagLayout());

        textField = new JTextArea(5,10);

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

    private void upButtonPressed(){

    }
    private void downButtonPressed(){

    }
    private void leftButtonPressed(){

    }
    private void rightButtonPressed(){

    }
    private void useButtonPressed(){

    }

}
