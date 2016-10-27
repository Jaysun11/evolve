package evolve;

/**
 * Created by Jason on 27/10/2016.
 */
public class World {
    private int height;
    private int width;
    private Game game;
    public World(Game game, int height, int width) {
        this.height = height;
        this.width = width;
        this.game = game;
    }

    private int getHeight() {
        return this.height;
    }

    private int getWidth() {
        return this.width;
    }

}