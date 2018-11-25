//package ObjectOrientedDesign;
//
//import java.util.*;
//public class Player {
//    private class Pair<T>{
//
//    }
//    private final char label;
//    private Set<Pair<Integer>> pieces = new HashSet<Pair<Integer>>();
//
//    public Player(char label) {
//        this.label = label;
//    }
//
//    public void addOnePiece(Pair<Integer> piece) {
//        pieces.add(piece);
//    }
//
//    public void removeOnePiece(Pair<Integer> piece) {
//        pieces.remove(piece);
//    }
//
//    public Set<Pair<Integer>> getPieces() {
//        return pieces;
//    }
//
//    public char getLabel() {
//        return label;
//    }
//
//}
//
//public class Board {
//    private final char BLACK = '*';
//    private final char WHITE = '^';
//    private Player black;
//    private Player white;
//
//    private char[][] board = new char[8][8];
//
//    public Board() {
//        for (int i = 0; i < board.length; ++i) {
//            for (int j = 0; j < board[0].length; ++j) {
//                board[i][j] = '.';
//            }
//        }
//        black = new Player(BLACK);
//        black.addOnePiece(new Pair<Integer>(3, 4));
//        board[3][4] = BLACK;
//        black.addOnePiece(new Pair<Integer>(4, 3));
//        board[4][3] = BLACK;
//
//        white = new Player(WHITE);
//        white.addOnePiece(new Pair<Integer>(3, 3));
//        board[3][3] = WHITE;
//        white.addOnePiece(new Pair<Integer>(4, 4));
//        board[4][4] = WHITE;
//    }
//
//    public boolean checkMove(Player player, Player opponent,
//            Pair<Integer> piece) {
//        if (piece.getX() < 0 || piece.getX() >= 7)
//            return false;
//        if (piece.getY() < 0 || piece.getY() >= 7)
//            return false;
//        char label = player.getLabel();
//        char backup = board[piece.getX()][piece.getY()];
//        board[piece.getX()][piece.getY()] = label;
//        for (Pair<Integer> pos : opponent.getPieces()) {
//            if (capturedLeftAndRight(pos) || capturedUpAndDown(pos))
//                return true;
//        }
//        board[piece.getX()][piece.getY()] = backup;
//        return false;
//    }
//
//    public boolean capturedLeftAndRight(Pair<Integer> piece) {
//        int row = piece.getX();
//        int col = piece.getY();
//        int leftCol = col - 1 < 0 ? col : col - 1;
//        int rightCol = col + 1 >= 8 ? col : col + 1;
//        char left = board[row][leftCol];
//        char right = board[row][rightCol];
//        return left == right && left != board[row][col] && left != '.';
//    }
//
//    public boolean capturedUpAndDown(Pair<Integer> piece) {
//        int row = piece.getX();
//        int col = piece.getY();
//        int upRow = row - 1 < 0 ? row : row - 1;
//        int downRow = row + 1 >= 8 ? row : row + 1;
//        char up = board[upRow][col];
//        char down = board[downRow][col];
//        return up == down && up != board[row][col] && up != '.';
//    }
//
//    public void flip(Pair<Integer> piece) {
//        if (board[piece.getX()][piece.getY()] == BLACK)
//            board[piece.getX()][piece.getY()] = WHITE;
//        else if (board[piece.getX()][piece.getY()] == WHITE)
//            board[piece.getX()][piece.getY()] = BLACK;
//    }
//
//    @Override
//    public String toString() {
//        String result = new String();
//        result += ' ';
//        for (int i = 0; i < board.length; ++i) {
//            result += i;
//        }
//        result += '\n';
//        for (int i = 0; i < board.length; ++i) {
//            result += i;
//            for (int j = 0; j < board[0].length; ++j) {
//                result += board[i][j];
//            }
//            result += '\n';
//        }
//        return result;
//    }
//
//    public void step() {
//        // System.out.println(this);
//
//        String input = new String();
//        int x = 0;
//        int y = 0;
//        do {
//            System.out.println("White's turn: ");
//            InputStreamReader converter = new InputStreamReader(System.in);
//            BufferedReader in = new BufferedReader(converter);
//            try {
//                input = in.readLine();
//                char[] inputs = input.toCharArray();
//                x = Integer.parseInt("" + inputs[0]);
//                y = Integer.parseInt("" + inputs[1]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } while (!checkMove(white, black, new Pair<Integer>(x, y)));
//        board[x][y] = WHITE;
//        white.addOnePiece(new Pair<Integer>(x, y));
//
//        boolean blackWin = true;
//        List<Pair<Integer>> posToBeRemoved = new LinkedList<Pair<Integer>>();
//        for (Pair<Integer> pos : black.getPieces()) {
//            if (capturedLeftAndRight(pos) || capturedUpAndDown(pos)) {
//                flip(pos);
//                // black.removeOnePiece(pos);
//                posToBeRemoved.add(pos);
//                white.addOnePiece(pos);
//                blackWin = false;
//            }
//        }
//        for (Pair<Integer> pos : posToBeRemoved) {
//            black.removeOnePiece(pos);
//        }
//        posToBeRemoved.clear();
//        System.out.println(this);
//        if (blackWin) {
//            System.out.println("Black has won!");
//            System.exit(0);
//        }
//
//        do {
//            System.out.println("Black's turn: ");
//            InputStreamReader converter = new InputStreamReader(System.in);
//            BufferedReader in = new BufferedReader(converter);
//            try {
//                input = in.readLine();
//                char[] inputs = input.toCharArray();
//                x = Integer.parseInt("" + inputs[0]);
//                y = Integer.parseInt("" + inputs[1]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } while (!checkMove(black, white, new Pair<Integer>(x, y)));
//        board[x][y] = BLACK;
//        black.addOnePiece(new Pair<Integer>(x, y));
//
//        boolean whiteWin = true;
//        for (Pair<Integer> pos : white.getPieces()) {
//            if (capturedLeftAndRight(pos) || capturedUpAndDown(pos)) {
//                flip(pos);
//                // white.removeOnePiece(pos);
//                posToBeRemoved.add(pos);
//                black.addOnePiece(pos);
//                whiteWin = false;
//            }
//        }
//        for (Pair<Integer> pos : posToBeRemoved) {
//            white.removeOnePiece(pos);
//        }
//        posToBeRemoved.clear();
//        System.out.println(this);
//        if (whiteWin) {
//            System.out.println("White has won!");
//            System.exit(0);
//        }
//    }
//}