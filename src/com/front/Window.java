package com.front;

import com.cfg.Constants;
import com.time.Time;
import com.tools.KL;
import com.tools.Logger;
import com.tools.ML;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    private static Window windowInstance = null;
    public boolean isRunning;
    private final Logger logger = new Logger(this.getClass());
    public int currentState;
    public Scene currentScene;

    public KL keyListener = new KL();
    public ML mouseListener = new ML();

    private Window(int width, int height, String title){
        setSize(new Dimension(width, height));
        setTitle(title);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Key listener
        addKeyListener(this.keyListener);
        addMouseListener(this.mouseListener);
        addMouseMotionListener(this.mouseListener);


        // Run program
        this.isRunning = true;
        this.changeState(0);




    }

    public void close(){
        this.isRunning = false;
    }

    public void changeState(int newState){
        this.currentState = newState;
        switch (this.currentState){
            case 0:
                this.currentScene = new MenuScene(this.keyListener, this.mouseListener);
                break;

            case 1:
                this.currentScene = new GameScene();
                break;

            default:
                logger.error("Unknown Scene");
                this.currentScene = null;
                break;


        }

    }


    public void update(double deltaTime){
        Image doubleBufferImage = this.createImage(this.getWidth(), this.getHeight());
        Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphics);
        this.getGraphics().drawImage(doubleBufferImage, 0, 0, this);
        this.currentScene.update(deltaTime);
    }


    public void draw(Graphics g){
        this.currentScene.draw(g);

    }

    public static Window getInstance() {
        if (windowInstance == null){
            windowInstance = new Window(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);
        }
        return windowInstance;
    }

    @Override
    public void run(){

        double lastFrameTime = 0.0;
        double time;
        double deltaTime;
        try{
            while(this.isRunning){
                time = Time.getTime();
                deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                this.update(deltaTime);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        this.dispose();

    }

}
