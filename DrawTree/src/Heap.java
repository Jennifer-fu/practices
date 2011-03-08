import java.nio.ShortBuffer;

public class Heap    {
    private int[] nodes;

    public Heap(int[] nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        StringBuffer heapString = new StringBuffer();
        int height = (int)(Math.log(nodes.length) / Math.log(2));
        for(int i = 0; i< height;i++){
            int level = i==0?0:(int)(Math.log(i) / Math.log(2))+1;
            heapString.append(printSimpleTree(new int[]{nodes[i],nodes[2*i+1],nodes[2*i+2]},height, level));
        }
        return heapString.toString();
    }

    private String printSimpleTree(int[] tree,int height,int level) {
        StringBuffer treeString = new StringBuffer();
        int connectorNumber = 2*(height-level);
        int spaceNumber = countSpaceNumber(height,level);
        treeString.append(print(" ",spaceNumber)).append(tree[0]).append("\n");
        treeString.append(print(" ",spaceNumber)).append("|\n");
        treeString.append(print(" ",spaceNumber-connectorNumber-1)).append("+").append(print("-",connectorNumber)).append("+").append(print("-",connectorNumber)).append("+\n");
        treeString.append(print(" ",spaceNumber-connectorNumber-1)).append("|").append(print(" ",2*connectorNumber+1)).append("|\n");
        treeString.append(print(" ",spaceNumber-connectorNumber-1)).append(tree[1]).append(print(" ",2*connectorNumber)).append(tree[2]).append("\n");
        return treeString.toString();
    }

    private int countSpaceNumber(int height, int level) {
        int count =0;
        for(int i=height;i>level;i--){
            count += (2*(height-i+1)+1);
        }
        return count;
    }

    private String print(String content,int number){
        StringBuffer contents = new StringBuffer();
        for(int i = 0; i< number;i++){
            contents.append(content);
        }
        return contents.toString();
    }
}
