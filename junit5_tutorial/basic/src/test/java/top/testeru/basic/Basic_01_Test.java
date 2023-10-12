package top.testeru.basic;

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
 * 执行顺序：
 *      @BeforeEach --> @Test修饰的方法1 --> @AfterEach -->
 *      @BeforeEach --> @Test修饰的方法2 --> @AfterEach
 * @Date: 2023/10/8
 */
public class Basic_01_Test {
    static final Logger log = getLogger(lookup().lookupClass());

    Calculator calculator;

    /**
     * @BeforeEach:void返回值
     *  执行顺序：在每一个@Test注解修饰的方法之前运行一次；当前测试类有多少个@Test注解，@BeforeEach注解修饰的方法就运行多少次
     *  应用场景：测试用例中，测试方法需要初始化的内容及属性，比如：app/web端进入固定页面，回退到固定页面；重启app；删除某些产生的测试数据
     */
    @BeforeEach
    void setup() {
        calculator = new Calculator("[Basic test]");
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

    /**
     * @AfterEach:void返回值
     *   执行顺序：在每一个@Test注解修饰的方法之后运行一次；前测试类有多少个@Test注解，@AfterEach注解修饰的方法就运行多少次
     *   应用场景：测试用例中，测试方法需要初始化的内容及属性，比如：app/web端进入固定页面，回退到固定页面；重启app；删除某些产生的测试数据
     */
    @AfterEach
    void teardown() {
        calculator.releaseId();
        calculator.close();
    }

}
