package cn.zql.customerprovider.controller;


import cn.zql.customerprovider.dao.CustomerDAO;
import cn.zql.goodscommon.pojo.Customer;
import cn.zql.goodscommon.vo.ResultVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerProviderController {

    @Resource
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public List<Customer> customerList(){
        return customerDAO.getCustomerList();
    }

    @RequestMapping("/lists")
    public ResultVo getListById(@RequestParam("id")Integer id){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = customerDAO.getCustomerById(id);
        return ResultVo.ok(customer);
    }
}
