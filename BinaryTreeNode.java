// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
import java.io.*;
import java.util.*;


class BinaryTreeNode<dataType>
{
    String data;
    BinaryTreeNode<dataType> left;
    BinaryTreeNode<dataType> right;

    public BinaryTreeNode ( String d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
    {
        data = d;
        left = l;
        right = r;
    }

    BinaryTreeNode<dataType>  getLeft () { return left; }
    BinaryTreeNode<dataType> getRight () { return right; }
}
class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{  BinaryTreeNode root = null;
    public void insert (String d )
    {
        if (root == null)
            root = new BinaryTreeNode<dataType> (d, null, null);
        else
            insert (d, root);
    }
    public void insert ( String d, BinaryTreeNode node )
    {
        if (d.compareTo (node.data) <= 0)
        {
            if (node.left == null)
                node.left = new BinaryTreeNode<dataType> (d, null, null);
            else
                insert (d, node.left);
        }
        else
        {
            if (node.right == null)
                node.right = new BinaryTreeNode<dataType> (d, null, null);
            else
                insert (d, node.right);
        }
    }

    public BinaryTreeNode<dataType> find ( String d )
    {
        if (root == null)
            return null;
        else
            return find (d, root);
    }
    public BinaryTreeNode<dataType> find ( String d, BinaryTreeNode node )
    {
        Account acc = new Account((String) d);
        Account accNode = new Account((String)node.data);

        String p = node.data;
        //System.out.println(p.charAt(0) + " is the char of the node" );
        if (acc.compareTo (accNode) == 0)
            return node;
        else if (acc.compareTo (accNode) < 0)
            return (node.left == null) ? null : find (d, node.left);
        else
            return (node.right == null) ? null : find (d, node.right);
    }

    public int getSize()
    {
        return getSize(root);
    }

    public int getSize(BinaryTreeNode node)
    {
        if(node == null)
            return 0;
        else
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }
    public void delete ( String d )
    {
        root = delete (d, root);
    }
    public BinaryTreeNode<dataType> delete ( String d, BinaryTreeNode node )
    {
        if (node == null) return null;
        if (d.compareTo (node.data) < 0)
            node.left = delete (d, node.left);
        else if (d.compareTo (node.data) > 0)
            node.right = delete (d, node.right);
        else if (node.left != null && node.right != null )
        {
            node.data = findMin (node.right).data;
            node.right = removeMin (node.right);
        }
        else
        if (node.left != null)
            node = node.left;
        else
            node = node.right;
        return node;
    }

    public BinaryTreeNode<dataType> findMin ( BinaryTreeNode node )
    {
        if (node != null)
            while (node.left != null)
                node = node.left;
        return node;
    }

    public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode node )
    {
        if (node == null)
            return null;
        else if (node.left != null)
        {
            node.left = removeMin (node.left);
            return node;
        }
        else
            return node.right;
    }

    // get all the posts by account name
    public ArrayList<String> getPosts(String name)
    {
        ArrayList<String> posts = new ArrayList<String>();
        getPosts(name, root, posts);
        return posts;
    }

    private void getPosts(String name, BinaryTreeNode root, ArrayList<String> posts) {
        if(root == null)
            return;
        Account acc = new Account((String) root.data);
        if(acc.getName().equals(name))
        {
            posts.add(root.data);
        }
        getPosts(name, root.left, posts);
        getPosts(name, root.right, posts);
    }

}

class BinaryTree<dataType>
{
    BinaryTreeNode<dataType> root;

    public BinaryTree ()
    {
        root = null;
    }

    public int getHeight ()
    {
        return getHeight (root);
    }
    public int getHeight ( BinaryTreeNode<dataType> node )
    {
        if (node == null)
            return -1;
        else
            return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
    }

    public int getSize ()
    {
        return getSize (root);
    }
    public int getSize ( BinaryTreeNode<dataType> node )
    {
        if (node == null)
            return 0;
        else
            return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
    }

    public void visit ( BinaryTreeNode<dataType> node )
    {
        System.out.println (node.data);
    }

    public void preOrder ()
    {
        preOrder (root);
    }
    public void preOrder ( BinaryTreeNode<dataType> node )
    {
        if (node != null)
        {
            visit (node);
            preOrder (node.getLeft ());
            preOrder (node.getRight ());
        }
    }

    public void postOrder ()
    {
        postOrder (root);
    }
    public void postOrder ( BinaryTreeNode<dataType> node )
    {
        if (node != null)
        {
            postOrder (node.getLeft ());
            postOrder (node.getRight ());
            visit (node);
        }
    }

    public void inOrder ()
    {
        inOrder (root);
    }
    public void inOrder ( BinaryTreeNode<dataType> node )
    {
        if (node != null)
        {
            inOrder (node.getLeft ());
            visit (node);
            inOrder (node.getRight ());
        }
    }

    public void levelOrder ()
    {
        if (root == null)
            return;
        BTQueue<dataType> q = new BTQueue<dataType> ();
        q.enQueue (root);
        BinaryTreeNode<dataType> node;
        while ((node = q.getNext ()) != null)
        {
            visit (node);
            if (node.getLeft () != null)
                q.enQueue (node.getLeft ());
            if (node.getRight () != null)
                q.enQueue (node.getRight ());
        }
    }
}


