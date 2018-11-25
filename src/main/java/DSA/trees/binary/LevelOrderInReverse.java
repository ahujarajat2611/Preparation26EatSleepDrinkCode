/**
 * 
 */
package DSA.trees.binary;

import DSA.nodes.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author Raj
 *
 */
public class LevelOrderInReverse {

	public List<List<Integer>> levelOrderFromBottom(BinaryTreeNode<Integer> root) {
		List<List<Integer>> res = new ArrayList<>();
		if (null == root)
			return res;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode<Integer> temp = q.poll();
			//	list.add(0, temp.data);
				list.add(temp.data);
			//	System.out.println(list);
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			res.add(0, list);
		}
		return res;
	}

	public static void main(String[] args) {
		LevelOrderInReverse obj = new LevelOrderInReverse();

		BinaryTree ob = new BinaryTree();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.insert(8);
		ob.insert(9);
		ob.insert(10);

		BinaryTreeNode<Integer> root = ob.root;

		// Time :O(n2)
		obj.levelOrderTraversal(root);
		// Time : O(n2)
	//	obj.levelOrderInReverse(root);

		// Time : O(n)
		obj.levelOrderInReverseUsingStack(root);
		List<List<Integer>> res = obj.levelOrderFromBottom(ob.root);
		System.out.println(res);

	}

	public void levelOrderInReverse(BinaryTreeNode<Integer> root) {
		int size = new Height().height(root);
		for (int i = size; i >= 1; i--) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		int size = new Height().height(root);
		for (int i = 1; i <= size; i++) {
			printNodesAtGivenLevel(root, i);
			System.out.print("| ");
		}
		System.out.println();
	}

	public void printNodesAtGivenLevel(BinaryTreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printNodesAtGivenLevel(root.left, level - 1);
			printNodesAtGivenLevel(root.right, level - 1);
		}

	}

	public void levelOrderInReverseUsingStack(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return;
		}

		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();

		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			stack.addFirst(cur);
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
			if (cur.left != null) {
				queue.addLast(cur.left);
			}
		}
		while (!stack.isEmpty())
			System.out.print(stack.removeFirst().data + " ");
		System.out.println();
	}

}


// network byte optmi
// database optimzation :-
//
//databse cluster :- 2 replica in 1 dc , we did not had casandra talk to local dc
 // lz4 compression :- jvm gc rate :-
 // byte arrays :- compression
 // network byte optmization
 // design system :- read :- index is not there ... some one created index :-
 // service was slower than expected :- direct sql query similar small size
 // reindexes to be created ;- ( one small parition )
 // full day to scan!! indexe not working in postgresql
 // cansandra -distributed database :- 2 replicas and 2 in other datacentres
 // one datacentre has outage :- most of the time same datacentre :-
 // cross dc calls 10 20 ms () :- coordinatr
 // cpu utilization ( good exmaple ) 20 to 30 precent:- spike in traffice
 // remaining cpu encryption decreytiong :- lots of of cpu
 // lz4 :- (jvm grbage collection)
 // cpu utilizatoin ;- not to create not too many threads ;-
 // too many threaads context switches that affect cpu :-
 // less number of threads -> one more thread does more work ( one thread handling multiple requests )


 // async programming:- ( one thread is doing )
 /// how you are handling threads everywhere is threadpool
 // most of the time is blocked on io
 // async programming :- complretable future :- ( event-driven programming)
 // netty :-( for networking layer ) not for application layer
 // 5 neryy threads :- // by non-blocking( thread will continue to work )
 // find number of threads :- 24 cores machine ( nettty :- 2 per core)

 // 24 threaads :- 1000 requests per second

 //nginx :- (it delagtes works 10,0000 request  async thing )
 // nginx :- // do not create too many threads ( 12 cores :- 24 threads )
// async programming // u want as little as context switch
// one thread
// cpu parallelism :- ( it takes one processs)
// have little switches as possible
/// thread per cpu .. each thread will sit on core .. dont have to context switch
// 500 threads :- 24 cores :- then context swtich will happen a lot
// high cpu utilizatioon if you have so many threads but actually only context switch would be happening






// 1) Encrypted Files and decrypt files so it is going to be CPU intensive
// 2) Databases indexed not being genetaed properly
// 3) https://www.postgresql.org/docs/9.3/static/sql-reindex.html
// 4) Cpu intensive memory intensive ( Application)
// 5) Full day to scan and reindexes not working properly
// 6) Gc was the problem /// creating lots of objects while loading the file
// 7) CPu utilization should be around 30 40 percent and remaining for the peak time
// 8) nginx can handles 10,000 of requests at the top layer using async programming(it also has 24 threads)
// one thread per core so that it does not do lots of context switch .. rather
	  // dont block on thread for io rather than do some work and once that io happens go back to do that work
	  // thats the bassic funda of async programming ( thats what completable future does to you )
	  //
// high cpu utilizatioon if you have so many threads but actually only context switch would be happening
// 500 threads :- 24 cores :- then context swtich will happen a lot
// threads per cpu ( core)
// /// thread per cpu .. each thread will sit on core .. dont have to context switch
// non blocking io
// one thread can handle mutiple requestsssss
// // find number of threads :- 24 cores machine ( nettty :- 2 per core)
// netty does that at network level not at application level
// completable future does at application level
// async programming:- ( one thread is doing )
// how you are handling threads everywhere is threadpool
// most of the time is blocked on io

// thread pool will be there everywhere thats for  sure
// not upto you you want to handle request per thread or multiple requests per thread
// thats up to you netty does that network layer one trhead multiple requests
// completable future at at application layer
// create threads as per the number of cores
//




// load balanceer is on the client side ( ad-server request)
// request comes to nginx
// nginx delgates request to tomcat server
// tomcat server has all servlets (request, response)


// Geo -service has this model !!!
// request has content type (x-thrift)
// we are using binary protocl so messgae gets in binary format
// we take taht then we call geo service that has lots of data
// we use servlet technology readrequest ---> that has binary message in the form of thrift
//

/*

https://stackoverflow.com/questions/12806678/netty-slower-than-tomcat
 */

// there are two server options one is netty server and one is tomcat server ( we choose tomcat sever with servlet but but
// we pass on thriftmessages which needs to be decodeddddd
// tomcat is faster than netty ( might be )
// tomcat has netty enabled so that one thread handles multiple requestsssss not just one request


/*



WAR files vs. Java apps with embedded servers

https://steveperkins.com/war-files-vs-embedded-servers/



we use container approach FYI ( okay !!!!)
			in geo service reposnse
			response.setContentType("application/x-thrift");

			Again we dont use thrift based server RPC, we use tomcat as container and deploy our base servlet
			// we get request and decode and it let thrift processser pass it on to function that it wants to call
			// weird architecture but yes it is the architecctire
			// we used tomcat so that we can deal with threads number of threads //


 */