package com.lyh.springbasic.service;

import org.springframework.stereotype.Service;

import com.lyh.springbasic.dto.PostUserRequestDto;
import com.lyh.springbasic.entity.SampleUserEntity;
import com.lyh.springbasic.repository.SampleUserRepository;
import com.lyh.springbasic.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final SampleUserRepository sampleUserRepository;

    @Override
    public String signUp(PostUserRequestDto dto) {
        
        try {

            String userId = dto.getUserId();
            boolean isExistedId = sampleUserRepository.existsByUserId(userId);
            if (isExistedId) return "존재하는 아이디!";

            String telNumber = dto.getTelNumber();
            boolean isExistedTelNumber =sampleUserRepository.existsByTelNumber(telNumber);
            if (isExistedTelNumber) return "존재하는 전화번호!";

            String password = dto.getPassowrd();
            String name = dto.getName();
            String address = dto.getAddress();
            // SampleUserEntity userEntity = new SampleUserEntity(userId, password, name, address, telNumber);
            // SampleUserEntity userEntity = new SampleUserEntity();
            // userEntity.setUserId(userId);
            // userEntity.setPassword(password);

        } catch(Exception exception) {
            exception.printStackTrace();
            return "예외발생!";
        }

    }
    
}
