package com.front;

import com.cfg.Constants;

import java.awt.*;

public class GameScene extends Scene{

    public Rect backGround, foreGround;
    Snake snake;


    public GameScene(){
        this.backGround = new Rect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.foreGround = new Rect(24, 48, 24 * 31, 24 * 22);
        this.snake = new Snake(5, 48, 48 + 24, 24, 24);
    }




    @Override
    public void update(double deltaTime) {


    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) this.backGround.x, (int) this.backGround.y, (int) this.backGround.width, (int) this.backGround.height);

        g.setColor(Color.WHITE);
        g.fillRect((int) this.foreGround.x, (int) this.foreGround.y, (int) this.foreGround.width, (int) this.foreGround.height);

        this.snake.draw(g);

    }
}
