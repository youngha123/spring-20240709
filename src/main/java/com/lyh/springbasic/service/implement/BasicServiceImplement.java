package com.lyh.springbasic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lyh.springbasic.service.BasicService;

public class BasicServiceImplement implements BasicService {

    @Override
    public ResponseEntity<String> getService() {
        return ResponseEntity.status(HttpStatus.OK).body("서비스 호출");
    }
    
}
