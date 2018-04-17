package testManyToOne;

import org.junit.Test;

public class ErFenFaPaiXu {
    public static void main(String[] args) {
        /*
        * 二分法插入排序是在插入第i个元素时，对前面的0～i-1元素进行折半，
        * 先跟他们中间的那个元素比，
        * 如果查找的值比中间的值小，则对前半再进行折半，否则查找的值比中间的值大对后半进行折半，直到left<right，
        * 然后再把第i个元素前1位与目标位置之间的所有元素后移，再把第i个元素放在目标位置上。
        * */
        int[] arr = { 0, 49, 38, 65, 97, 76, 13, 27 };
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int low = 0, high = i - 1;
                int mid = -1;
                while (low <= high) {
                    mid = low + (high - low) / 2;
                    if (arr[mid] > temp) {
                        high = mid - 1;
                    } else { // 元素相同时，也插入在后面的位置
                        low = mid + 1;
                    }
                }
                for(int j = i - 1; j >= low; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[low] = temp;
            }
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]+">>>>>>");
            }
        }
}
