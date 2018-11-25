package BasicAlgorithms.Trie;

class TernarySearchTree {
    class TSTNode {
		char data;
		boolean end_of_word;
		TSTNode left, right, eq;

		public TSTNode(char data) {
			super();
			this.data = data;
			left = null;
			right = null;
			eq = null;
		}
	}

	TSTNode root = null;

	public TSTNode insert(TSTNode root, String word, int pos) {
		if (null == root) {
			root = new TSTNode(word.charAt(pos));

			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		if (root.data > word.charAt(pos)) {
			root.left = insert(root.left, word, pos);
		} else if (root.data < word.charAt(pos)) {
			root.right = insert(root.right, word, pos);
		} else {
			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		return root;
	}
}