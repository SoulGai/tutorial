package top.testeru;

import org.slf4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @program: junit5_tutorial
 * @author: 盖盖
 * @description: 计算器
 * @Date: 2023/10/8
 */
public class Calculator implements Closeable {
    static final Logger log = getLogger(lookup().lookupClass());

    String name;
    String id;

    public Calculator(String name) {
        this.name = name;
        log.info("{} created", name);
    }
    //初始化ID 用户登录
    public void initId() {
        id = UUID.randomUUID().toString();
        log.info("Id created: {}", id);
    }
    //ID释放 用户退出
    public void releaseId() {
        if (null == id) {
            throw new IllegalArgumentException(name + " not initilized");
        }
        log.info("Id released: {}", id);
        id = null;
    }

    //整数连续相加
    public int sum(int... numbers) {
        //100
        if(Arrays.stream(numbers).anyMatch(u -> u == 100)){
            log.warn("number is contain 100!");
            //拦截，重置，发送某些消息给其他服务端
            throw new NumberFormatException("number is contain 100!");
        }else if(Arrays.stream(numbers).anyMatch(u -> u > 99) | Arrays.stream(numbers).anyMatch(u -> u < -99)){
            log.warn("Please enter an integer within the range!");
            throw new IllegalArgumentException("Please enter an integer within the range!");
        }else {
            //[-99,99]
            return IntStream.of(numbers).sum();
        }
    }

    //字符串拼接 中间用空格
    public String concatenate(String... words) {
        return String.join(" ", words);
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }


    //app关闭
    @Override
    public void close(){
        log.info("{} closed", name);
    }

}
