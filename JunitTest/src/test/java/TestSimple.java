import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.DemoInputField;

import java.util.logging.Logger;

public class TestSimple {
    static final Logger logger = Logger.getLogger(TestSimple.class.getName());

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

    @AfterEach
    public void tearDownTest(){

    }

    @AfterAll
    public  static void tearDownAll(){

    }


}
