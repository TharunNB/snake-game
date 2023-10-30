import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel{
    
    private class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    int boardWidth;
    int boardHeight;
    int tileSize = 20;

    Random foodRandom;

    Tile snakeHead;
    Tile food;


    SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));

        foodRandom = new Random();

        snakeHead = new Tile(5, 5);

        food = new Tile(10, 10);

        foodPlacement();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //Grid
        for(int i=0; i<boardWidth/tileSize;i++){
            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
        }

        // Food
        g.setColor(Color.red);
        g.fillRect(food.x *tileSize, food.y*tileSize, tileSize, tileSize);

        //Snakes head definition
        g.setColor(Color.GREEN);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
    }

    public void foodPlacement() {
        food.x = foodRandom.nextInt(boardWidth/tileSize);
        food.y = foodRandom.nextInt(boardHeight/tileSize);

    }
}
