package com.spring.four.chapterSixteen.RestAPI.controller;

import com.spring.four.chapterSixteen.RestAPI.Exception.SpittleNotFoundException;
import com.spring.four.chapterSixteen.RestAPI.data.SpittleRepository;
import com.spring.four.chapterSixteen.RestAPI.domain.Error;
import com.spring.four.chapterSixteen.RestAPI.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * 程序清单16.1 实现RESTful功能的Spring MVC控制器
 */
//@Controller
@RestController//Spring4.0提供，默认使用消息转换替代了每个方法中使用@ResponseBody注解
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING="9223372036854775807";

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ){
        return spittleRepository.findSpittles(max, count);
    }
    //在响应体中返回资源状态
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Spittle> spittles1(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ){
        return spittleRepository.findSpittles(max, count);
    }

    //在请求中接受资源状态
    @RequestMapping(value = "/saveSpittle", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)//http相应码为201（create），不仅仅表示请求成功，同时描述创建了新资源
    public @ResponseBody Spittle saveSpittle(@RequestBody Spittle spittle){
         return spittleRepository.save(spittle);
    }

    //使用ResponseEntity代替@ResponseBody，由于ResponseEntity可以使用状态码
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Spittle> spittleById(@PathVariable long id){
        Spittle spittle = spittleRepository.findOne(id);
        //指定返回状态码，当spittle返回为空时，指定为404
        HttpStatus status = spittle != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Spittle>(spittle, status);
    }
    //对上述方法spittleById进行优化
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> spittleByIdUpdate(@PathVariable long id){
        Spittle spittle = spittleRepository.findOne(id);
        if(spittle == null){
            Error error = new Error(4, "Spittle [" + id + "] not found");
            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
    }

    //使用错误处理器，处理错误、处理异常
    @ExceptionHandler(SpittleNotFoundException.class)
    public ResponseEntity<Error> spittleNotFound(SpittleNotFoundException e){

        long spittleId = e.getSpittleId();
        Error error = new Error(4, "Spittle [" + spittleId + "] not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Spittle> spittleByIdUpdateUpdate(@PathVariable long id){
        Spittle spittle = spittleRepository.findOne(id);
        if(spittle == null){
            //使用错误处理器处理错误我们就可以移除掉大多数的错误代码，并且返回值不在使用泛型，使程序更加健全
            throw new SpittleNotFoundException(id);
        }
        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
    }

    /**
     * 程序清单16.4 当返回ResponseEntity时，在响应中设置头部信息
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spittle> saveSpittle1(@RequestBody Spittle spittle){
        //获取spittle
        Spittle spittle1 = spittleRepository.save(spittle);
        //设置Location头部信息
        HttpHeaders headers = new HttpHeaders();
        URI localUri = URI.create("http://localhost:8080/spittr/spittles/" + spittle.getId());
        headers.setLocation(localUri);
        //创建ResponseEntity
        ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
        return responseEntity;

    }
    /**
     * 程序清单16.5 使用UriComponentsBuilder来构建Localtion URI
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spittle> saveSpittle2(@RequestBody Spittle spittle,
                                                //给定UriComponent
                                                UriComponentsBuilder ucb){
        Spittle spittle1 = spittleRepository.save(spittle);
        HttpHeaders headers = new HttpHeaders();
        //计算Location URI
        URI locationUri = ucb.path("/spittles/")
                             .path(String.valueOf(spittle.getId()))
                             .build()
                             .toUri();
        headers.setLocation(locationUri);
        //创建ResponseEntity
        ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
        return responseEntity;
    }

}