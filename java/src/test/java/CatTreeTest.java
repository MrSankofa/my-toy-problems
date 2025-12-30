import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CatTreeTest {

    @Test
    void findsTrueChildCase() {

        CatTree catTree = new CatTree();
        catTree.left = new CatTree();
        catTree.right = new CatTree();
        catTree.left.left = new CatTree();
        catTree.left.right = new CatTree();
        catTree.right.left = new CatTree();

        catTree.value = "white";
        catTree.left.value = "black-white";
        catTree.left.left.value = "black-white-orange";
        catTree.left.right.value = "black-white-green";
        catTree.right.value = "white-brown";
        catTree.right.left.value = "white-brown-red";

        String targetColor = "white-brown-red-blue";


        assertTrue(CatTree.isColorADescendent(catTree, targetColor));
    }
}