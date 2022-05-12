package cn.zql.goodsui.controller;

import cn.zql.goodscommon.pojo.Book;
import cn.zql.goodscommon.vo.ResultVo;
import cn.zql.goodsui.service.GoodsUIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUIController {

    @Resource
    private GoodsUIService goodsUIService;

    //测试goods-ui调用goods-provider
    @RequestMapping("/test")
    public String test(){
        goodsUIService.testGoodsProvider();
        return "ok";
    }

    @RequestMapping("/list")
    public List<Book> getBooks(){
        List<Book> bookList = goodsUIService.getBookList();
        return bookList;
    }

    @RequestMapping("/lists/{id}")
    public ResultVo getBookById(@PathVariable("id") Integer id){
        ResultVo book = goodsUIService.getBookById(id);
        return book;
    }

    @PostMapping("/add")
    public Boolean addBook(@RequestBody Book book){
       return goodsUIService.addBooks(book);
    }

}
