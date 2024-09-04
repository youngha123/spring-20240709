package com.lyh.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostUserRequestDto {

    private String userId;
    private String passowrd;
    private String name;
    private String address;
    private String telNumber;

}
