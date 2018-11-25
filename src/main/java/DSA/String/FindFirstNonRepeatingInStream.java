package DSA.String;

class FindFirstNonRepeatingInStream {
    class DLLNode {
			char data;
			DLLNode next, prev;
		}

		DLLNode front = null, rear = null;
		DLLNode links[] = new DLLNode[256];
		boolean[] visited = new boolean[256];

		public void insertInStream(char ch) {
			if (visited[ch]) {
				remove(links[ch]);
				links[ch] = null;
			} else {
				visited[ch] = true;
				add(ch);
				links[ch] = rear;
			}
		}

		public void add(char ch) {
			DLLNode node = new DLLNode();
			node.data = ch;
			if (front == null) {
				front = node;
				rear = node;
			} else {
				rear.next = node;
				node.prev = rear;
				rear = rear.next;
			}
		}

		public void remove(DLLNode nn) {
			if (nn == null)
				return;
			if (nn.prev != null) {
				nn.prev.next = nn.next;
			} else {
				front = nn.next;
			}

			if (nn.next != null) {
				nn.next.prev = nn.prev;
			} else {
				rear = nn.prev;
			}
		}

		public char firstNonRepeatingCharacter() {
			return front == null ? 0 : front.data;
		}
	}
