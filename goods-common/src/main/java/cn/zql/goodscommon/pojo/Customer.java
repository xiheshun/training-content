package cn.zql.goodscommon.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("customer")
public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private String customerTicket;
}
