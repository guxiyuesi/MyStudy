

package BinarySearch_1;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearch {
    public static int rank(int k, ArrayList<Integer> a) {
        int length = a.size();
        int lo = 0;
        int hi = length - 1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(a.get(mid) > k) hi = mid - 1;
            else if(a.get(mid) < k) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> arrW = new ArrayList<Integer>();

        /** 将tinyAllowlist.txt中的数据读入arrW数组中
         * */
        Scanner sc = new Scanner(new File("tinyAllowlist.txt"));
        while(sc.hasNext()) {
            if(sc.hasNextInt()) {
                arrW.add(sc.nextInt());
            }
            else {
                sc.next();
            }
        }

        ArrayList<Integer> arrT = new ArrayList<>();
        /** 将tinyText.txt中的数据读入arrT数组中
         * */
        Scanner scT = new Scanner(new File("tinyText.txt"));
        while(scT.hasNext()) {
            if(scT.hasNextInt()) {
                arrT.add(scT.nextInt());
            }
            else {
                scT.next();
            }
        }
        /** 二分查找的对象必须是有序数组
         *      Comparator.naturalOrder()     指定元素升序排序
         *      Comparator.reverseOrder()     指定元素降序排序
         * */
        arrT.sort(Comparator.naturalOrder());

        /** 如果arrW中的数据不在arrT中, 则输出该数据
         *
         * 白名单过滤:
         *  1. 将客户的账号保存在一个文件中, 称其为白名单
         *  2. 从标准输入中得到每笔交易的账号
         *  3. 使用测试用例在标准输出中打印所有与客户无关的账户
         * */
       for (int i = 0; i < arrW.size(); i++) {
            if(rank(arrW.get(i), arrT) < 0) System.out.println(arrW.get(i));
        }
    }
}
