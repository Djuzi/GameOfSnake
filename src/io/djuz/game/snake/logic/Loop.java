package io.djuz.game.snake.logic;

import io.djuz.game.snake.ui.Draw;
import javafx.scene.canvas.GraphicsContext;

public class Loop implements Runnable {
    private final Grid grid;
    private final GraphicsContext context;
    private boolean running;
    private boolean paused;
    private float interval;
    private boolean keyIsPressed;

    public Loop(Grid grid, GraphicsContext context) {
        this.grid = grid;
        this.context = context;
        this.interval = 600.0f;
        this.running = true;
        this.paused = false;
        this.keyIsPressed = false;
    }

    public boolean isKeyIsPressed() {
        return keyIsPressed;
    }

    public void setKeyIsPressed(boolean keyIsPressed) {
        this.keyIsPressed = keyIsPressed;
    }

    public void resume() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }
    public void pause() {
        paused = true;
    }

    @Override
    public void run() {
        while (running && !paused) {

            float time = System.currentTimeMillis();
            keyIsPressed = false;
            grid.update();
            Draw.paint(grid, context);

            if (!grid.getSnake().isAlive()) {
                pause();
                Draw.paintResetMessage(context);
                break;
            }

            time = System.currentTimeMillis() - time;

            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            }
        }


    }
}
