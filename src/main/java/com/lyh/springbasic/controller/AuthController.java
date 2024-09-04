package com.lyh.springbasic.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @GetMapping("")
    public String getAuth(

        // @AuthenticationPrincipal
        // 인증 필터에서 security context에 등록된 해당 request의 접근 주체의 정보를 가져오는 어노테이션
        // 인증이 성공적으로 완료된 접근 주체일 경우 authentication token의 principal 값을 가져옴
        // 인증에 실패한 접근 주체일 경우 anonymousUser를 반환함, 단 해당 url 패턴이 permitAll 일때만 가져옴
        @AuthenticationPrincipal String principal
    ) {
        return principal;
    }

}
