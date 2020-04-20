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

        GoodObstacle goodObstacle1 = new GoodObstacle((Pong.WIDTH - 50)*Math.random(),Pong.HEIGHT*Math.random());
        this.obstacles.add(goodObstacle1);

        BadObstacle badObstacle1 = new BadObstacle((Pong.WIDTH - 50)*Math.random(),Pong.HEIGHT*Math.random());
        this.obstacles.add(badObstacle1);
    }

    public void draw(){
        for (Obstacle obstacle : this.obstacles) {
            obstacle.draw();
        }
    }

}
