package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class InputHandler implements KeyboardHandler {

    Keyboard keyboard;
    KeyboardEvent[] events;
    Rectangle cursor;
    Grid grid;

    boolean isPressed = false;
     
    public InputHandler(Rectangle cursor, Grid grid) {
        this.cursor = cursor;
        this.grid = grid;
        keyboard = new Keyboard(this);
        events = new KeyboardEvent[15];
        createEvents();
    }

    public void createEvents() {
        for (int i = 0; i< events.length; i++) {
            events[i] = new KeyboardEvent();
        }
        events[0].setKey(KeyboardEvent.KEY_SPACE);
        events[1].setKey(KeyboardEvent.KEY_DOWN);
        events[2].setKey(KeyboardEvent.KEY_RIGHT);
        events[3].setKey(KeyboardEvent.KEY_LEFT);
        events[4].setKey(KeyboardEvent.KEY_UP);
        events[5].setKey(KeyboardEvent.KEY_SPACE);
        events[6].setKey(KeyboardEvent.KEY_C);
        events[7].setKey(KeyboardEvent.KEY_Q);
        events[8].setKey(KeyboardEvent.KEY_S);
        events[9].setKey(KeyboardEvent.KEY_L);
        events[10].setKey(KeyboardEvent.KEY_Y);
        events[11].setKey(KeyboardEvent.KEY_B);

        for (int i = 0; i< events.length-1; i++) {
            events[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(events[i]);
        }
        events[0].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(events[0]);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if(cursor.getY() > Grid.PADDING) {
                    cursor.translate(0, -Grid.cellSize);
                }
                if(isPressed) {
                    grid.paintMode(cursor);
                }
                    break;
            case KeyboardEvent.KEY_DOWN:
                if(cursor.getY() < Grid.SIZE - Grid.cellSize) {
                    cursor.translate(0, Grid.cellSize);
                }
                if(isPressed) {
                    grid.paintMode(cursor);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if(cursor.getX() > Grid.PADDING) {
                    cursor.translate(-Grid.cellSize, 0);
                }
                if(isPressed) {
                    grid.paintMode(cursor);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(cursor.getX() < Grid.SIZE - Grid.cellSize) {
                    cursor.translate(Grid.cellSize, 0);
                }
                if(isPressed) {
                    grid.paintMode(cursor);
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                isPressed = true;
                grid.paintMode(cursor);
                break;
            case KeyboardEvent.KEY_C:
                grid.clear();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_S:
                try {
                    grid.write("resources/PasteFile.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_L:
                try {
                    grid.read("resources/PasteFile.txt", cursor);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case KeyboardEvent.KEY_Y:
                cursor.setColor(Color.YELLOW);
                break;
            case KeyboardEvent.KEY_B:
                cursor.setColor(Color.BLUE);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                isPressed = false;
                break;
        }
    }

}
