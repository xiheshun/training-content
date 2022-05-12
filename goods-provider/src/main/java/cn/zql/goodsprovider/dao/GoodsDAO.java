package cn.zql.goodsprovider.dao;

import cn.zql.goodscommon.pojo.Book;

import java.util.List;

public interface GoodsDAO {
    List<Book> getBookList();

    Book getBookById(Integer id);

    void addBook(Book book);
}
