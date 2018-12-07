package com.example.springbootelasticsearch.repository;

import com.example.springbootelasticsearch.pojo.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}
