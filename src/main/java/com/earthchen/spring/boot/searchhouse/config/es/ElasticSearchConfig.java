package com.earthchen.spring.boot.searchhouse.config.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * es 配置
 *
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Configuration
public class ElasticSearchConfig {

    @Autowired
    private ElasticSearchProperties elasticSearchProperties;


    @Bean
    public TransportClient esClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", elasticSearchProperties.getEsClusterName())
//                .put("cluster.name", "elasticsearch")
                // 自动发现节点
                .put("client.transport.sniff", true)
                .build();

        InetSocketTransportAddress master = new InetSocketTransportAddress(
                InetAddress.getByName(elasticSearchProperties.getEsHost()),
                elasticSearchProperties.getEsPort()
//          InetAddress.getByName("10.99.207.76"), 8999
        );

        InetSocketTransportAddress slave1 = new InetSocketTransportAddress(
                InetAddress.getByName(elasticSearchProperties.getEsHost()),
                8300
//          InetAddress.getByName("10.99.207.76"), 8999
        );

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(master)
                .addTransportAddress(slave1);

        return client;
    }
}
