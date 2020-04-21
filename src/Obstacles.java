import java.util.ArrayList;

public class Obstacles {

    private int numberOfGoodObstacles;
    private int numberOfBadObstacles;
    ArrayList<Obstacle> obstacles;
    ArrayList<GoodObstacle> goodObstacles;
    ArrayList<BadObstacle> badObstacles;

    public Obstacles() {

        if (Level.getDifficulty() == Level.EASY) {
            numberOfGoodObstacles = Level.GOODOBSTACLES_EASY;
            numberOfBadObstacles = Level.BADOBSTACLES_EASY;
        } else if (Level.getDifficulty() == Level.MEDIUM) {
            numberOfGoodObstacles = Level.GOODOBSTACLES_MEDIUM;
            numberOfBadObstacles = Level.BADOBSTACLES_MEDIUM;
        } else if (Level.getDifficulty() == Level.HARD) {
            numberOfGoodObstacles = Level.GOODOBSTACLES_HARD;
            numberOfBadObstacles = Level.BADOBSTACLES_HARD;
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
