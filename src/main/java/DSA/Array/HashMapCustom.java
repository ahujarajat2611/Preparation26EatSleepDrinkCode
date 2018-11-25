package DSA.Array;

class HashMapCustom<K, V> {
        class Entry<K, V> {
			private K key;
			private V value;
			Entry<K, V> next;

			public Entry(K key, V value) {
				super();
				this.key = key;
				this.value = value;
				this.next = null;
			}
		}


		private int size;
		private Entry[] entries;


		HashMapCustom() {
			this.size = 10;
			entries = new Entry[10];

		}

		public void insert(K key, V value) {
			int hash = hashCode(key);
			Entry<K, V> entry = new Entry<K, V>(key, value);
			if (entries[hash] == null) {
				entries[hash] = entry;
			} else {
				entry.next = entries[hash];
				entries[hash] = entry;
			}
		}

		public V get(K key) {
			int hash = hashCode(key);
			if (entries[hash] == null) {
				return null;
			}
			Entry<K, V> cur = entries[hash];
			while (cur != null) {
				if (cur.key == key)
					return cur.value;
				cur = cur.next;
			}
			return null;
		}

		public int hashCode(K key) {
			return key.hashCode() % size;
		}
	}
