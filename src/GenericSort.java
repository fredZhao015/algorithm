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
            //System.out.println("p="+p+", q="+q+", r="+r+", k="+k+", array[k]="+array[k]);
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
}


