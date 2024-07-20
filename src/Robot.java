import java.awt.*;

public class Robot {
    private CustumeRectangle head;
    private CustumeRectangle body;
    private CustumeRectangle leftFoot;
    private CustumeRectangle rightFoot;
    private int headSize;
    private boolean enemy= false;
    public static final int DEFAULT_HEAD_SIZE=50;
    private int direction;
    private boolean alive;


    public Robot (int x, int y, int headSize){
        this.headSize= headSize;
        this.head=  new CustumeRectangle(x,y,headSize, headSize);
        this.body= new CustumeRectangle(x-headSize/2, y+headSize, headSize*2, headSize*2);
        this.enemy= true;
        this.alive= true;

    }

    public Robot(int x, int y){
        this(x,y,DEFAULT_HEAD_SIZE);
        this.enemy= false;

    }
    public void paint(Graphics graphics){
        graphics.setColor(this.enemy? Color.RED: Color.GREEN);
     this.head.paint(graphics);
      this.body.paint(graphics);
    }

    public void moveRight(){
     this.head.moveRight();
     this.body.moveRight();
    }

    public void moveLeft(){
        this.head.moveLeft();
        this.body.moveLeft();
    }

    public void moveUp(){
        this.head.moveUp();
        this.body.moveUp();
    }
    public void moveDown(){
        this.head.moveDown();
        this.body.moveDown();
    }

    public CustumeRectangle getHead() {
        return head;
    }

    public void setHead(CustumeRectangle head) {
        this.head = head;
    }

    public CustumeRectangle getBody() {
        return body;
    }

    public void setBody(CustumeRectangle body) {
        this.body = body;
    }

    public CustumeRectangle getLeftFoot() {
        return leftFoot;
    }

    public void setLeftFoot(CustumeRectangle leftFoot) {
        this.leftFoot = leftFoot;
    }

    public CustumeRectangle getRightFoot() {
        return rightFoot;
    }

    public void setRightFoot(CustumeRectangle rightFoot) {
        this.rightFoot = rightFoot;
    }

    public int getHeadSize() {
        return headSize;
    }

    public void setHeadSize(int headSize) {
        this.headSize = headSize;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Rectangle getRobotAsREctangle(){

        Rectangle rectangle= new Rectangle(
                this.body.getX(),
                this.body.getY(),
                this.body.getWidth(),
                this.body.getHeight()

        );
        return rectangle;
    }

    public void  kill(){
        this.alive= false;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public void fallApart(){
        if (!this.alive){
            this.head.moveDown();
            this.body.moveUp();
        }
    }
}
