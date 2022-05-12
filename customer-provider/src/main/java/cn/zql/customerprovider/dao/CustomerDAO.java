package cn.zql.customerprovider.dao;

import cn.zql.goodscommon.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDAO {


    List<Customer> getCustomerList();

    void add(Customer customer);

    void delBatch(@Param("ids") Integer[] ids);

    Customer getCustomerById(Integer id);

    void deleteById(Integer id);

    void update(Customer customer);
}
