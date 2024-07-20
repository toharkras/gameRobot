import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;


import static java.lang.Thread.sleep;

public class ScenePanel extends JPanel {
    public static final int MAX_ENEMIES = 3;
    private Robot robot;
    private ArrayList<Robot> enemies;


    public ScenePanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.robot = new Robot(300, 300);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyBoardListener(this, this.robot));
        mainGameLoop();
        Random random = new Random();
        this.enemies = new ArrayList<>();
        for (int i = 0; i < MAX_ENEMIES; i++) {
            this.enemies.add(new Robot(
                    random.nextInt(0, width),
                    random.nextInt(0, height), 20));

        }

    }

    public void mainGameLoop() {
        Random random = new Random();
        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    if (count % 100 == 0) {
                        for (Robot enemy : this.enemies) {
                            enemy.setDirection(0);
                        }
                    }
                    for (Robot enemy : this.enemies) {
                        if (enemy.getDirection() == 0) {
                            enemy.setDirection(random.nextInt(1, 5));
                        }
                        int direction = enemy.getDirection();
                        switch (direction) {
                            case 1:
                                enemy.moveRight();
                                break;
                            case 2:
                                enemy.moveLeft();
                                break;
                            case 3:
                                enemy.moveUp();
                                break;
                            case 4:
                                enemy.moveDown();

                        }
                        if (collision(this.robot.getRobotAsREctangle(), enemy.getRobotAsREctangle())){
                            this.robot.kill();
                        }
                    }
                    sleep(10);
                    repaint();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.robot.paint(graphics);
        for (Robot enemy : this.enemies) {
            enemy.paint(graphics);
        }
    }

    public boolean collision (Rectangle robot, Rectangle enemy){
        return robot.intersects(enemy);
    }


}
