import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;

public class Window extends JFrame{
    public static final int WIDTH=800;
    public static final int HEIGHT=800;

    public static void main(String[] args) {
       new Window();
    }

    public Window(){
        MenuPanel menuPanel= new MenuPanel(0,0,WIDTH/4, HEIGHT);
        this.add(menuPanel);
        ScenePanel scenePanel= new ScenePanel(WIDTH/4, 0, WIDTH*3/4, HEIGHT);
        this.add(scenePanel);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void sleep(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public boolean collision(Rectangle robot, Rectangle enemy){
        return robot.intersects(enemy);

    }


}
