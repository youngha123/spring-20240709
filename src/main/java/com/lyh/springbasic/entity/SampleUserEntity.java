package com.lyh.springbasic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="sample_user")
public class SampleUserEntity {
    
    @Id
    private String user_id;
    private String password;
    private String name;
    private String address;
    private String telNumber;

}
