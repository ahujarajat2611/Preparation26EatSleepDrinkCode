package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Design Snake Game
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

Using a deque for the positions of the snake, a set to check if snake's body has already occupied the position. When moving the snake, only head is moved and tail is removed, if no food is eaten. Otherwise add head to the first.
 */
public class DesignSnakeGame {
    public class SnakeGame {
        private int width;
        private int height;
        private int[][] food;
        private int foodPos;
        private int score;
        private Deque<int[]> snake;
        private Set<String> bodies;
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            foodPos = 0;
            score = 0;
            snake = new LinkedList<>();
            snake.add(new int[]{0, 0});
            bodies = new HashSet<>();
        }
        public int move(String direction) {
            int[] head = snake.peekFirst();
            int[] next = new int[]{head[0], head[1]};
            if ("U".equals(direction)) {
                next[0]--;
            } else if ("D".equals(direction)) {
                next[0]++;
            } else if ("R".equals(direction)) {
                next[1]++;
            } else if ("L".equals(direction)) {
                next[1]--;
            } else {
                return -1;
            }
            // we are not removing from bodies
            // just adding
            // so as per this logic we can not come bak to point which we have alrready
            // visted
            // thats not rrright we can visit points !!!
            if(next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width
                    || !bodies.add(headToString(head))) {
                return -1;
            }
            if (foodPos < food.length
                    && next[0] == food[foodPos][0]
                    && next[1] == food[foodPos][1]) {
                score++;
                foodPos++;
            } else {
                snake.pollLast();
            }
            snake.addFirst(next);
            return score;
        }

        private String headToString(int[] head) {
            return head[0] + "," + head[1];
        }

    }
}
