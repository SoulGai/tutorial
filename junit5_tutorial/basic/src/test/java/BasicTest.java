import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import top.testeru.Calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @program: junit5_tutorial
 * @author: 盖盖
 * @description: 基本注解
 * @Date: 2023/10/8
 */
public class BasicTest {
    static final Logger log = getLogger(lookup().lookupClass());

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator("[Basic test]");
        //初始化ID
        calculator.initId();
    }

    @Test
    void sumTest() {
        log.debug("Testing sum method in {}", calculator.getName());

        // exercise 业务调用
        int sum = calculator.sum(1, 2, 3);

        // verify 断言
        Assertions.assertTrue(sum == 6);
    }

    @Test
    void concanateTest() {
        log.debug("Testing sum concatenate in {} SUT", calculator.getName());

        // exercise
        String phrase = calculator.concatenate("hello", "world");

        // verify
        Assertions.assertTrue(phrase.equals("hello world"));
    }

    @AfterEach
    void teardown() {
        calculator.releaseId();
        calculator.close();
    }

}
