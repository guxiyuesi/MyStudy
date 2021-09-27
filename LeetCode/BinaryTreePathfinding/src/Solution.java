import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *               01
 *            11    10
 *        100  101 110 111
 *   1111 1110       1001 1000
 *   对于正常二叉树来说, 子节点的二进制的末位对应的是在该节点的左边还是右边
 *   尽管之字形二叉树打乱了左右顺序, 但是对于同一个父节点来说, 子节点的末位都是相同的
 * */
public class Solution {
    public static void main(String[] args) {
        pathInZigZagTree(14);
    }
    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        list.add(label);
        while (label != 1) {
            label >>= 1;
            //System.out.println( (int)Math.pow(2, (int)(Math.log(label)/Math.log(2))));
            label = label ^(1 << (Integer.toBinaryString(label).length() - 1)) - 1;
            list.add(0, label);
        }
        return list;
    }


}
