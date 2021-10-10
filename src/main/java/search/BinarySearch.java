package search;

import java.util.List;

import static algo.sort.Util.getItemsToSort;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> items = getItemsToSort(100);
        BinaryTree tree = new BinaryTree();
        items.forEach(item -> tree.add(item));
        BinaryTree.TreeNode node = tree.search(items.get(34));
        System.out.println(node);
    }

    private static class BinaryTree {

        private TreeNode root;

        private static class TreeNode {
            private int value;
            TreeNode left;
            TreeNode right;

            TreeNode(int value) {
                this.value = value;
            }
        }

        void add(int item) {
            root = insert(root, new TreeNode(item));
        }

        TreeNode search(int value) {
            return search(root, value);
        }

        void delete(int value) {
            root = delete(root, value);
        }

        private TreeNode delete(TreeNode subroot, int value) {
            if (subroot.left != null && subroot.left.value == value) {
                if (subroot.left.left == null) {
                    subroot.left = subroot.left.right;
                } else if (subroot.left.right == null) {
                    subroot.left = subroot.left.left;
                } else {
                    TreeNode min = findMin(subroot.left.right);
                    delete(subroot.left.right, min.value);
                }
            }
            if (subroot.right != null && subroot.right.value == value) {
                if (subroot.right.left == null) {
                    subroot.right = subroot.right.right;
                } else if (subroot.right.right == null) {
                    subroot.right = subroot.right.left;
                } else {
                    TreeNode min = findMin(subroot.right.right);
                    delete(subroot.right.right, min.value);
                    subroot.right = min;
                    min.left =
                }
            }
        }

        private TreeNode findMin(TreeNode subroot) {
            if(subroot.left == null) return subroot;
            return findMin(subroot.left);
        }

        private TreeNode search(TreeNode subroot, int value) {
            if (subroot.value == value) {
                return subroot;
            }
            if (subroot.value > value) {
                return search(subroot.left, value);
            }
            if (subroot.value < value) {
                return search(subroot.right, value);
            }
            return null;
        }

        private TreeNode insert(TreeNode subroot, TreeNode item) {
            if (subroot == null) {
                subroot = item;
            } else {
                if (item.value <= subroot.value) {
                    subroot.left = insert(subroot.left, item);
                }
                if (item.value > subroot.value) {
                    subroot.right = insert(subroot.right, item);
                }
            }
            return subroot;
        }
    }


}
