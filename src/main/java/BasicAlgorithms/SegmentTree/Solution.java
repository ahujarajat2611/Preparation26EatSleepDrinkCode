package BasicAlgorithms.SegmentTree;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;
class QueueHeight {
    
    class PersonInQ {
        
        int height;
        int equalOrHighCount;
     
        public PersonInQ(int height, int equalOrHighCount) {
            this.height = height;
            this.equalOrHighCount = equalOrHighCount;
        }
        
        public String toString() {
            return "[" + height + "," + equalOrHighCount + "]";
        }
    }
    
    class PersonInQComparator implements Comparator<PersonInQ> {
        public int compare(PersonInQ p1, PersonInQ p2) {
            if (p1.height != p2.height) {
                return p2.height-p1.height;
            } else if (p1.height == p2.height) {
                if (p1.equalOrHighCount < p2.equalOrHighCount) {
                    return -1;
                } else if (p1.equalOrHighCount == p2.equalOrHighCount) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
    
    class BinaryIndexTree<T> {
    	
		T element;
		int leftCount;
		int rightCount;
		BinaryIndexTree<T> left;
		BinaryIndexTree<T> right;
		BinaryIndexTree<T> parent;
    	    	
    	public BinaryIndexTree(T element) {
    		this.element = element;
    	}
    	
    	public int getSize() {
    		return leftCount + rightCount + 1;
    	}

    	private void updateParentCounts(BinaryIndexTree<T> start) {
			BinaryIndexTree<T> current = start;
			while (current.parent != null) {
				if (current == current.parent.left) {
					current.parent.leftCount = current.getSize();
				} else if (current == current.parent.right) {
					current.parent.rightCount = current.getSize();
				}
				current = current.parent;
			}
    	}
    	
    	public void add(T element, int index) {  		
    		if (index < this.leftCount) {
    			this.left.add(element, index);
    		} else if (index == this.leftCount) {    			
				BinaryIndexTree<T> newNode = new BinaryIndexTree<>(element);
				newNode.left = this.left;
				newNode.parent = this;
				this.left = newNode;
				
				if (newNode.left != null) {
	    			newNode.left.parent = newNode;
	    			newNode.leftCount = newNode.left.getSize();
				}
				
				updateParentCounts(newNode);
    		} else if (index < this.getSize()) {    			
    			this.right.add(element, index - this.leftCount - 1);
    		} else if (index == this.getSize()) {
    			BinaryIndexTree<T> current = this;
    			while (current.right != null) {
    				current = current.right;
    			}
    			BinaryIndexTree<T> newNode = new BinaryIndexTree<>(element);
    			newNode.parent = current;
    			current.right = newNode;
    			current.rightCount = current.right.getSize();
    			updateParentCounts(newNode);
    		}
    	}
    	
    	public List<T> orderedList() {
    		
    		List<T> result = new ArrayList<>();
    		
    		List<T> leftList = null;
    		if (this.left != null) {
    			 leftList = this.left.orderedList();
    			 result.addAll(leftList);
    		}
    		
    		result.add(this.element);
    		
    		List<T> rightList = null;
    		if (this.right != null) {
    			 rightList = this.right.orderedList();
    			 result.addAll(rightList);
    		}
    		    		
    		return result;
    	}
    	
    	public void printOrdered() {
    		List<T> l = this.orderedList();
    		for (int i=0; i<l.size(); i++) {
    			System.out.print(l.get(i).toString() + " ");			
    		}    		
    	}
    }
    
    public int[][] reconstructQueue(int[][] people) {
        
        int[][] queue = new int[people.length][2];
        
        if (people.length == 0) {
            return queue;
        }
        
        List<PersonInQ> list = new ArrayList<PersonInQ>();

        for (int i=0; i<people.length; i++) {
        	list.add(new PersonInQ(people[i][0], people[i][1]));
        }
        
        Collections.sort(list, new PersonInQComparator());
		System.out.println(list);

		BinaryIndexTree<PersonInQ> root = new BinaryIndexTree<PersonInQ>(list.get(0));
        for (int i=1; i<list.size(); i++) {
        	root.add(list.get(i), list.get(i).equalOrHighCount);
        }
        
        List<PersonInQ> sortedResult = root.orderedList();
        
        for (int i=0; i<sortedResult.size(); i++) {
        	queue[i][0] = sortedResult.get(i).height;
        	queue[i][1] = sortedResult.get(i).equalOrHighCount;
        }
        
        return queue;
    }

	public static void main(String[] args) {
    	int matrix [][]={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}
;
		QueueHeight queueHeight = new QueueHeight();
		ConsoleWriter.printIntArray(queueHeight.reconstructQueue(matrix));
	}
}