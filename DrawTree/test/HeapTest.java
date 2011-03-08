import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *  1.root is smallest: 12,20,15->root->12,left->20,right->15
   12
   |
+--+--+
|     |
20    15
 *  2.children node is also heap: 12,20,15,29,23->root->12,,left->20,right->15,left-left->29,left-right->23
        12
        |
   +----+----+
   |         |
   20        15
   |
+--+--+
|     |
29    23
 *  3.insert 17: 12,20,15,29,23->root->12,left->20,right->15,left-left->29,left-right->23,right-left->17
        12
        |
   +----+----+
   |         |
   20        15
   |         |
+--+--+   +--+
|     |   |
29    23  17
 *  4.insert 13: 12,20,15,29,23->root->12,left->20,right->13,left-left->29,left-right->23,right-left->15
        12
        |
   +----+----+
   |         |
   20        13
   |         |
+--+--+   +--+--+
|     |   |     |
29    23  17    15
 *  5.extract: root->13,left->20,right->15,left-left->29,left-right->23,right-left->17
        13
        |
   +----+----+
   |         |
   20        15
   |         |
+--+--+   +--+
|     |   |
29    23  17
 */
public class HeapTest {
    @Test
    public void should_print_simple_tree(){
        String treeString = new Heap(new int[]{12, 20, 15}).toString();
        String expectedString =
                "   12\n" +
                "   |\n" +
                "+--+--+\n" +
                "|     |\n" +
                "20    15\n";
        assertEquals(expectedString,treeString);
    }

//    @Test
    public void should_print_tree_with_three_layer(){
        String treeString = new Heap(new int[]{12,20,15,29,23}).toString();
        String expectedString =
                "        12\n" +
                "        |\n" +
                "   +----+----+\n" +
                "   |         |\n" +
                "   20        15\n" +
                "   |\n" +
                "+--+--+\n" +
                "|     |\n" +
                "29    23\n";
        assertEquals(expectedString,treeString);
    }
}
