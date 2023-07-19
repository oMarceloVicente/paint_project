package org.academiadecodigo.heroisdovar;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {
    public final static int cellSize = 20;
    public final static int PADDING = 10;
    private int cols = 43;
    private int rows = 43;
    public final static int SIZE = 900;
    private int height = rows * cellSize;
    private int width = cols * cellSize;
    private boolean painted;

    public boolean isPainted() {
        return painted;
    }

    Cell[][] cell = new Cell[height][width];

    public void makeGrid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cell[i][j] = new Cell(i * cellSize + PADDING, j * cellSize + PADDING, cellSize, cellSize);
                cell[i][j].draw();
            }
        }
    }

    public void paintMode(Rectangle cursor) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (cell[i][j].getX() == cursor.getX() && cell[i][j].getY() == cursor.getY()) {
                    if (!cell[i][j].isFilled()) {
                        cell[i][j].setColor(cursor.getColor());
                        cell[i][j].fill();
                    } else {
                        cell[i][j].setColor(Color.BLACK);
                        cell[i][j].draw();
                    }
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cell[i][j].setColor(Color.BLACK);
                cell[i][j].draw();
            }
        }
    }

    public void write(String file) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(writer);
        for (int i = 0; i < cols; i++) {
            if (i > 0) {
                bWriter.write("\n");
            }
            for (int j = 0; j < rows; j++) {
                if (cell[i][j].isFilled()) {
                    if (cell[i][j].getColor() == Color.GREEN) {
                        bWriter.write("1");
                    }
                    else if (cell[i][j].getColor() == Color.YELLOW) {
                        bWriter.write("2");
                    }
                    else if (cell[i][j].getColor() == Color.BLUE) {
                        bWriter.write("3");
                    }
                } else {
                    bWriter.write("0");
                }
            }
        }
        bWriter.close();
    }

        public void read(String file, Rectangle cursor) throws IOException {
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String[][] array = new String[cols][rows];
            for (int i = 0; i < cols; i++) {
                array[i] = bReader.readLine().split("");
                for (int j = 0; j < rows; j++) {
                    int num = Integer.parseInt(array[i][j]);
                    if (num == 0) {
                        cell[i][j].setColor(Color.BLACK);
                        cell[i][j].draw();
                    } else if (num == 1)
                    {
                        cell[i][j].setColor(Color.GREEN);
                        cell[i][j].fill();
                    }
                    else if (num == 2){
                        cell[i][j].setColor(Color.YELLOW);
                        cell[i][j].fill();
                    }
                    else if (num == 3){
                        cell[i][j].setColor(Color.BLUE);
                        cell[i][j].fill();
                    }
                }
            }
            bReader.close();
        }

}