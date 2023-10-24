package cn.bugstack.xfg.dev.tech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@SpringBootApplication
@Configurable
@RestController("mysql")
@RequestMapping("/api/jmeter/")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * http://127.0.0.1:8091/api/jmeter/query_order_info?orderId=100001
     * @param orderId
     */
    @RequestMapping(value = "query_order_info", method = RequestMethod.GET)
    public String queryOrderInfo(@RequestParam String orderId) throws InterruptedException {
        log.info("查询订单信息 orderId: {}", orderId);
        // 180~220 随机休眠
        Thread.sleep(new Random().nextInt(41) + 220);
        return "您的订单信息查询完毕";
    }

}
