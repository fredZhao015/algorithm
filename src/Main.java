import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
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
        final int MAXLENGTH = 20000;
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
        System.out.print("Before SelectionSort:");
        System.out.println(Arrays.toString(array1));
        startTime = System.currentTimeMillis();
        sort.SelectionSort(array1);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  SelectionSort:");
        System.out.println(Arrays.toString(array1));
        System.out.println("选择排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");

        System.out.println("****************************************************************************");
        Integer[] array2 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array2,0,array.length);
        System.out.print("Before InsertionSort:");
        System.out.println(Arrays.toString(array2));
        startTime = System.currentTimeMillis();
        sort.InsertionSort(array2);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  InsertionSort:");
        System.out.println(Arrays.toString(array2));
        System.out.println("插入排序算法1运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array3 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array3,0,array.length);
        System.out.print("Before InsertionSort2:");
        System.out.println(Arrays.toString(array3));
        startTime = System.currentTimeMillis();
        sort.InsertionSort2(array3);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  InsertionSort2:");
        System.out.println(Arrays.toString(array3));
        System.out.println("插入排序算法2运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array4 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array4,0,array.length);
        System.out.print("Before ShellSort:");
        System.out.println(Arrays.toString(array4));
        startTime = System.currentTimeMillis();
        sort.ShellSort(array4);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  ShellSort:");
        System.out.println(Arrays.toString(array4));
        System.out.println("希尔排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array5 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array5,0,array.length);
        System.out.print("Before MergeSort:");
        System.out.println(Arrays.toString(array5));
        startTime = System.currentTimeMillis();
        sort.MergeSort(array5,0, array5.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  MergeSort:");
        System.out.println(Arrays.toString(array5));
        System.out.println("归并排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        Integer[] array6 = new Integer[MAXLENGTH];
        System.arraycopy(array,0, array6,0,array.length);
        System.out.print("Before QuickSort:");
        System.out.println(Arrays.toString(array6));
        startTime = System.currentTimeMillis();
        sort.QuickSort(array6,0, array6.length-1);
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  QuickSort:");
        System.out.println(Arrays.toString(array6));
        System.out.println("快速排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");


        System.out.println("****************************************************************************");
        System.out.print("Before Javasort:");
        System.out.println(Arrays.toString(array));
        startTime = System.currentTimeMillis();
        Collections.sort(Arrays.asList(array));
        endTime = System.currentTimeMillis();   //获取结束时间
        System.out.print("After  Javasort:");
        System.out.println(Arrays.toString(array));
        System.out.println("JAVA自带排序算法运行时间： "+ (endTime-startTime) +"ms");
        System.out.println("****************************************************************************");



    }
}
