package acacia.generic.practise;


import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by miaomiao on 6/19/2017.
 */
public class GenericTest {

    @Test
    public void  test_1(){

        String test = "This is test";
        Container<String> container = new SALContainer(test);
        String result = container.getValues();
        System.out.println("Get values is: " + result);

        container.getEveryValuesFromParameter("123","tyty","yoyo");

    }
    @Test
    public void test_2(){
        List<String> list = new ArrayList<String>();
        list.add("Test");
        list.add("is");
        list.add("nothing");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        ListIterator<String> listIterator = list.listIterator();
        iterator.next();
        Map<Integer,String> map = new HashMap<Integer, String>(1);


    }

    @Test
    public void test_3(){
        GenericA<TypeB> genericA = new GenericA<TypeB>();
        GenericA<TypeC> genericA1 = new GenericA<TypeC>();
    }

    @Test
    public  void test_4(){
        GenericB<TypeD> genericB = new GenericB<TypeD>();
    }


    public static <K,V> Map<K,V> testMap(K[] K,V[] V) throws Exception {
        Map<K,V> map = new HashMap<K, V>();
       if (K.length == V.length){
           for (int i = 0; i < K.length; i++) {
               map.put(K[i],V[i]);
           }
       }else {
           throw new Exception("Key and Values length are not equal!");
       }
        return map;
    }

    @Test
    public void test_5() throws Exception {
        Map<Integer,String> newMap = new HashMap<Integer, String>();
        Integer[] key = {1,2,3};
        String[] value = {"This","is","Test"};
        newMap = GenericTest.testMap( key, value);
        System.out.println("Map is: " + newMap);
    }

    public static <T> T getFavorite(T t) throws Exception {
        if (t instanceof String ? true:false){
            System.out.println("This is a String");
            return t;
        }else if (t.getClass().getName().equals(Integer.class.getName())){
            System.out.println("This is a Interger");
            return t;
        }else if (Double.class.isInstance(t)){
            System.out.println("This is a Double");
            return t;
        } else {
            throw new Exception("Can't resolve this type!");
        }
    }

    @Test
    public void test_6() throws Exception {
        String t = "Test";
        System.out.println( t.getClass().isInstance(t));
        System.out.println(String.class);
        System.out.println(t.getClass().isInstance(String.class));
        GenericTest.getFavorite(t);
        Integer i = 123;
        GenericTest.getFavorite(i);
        Double dou = 23.4;
        GenericTest.getFavorite(dou);

    }


}
