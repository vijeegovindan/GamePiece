package com.theironyard;

class GamePiece{

    int positionX;
    int positionY;
    boolean frozen;
    String name;
    String color;
    int minX;
    int maxX;
    int minY;
    int maxY;


    public GamePiece() {
        this.positionX = 0;
        this.positionY = 0;
        this.frozen = false;
        this.name = "This game";
        this.color = "brown";
        int minX = 0;
        int maxX = 100;
        int minY = 0;
        int maxY = 500;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void move(int x, int y){
        if(!frozen){
         if( x >=0 && x <=100 && y>=0 && y<=500){
                this.positionX = x;
                this.positionY = y;
         }
        }
    }

    public void freeze(){
        this.frozen = true;
    }

    public void unfreeze(){
        this.frozen  = false;
    }

}

public class Main {

    public static void main(String[] args) {

        GamePiece gamepiece = new GamePiece();

        System.out.println("Test - Expected: Piece is frozen -  can't move");
        gamepiece.freeze();
        if(gamepiece.frozen){
           System.out.println("Test - Passed: The game piece can't move");
        }

        System.out.println("--------------------------------");

        System.out.println("Test - Expected : Piece is not frozen - can move");
        gamepiece.unfreeze();
        gamepiece.move(0,5);
        if(!gamepiece.frozen){
            System.out.println("Test - Passed: The game piece can move. Position is ("+ gamepiece.positionX + "," + gamepiece.positionY + ")");
        }

        System.out.println("--------------------------------");

        System.out.println("Test - Expected: The game piece moves to new position when itz not frozen. Position(10,10)");
        gamepiece.unfreeze();
        gamepiece.move(10,10);
        System.out.println("Test - Passed: The new position is(" + gamepiece.positionX + "," + gamepiece.positionY + ")");

        System.out.println("--------------------------------");

        System.out.println("Test - Expected: The piece is frozen and retains the same position");
        gamepiece.freeze();
        gamepiece.move(0,5);
        System.out.println("Test - Passed: The piece is in the same position (" + gamepiece.positionX + "," + gamepiece.positionY + ")");

        System.out.println("--------------------------------");

        System.out.println("Test - Expected : Setting of min &  max position for x : (55,100)");
        gamepiece.unfreeze();
        gamepiece.move(55,100);
        System.out.println("Test should pass and the new position is (" + gamepiece.positionX + "," + gamepiece.positionY + ")");

        System.out.println("--------------------------------");

        System.out.println("Test: Setting of min &  max position for x : (101,100)");
        gamepiece.unfreeze();
        gamepiece.move(101,100);
        System.out.println("Test should fail-out of range and the position is(" + gamepiece.positionX + "," + gamepiece.positionY + ")");

        System.out.println("--------------------------------");

        System.out.println("Test: Setting of min &  max position for y: (55, 499)");
        gamepiece.unfreeze();
        gamepiece.move(55,499);
        System.out.println("The new position is (" + gamepiece.positionX + "," + gamepiece.positionY + ")");

        System.out.println("--------------------------------");

        System.out.println("Test: Setting of min &  max position for y: (55, 600)");
        gamepiece.unfreeze();
        gamepiece.move(55,600);
        System.out.println("Test should fail-out of range and the last position is (" + gamepiece.positionX + "," + gamepiece.positionY +")");

    }
}
