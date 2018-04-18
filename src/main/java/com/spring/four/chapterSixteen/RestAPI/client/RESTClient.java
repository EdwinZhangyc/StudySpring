package com.spring.four.chapterSixteen.RestAPI.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.four.chapterSixteen.RestAPI.domain.Spitter;
import com.spring.four.chapterSixteen.RestAPI.domain.Spittle;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.java2d.cmm.Profile;

import java.io.IOException;

public class RESTClient {

    /**
     * 程序清单16.6 使用Apache HTTP Client获取facebook中的个人基本信息
     */
    public Profile fetchFacebookProfile(String id) throws IOException {

        //创建客户端
        HttpClient client = HttpClients.createDefault();
        //创建请求
        HttpGet request = new HttpGet("http://graph.fackbook.com" + id);
        request.setHeader("Accept", "application/json");
        //执行请求
        HttpResponse response = client.execute(request);
        //将响应映射为对象
        HttpEntity entity = response.getEntity();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(entity.getContent(), Profile.class);

    }

    //16.3 检索资源,使用RestTemplate优化程序清单16.6的代码
    public Profile fetchFacebookProfile1(String id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://grah.facebook.com/{spitter}", Profile.class, id);
    }

    //16.4 抽取响应元数据
    public Spittle fetchSpittle(long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Spittle> response = restTemplate.getForEntity(
                "http://localhost:8080/spittr-api/spittles/{id}", Spittle.class, id);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND)
            throw new NotModifiedException();
        return response.getBody();
    }

    class NotModifiedException extends RuntimeException{

    }

    //16.5 PUT资源
    public void updateSpittle(Spittle spittle) throws SpitterExcetion{
        RestTemplate restTemplate = new RestTemplate();
        //String url = "http://localhost:8080/spittr-api/spittles/" + spittle.getId();
        //restTemplate.put(URI.create(url), spittle);
        restTemplate.put("http://localhost:8080/spittr-api/spittles/{id}", spittle, spittle.getId());
    }

    private class SpitterExcetion extends Exception {
    }

    //16.6 DELETE资源
    public void deleteSpittle(long id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/spittr-api/spittles/" + id);
        restTemplate.delete("http://localhost:8080/spittr-api/spittles/{id}" + id);
    }

    //16.8 在POST请求中获取响应对象
    public Spitter postSpitterForObject(Spitter spitter){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/spittr-api/spittles", spitter, Spitter.class);
    }
}