package com.lyh.springbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// http://localhost:4000/request-data/**
@RequestMapping("/request-data")
public class RequestDataContoller {
    
    // @RequestParam() : 
    // - GET, DELETE 처럼 Request Body가 존재하지 않고 URL로 데이터를 전송하는 메서드에서
    //   Query String 방식으로 데이터를 가져오기 위해 사용하는 어노테이션

    // GET http://localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?name=홍길동&age=30
    public String requestParam(
        // @RequestParam(name="name") String name,
        @RequestParam("name") String name,
        @RequestParam(name="age", required=false) Integer age
    ) {
        return "이름 : " + name + " 나이 : " + age;
    }

    // @PathVariable():
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라 데이터를 추출
    // GET http://localhost:4000/request-data/path-variable/*/*
    @GetMapping({
        "/path-variable/{var}/{str}", 
        "/path-variable/{var}/",
        "/path-variable/{var}"
    })
    public String pathVariable(
        @PathVariable(name="var") String var,
        @PathVariable(name="str", required=false) String str
    ) {
        return "읽은 경로 변수 : " + var + ", " + str;
    }

    // ! 주의
    // 경로 변수를 사용하여 URL 패턴을 작성할 때
    // 겹치는 패턴이 존재하는지 잘 확인해야함
    @GetMapping("/path-variable/other")
    public String otherPathVariable() {
        return "other 메서드 호출";
    }

    // "/path-variable/another/another"

    @GetMapping("/path-variable/{var}/another")
    public String anotherPathVariable1 (
        @PathVariable("var") String var
    ) {
        return "another1";
    }

    @GetMapping("/path-variable/another/{var}")
    public String anotherPathVariable2 (
        @PathVariable("var") String var
    ) {
        return "another2";
    }

}