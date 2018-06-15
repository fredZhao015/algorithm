import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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
        final int MAXLENGTH = 50000;
        GenericSort sort = (GenericSort) context.getBean("genericSort");
        Random random = new Random();
        //Integer[] array = new Integer[] { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7, 15, 13, 12, 20, 19, 18, 25, 23, 28, 27, 21,24 };
        Integer[] array = new Integer[MAXLENGTH];
        for(int i=0; i< MAXLENGTH; i++){
            array[i] = random.nextInt(100000);
        }


        long startTime = 0, endTime = 0;
        System.out.println("****************************************************************************");
        Integer[] array1 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array1,0,array.length);
        logger.info("Before SelectionSort:");
        logger.info(Arrays.toString(array1));
        startTime = System.currentTimeMillis();
        sort.SelectionSort(array1);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  SelectionSort:");
        logger.info(Arrays.toString(array1));
        System.out.println("选择排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

        System.out.println("****************************************************************************");
        Integer[] array2 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array2,0,array.length);
        logger.info("Before InsertionSort:");
        logger.info(Arrays.toString(array2));
        startTime = System.currentTimeMillis();
        sort.InsertionSort(array2);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  InsertionSort:");
        logger.info(Arrays.toString(array2));
        System.out.println("插入排序算法1运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array3 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array3,0,array.length);
        logger.info("Before InsertionSort2:");
        logger.info(Arrays.toString(array3));
        startTime = System.currentTimeMillis();
        sort.InsertionSort2(array3);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  InsertionSort2:");
        logger.info(Arrays.toString(array3));
        System.out.println("插入排序算法2运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array4 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array4,0,array.length);
        logger.info("Before ShellSort:");
        logger.info(Arrays.toString(array4));
        startTime = System.currentTimeMillis();
        sort.ShellSort(array4);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  ShellSort:");
        logger.info(Arrays.toString(array4));
        System.out.println("希尔排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array5 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array5,0,array.length);
        logger.info("Before MergeSort:");
        logger.info(Arrays.toString(array5));
        startTime = System.currentTimeMillis();
        sort.MergeSort(array5,0, array5.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  MergeSort:");
        logger.info(Arrays.toString(array5));
        System.out.println("归并排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array6 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array6,0,array.length);
        logger.info("Before QuickSort:");
        logger.info(Arrays.toString(array6));
        startTime = System.currentTimeMillis();
        sort.QuickSort(array6,0, array6.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  QuickSort:");
        logger.info(Arrays.toString(array6));
        System.out.println("快速排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

        System.out.println("****************************************************************************");
        Integer[] array7 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array7,0,array.length);
        logger.info("Before HeapSort:");
        logger.info(Arrays.toString(array7));
        startTime = System.currentTimeMillis();
        sort.HeapSort(array7);
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  HeapSort:");
        logger.info(Arrays.toString(array7));
        System.out.println("堆排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        logger.info("Before Javasort:");
        logger.info(Arrays.toString(array));
        startTime = System.currentTimeMillis();
        Collections.sort(Arrays.asList(array));
        endTime = System.currentTimeMillis();   //获取结束时间
        logger.info("After  Javasort:");
        logger.info(Arrays.toString(array));
        System.out.println("JAVA自带排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");



    }
}
