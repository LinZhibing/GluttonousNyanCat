package com.zhibing.cat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length;
    int[] catX = new int[500];
    int[] catY = new int[500];
    String dir;
    Timer timer = new Timer(100, this);
    boolean isStart = false;

    int pizzaX;
    int pizzaY;
    int[] foodXs = new int[5];
    int[] foodYs = new int[5];

    Random random = new Random();
    boolean isFail = false;
    int score;
    int topScore;
    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    public void init(){
        length = 3;
        catX[0] = 100; catY[0] = 100;
        catX[1] = 75; catY[1] = 100;
        catX[2] = 50; catY[2] = 100;
        dir = "R";
        pizzaX = 25 + 25 * random.nextInt(34);
        pizzaY = 75 + 25 * random.nextInt(21);
        score = 0;
        topScore = 0;

        for (int i = 0; i < 5; i++) {
            foodXs[i] = 25 + 25 * random.nextInt(34);
            foodYs[i] = 75 + 25 * random.nextInt(21);
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        //Data.header.paintIcon(this, g, 25, 11);
        g.fillRect(25, 55, 850, 550);
        if (dir.equals("R")) {
            Data.right.paintIcon(this, g, catX[0], catY[0]);

        } else if (dir.equals("L")) {
            Data.left.paintIcon(this, g, catX[0], catY[0]);
        } else if (dir.equals("U")) {
            Data.up.paintIcon(this, g, catX[0], catY[0]);
        } else {
            Data.down.paintIcon(this, g, catX[0], catY[0]);
        }


//        for (int i = 1; i < length; i++) {
//            Data.body.paintIcon(this, g, catX[i], catY[i]);
//        }
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial Black", Font.PLAIN, 18));
        g.drawString("Score: " + score, 650, 50);
        g.drawString("Highest Score: " + topScore, 650, 35);

        Data.pizza.paintIcon(this, g, pizzaX, pizzaY);

        for (int i = 0; i < 5; i++) {
            Data.food.paintIcon(this, g, foodXs[i], foodYs[i]);
        }
        if (!isStart) {
            g.setColor(Color.CYAN);
            //g.setFont(new Font());
            g.setFont(new Font("Arial Black", Font.PLAIN, 30));
            g.drawString("Press space to start", 300, 300);
        }


        for (int i = 1; i < length; i++) {

            if (catY[i] != catY[i - 1]) {
                Data.bodyUp.paintIcon(this, g, catX[i], catY[i]);
//            } else if (dir.equals("R") && catY[i] < catY[i - 1]) {
//                Data.bodyDown.paintIcon(this, g, catX[i], catY[i]);
//            } else if (dir.equals("L") && catY[i] > catY[i - 1]) {
//                Data.bodyDown.paintIcon(this, g, catX[i], catY[i]);
//            } else if (dir.equals("L") && catY[i] < catY[i - 1]) {
//                Data.bodyUp.paintIcon(this, g, catX[i], catY[i]);
//            } else if (dir.equals("D") && catY[i] < catY[i - 1]) {
//                Data.bodyDown.paintIcon(this, g, catX[i], catY[i]);
//            } else if (dir.equals("U") && catY[i] > catY[i - 1]) {
//                Data.bodyUp.paintIcon(this, g, catX[i], catY[i]);
            } else {
                Data.body.paintIcon(this, g, catX[i], catY[i]);
            }
        }

        if (isFail) {
            g.setColor(Color.PINK);
            //g.setFont(new Font());
            g.setFont(new Font("Arial Black", Font.PLAIN, 30));
            g.drawString("YOU DIED", 360, 300);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE){
            if (isFail) {
                isFail = false;
                int temp = score;
                if (score < topScore) {
                    temp = topScore;
                }
                init();
                topScore = temp;

            } else {
                isStart = !isStart;
            }



        }
        if (keyCode == KeyEvent.VK_LEFT && !dir.equals("R")) {
            dir = "L";
        } else if (keyCode == KeyEvent.VK_UP && !dir.equals("D")) {
            dir = "U";
        } else if (keyCode == KeyEvent.VK_DOWN && !dir.equals("U")) {
            dir = "D";
        } else if (keyCode == KeyEvent.VK_RIGHT && !dir.equals("L")) {
            dir = "R";
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && !isFail) {

            for (int i = length - 1; i > 0; i--) {
                catX[i] = catX[i - 1];
                catY[i] = catY[i - 1];
            }

            if (dir.equals("R")) {
                catX[0] += 25;
                if (catX[0] > 850) {
                    catX[0] = 25;
                }
            } else if (dir.equals("L")) {
                catX[0] -= 25;
                if (catX[0] < 25) {
                    catX[0] = 850;
                }
            } else if (dir.equals("U")) {
                catY[0] -= 25;
                if (catY[0] < 50) {
                    catY[0] = 575;
                }
            } else if (dir.equals("D")) {
                catY[0] += 25;
                if (catY[0] > 590) {
                    catY[0] = 50;
                }
            }

            for (int i = 0; i < 5; i++) {
                if (catX[0] == foodXs[i] && catY[0] == foodYs[i]) {
                    length++;
                    score += 50;
                    foodXs[i] = 25 + 25 * random.nextInt(34);
                    foodYs[i] = 75 + 25 * random.nextInt(21);

                }
            }
            if (catX[0] == pizzaX && catY[0] == pizzaY) {
                length++;
                score += 100;
                pizzaX = 25 + 25 * random.nextInt(34);
                pizzaY = 75 + 25 * random.nextInt(21);

            }

            for (int i = 1; i < length; i++) {
                if (catX[0] == catX[i] && catY[0] == catY[i]) {
                    isFail = true;
                }
            }

            repaint();

        }
        timer.start();
    }
}
