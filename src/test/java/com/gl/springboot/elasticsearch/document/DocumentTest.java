/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.elasticsearch.document;

import cn.hutool.json.JSONUtil;
import com.gl.springboot.entity.UserInfo;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Description: ES文档的测试
 * @Auther: za-guanlei
 * @Date: 2021/03/24/15:45
 */
@SpringBootTest
public class DocumentTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 添加文档
     * @throws IOException
     */
    @Test
    void testAddDocument() throws IOException {
        UserInfo userInfo = new UserInfo("111","guanlei",20);
        IndexRequest request = new IndexRequest("gl_index");
        request.id("1");
        //设置超时时间
        request.timeout("10s");
        //将数据放到json字符串
        request.source(JSONUtil.toJsonStr(userInfo), XContentType.JSON);
        //发送请求
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println("添加文档-------"+response.toString());
        System.out.println("添加文档-------"+response.status());

//      结果
//      添加文档-------IndexResponse[index=lisen_index,type=_doc,id=1,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
//      添加文档-------CREATED
    }

    /**
     * 测试文档是否存在
     * @throws IOException
     */
    @Test
    void testExistDocument() throws IOException {
        GetRequest request= new GetRequest("gl_index","1");
        boolean exist = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println("测试文档是否存在-----"+exist);
    }

    /**
     * 测试获取文档
     * @throws IOException
     */
    @Test
    void testGetDocument() throws IOException {
        GetRequest request= new GetRequest("gl_index","1");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println("测试获取文档-----"+response.getSourceAsString());
        System.out.println("测试获取文档-----"+response);

//      结果
//      测试获取文档-----{"age":27,"name":"lisen"}
//      测试获取文档-----{"_index":"lisen_index","_type":"_doc","_id":"1","_version":1,"_seq_no":0,"_primary_term":1,"found":true,"_source":{"age":27,"name":"lisen"}}

    }

    /**
     * 测试修改文档
     * @throws IOException
     */
    @Test
    void testUpdateDocument() throws IOException {
        UserInfo userInfo = new UserInfo("111","guanlei66",21);
        //修改是id为1的
        UpdateRequest request= new UpdateRequest("gl_index","1");
        request.timeout("1s");
        request.doc(JSONUtil.toJsonStr(userInfo),XContentType.JSON);

        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println("测试修改文档-----"+response);
        System.out.println("测试修改文档-----"+response.status());

//        结果
//        测试修改文档-----UpdateResponse[index=lisen_index,type=_doc,id=1,version=2,seqNo=1,primaryTerm=1,result=updated,shards=ShardInfo{total=2, successful=1, failures=[]}]
//        测试修改文档-----OK

//        被删除的
//        测试获取文档-----null
//        测试获取文档-----{"_index":"lisen_index","_type":"_doc","_id":"1","found":false}
    }


    /**
     * 测试删除文档
     * @throws IOException
     */
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest request= new DeleteRequest("lisen_index","1");
        request.timeout("1s");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println("测试删除文档------"+response.status());
    }

    /**
     * 测试批量添加文档
     * @throws IOException
     */
    @Test
    void testBulkAddDocument() throws IOException {
        ArrayList<UserInfo> userlist = new ArrayList<>();
        userlist.add(new UserInfo("111","guanlei661",21));
        userlist.add(new UserInfo("112","guanlei662",21));
        userlist.add(new UserInfo("113","guanlei663",21));
        userlist.add(new UserInfo("114","guanlei664",21));
        userlist.add(new UserInfo("115","guanlei665",21));
        userlist.add(new UserInfo("116","guanlei666",21));

        //批量操作的Request
        BulkRequest request = new BulkRequest();
        request.timeout("1s");

        //批量处理请求
        for (int i = 0; i < userlist.size(); i++) {
            request.add(
                    new IndexRequest("gl_index")
                            .id(""+(i+1))
                            .source(JSONUtil.toJsonStr(userlist.get(i)),XContentType.JSON)
            );
        }
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println("测试批量添加文档是否失败-----"+response.hasFailures());

//        结果:false为成功 true为失败
//        测试批量添加文档-----false
    }


    /**
     * 测试查询文档
     * @throws IOException
     */
    @Test
    void testSearchDocument() throws IOException {
        SearchRequest request = new SearchRequest("gl_index");
        //构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置了高亮
        sourceBuilder.highlighter();
        //构建精确查询
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("userName", "guanlei661");
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        System.out.println("测试查询文档-----"+JSONUtil.toJsonStr(response.getHits()));
        System.out.println("=====================");
        for (SearchHit documentFields : response.getHits().getHits()) {
            System.out.println("测试查询文档--遍历参数--"+documentFields.getSourceAsMap());
        }

//        测试查询文档-----{"fragment":true,"hits":[{"fields":{},"fragment":false,"highlightFields":{},"id":"1","matchedQueries":[],"primaryTerm":0,"rawSortValues":[],"score":1.8413742,"seqNo":-2,"sortValues":[],"sourceAsMap":{"name":"cyx1","age":5},"sourceAsString":"{\"age\":5,\"name\":\"cyx1\"}","sourceRef":{"fragment":true},"type":"_doc","version":-1}],"maxScore":1.8413742,"totalHits":{"relation":"EQUAL_TO","value":1}}
//        =====================
//        测试查询文档--遍历参数--{name=cyx1, age=5}
    }

}
