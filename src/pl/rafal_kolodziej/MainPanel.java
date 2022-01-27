package pl.rafal_kolodziej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {

    private final Train train = new Train();
    private Apple apple = new Apple();
    private boolean gameOver = false;


    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        MainTimer timer = new MainTimer();
        timer.start();

        MainFrame.score.setText("WAGONY:" + train.getSize());


        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }




    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        train.draw(g);
        apple.draw(g);
    }

    private class MainTimer extends Timer {
        public static final int DELAY = 100;

        public MainTimer() {
            super(DELAY, e -> {
                if (!gameOver) {
                    train.move();


                    if (train.eatApple(apple)) {
                        apple = new Apple();

                    }
                    if (train.isCollision()) {
                        gameOver = true;
                        MainFrame.score.setText("GAME OVER - PRZYPIĘTE WAGONY:" + train.getSize());
                    }

                    repaint();
                }
            });
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (train.getDirection() != Direction.R) {
                        train.setDirection(Direction.L);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (train.getDirection() != Direction.L) {
                        train.setDirection(Direction.R);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (train.getDirection() != Direction.U) {
                        train.setDirection(Direction.D);
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (train.getDirection() != Direction.D) {
                        train.setDirection(Direction.U);
                    }
                    break;
            }
        }
    }
}


