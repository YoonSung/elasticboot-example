package com.example.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by jins on 2017-04-25.
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "com.example.repository")
public class ElasticSearchConfig {
    @Resource
    private Environment environment;

    private Client client;

    @Bean @Lazy
    public Client client(){
        Settings settings = Settings.settingsBuilder()
                .put("client.transport.sniff", true)
                .put("cluster.name", "elasticsearch")
                .put("client.transport.ping_timeout", "30s")
                .build();
        try {
            client = TransportClient.builder()
                    .settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(
                            InetAddress.getByName(environment.getProperty("elasticsearch.host")),
                            Integer.parseInt(environment.getProperty("elasticsearch.port"))
                    ));
             }catch (UnknownHostException unex){

        }
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        return new ElasticsearchTemplate(client());
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setFallbackPageable(new PageRequest(0, 30));
        argumentResolvers.add(resolver);
    }
}
