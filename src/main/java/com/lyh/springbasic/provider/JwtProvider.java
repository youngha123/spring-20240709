package com.lyh.springbasic.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
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

    // JWT 암호화에 사용되는 비밀키는 보안 관리가 되어야함
    // 코드에 직접적으로 작성하면 보안상 좋지 않음

    // 해결책
    // 1. application.properties / application.yaml에 등록
    // - application.properties / application.yaml에 비밀키를 작성
    // - @Value()를 이용하여 값을 가져옴
    // - 주의사항 : application.properties / application.yaml을 .gitignore에 등록해야함
    @Value("${jwt.secret}")
    private String secretKey;

    // 2. 시스템의 환경변수로 등록하여 사용
    // - OS 자체의 시스템 환경변수에 비밀키로 등록
    // - Spring에서 환경변수 값을 읽어서 사용

    // 3. 외부 데이터 관리 도구를 사용
    // - 자체 서버가 아닌 타 서버에 등록된 Vault 도구를 사용하여 비밀키 관리
    // - OS 부팅 시 Vault 서버에서 비밀키를 가져와 사용
    // - OS 매번 부팅 시 새로운 비밀키를 부여함

    public String create(String name) {

        // JWT의 만료일자 및 시간
        Date expiredDate = Date.from(Instant.now().plus(4, ChronoUnit.HOURS));

        // 비밀키 생성
        // String secretKey = "qwertyuiasdfghjklzxcvbnm123456789012345678901234567980";
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
