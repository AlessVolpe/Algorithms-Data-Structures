package EsameAprile18.JavaAux;

public class BST{

    private BinNode root;

    public BST() {
        this.root = null;
    }

    public BinNode getRoot(){
        return root;
    }

    public void print(BinNode t, int level, char pos) {
        if (t==null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" "+pos+":--");
        }

        System.out.println(t.getKey());

        print(t.getLeft(), level + 1,'l');
        print(t.getRight(), level + 1,'r');
    }
    public void BST_print(){
        if (root!=null)
            print(this.root, 0,' ');
    }

    public BinNode insert_AUX(BinNode node, int key) {
        if (node == null) 
            return new BinNode(key);

        if (key < node.getKey()) 
            node.setLeft(insert_AUX(node.getLeft(), key));
        else if (key > root.getKey())
            node.setRight(insert_AUX(node.getRight(), key));

        return node;
    }

    public BinNode findNode(BinNode node, int key) {
        if (node == null || node.getKey() == key) 
            return node;
        
        if (key < node.getKey()) 
            return findNode(node.getLeft(), key);

        return findNode(node.getRight(), key);
    }

    public BinNode BST_insert(int k) {
        this.root = insert_AUX(getRoot(), k);
        return findNode(this.root, k);
    }

    static int maxValue(BinNode node) {
        if (node == null) 
            return Integer.MIN_VALUE;

        int value = node.getKey(),
            leftMax = maxValue(node.getLeft()),
            rightMax = maxValue(node.getRight());

        return Math.min(value, Math.min(leftMax, rightMax));
    }

    static int minValue(BinNode node) {
    if (node == null) 
        return Integer.MAX_VALUE;

    int value = node.getKey(),
        leftMax = minValue(node.getLeft()),
        rightMax = minValue(node.getRight());
 
    return Math.min(value, Math.min(leftMax, rightMax));
  }

    public int checkOrder(BinNode node) {
        if (node == null) 
            return 1;

        int nodeKey = node.getKey();
        // System.out.println("Currently checking node with key: " + nodeKey);
    
        if (node.getLeft() != null && maxValue(node.getLeft()) > nodeKey)
            return 0;
        if (node.getRight() != null && minValue(node.getRight()) < nodeKey)
            return 0;
        if (checkOrder(node.getLeft()) != 1 || checkOrder(node.getRight()) != 1)
            return 0;

        return 1;
    }

    public int isBST() {
        return checkOrder(getRoot());
    }

    public int getHeight(BinNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public int isBalanced(BinNode node) {
        if (node == null)
            return 1;
        
        int leftHeight = getHeight(node.getLeft()),
            rightHeight = getHeight(node.getRight());
        
        if (Math.abs(leftHeight - rightHeight) > 1)
            return 0;
        if (isBalanced(node.getLeft()) != isBalanced(node.getRight()))
            return 0;

        return 1;
    }

    public int isBalanced() {
        return isBalanced(getRoot());
    }



}
