package cn.zql.goodsprovider.controller;

import cn.zql.goodscommon.pojo.Book;
import cn.zql.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;

    //测试goods-ui是否调用成功
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goods-provider-------");
        return "ok!";
    }

    @RequestMapping("/list")
    public List<Book> bookList(){
        List<Book> bookList = goodsProviderService.getBookList();
        return bookList;
    }

    @RequestMapping("/lists/{id}")
    public Book getBookById(@PathVariable("id")Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book = goodsProviderService.getBookById(id);
        return book;
    }

    @PostMapping("/add")
    public Boolean addBook(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return true;
    }
    @HystrixCommand(
            fallbackMethod = "fallback",commandProperties = {
    }//降级响应设置的时间
    )
    @RequestMapping("/test_hystrix")
    public String textHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回结果:"+n+"/"+num+"="+result;
    }
    public String fallback(@RequestParam("num")Integer num){
        return "服务降级响应:num为0";
    }
}
