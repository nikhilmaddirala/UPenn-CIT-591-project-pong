import java.util.ArrayList;

public class Obstacles {
    public static final int GOODOBSTACLES_EASY = 0;
    public static final int GOODOBSTACLES_MEDIUM = 5;
    public static final int GOODOBSTACLES_HARD = 1;

    public static final int BADOBSTACLES_EASY = 0;
    public static final int BADOBSTACLES_MEDIUM = 1;
    public static final int BADOBSTACLES_HARD = 1;

    private int numberOfGoodObstacles;
    private int numberOfBadObstacles;
    ArrayList<Obstacle> obstacles;
    ArrayList<GoodObstacle> goodObstacles;
    ArrayList<BadObstacle> badObstacles;

    public Obstacles() {

        if (Level.getDifficulty() == Level.EASY) {
            numberOfGoodObstacles = GOODOBSTACLES_EASY;
            numberOfBadObstacles = BADOBSTACLES_EASY;
        } else if (Level.getDifficulty() == Level.MEDIUM) {
            numberOfGoodObstacles = GOODOBSTACLES_MEDIUM;
            numberOfBadObstacles = BADOBSTACLES_MEDIUM;
        } else if (Level.getDifficulty() == Level.HARD) {
            numberOfGoodObstacles = GOODOBSTACLES_HARD;
            numberOfBadObstacles = BADOBSTACLES_HARD;
        }

        this.obstacles = new ArrayList<Obstacle>();

        for (int i = 0; i < numberOfGoodObstacles; i++) {
            this.obstacles.add(new GoodObstacle((Pong.WIDTH - 50) * Math.random(), (Pong.HEIGHT  - 50)*Math.random()));
        }

        for (int i = 0; i < numberOfBadObstacles; i++) {
            this.obstacles.add(new BadObstacle((Pong.WIDTH - 50) * Math.random(), (Pong.HEIGHT  - 50)*Math.random()));
        }
    }

    public void draw() {
        for (Obstacle obstacle : this.obstacles) {
            obstacle.draw();
        }
    }

}
