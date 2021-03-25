/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.elasticsearch.index;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @Description: ES索引的测试
 * @Auther: za-guanlei
 * @Date: 2021/03/24/14:36
 */
@SpringBootTest
public class IndexTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex() throws IOException {
        //1.创建索引的请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("gl_index");
        //2.执行创建请求
        CreateIndexResponse response = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 测试索引是否存在
     */
    @Test
    void testExistIndex() throws IOException {
        //1.创建索引的请求
        GetIndexRequest request = new GetIndexRequest("gl_index");
        //2客户端执行请求，请求后获得响应
        boolean exist =  restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("测试索引是否存在-----"+exist);
    }
}
