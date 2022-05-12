package tree;

public class Tree {

    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public Tree insert(int value) {
        if (value < this.value) {
            if (left == null) {
                Tree newBST = new Tree(value);
                left = newBST;
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                Tree newBST = new Tree(value);
                right = newBST;
            } else {
                right.insert(value);
            }
        }
        return this;
    }

    public boolean contains(int value) {
        if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else if (value > this.value) {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        } else {
            return true;
        }
    }

    public Tree remove(int value) {
        remove(value, null);
        return this;
    }

    public void remove(int value, Tree parent) {
        if (value < this.value) {
            if (left != null) {
                left.remove(value, this);
            }
        } else if (value > this.value) {
            if (right != null) {
                right.remove(value, this);
            }
        } else {
            if (left != null && right != null) {
                this.value = right.getMinValue();
                right.remove(this.value, this);
            } else if (parent == null) {
                if (left != null) {
                    this.value = left.value;
                    right = left.right;
                    left = left.left;
                } else if (right != null) {
                    this.value = right.value;
                    left = right.left;
                    right = right.right;
                } else {
                    // This is a single-node tree; do nothing.
                }
            } else if (parent.left == this) {
                parent.left = left != null ? left : right;
            } else if (parent.right == this) {
                parent.right = left != null ? left : right;
            }
        }
    }

    public int getMinValue() {
        if (left == null) {
            return this.value;
        } else {
            return left.getMinValue();
        }
    }
}