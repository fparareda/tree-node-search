package com.treenode;

import gherkin.lexer.Ru;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {

    @Test(expected = RuntimeException.class)
    public void given_treenode_without_parent() {
        TreeNode treeNode = new TreeNode(null);
        TreeNode treeNode2 = new TreeNode(null);

        treeNode.findFirstCommonAncestor(treeNode2);
    }

    @Test
    public void given_treenode_with_the_same_parent() {
        TreeNode treeNode = new TreeNode(null);
        TreeNode treeNodeChild1 = new TreeNode(treeNode);
        TreeNode treeNodeChild2 = new TreeNode(treeNode);

        assertEquals(treeNodeChild1.findFirstCommonAncestor(treeNodeChild2), treeNode);
    }

    @Test
    public void given_treenode_with_three_levels_to_check() {
        TreeNode treeNodeWithGrandTreeNode = new TreeNode(null);
        TreeNode treeNodeWithParentTreeNode = new TreeNode(treeNodeWithGrandTreeNode);
        TreeNode treeNodeWithParentTreeNode2 = new TreeNode(treeNodeWithGrandTreeNode);
        TreeNode treeNodeToCheck = new TreeNode(treeNodeWithParentTreeNode);

        assertEquals(treeNodeToCheck.findFirstCommonAncestor(treeNodeWithParentTreeNode2), treeNodeWithGrandTreeNode);
    }

    @Test
    public void given_treenode_with_three_levels_with_two_levels_each_child_to_check() {
        TreeNode treeNodeWithGrandTreeNode = new TreeNode(null);
        TreeNode treeNodeWithParentTreeNode = new TreeNode(treeNodeWithGrandTreeNode);
        TreeNode treeNodeWithParentTreeNode2 = new TreeNode(treeNodeWithGrandTreeNode);
        TreeNode treeNodeToCheck = new TreeNode(treeNodeWithParentTreeNode);
        TreeNode treeNodeToCompare = new TreeNode(treeNodeWithParentTreeNode2);

        assertEquals(treeNodeToCheck.findFirstCommonAncestor(treeNodeToCompare), treeNodeWithGrandTreeNode);
    }
}
