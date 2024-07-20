import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {
    private ScenePanel scenePanel;
    private Robot robot;
    public KeyBoardListener (ScenePanel scenePanel, Robot robot){
        this.scenePanel= scenePanel;
        this.robot= robot;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getExtendedKeyCode()){
            case KeyEvent.VK_LEFT -> this.robot.moveLeft();
            case KeyEvent.VK_RIGHT -> this.robot.moveRight();
            case KeyEvent.VK_UP-> this.robot.moveUp();
            case KeyEvent.VK_DOWN -> this.robot.moveDown();

        }
        this.scenePanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
