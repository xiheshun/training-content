package cn.zql.goodsui.service.impl;

import cn.zql.goodscommon.pojo.Book;
import cn.zql.goodscommon.vo.ResultVo;
import cn.zql.goodsui.service.GoodsUIService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class IGoodsUIServiceImpl implements GoodsUIService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        //url:调用服务的地址:应用名称和对应的映射url组合
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回的结果--->"+object);
    }

    @Override
    public List<Book> getBookList() {
        Book[] bookobject = restTemplate.getForObject("http://goods-provider/provider/list", Book[].class);
        return Arrays.asList(bookobject);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBook",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "8000")
    }//降级响应设置的时间
    )
    public ResultVo getBookById(Integer id) {
        Book booksObject = restTemplate.getForObject("http://goods-provider/provider/lists/"+id, Book.class);
        return ResultVo.ok(booksObject);
    }
    public ResultVo fallBackBook(Integer id){
        return ResultVo.error("服务降级返回的响应内容");
    }

    @Override
    public Boolean addBooks(Book book) {
        Boolean flag = restTemplate.postForObject("http://goods-provider/provider/add", book, Boolean.class);
        return flag;
    }
}
