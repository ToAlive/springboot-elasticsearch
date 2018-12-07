package com.example.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来来与ES交互
 * 1.Jest   默认不生效的，需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2.SpringData ElasticSearch [es版本有可能不合适]
 *  版本适配说明：spring官网 data文档里面
 *     如果版本不适配 1.升级springboot的版本  2.安装对应版本的es
 *      1.Client 节点信息 clusterNodes clusterName
 *      2.ElasticsearchTemplate 来操作es
 *      3.也可以编写一个ElasticsearchRepository的子接口来操作es
 *两种用法：参照spring官网 data文档
 *  1.编写ElasticsearchRepository接口
 */
@SpringBootApplication
public class SpringbootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchApplication.class, args);
    }
}
