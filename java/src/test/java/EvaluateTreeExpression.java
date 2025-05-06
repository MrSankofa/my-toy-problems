import com.sun.source.tree.BinaryTree;

class Tree {
  int value;
  Tree left = null;
  Tree right = null;

  public Tree(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }


}

public class EvaluateTreeExpression {

  public static int evaluateExpressionTree(Tree tree) {
    if (tree == null) {
      return 0; // Return 0 for null nodes (although this case shouldn't happen if the tree is valid)
    }

    // Base case: If the node is a leaf, return its value
    if (tree.left == null && tree.right == null) {
      return tree.value;
    }

    // Recursive case: Evaluate the left and right subtrees
    int leftValue = evaluateExpressionTree(tree.left);   // Evaluate left subtree
    int rightValue = evaluateExpressionTree(tree.right); // Evaluate right subtree

    // Perform the operation based on the current node's value
    switch (tree.value) {
      case -1: // Addition
        return leftValue + rightValue;
      case -2: // Subtraction
        return leftValue - rightValue;
      case -3: // Division (round towards zero)
        return (int) Math.floorDiv(leftValue, rightValue);  // Use floorDiv for integer division in Java
      case -4: // Multiplication
        return leftValue * rightValue;
      default:
        throw new IllegalArgumentException("Invalid operator value");
    }
  }
}
