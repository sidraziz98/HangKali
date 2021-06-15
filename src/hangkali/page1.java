/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangkali;

/**
 *
 * @author Sidra Aziz 14809
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class page1 extends JFrame {

    JLabel intro;
    JButton PlayGame;
    page2 p2;

    public page1() {

        setSize(1450, 1080);
        setTitle("HangKali Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setBackground(new Color(172, 225, 175));
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 0, 0, 0);

        java.net.URL intro_URL = getClass().getResource("/1.png");
        intro = new JLabel(new ImageIcon(intro_URL));
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(intro, gbc);

        PlayGame = new JButton("<HTML><FONT SIZE=+5><FONT COLOR = rgb(172,225,175)><B>PLAY GAME</B>");
        PlayGame.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pane.add(PlayGame, gbc);

        PlayGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object src = evt.getSource();
                p2 = new page2();
                dispose();
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        page1 pp = new page1();
    }
}
