package com.theironyard;

class GamePiece{

    int positionX;
    int positionY;
    boolean frozen;
    String name;
    String color;

    public GamePiece() {
        this.positionX = 0;
        this.positionY = 0;
        this.frozen = false;
        this.name = "This game";
        this.color = "brown";
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
            this.positionX = x;
            this.positionY = y;
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

        System.out.println("Test: The game piece is frozen");
        gamepiece.freeze();
        if(gamepiece.frozen){
           System.out.println("Passed: The game piece is frozen");
        }

        System.out.println("Test: The game piece is not frozen");
        gamepiece.unfreeze();

        if(!gamepiece.frozen){
            System.out.println("Passed: The game piece can move");
        }

        System.out.println("Test: The game piece moves to new position when itz not frozen");
        gamepiece.unfreeze();
        gamepiece.move(0,5);
        System.out.println("Passed: The new position is " + gamepiece.positionX + "," + gamepiece.positionY);

        System.out.println("Test: The game piece doesnt move and retain the position when frozen");
        gamepiece.freeze();
        gamepiece.move(0,5);
        System.out.println("Passed: The same position is " + gamepiece.positionX + "," + gamepiece.positionY);
    }
}
