package com.front;

import java.awt.*;

public class Snake {
    public Rect[] body = new Rect[100];
    public double bodyWidth, bodyHeight;

    public int size;
    public int tail;
    public int head;


    public Snake(int size, double startX, double startY, double bodyWidth, double bodyHeight) {
        this.size = size;
        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;

        for (int i = 0; i <= size; i++){
            var bodyPiece = new Rect(startX + i * bodyWidth, startY, bodyWidth, bodyHeight);
            this.body[i] = bodyPiece;
            this.head++;
        }
        this.head--;
    }


    public void draw(Graphics g){
        for (int i = 0; i != this.head; i = (i + 1) % this.body.length){
            Rect piece = this.body[i];
            double subWidth = (piece.width - 6.0) / 2.0, subHeight = (piece.height - 6.)/2.;



            g.setColor(Color.black);
            g.fillRect((int) (piece.x + 2.0), (int) (piece.y + 2.0), (int) subWidth, (int) subHeight);
            g.fillRect((int) (piece.x + 4.0 + subWidth), (int) (piece.y + 2.0), (int) subWidth, (int) subHeight);
            g.fillRect((int) (piece.x + 2.0), (int) (piece.y + 4.0 + subHeight), (int) subWidth, (int) subHeight);
            g.fillRect((int) (piece.x + 4.0 + subWidth), (int) (piece.y + 4.0 + subHeight), (int) subWidth, (int) subHeight);

        }
    }


}
