package com.lyh.springbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyh.springbasic.service.BasicService;
import com.lyh.springbasic.service.implement.BasicServiceImplement;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private BasicService basicService = new BasicServiceImplement(); 

    @GetMapping("")
    public ResponseEntity<String> getService() {
        return basicService.getService();
    }

}
