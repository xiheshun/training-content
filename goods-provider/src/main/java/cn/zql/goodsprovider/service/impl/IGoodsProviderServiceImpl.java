package cn.zql.goodsprovider.service.impl;

import cn.zql.goodscommon.pojo.Book;
import cn.zql.goodsprovider.dao.GoodsDAO;
import cn.zql.goodsprovider.service.GoodsProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IGoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsDAO goodsDAO;

    @Override
    public List<Book> getBookList() {
        return goodsDAO.getBookList();
    }

    @Override
    public Book getBookById(Integer id) {
        return goodsDAO.getBookById(id);
    }

    @Override
    public void addBook(Book book) {
        goodsDAO.addBook(book);
    }
}
