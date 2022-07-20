import java.util.*;
public class Main {
    public static class pair{
        Node node;
        int state;
        pair(){}
        pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(){}
        Node(int val){
            this.val=val;
        }
        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

    }

    public static void display(Node root){
        if(root==null){
            return ;
        }
        if(root.left!=null){
            System.out.print(root.left.val);
        }
        else{
            System.out.print(".");
        }
        System.out.print(" <-"+root.val+"-> ");
        if(root.right!=null){
            System.out.print(root.right.val);
        }
        else{
            System.out.print(".");
        }
        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
       
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String []args){
        Integer arr[]={50,60,12,null,null,4,null,null,70,6,null,null,null};
        Node root=new Node(arr[0]);
        Stack<pair> st=new Stack<>();
        pair rootPair=new pair(root,1);
        st.push(rootPair);
        int idx=1;
        while(st.size()!=0){

            pair peekPair=st.peek();
            if(peekPair.state==1){
                peekPair.state++;
                if(arr[idx]!=null){
                    Node leftChild=new Node(arr[idx]);
                    peekPair.node.left=leftChild;
                    st.push(new pair(leftChild,1));
                }
                idx++;
            }
           else if(peekPair.state==2){
                peekPair.state++;
                if(arr[idx]!=null){
                    Node rightChild=new Node(arr[idx]);
                    peekPair.node.right=rightChild;
                    st.push(new pair(rightChild,1));
                }
                idx++;
            }
            else{
                st.pop();
            }

        }
        //display(root);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        

    }
}
