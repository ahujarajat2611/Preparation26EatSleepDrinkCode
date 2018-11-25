package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 20/12/17.
 */
public class GeneralTemplateOfShortestPathProblems {
}

/*
    Set<Long> memorizer = new HashSet<>();

    int[] d1 = new int[] {-1, 1, 0, 0};
    int[] d2 = new int[] {0, 0, -1, 1};

    boolean minimalStepSolve(int[][] board) {
        memorizer.clear();
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(board, 0, null));
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            memorizer.add(encode(step.board));
            if (isEndState(step.board)) {
                step.printTransformStep();
                return true;
            }
            List<Step> availableSteps = getAvailableSteps(step);
            for (Step s : availableSteps) {
                if (!memorizer.contains(encode(s.board))) {
                    queue.offer(s);
                }
            }
        }
        return false;
    }
 */