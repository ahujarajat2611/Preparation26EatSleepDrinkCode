package DSA.Design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {

	// 2D position info is encoded to 1D and stored as two copies
	Set<Integer> set; // this copy is good for fast loop-up for eating body case
	Deque<Integer> body; // this copy is good for updating tail
	int score;
	int[][] food;
	int foodIndex;
	int width;
	int height;

	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		set = new HashSet<>();
		set.add(0); // intially at [0][0]
		body = new LinkedList<>();
		body.offerLast(0);
	}

	public int move(String direction) {
		// case 0: game already over: do nothing
		if (score == -1) {
			return -1;
		}

		// compute new head
		int rowHead = body.peekFirst() / width;
		int colHead = body.peekFirst() % width;
		switch (direction) {
		case "U":
			rowHead--;
			break;
		case "D":
			rowHead++;
			break;
		case "L":
			colHead--;
			break;
		default:
			colHead++;
		}
		int head = rowHead * width + colHead;

		// rmemove tail index
		// case 1: out of boundary or eating body
		set.remove(body.peekLast()); // new head is legal to be in old tail's
		// have not removed last index frmo body yet !!!								// position, remove from set temporarily
		if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
			return score = -1;
		}

		// add head for case2 and case3
		set.add(head);
		// add new head in the bosy as well as set
		body.offerFirst(head);

		// case2: eating food, keep tail, add head
		if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
			set.add(body.peekLast()); // old tail does not change, so add it
										// back to set
			foodIndex++;
			// increement score as well
			return ++score;
		}

		//
		// case3: normal move, remove tail, add head
		body.pollLast();
		return score;

	}

	public static void main(String... args) {
		// order of ffood index
		int[][] food = { { 1, 2 }, { 0, 1 } };
		SnakeGame snake = new SnakeGame(3, 2, food);
		int result = -1;
		result = snake.move("R");
		System.out.println(result);
		result = snake.move("D");
		System.out.println(result);
		result = snake.move("R");
		System.out.println(result);
		result = snake.move("U");
		System.out.println(result);
		result = snake.move("L");
		System.out.println(result);
		result = snake.move("U");
		System.out.println(result);
	}
}