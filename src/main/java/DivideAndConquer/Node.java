package DivideAndConquer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
    Node left;
    String data;
    Node right;

    Node(Node left, String data, Node right)
    {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public String getData()
    {
        return data;
    }
}

class Tree
{
    Node node;

    //insert
    public void insert(String data)
    {
        if(node == null)
            node = new Node(null,data,null);
        else
        {
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);

            while(q.peek() != null)
            {
                Node temp = q.remove();
                if(temp.left == null)
                {
                    temp.left = new Node(null,data,null);
                    break;
                }
                else
                {
                    q.add(temp.left);
                }

                if(temp.right == null)
                {
                    temp.right = new Node(null,data,null);
                    break;
                }
                else
                {
                    q.add(temp.right);
                }
            }
        }
    }

    public void postorder(Node node)
    {
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.getData()+" --> ");
    }

    public void iterative(Node node)
    {
        Stack<Node> s = new Stack<Node>();
        Node lastpost = null;
        while(true)
        {
            while(node != null)
            {
                s.push(node);
                node = node.left;
            }

            if(s.isEmpty())break;
            Node topagain= s.pop();

            if(topagain.right==null || topagain.right == lastpost){
                System.out.print(topagain.getData()+" --> ");
                lastpost = topagain;
                node = null;
            }

            else {
                s.push(topagain);
                node = topagain.right;
            }
//            if(topagain<0){
//                s.push(topagain);
//            }
//            else{
//
//            }
//
//
//            if(s.peek().right == null)
//            {
//                node = s.pop();
//                System.out.print(node.getData()+" --> ");
//                if(node == s.peek().right)
//                {
//                    System.out.print(s.peek().getData()+" --> ");
//                    s.pop();
//                }
//            }
//
//            if(s.isEmpty())
//                break;
//
//            if(s.peek() != null)
//            {
//                node = s.peek().right;
//            }
//            else
//            {
//                node = null;
//            }
        }
    }
}

class Main
{
    public static void main(String[] args) 
    {
        Tree t = new Tree();
        t.insert("A");
        t.insert("B");
        t.insert("C");
        t.insert("D");
        t.insert("E");

        t.postorder(t.node);
        System.out.println();

        t.iterative(t.node);
        System.out.println();
    }
}