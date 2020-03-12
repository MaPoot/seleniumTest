import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;
import steps.DemoInputField;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;

public class TestSimple {
    private static final Logger logger = Logger.getLogger(TestSimple.class.getName());

    @BeforeAll
    public static void setupAll(){

    }

    @BeforeEach
    public void setUpTest(){

    }

    @Test
    public void test(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            DemoInputField demo;
            demo = new DemoInputField();

            demo.showMessage();
            throw new NullPointerException();
        });
    }

    @ParameterizedTest
    @ValueSource ( strings = {" an it a lava la tina", "hola", "olo"})
    public void idPalindrome (String word) {
        boolean condition = true;

        word = word.trim().replace(" ", "");
        int word_length = word.length();

        for(int i = 0; i < word_length/2; i++){
            //System.out.println(String.format("%s, %s", word.charAt(i), word.charAt(word_length - (i + 1))));
            if (word.charAt(i) != word.charAt(word_length - (i + 1))) {
                condition = false;
                break;
            }
        }

        try{
            Assertions.assertTrue(condition, String.format("'%s' is not palindrome", word));
            logger.info(String.format("'%s' is palindrome", word));
        }catch (AssertionFailedError e){
            logger.info(e.getMessage());
            throw e;
        }
    }

    @Test
    public void setTest(){
        Set<String> setTest = new HashSet<>();

        setTest.add("Hi");
        setTest.add("Hi2");
        setTest.add("Hi");
        setTest.add("Hi");

        System.out.println(setTest);

    }

    @Test
    public void collectionTest(){
        SortedSet<String> set = new TreeSet<>();

        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");

        System.out.println(set);
    }

    @Test
    public void listTest(){
        ArrayList<String> list=new ArrayList<String>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        System.out.println(list);
    }

    @ParameterizedTest
    @ValueSource (ints = {})
    public void order(int [] data){
        //int[] data = {2,3,5,4,6,8,9};
        Ordenar order = new Ordenar();

        data = order.ordenar(data);

        boolean ban = true;

        for (int i=0; i < data.length - 1; i++) {
            if(data[i] <= data[i+1]){
                //System.out.printf("ok");
            }else{
                ban = false;
                Assertions.assertTrue(ban);
                break;
            }
        }

        System.out.printf("Ordenado de menor a mayor");
    }

    @AfterEach
    public void tearDownTest(){

    }

    @AfterAll
    public  static void tearDownAll(){

    }


}
