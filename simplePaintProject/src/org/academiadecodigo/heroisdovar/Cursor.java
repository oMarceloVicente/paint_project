package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Cursor {

    Rectangle cursor;

    public void generateCursor() {
        cursor = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.cellSize, Grid.cellSize);
        cursor.setColor(Color.GREEN);
        cursor.fill();
    }

}
