package cn.zql.customerui.feign;

import cn.zql.goodscommon.pojo.Customer;
import cn.zql.goodscommon.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign{

    @Override
    public List<Customer> customerList() {
        return null;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBook",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置的时间
    )
    public ResultVo getCustomerById(Integer id) {
        return ResultVo.error("fegin服务降级返回的响应内容");
    }
    public ResultVo fallBackBook(Integer id){
        return ResultVo.error("fegin服务降级返回的响应内容");
    }
}
