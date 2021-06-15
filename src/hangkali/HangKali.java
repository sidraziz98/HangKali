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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangKali extends JFrame { //implements ActionListener{

    /**
     * @param args the command line arguments
     */
    JLabel lizard;
    JButton[] letters;
    JPanel letPanel,panel;
    JLabel label,lComment,lWrong;
    JLabel chance1,chance2,chance3,chance4,chance5;
    MainGame mg;

    public HangKali(String level) {

        setSize(1450, 1080);
        setTitle("HangKali Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setBackground(new Color(172, 225, 175));
        pane.setLayout(new GridBagLayout());
        
        //game play
        mg = new MainGame(level);
        
        //add comments
        lComment = new JLabel("<HTML><FONT SIZE=+2><B>Let's Get It!!</B>");
        
        GridBagConstraints gbcComment = new GridBagConstraints();//position
        gbcComment.gridx = 0;
        gbcComment.gridy = 0;
        gbcComment.anchor = GridBagConstraints.NORTHWEST;
        gbcComment.insets = new Insets(320, 230, 0, 0);
        pane.add(lComment, gbcComment);

        //add LIZARD
        java.net.URL lizard_URL = getClass().getResource("/animations.gif");
        ImageIcon imgIcon1 = new ImageIcon(lizard_URL);
        ImageIcon imgIcon2 = new ImageIcon(imgIcon1.getImage().getScaledInstance(400,290, java.awt.Image.SCALE_DEFAULT));
        lizard = new JLabel(imgIcon2);
        
        GridBagConstraints gbcLiz = new GridBagConstraints();//position
        gbcLiz.insets = new Insets(120, 70, 0, 0);
        gbcLiz.gridx = 0;
        gbcLiz.gridy = 0;
        gbcLiz.anchor = GridBagConstraints.NORTHWEST;
        gbcLiz.weightx = 0.5;
        gbcLiz.weighty = 1.0;
        pane.add(lizard, gbcLiz);

        // add Chances Images(X) to Panel
        java.net.URL x_URL = getClass().getResource("/3.png");
        ImageIcon imgIcon3 = new ImageIcon(x_URL);
        ImageIcon imgIcon4 = new ImageIcon(imgIcon3.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT));
        chance1 = new JLabel(imgIcon4);
        chance2 = new JLabel(imgIcon4);
        chance3 = new JLabel(imgIcon4);
        chance4 = new JLabel(imgIcon4);
        chance5 = new JLabel(imgIcon4);

        JPanel chance = new JPanel(new GridBagLayout());
        chance.setBackground(new Color(172, 225, 175));
        
        GridBagConstraints gbcChance = new GridBagConstraints();//position
        gbcChance.gridx = 0;
        gbcChance.gridy = 0;
        chance.add(chance1, gbcChance);
        gbcChance.gridx = 1;
        gbcChance.gridy = 0;
        chance.add(chance2, gbcChance);
        gbcChance.gridx = 2;
        gbcChance.gridy = 0;
        chance.add(chance3, gbcChance);
        gbcChance.gridx = 3;
        gbcChance.gridy = 0;
        chance.add(chance4, gbcChance);
        gbcChance.gridx = 4;
        gbcChance.gridy = 0;
        chance.add(chance5, gbcChance);

        //add CHANCES Panel
        GridBagConstraints gbcCH = new GridBagConstraints();//position
        gbcCH.gridx = 0;
        gbcCH.gridy = 0;
        gbcCH.insets = new Insets(0, 150, 100, 0);
        gbcCH.anchor = GridBagConstraints.SOUTHWEST;
        pane.add(chance, gbcCH);

        //add Keyboard to Panel
        letPanel = new JPanel();
        letPanel.setLayout(new GridBagLayout());
        letPanel.setBackground(new Color(172, 225, 175));

        java.net.URL keyBG_URL = getClass().getResource("/5.jpg");
        ImageIcon imgIcon7 = new ImageIcon(keyBG_URL);
        ImageIcon imgIcon8 = new ImageIcon(imgIcon7.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_DEFAULT));
        letters = new JButton[26];
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++, i++) {
            letters[i] = new JButton("<HTML><FONT SIZE=+5><FONT COLOR = WHITE><B>" + c + "</B>",imgIcon8);
            letters[i].setHorizontalTextPosition(JButton.CENTER);
            letters[i].setContentAreaFilled(false);
            letters[i].setMargin( new Insets(0,0,0,0) );
        }
        
        GridBagConstraints gbcLet = new GridBagConstraints();//position
        for (int j = 0; j < 10; j++) {
            gbcLet.gridx = j;
            gbcLet.gridy = 0;
            letPanel.add(letters[j], gbcLet);
        }

        for (int j = 1; j < 9; j++) {
            gbcLet.gridx = j;
            gbcLet.gridy = 1;
            letPanel.add(letters[j + 9], gbcLet);
        }

        for (int j = 1; j < 9; j++) {
            gbcLet.gridx = j;
            gbcLet.gridy = 2;
            letPanel.add(letters[j + 17], gbcLet);
        }
        
        //add KEYBOARD Panel
        GridBagConstraints gbcKB = new GridBagConstraints();

        gbcKB.gridx = 0;
        gbcKB.gridy = 0;
        gbcKB.insets = new Insets(0, 0, 110, 100);
        gbcKB.anchor = GridBagConstraints.SOUTHEAST;
        pane.add(letPanel, gbcKB);

        //add Word to Panel
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,70));
        panel.setBackground(new Color(172, 225, 175));
        label = new JLabel("<HTML><FONT SIZE=+15><B>"+mg.printDashes()+"</B>",SwingConstants.CENTER);
        label.setSize(100, 40);
        
        //add WORD Panel
        GridBagConstraints gbcJL = new GridBagConstraints();//position
        gbcJL.gridx = 0;
        gbcJL.gridy = 0;
        gbcJL.anchor = GridBagConstraints.EAST;
        gbcJL.insets = new Insets(0, 0, 150, 110);
        panel.add(label);
        pane.add(panel, gbcJL);
        
        //add wrong characters
        lWrong = new JLabel();
        lWrong.setSize(100, 40);
        
        GridBagConstraints gbcWrong = new GridBagConstraints();//position
        gbcWrong.gridx = 0;
        gbcWrong.gridy = 0;
        gbcWrong.anchor = GridBagConstraints.SOUTHWEST;
        gbcWrong.insets = new Insets(0, 200, 250, 0);
        pane.add(lWrong, gbcWrong);
        
        //add actionListener
        for (JButton button : letters) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Object src = evt.getSource();
                    if (src instanceof JButton) {
                        String enteredLetter = ((JButton) src).getText().charAt(43) + "";
                        mg.checkLetter(enteredLetter);
                        label.setText("<HTML><FONT SIZE=+15><B>" + mg.printDashes() + "</B>");
                        lWrong.setText("<HTML><FONT SIZE=+15><FONT COLOR = RED><B>" + mg.getWrongChar() + "</B>");
                        if(!mg.checkLose()){
                            if (mg.checkWin()) {
                                lComment.setText("<HTML><FONT SIZE=+2><B>You Won!!</B>");
                                playAgain(true);
                            }
                        }
                        else{
                            lComment.setText("<HTML><FONT SIZE=+2><B>You Lost:(</B>");
                            playAgain(false);
                        }
                        reduceChances();
                    }
                }
            });
        }

        setVisible(true);

    }
    
    //play again dialog box
    public void playAgain(boolean win) {
        JDialog frame = new JDialog(HangKali.this, "Play", true);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        Container pane1 = frame.getContentPane();
        pane1.setBackground(new Color(172, 220, 175));
        pane1.setLayout(new GridLayout(4, 1));

        JLabel ShowWord = new JLabel("<HTML><FONT SIZE=+1><B>Word: "+mg.getWord()+"</B>", SwingConstants.CENTER);
        ShowWord.setVerticalAlignment(SwingConstants.BOTTOM);
        JLabel ShowMeaning = new JLabel("<HTML><FONT SIZE=+1><B>Meaning: "+mg.getWordMeaning()+"</B>", SwingConstants.CENTER);
        ShowMeaning.setVerticalAlignment(SwingConstants.TOP);
        JLabel win_lose = new JLabel("", SwingConstants.CENTER);
        win_lose.setVerticalAlignment(SwingConstants.TOP);
        if (win) {
            win_lose.setText("<HTML><FONT SIZE=+2><B>You Won!! Do you want to play again?</B>");
        } else {
            win_lose.setText("<HTML><FONT SIZE=+2><B>You Lost:( Do you want to play again?</B>");
        }
        JButton y = new JButton("YES");
        JButton n = new JButton("NO");
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(172, 225, 175));
        buttons.add(y);
        buttons.add(n);

        pane1.add(ShowWord);
        pane1.add(ShowMeaning);
        pane1.add(win_lose);
        pane1.add(buttons);
        
        y.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Object src = evt.getSource();
                    if (src instanceof JButton) {
                        page2 p2 = new page2();
                        dispose();
                    }
            }
        });
        n.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Object src = evt.getSource();
                    if (src instanceof JButton) {
                        win_lose.setText("<HTML><FONT SIZE=+5><B>GAME OVER!!!</B>");
                        buttons.setVisible(false);
                        ShowWord.setVisible(false);
                        ShowMeaning.setVisible(false);
                    }
            }
        });
        
        frame.setVisible(true);
    }

    public void reduceChances() {
        //Chances images(dull X)
        java.net.URL x_URL = getClass().getResource("/4.png");
        ImageIcon imgIcon5 = new ImageIcon(x_URL);
        ImageIcon imgIcon6 = new ImageIcon(imgIcon5.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT));
        switch (mg.getChances()) {
            case 4:
                chance1.setIcon(imgIcon6);
                break;
            case 3:
                chance2.setIcon(imgIcon6);
                break;
            case 2:
                chance3.setIcon(imgIcon6);
                break;
            case 1:
                chance4.setIcon(imgIcon6);
                break;
            case 0:
                chance5.setIcon(imgIcon6);
                break;
        }
    }
    
    /*public static void main(String[] args){
        HangKali hm = new HangKali("Easy");
    }*/
    
}