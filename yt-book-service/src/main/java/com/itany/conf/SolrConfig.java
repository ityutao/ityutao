package com.itany.conf;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {

    @Bean(name="solrClient")
    public HttpSolrClient solrClient(){
         return new HttpSolrClient.Builder("http://localhost:8080/solr/t_user")
                 .withConnectionTimeout(10000)
                 .withSocketTimeout(60000).build();
    }
}
