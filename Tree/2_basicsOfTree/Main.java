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
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

       return(Math.max(lh,rh)+1);

    }
    public static int max(Node root){
        if(root==null){
            return 0;
        }
        int lm=max(root.left);
        int rm=max(root.right);

        int myAns=Math.max(lm,rm);

        return Math.max(myAns,root.val);

    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int ls=sum(root.left);
        int rs=sum(root.right);

        return ls+rs+root.val;
    }
   public static int size(Node root){
    if(root==null){
        return 0;
    }
    int ls=size(root.left);
    int rs=size(root.right);
    return ls+rs+1;
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
        // display(root);
       // int h=height(root);
        //System.out.println("Height of Tree-> "+h);
        //int mx=max(root);
       // int sm=sum(root);
        int sze=size(root);
        // System.out.println("Max of Tree-> "+mx);
        // System.out.println("sum of Tree-> "+sm);
        System.out.println("size of Tree-> "+sze);


    }
}
