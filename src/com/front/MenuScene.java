package com.front;

import com.cfg.Constants;
import com.tools.KL;
import com.tools.Logger;
import com.tools.ML;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuScene extends Scene{
    public KL keyListener;
    public ML mouseListener;
    public BufferedImage title, play, playPressed, exit, exitPressed, playCurrentImage, exitCurrentImage;

    public Rect playRect, exitRect, titleRect;



    private static final Logger logger = new Logger(Window.class);

    {
        // Import the main menu image and also crop sub images from it
        try{
            BufferedImage spriteSheet = ImageIO.read(new File("assets/menuSprite.png"));
            this.title = spriteSheet.getSubimage(0, 242, 960, 240);
            this.play = spriteSheet.getSubimage(0, 121, 261, 121);
            this.playPressed = spriteSheet.getSubimage(264, 121, 261, 121);
            this.exit = spriteSheet.getSubimage(0, 0, 233, 93);
            this.exitPressed = spriteSheet.getSubimage(264, 0, 233, 93);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // This is because to change the image when it will be pressed
        this.playCurrentImage = this.play;
        this.exitCurrentImage = this.exit;

        // Defining image coordinates, and width and height
        this.titleRect = new Rect(Constants.SCREEN_WIDTH / 3., Constants.SCREEN_HEIGHT / 10., 300, 100);
        this.playRect = new Rect((Constants.SCREEN_WIDTH / 2.3), Constants.SCREEN_HEIGHT / 3., 150, 70);
        this.exitRect = new Rect((Constants.SCREEN_WIDTH / 2.25), (Constants.SCREEN_HEIGHT / 1.9), 130, 55);

    }

    public MenuScene(KL keyListener, ML mouseListener){
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;


    }

    @Override
    public void update(double deltaTime) {
        if (keyListener.isKeyPressed(KeyEvent.VK_UP)){

            logger.info("Up key is pressed");

        }

        // If exit is hovered change the button style
        if (this.playRect.isInRect(this.mouseListener.getX(), this.mouseListener.getY())){
            logger.info("Mouse coordinate is x=" + this.mouseListener.getX() + ", y=" + this.mouseListener.getY());
            this.playCurrentImage = this.playPressed;
            // Change the state of the window in other words go to the game scene
            if (this.mouseListener.isPressed()){
                Window.getInstance().changeState(1);
            }
        } else {
            // Restore the default image
            this.playCurrentImage = this.play;
        }

        // If exit is hovered change the button style
        if (this.exitRect.isInRect(this.mouseListener.getX(), this.mouseListener.getY())){
            logger.info("Mouse coordinate is x=" + this.mouseListener.getX() + ", y=" + this.mouseListener.getY());
            this.exitCurrentImage = this.exitPressed;
            // If exit is clicked close the window
            if (this.mouseListener.isPressed()){
                Window.getInstance().close();
            }
        } else {
            // Restore the default image
            this.exitCurrentImage = this.exit;
        }



    }

    @Override
    public void draw(Graphics g) {
        // Changes background color fill rect fills the rectangle with the given coordinates
        g.setColor(new Color(30, 169, 208));
        g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        // Drawing main menu image buttons using rectangle class
        g.drawImage(this.title, (int) this.titleRect.x, (int) this.titleRect.y, (int) this.titleRect.width, (int) this.titleRect.height, null);
        g.drawImage(this.playCurrentImage, (int) this.playRect.x, (int) this.playRect.y, (int) this.playRect.width, (int) this.playRect.height, null);
        g.drawImage(this.exitCurrentImage, (int) this.exitRect.x, (int) this.exitRect.y, (int) this.exitRect.width, (int) this.exitRect.height, null);

    }
}
