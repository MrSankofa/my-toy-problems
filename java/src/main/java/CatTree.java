

public class CatTree {
    String value;
    CatTree left = null, right = null;


    static boolean isCatFamily(CatTree catTree, String value) {
       return dfs(catTree, value);
    }

    static boolean dfs(CatTree catTree, String targetColor) {
        if(catTree == null) return false;

        dfs(catTree.left, targetColor);
        dfs(catTree.right, targetColor);

        return false;
    }

}
