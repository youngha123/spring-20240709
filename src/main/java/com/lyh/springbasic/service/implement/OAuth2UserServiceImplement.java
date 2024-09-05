package com.lyh.springbasic.service.implement;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyh.springbasic.service.object.CustomOAuth2User;

@Service
// OAuth2를 통해서 클라이언트 정보를 받은 후 진행할 비즈니스로직을 작성하는 서비스
// - 반드시 DefaultOAuth2UserService 클래스를 확장해야함
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {
    
    // OAuth2 인증 정보를 받고 실행할 비즈니스 로직 메서드
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registration = userRequest.getClientRegistration().getClientName();

        try {
            System.out.println(registration);
            System.out.println("==============================================================");
            System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
            System.out.println("==============================================================");
            System.out.println(oAuth2User.getName());
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        // 데이터베이스 작업이 들어감

        return new CustomOAuth2User(oAuth2User.getName(), oAuth2User.getAttributes());

    }

}