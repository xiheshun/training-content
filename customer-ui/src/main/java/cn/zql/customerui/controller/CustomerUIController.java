package cn.zql.customerui.controller;

import cn.zql.customerui.feign.CustomerUIFeign;
import cn.zql.goodscommon.pojo.Customer;
import cn.zql.goodscommon.vo.ResultVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerUIController {

    @Resource
    private CustomerUIFeign customerUIFeign;

    @RequestMapping("/list")
    public List<Customer> customerList(){
        List<Customer> customers = customerUIFeign.customerList();
        return customers;
    }

    @RequestMapping("/lists/{id}")
    public ResultVo getListById(@PathVariable("id")Integer id){
        return customerUIFeign.getCustomerById(id);
    }
}
