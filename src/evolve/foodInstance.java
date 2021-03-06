package evolve;

import java.awt.*;

/**
 * Created by Jason on 27/10/16.
 */
public class foodInstance extends Entity {
    private Game game;
    private World world;

    private double height;
    private double width;

    private double maxSpeed = 0.025;

    double yDirection = 0;
    double xDirection = 0;


    public foodInstance(Game game, double x, double y, double height, double width) {
        super(game, x, y, height, width);

        this.world = game.getWorld();
        this.game = game;
        this.height = height;
        this.width = width;

        getDirection();
    }

    @Override
    public void tick() {
        findMove();
    }
    public void makeMove(){
        y += yDirection;
        x += xDirection;
    }

    public void findMove() {
        if (y >= world.getHeight()- height -10) {
            yDirection = -yDirection;
        }
        if (x >= world.getWidth() - width) {
            xDirection= -xDirection;
        }
        if (y <= 50) {
            yDirection = -yDirection;
        }
        if (x <= 250) {
            xDirection= -xDirection;
        }
        if (Math.random() > 0.999) {
            getDirection();
        }

        makeMove();
    }

    public void getDirection() {
        yDirection = maxSpeed * (Math.random() > 0.5? 1 : -1);
        xDirection = maxSpeed * (Math.random() > 0.5? 1 : -1);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.foodSprite, (int)x, (int)y, (int)height, (int)width, null);
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }



}
