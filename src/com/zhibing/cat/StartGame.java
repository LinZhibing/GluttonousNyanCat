package com.zhibing.cat;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GluttonousCat");
        frame.setBounds(10, 10, 900, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        frame.add(new GamePanel());



    }
}
