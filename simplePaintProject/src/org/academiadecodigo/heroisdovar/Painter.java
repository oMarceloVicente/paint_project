package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    private int cellSize = 50;
    private final static int PADDING = 10;
    private int cols;
    private int rows;
    Rectangle paint;
    Cursor cursor;

    Rectangle[][] saveRectangle;

    public void paintMode() {
        for(int i = 0; i < cols; i += cellSize ) {
            for (int j = 0; j < rows; j += cellSize) {
                if(paint.getX() == cursor.cursor.getX() && paint.getY() == cursor.cursor.getY()) {
                    paint = new Rectangle(paint.getX(), paint.getY(), cellSize, cellSize);
                    paint.setColor(Color.BLACK);
                    paint.fill();
                }
            }
        }
    }

}
