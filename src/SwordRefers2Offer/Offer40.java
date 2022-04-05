package SwordRefers2Offer;

import java.util.Arrays;

/**
 * @ClassName Offer40.最小的k个数
 * @Description
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @Author 黄景棠
 * @Update 2021/12/16 下午 4:28
 * @Since
 * @Version 1.0
 **/
public class Offer40 {

    //滑动窗口实现前K个数
    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length==0) return arr;

        for (int i=k;i<arr.length;i++)
        {
            for (int j=0;j<k;j++)
            {
                if (arr[i]>=arr[j]) continue;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        return Arrays.copyOf(arr,k);

    }


    //快排实现前K个数
    public int[] getLeastNumbersByQuickSort(int[] arr, int k){

        if (k>=arr.length) return arr;

        return quickSort(arr,k,0,arr.length);

    }

    public int[] quickSort(int[] arr,int k,int left,int right){


        int num = arr[left];
        int l = left;
        int r = right;
        while (l<r)
        {
            while (arr[++l]<=num) if (l>=right-1) break;
            while(arr[--r]>=num)    if (r<=left) break;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        arr[left] = arr[l];
        arr[l] = num;

        if (l<k) return quickSort(arr,k,l+1,right);
        if (l>k) return quickSort(arr,k,left,l);

        return Arrays.copyOf(arr,k);



    }

    public static void main(String[] args) {
        Offer40 o = new Offer40();
        int[] arr = {0,1,2,1};
        int k= 1;
        int[] res = o.getLeastNumbersByQuickSort(arr,1);
        for (int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }

}

