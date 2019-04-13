package com.itany.book.service.impl;

import com.itany.book.service.IBookService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tyh on 2018/9/23.
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class BookServiceImpl implements IBookService{


    @Autowired
    private HttpSolrClient solrClient;

    @Override
    public void addDoc() {
            try {

                for(int i=0;i<10;i++){
                    SolrInputDocument doc = new SolrInputDocument();
                    doc.addField("id",i+1);
                    doc.addField("username","风云"+i);
                    solrClient.add(doc);
                }

                solrClient.commit();

            }catch (Exception e){
                e.printStackTrace();
               try {
                   solrClient.rollback();
               }catch (Exception e1){

               }
            }

    }

    @Override
    public List<Map<String, String>> findDoc() {

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        try {
           String q="username:风云";
           SolrQuery solrQuery = new SolrQuery();
           solrQuery.setQuery(q);
           solrQuery.setHighlight(true);
           solrQuery.setHighlightSimplePre("<font color='red'>");
           solrQuery.setHighlightSimplePost("</font>");
           solrQuery.setParam("hl.fl","*");
           QueryResponse response =solrClient.query(solrQuery);
           SolrDocumentList results=response.getResults();
           System.out.println("-------------"+results.getNumFound());
           for(int i=0;i<results.size();i++){
               Map<String,String> map = new HashMap<String,String>();
               SolrDocument document = results.get(i);
               String id=(String)document.get("id");

               Map<String,List<String>> map1 = response.getHighlighting().get(id);
               List<String> usernamelist = map1.get("username");
               if(null != usernamelist){
                   map.put("username",usernamelist.get(0));
               }else{
                   map.put("username",(String)document.get("username"));
               }
               list.add(map);
           }




        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
