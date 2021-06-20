import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PostOrderTraversalTest {

	@Test
	public void test() {
		TreeNode root = TreeNode.create();
		PostOrderTraversal test = new PostOrderTraversal();
		var result = test.postorderTraversal(root);
		assertArrayEquals(new Integer[] { 4, 5, 2, 6, 3, 1 }, result.toArray(new Integer[] {}));
	}
}
