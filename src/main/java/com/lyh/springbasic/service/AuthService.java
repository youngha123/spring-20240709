package com.lyh.springbasic.service;

import com.lyh.springbasic.dto.PostUserRequestDto;
import com.lyh.springbasic.dto.SignInRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
    String signIn(SignInRequestDto dto);
}
