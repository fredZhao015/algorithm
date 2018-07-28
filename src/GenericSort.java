import java.util.ArrayList;
import java.util.Random;

public class GenericSort
{
    /// <summary>
    /// 选择排序
    /// </summary>
    /// <param name="array"></param>
    public static <T extends Comparable<? super T>> void SelectionSort(T[] array){
        int n=array.length;
        for(int i=0;i<n; i++)
        {
            int min=i;
            //从第i+1个元素开始，找最小值
            for(int j=i+1;j<n; j++)
            {
                if(array[min].compareTo(array[j])>0) {
                    min = j;
                }
            }
            //找到之后和第i个元素交换
            if(min!=i) {
                Swap(array, i, min);
            }
        }

    }

    /// <summary>
    /// 插入排序
    /// </summary>
    /// <param name="array"></param>
    public static <T extends Comparable<? super T>> void InsertionSort(T[] array){
        int i=0, j=0;
        int n = array.length;
        //从第二个元素开始
        for (i=1; i<n; i++){
            //从第i个元素开始
            for (j=i; j>0; j--){
                //一次和前面已经排好序的i-1个元素比较，如果小于，则交换
                if(array[j].compareTo(array[j-1])<0){
                    Swap(array,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

        /// <summary>
        /// 插入排序优化
        /// </summary>
        /// <param name="array"></param>
        public static <T extends Comparable<? super T>> void InsertionSort2(T[] array){
            int i=0, j=0;
            int n = array.length;
            T key ;
            for (i=1; i<n; i++){
                key = array[i];
                for (j=i-1; j>=0; j--){
                    if(key.compareTo(array[j])<0){
                        array[j+1] = array[j];
                    }else{
                        break;
                    }
                }
                //找到之后和第i个元素交换
                array[j+1] = key;
            }
        }

    /// <summary>
    /// 希尔排序
    /// </summary>
    /// <param name="array"></param>
    public static <T extends Comparable<? super T>> void ShellSort(T[] array)
    {
        int n = array.length;
        int h = 1;
        //初始最大步长
        while (h < n/3) h = h * 3 + 1;
        while (h >= 1)
        {
            //从第二个元素开始
            for (int i = 1; i < n; i++)
            {
                //从第i个元素开始，依次次和前面已经排好序的i-h个元素比较，如果小于，则交换
                for (int j = i; j >= h; j = j - h)
                {
                    if (array[j].compareTo(array[j - h]) < 0)
                    {
                        Swap(array, j, j - h);
                    }
                    else //如果大于，则不用继续往前比较了，因为前面的元素已经排好序，比较大的大就是教大的了。
                        break;
                }
            }
            //步长除3递减
            h = h / 3;
        }
    }


    /// <summary>
    /// 归并排序算法
    /// </summary>
    /// <param name="array"></param>
    /// <param name="p"></param>
    /// <param name="r"></param>
    public static <T extends Comparable<? super  T>> void MergeSort(T[] array, int p, int r){
        if(p<r) {
            int q = (p + r) / 2;
            MergeSort(array, p, q);
            MergeSort(array,q+1, r);
            Merge(array,p,q,r);
        }
    }
    ///合并操作
    public static <T extends Comparable<? super T>> void Merge(T[] array, int p, int q, int r){
        int i=0, j=0, k=0 ;
        int n1 = q - p + 1;
        int n2 = r - q;
        ArrayList<T> leftArray  = new ArrayList<T>();
        ArrayList<T> rightArray = new ArrayList<T>();
        for(i=0; i<n1; i++){
            leftArray.add(i, array[p+i]);
        }
        leftArray.add(n1,null);
        for(j=0; j<n2; j++){
            rightArray.add(j, array[q+j+1]);
        }
        rightArray.add(n2,null);

        //合并左右两个子数组
        T litem, ritem;
        for(i=0,j=0,k=p; k<=r; k++){
            litem = leftArray.get(i);
            ritem = rightArray.get(j);
            if(litem!=null ){
                if(ritem!=null){
                    if(litem.compareTo(ritem)<=0){
                        array[k] = litem;
                        i++;
                    }else{
                        array[k] = ritem;
                        j++;
                    }
                }else{
                    array[k] = litem;
                    i++;
                }
            }else{
                if(ritem!=null) {
                    array[k] = ritem;
                    j++;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * @param array  待排序数组
     */
    public static <T extends Comparable<? super T>>  void BubbleSort(T[] array){
        for (int i = array.length-1; i > 0; i--) {      //外层循环移动游标
            for(int j = 0; j < i ; j++){    //内层循环遍历游标及之后(或之前)的元素
                if (array[j].compareTo(array[j+1]) > 0)
                    if(array[j].compareTo(array[j+1]) > 0){
                    Swap(array,j,j+1);
                    }
            }
        }
    }

    /// <summary>
    /// 快速排序算法
    /// </summary>
    /// <param name="array"></param>
    /// <param name="p"></param>
    /// <param name="r"></param>
    public static <T extends Comparable<? super T>> void QuickSort(T[] array, int p, int r){
        if(p<r){
            int q = Partition(array,p,r);
            QuickSort(array, p, q-1);
            QuickSort(array,q+1,r);
        }
    }

    ///划分
    public static <T extends Comparable<? super T>> int Partition(T[] array, int p, int r){
        int q = r ;
        T paviot = array[r];
        for(int  i=r-1; i>=p; i--){
            if (array[i].compareTo(paviot) > 0){
                array[q--] = array[i];
                array[i] = array[q];
            }
        }
        array[q] = paviot;
        return q;
    }

    ///快速排序随机版
    public static <T extends Comparable<? super T>> void RandQuickSort(T[] array, int p, int r){
        if(p<r){
            int q = RandPartition(array,p,r);
            RandQuickSort(array, p, q-1);
            RandQuickSort(array,q+1,r);
        }
    }

    ///随机划分
    public static <T extends Comparable<? super T>> int RandPartition(T[] array, int p, int r){
        Random rand = new Random();
        int i = rand.nextInt(r-p+1) + p;
        Swap(array,i,r);
        return Partition(array,p,r);
    }

    /**
     * 快速排序2
     *
     * @param array
     * @param low
     * @param high
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void QuickSort2(T[] array, int low, int high){
        int i=low;
        int j=high;

        if (low < high){
            T key=array[low];
            while(i<j){ // 此处的while循环结束，则完成了元素key的位置调整
                while(i<j && array[j].compareTo(key)>=0){
                    j--;
                }
                array[i]=array[j];
                while(i<j && array[i].compareTo(key)<=0){
                    i++;
                }
                array[j]=array[i];
                array[i]=key;  //此处不可遗漏
            }
            QuickSort2(array,low,i-1);
            QuickSort2(array,i+1,high);
        }
    }

    /// <summary>
    /// 堆排序算法
    /// </summary>
    /// <param name="array"></param>
    public static <T extends Comparable<? super T>> void HeapSort(T[] array){
        //1.构建大顶堆
        for(int i = array.length/2-1; i>=0; i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            AdjustMaxHeap(array, i, array.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=array.length-1;j>0;j--){
            Swap(array,0,j);//将堆顶元素与末尾元素进行交换
            AdjustMaxHeap(array,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param array
     * @param i
     * @param length
     */
    public static <T extends Comparable<? super T>> void AdjustMaxHeap(T[]array, int i, int length){
        T temp = array[i];//先取出当前元素i
        for(int k=i*2+1; k<length; k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && array[k].compareTo(array[k+1])<0 ){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if( array[k].compareTo(temp)>0 ){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[k];
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        array[i] = temp;
    }

    /// <summary>
    /// 元素交换
    /// </summary>
    /// <param name="array"></param>
    /// <param name="i"></param>
    /// <param name="min"></param>
    private static <T extends Comparable<? super T>>  void Swap(T[] array, int i, int min) {
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
    }


    /**
     * 基数排序（LSD 从低位开始）
     *
     * 基数排序适用于：
     *  (1)数据范围较小，建议在小于1000
     *  (2)每个数值都要大于等于0
     *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     * @param arr	 待排序数组
     */
    public static void RadixSort(Integer[] arr){
        if(arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while(max / 10 > 0){
            maxDigit++;
            max = max / 10;
        }
        //System.out.println("maxDigit: " + maxDigit);

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for(int i = 0; i < maxDigit; i++){
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for(int j = 0; j < arr.length; j++){
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for(int b = 0; b < buckets.length; b++){
                for(int p = 0; p < bktLen[b]; p++){
                    arr[k++] = buckets[b][p];
                }
            }

            //System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }

}


