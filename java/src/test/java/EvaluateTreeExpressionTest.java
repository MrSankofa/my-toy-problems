import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateTreeExpressionTest {

  // add another test

  @Test
  void evaluateExpressionTree() {

    Tree tree = new Tree(-1);
    tree.right = new Tree(-3);
    tree.left = new Tree(-2);

    tree.right.left = new Tree(8);
    tree.right.right = new Tree(3);

    tree.left.left = new Tree(-4);
    tree.left.right = new Tree(2);
    tree.left.left.left = new Tree(2);
    tree.left.left.right = new Tree(3);

    assertEquals(6, EvaluateTreeExpression.evaluateExpressionTree(tree));
  }
}
