/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangkali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Sidra Aziz 14809
 */
public class page2 extends JFrame {//implements ActionListener{

    JLabel choose;
    JButton Easy, Hard;
    HangKali hm;

    public page2() {

        setSize(1450, 1080);
        setTitle("HangKali Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setBackground(new Color(172, 225, 175));
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 0, 0, 0);

        java.net.URL choose_URL = getClass().getResource("/2.png");
        choose = new JLabel(new ImageIcon(choose_URL));
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(choose, gbc);

        JPanel jp = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        pane.add(jp, gbc);
        Easy = new JButton("<HTML><FONT SIZE=+5><FONT COLOR = rgb(172,225,175)><B>Easy</B>");
        Easy.setBackground(Color.BLACK);
        Hard = new JButton("<HTML><FONT SIZE=+5><FONT COLOR = rgb(172,225,175)><B>Hard</B>");
        Hard.setBackground(Color.BLACK);
        jp.setBackground(new Color(172, 225, 175));
        jp.add(Easy);
        jp.add(Hard);

        Easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hm = new HangKali("Easy");
                dispose();
            }
        });

        Hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hm = new HangKali("Hard");
                dispose();
            }
        });

        setVisible(true);

    }

    /*public static void main(String[] args) {
        page2 pp = new page2();
    }*/
}
