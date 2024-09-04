package com.lyh.springbasic.service;

import com.lyh.springbasic.dto.PostUserRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
}
