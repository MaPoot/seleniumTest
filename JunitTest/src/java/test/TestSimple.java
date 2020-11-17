package test;

import driveManager.DriverManager;
import main.Ordenar;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;
import steps.DemoInputField;
import steps.ExpediaSteps;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
    @ValueSource ( strings = {" anita lava la tina", "oro", "olo"})
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
        setTest.add("Hello");
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
    @MethodSource({"generateData"})
    public void order(List<Integer> data){
        boolean ban = true;

        for (int i=1; i < data.size() - 1; i++) {
            if(data.get(i) > data.get(i+1)){
                ban = false;
                break;
            }
        }

        Assertions.assertTrue(ban, String.format("No ordenado %s", data.toString()));
        System.out.println("Ordenado de menor a mayor " + data);
    }

    @ParameterizedTest
    @MethodSource({"getFlightPrices"})
    public void testFlightPage(List<Integer> data){
        boolean ban = true;

        for (int i=1; i < data.size() - 1; i++) {
            if(data.get(i) < data.get(i+1)){
                ban = false;
                break;
            }
        }

        Assertions.assertTrue(ban, String.format("No ordenado %s", data.toString()));
        System.out.println("Ordenado de mayor a menor " + data);
    }


    static Stream<Arguments> generateData() {
        int [] data = {1,3,2,5};
        Ordenar ordenar = new Ordenar();
        List<Integer> data_list = ordenar.ordenar_int(data);


        return Stream.of(
                Arguments.of(data_list)
        );
    }

    static Stream<Arguments> getFlightPrices() {
        ExpediaSteps expediaSteps = new ExpediaSteps();
        List<Integer> data_list = expediaSteps.runExpediaPage();

        return Stream.of(
                Arguments.of(data_list)
        );
    }

    @AfterEach
    public void tearDownTest(){
        DriverManager.close();
    }

    @AfterAll
    public  static void tearDownAll(){

    }


}
