package org.academiadecodigo.heroisdovar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

    Grid grid = new Grid();
    grid.makeGrid();
    Cursor cursor = new Cursor();
    cursor.generateCursor();
    InputHandler inputHandler = new InputHandler(cursor.cursor, grid);

    }
}
