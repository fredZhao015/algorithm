import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.io.File;


public class Main {
    //日志类
    public static Logger logger = Logger.getLogger(Main.class);

    public  static  void  main(String[] args){
        /*
        HelloWorld hello = new HelloWorld();
        hello.setName("Spring boot, I come!");
        hello.sayHello();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
        hello.setName("Spring boot, I come here!");
        hello.sayHello();

        /**
         * 通用排序算法测试
         */
        final int SORTARGNUM = 8;
        int i=0, rows=0, delta=500,  maxCourrent=100000;
        String[][]  sortdata = new String[maxCourrent/delta+1][SORTARGNUM+1];
        sortdata[rows++]= new String[]{"sample","SelectionSort","InsertionSort","ShellSort","MergeSort","QuickSort","HeapSort","RadixSort","Javasort"};
        for(i=delta;i<=maxCourrent; i+= delta ){
            sortdata[rows++] = executeSort(i);;
        }
        String[][]  csvdata = new String[SORTARGNUM+1][maxCourrent/delta+1];
        for( rows=0 ; rows<sortdata.length; rows++){
            for(i=0; i<sortdata[rows].length; i++){
                csvdata[i][rows] = sortdata[rows][i];
            }
        }


        try {
            File csv = new File("sortdata.csv"); // CSV文件
            // 追记模式
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            for(i=0;i<csvdata.length;i++){
                // 新增一行数据
                bw.write(String.join(",", csvdata[i]));
                bw.newLine();
                System.out.println(String.join(",", csvdata[i]));
            }
            bw.close();
        } catch (FileNotFoundException e) {
            // 捕获File对象生成时的异常
            e.printStackTrace();
        } catch (IOException e) {
            // 捕获BufferedWriter对象关闭时的异常
            e.printStackTrace();
        }
    }


    public static String[] executeSort(int sampleSize){
        int  cnt = 0;
        long startTime = 0, endTime = 0;
        final int SORTARGNUM = 8;
        final int MAXLENGTH = sampleSize;
        String[] costtime = new String[SORTARGNUM+1] ;
        costtime[cnt++] = String.valueOf(sampleSize);

        GenericSort sort = new GenericSort();
        Random random = new Random();
        //Integer[] array = new Integer[] { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7, 15, 13, 12, 20, 19, 18, 25, 23, 28, 27, 21,24 };
        Integer[] array = new Integer[MAXLENGTH];
        for(int i=0; i< MAXLENGTH; i++){
            array[i] = random.nextInt(MAXLENGTH);
        }

        System.out.println("****************************************************************************");
        Integer[] array1 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array1,0,array.length);
        logger.info("Before SelectionSort:");
        logger.info(Arrays.toString(array1));
        startTime = System.currentTimeMillis();
        sort.SelectionSort(array1);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  SelectionSort:");
        logger.info(Arrays.toString(array1));
        System.out.println("样本数："+sampleSize+"，选择排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

/*
        System.out.println("****************************************************************************");
        Integer[] array2 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array2,0,array.length);
        logger.info("Before BubbleSort:");
        logger.info(Arrays.toString(array2));
        startTime = System.currentTimeMillis();
        sort.BubbleSort(array2);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  BubbleSort:");
        logger.info(Arrays.toString(array2));
        System.out.println("冒泡排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");
*/


        System.out.println("****************************************************************************");
        Integer[] array3 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array3,0,array.length);
        logger.info("Before InsertionSort:");
        logger.info(Arrays.toString(array3));
        startTime = System.currentTimeMillis();
        sort.InsertionSort2(array3);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  InsertionSort:");
        logger.info(Arrays.toString(array3));
        System.out.println("样本数："+sampleSize+"，插入排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array4 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array4,0,array.length);
        logger.info("Before ShellSort:");
        logger.info(Arrays.toString(array4));
        startTime = System.currentTimeMillis();
        sort.ShellSort(array4);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  ShellSort:");
        logger.info(Arrays.toString(array4));
        System.out.println("样本数："+sampleSize+"，希尔排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array5 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array5,0,array.length);
        logger.info("Before MergeSort:");
        logger.info(Arrays.toString(array5));
        startTime = System.currentTimeMillis();
        sort.MergeSort(array5,0, array5.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  MergeSort:");
        logger.info(Arrays.toString(array5));
        System.out.println("样本数："+sampleSize+"，归并排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array6 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array6,0,array.length);
        logger.info("Before QuickSort:");
        logger.info(Arrays.toString(array6));
        startTime = System.currentTimeMillis();
        sort.RandQuickSort(array6,0, array6.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  QuickSort:");
        logger.info(Arrays.toString(array6));
        System.out.println("样本数："+sampleSize+"，快速排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

        System.out.println("****************************************************************************");
        Integer[] array7 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array7,0,array.length);
        logger.info("Before HeapSort:");
        logger.info(Arrays.toString(array7));
        startTime = System.currentTimeMillis();
        sort.HeapSort(array7);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  HeapSort:");
        logger.info(Arrays.toString(array7));
        System.out.println("样本数："+sampleSize+"，堆排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array8 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array8,0,array.length);
        logger.info("Before RadixSort:");
        logger.info(Arrays.toString(array8));
        startTime = System.currentTimeMillis();
        sort.RadixSort(array8);
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  RadixSort:");
        logger.info(Arrays.toString(array8));
        System.out.println("样本数："+sampleSize+"，基数排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        logger.info("Before Javasort:");
        logger.info(Arrays.toString(array));
        startTime = System.currentTimeMillis();
        Collections.sort(Arrays.asList(array));
        endTime = System.currentTimeMillis();   //获取结束时间
        costtime[cnt++] = String.valueOf(endTime-startTime);
        logger.info("After  Javasort:");
        logger.info(Arrays.toString(array));
        System.out.println("样本数："+sampleSize+"，JAVA自带排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

        return costtime;
    }
}
