package com.example.springbootelasticsearch;

import com.example.springbootelasticsearch.pojo.Article;
import com.example.springbootelasticsearch.pojo.Book;
import com.example.springbootelasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        //1.给es中索引一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("hello world");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            //执行保存
            jestClient.execute(index);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //使用jest来搜索文档
    @Test
    public void test(){
        //查询表达式
        String json = "{\"query\":{\"match\":{\"content\":\"hello\"}}}";
        //构建一个搜索
        Search build = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult searchResult = jestClient.execute(build);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuther("吴承恩");
        bookRepository.index(book);
    }
}
