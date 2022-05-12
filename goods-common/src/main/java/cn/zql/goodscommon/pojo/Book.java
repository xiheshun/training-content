package cn.zql.goodscommon.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDesc;
}
