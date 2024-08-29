package com.lyh.springbasic.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// JWT
// - Json Web Token, RFC7519 표준에 정의된 JSON 형식의 문자열을 포함하는 토큰
// - 인증 및 인가
// - 암호화가 되어 있어 클라이언트와 서버 간에 안전한 데이터 전달을 수행할 수 있음
// - 헤더 : 토큰의 유형, 암호화 알고리즘이 지정되어있음
// - 페이로드 : 클라이언트 혹은 서버가 전달할 데이터가 포함
// - 서명 : 헤더와 페이로드를 합쳐서 인코딩하고 비밀키로 암호화한 데이터
@Component
public class JwtProvider {

    public String create(String name) {

        // JWT의 만료일자 및 시간
        Date expiredDate = Date.from(Instant.now().plus(4, ChronoUnit.HOURS));

        // 비밀키 생성
        String secretKey = "qwer1234";
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        // JWT 생성
        String jwt = Jwts.builder()
            // 서명 (암호화 시 사용할 비밀키와 알고리즘)
            .signWith(key, SignatureAlgorithm.HS256)
            // 페이로드
            // 작성자
            .setSubject(name)
            // 생성 시간 (현재 시간)
            .setIssuedAt(new Date())
            // 만료 시간 ()
            .setExpiration(expiredDate)
            // 인코딩 (압축)
            .compact();

        return jwt;
    }

}
