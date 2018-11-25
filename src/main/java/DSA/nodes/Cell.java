package DSA.nodes;

public class Cell {
    int row;
			int col;

			public Cell(int r, int c) {
				this.row = r;
				this.col = c;
			}

			@Override
			public String toString() {
				return "Cell [row=" + row + ", col=" + col + "]";
			}

		}