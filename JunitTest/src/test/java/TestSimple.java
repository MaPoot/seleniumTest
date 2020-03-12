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

    @AfterEach
    public void tearDownTest(){

    }

    @AfterAll
    public  static void tearDownAll(){

    }


}
