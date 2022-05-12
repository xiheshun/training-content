package cn.zql.goodsprovider.service;

import cn.zql.goodscommon.pojo.Book;

import java.util.List;

public interface GoodsProviderService {
    List<Book> getBookList();

    Book getBookById(Integer id);

    void addBook(Book book);
}
