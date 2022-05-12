package cn.zql.goodsui.service;

import cn.zql.goodscommon.pojo.Book;
import cn.zql.goodscommon.vo.ResultVo;

import java.util.List;

public interface GoodsUIService {

    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo getBookById(Integer id);

    Boolean addBooks(Book book);
}
