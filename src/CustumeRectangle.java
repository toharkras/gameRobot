import java.awt.*;

public class CustumeRectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public CustumeRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics graphics){
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

    public void moveRight(){
        this.x++;

    }
    public void moveLeft(){
        this.x--;
    }

    public void moveUp(){
        this.y++;
    }

    public void moveDown(){
        this.y--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
