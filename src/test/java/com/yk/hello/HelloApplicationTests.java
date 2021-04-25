package com.yk.hello;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.yk.hello.pojo.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Clock;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() {
        Class aClass = super.getClass();
        Class aClass1 = this.getClass();
        System.out.println(aClass == aClass1);

        Class<?> superclass = new HelloApplicationTests().getClass().getSuperclass();
        System.out.println(aClass == superclass);
    }

    @Test
    void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> helloWorldClass = HelloApplicationTests.class.forName("com.yk.hello.pojo.HelloWorld");
        HelloWorld helloWorld = (HelloWorld) helloWorldClass.newInstance();
        helloWorld.setName("小康");
        helloWorld.setMsg("Hello World!!!");
        helloWorld.say();
    }

    @Test
    void testStringAndStringBuffer() {
        Set set = new HashSet();
        String a = "a";
        String b = "b";
        //String c = "c";
        StringBuffer c = new StringBuffer("a");
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(set.size());
    }

    @Test
    void testCollection() {
        List linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add(1);
        linkedList.add(2);
        Object o = linkedList.get(0);
        System.out.println(o);
    }

    @Test
    void testRepeatList() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);

        Set set = new HashSet(list);
        System.out.println(set);
    }

    @Test
    void finallyReturnTest() {
        int i = finallyReturn();
        System.out.println(i);
    }

    int finallyReturn() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    @Test
    void testString() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s5); //true
        System.out.println(s1 == s6); //false
        System.out.println(s1 == s6.intern()); //true
        System.out.println(s2 == s2.intern()); //false
    }

    @Test
    void testYearDateMouth(){
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        System.out.println(timeInMillis);
        long l = System.currentTimeMillis();
        System.out.println(l);
        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);
    }

    @Test
    void testInteger(){
        Integer f1=100,f2=100,f3=150,f4=150;

        System.out.println(f1==f2);
        System.out.println(f3==f4);
    }

    @Test
    void testSynchronizedCollection(){
        List list = new ArrayList();
        list.add("a");
        Collections.synchronizedList(list);
    }

    @Test
    void testArrayNum(){
        //统计相同元素的个数
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
        System.out.println("arr的长度："+arr.length);
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            map.put(arr[i],arr[i]);
        }
        for (Map.Entry<Integer,Integer> entity:map.entrySet()){
            int num=0;
            Integer key = entity.getKey();
            for (int i=0;i<arr.length;i++){
                if (arr[i]==key){
                    num++;
                }
            }
            map.put(key,num);
        }
        for (Map.Entry<Integer,Integer> entity:map.entrySet()){
           Integer key = entity.getKey();
           Integer value = entity.getValue();
           System.out.println(key + "出现次数："+value + "次");
        }
    }

    @Test
    public void testListAdd(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        //arrayList.re
        LinkedList linkedList = new LinkedList();
        linkedList.add("b");
        //linkedList.re
    }

    @Test
    void testLambda(){
        TestLambda testLambda = (a, b) -> a+b;
        int sum = testLambda.sum(1, 2);
        System.out.println(sum);
        TestLambdaJava testLambdaJava = new TestLambdaJava();
    }

    interface TestLambda{
        int sum(int a,int b);
    }

    class TestLambdaJava{
        String show(){
            return "hello";
        }
    }
    public String show1(){
        return "hello world";
    }

    @Test
    void testIO() throws IOException {
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream("K:\\abc.txt");
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,"utf8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
    }

    @Test
    void testThread(){
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " hello world");
            });
        }
    }

    @Test
    void testQueue(){
        Queue queue = new LinkedList();
//        queue.remove();
        Object poll = queue.poll();
        System.out.println(poll);
    }

    @Test
    void testMap(){
        Map hashMap = new HashMap();
        hashMap.put(null,null);
        hashMap.put("a","a");
        hashMap.put(null,"b");
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(null));

        Map hashTable = new Hashtable();
        hashTable.put(null,null);
        System.out.println(hashTable.get(null));
    }

    @Test
    void testRemoveList(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("b")){
                list.remove(i);
            }
        }
        System.out.println("size:"+list.size());
        Stream.of(list.toArray()).forEach(System.out::println);
    }

    @Test
    void testSafeFaild(){
        List list = new CopyOnWriteArrayList();
        list.add("a");
        list.add("b");

        ListIterator iterator = list.listIterator();
        while(iterator.hasNext()){
            String str = (String) iterator.next();
            System.out.println(str);
            list.add("c");
            System.out.println(list.size());
        }
    }

    @Test
    void testURL() throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String data = bufferedReader.readLine();
        while (data!= null){
            System.out.println(data);
            data = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();
        inputStream.close();
    }
}
