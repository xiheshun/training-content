package cn.zql.customerui.feign;

import cn.zql.goodscommon.pojo.Customer;
import cn.zql.goodscommon.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import javafx.beans.DefaultProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-provider",fallback = CustomerUIFeignImpl.class)
public interface CustomerUIFeign {

    @GetMapping("/customer/list")
    List<Customer> customerList();

    @GetMapping("/customer/lists")
    ResultVo getCustomerById(@RequestParam("id") Integer id);
}
