package com.tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ML extends MouseAdapter implements MouseMotionListener {

    private boolean isPressed = false;
    private double x = 0., y = 0.;


    @Override
    public void mousePressed(MouseEvent e){
        this.isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e){
        this.isPressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e){
         this.x = e.getX();
         this.y = e.getY();
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public boolean isPressed(){ return this.isPressed; }


}
