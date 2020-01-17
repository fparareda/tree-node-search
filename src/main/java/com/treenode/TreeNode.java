package com.treenode;

public class TreeNode {
    TreeNode parent;

    public TreeNode(TreeNode parent) {
        this.parent = parent;
    }

    TreeNode findFirstCommonAncestor(TreeNode other) {
        assert other != null;
        if(other.getParent() == null && parent == null) {
            throw new RuntimeException("This TreeNode does not exist or does not have ancestors");
        }

        assert other.getParent() != null;
        if(other.getParent().equals(parent)) {
            return parent;
        }
        return recursiveAncestor(this, other);
    }

    private TreeNode recursiveAncestor(TreeNode treeNode, TreeNode other) {
        TreeNode treeNodeAncestor = recursiveAncestorOfNode(treeNode, other);
        if(treeNodeAncestor == null) {
            return recursiveAncestorOfNode(treeNode, other.getParent());
        }
        return treeNodeAncestor;
    }

    TreeNode recursiveAncestorOfNode(TreeNode treeNode, TreeNode treeNodeToCompare) {
        if(treeNode == null || treeNodeToCompare == null) {
            return null;
        }
        if(treeNode.equals(treeNodeToCompare.getParent())) {
            return treeNode;
        }
        return recursiveAncestorOfNode(treeNode.getParent(), treeNodeToCompare);
    }


    TreeNode getParent() {
        return parent;
    }
}
