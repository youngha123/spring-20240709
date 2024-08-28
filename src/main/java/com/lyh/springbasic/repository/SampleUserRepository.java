package com.lyh.springbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyh.springbasic.entity.SampleUserEntity;

@Repository
public interface SampleUserRepository 
extends JpaRepository<SampleUserEntity, String> {
    
    // Query Method:
    // - Repository의 메서드 선언시에 지정된 패턴에 따라 메서드명을 작성하면 JPA가 SQL을 만들어주는 방법
    // - findBy : 필드명을 기준으로 모든 컬럼을 조회할 때 사용, findBy 뒤에 필드명을 붙여서 작성, 필드명의 첫글자는 대문자이어야함
    List<SampleUserEntity> findByName(String name);
    SampleUserEntity findByTelNumber(String telNumber);

    // - And/Or : and 연산 혹은 or 연산에 사용됨, 필드와 필드 사이에 사용
    //   And/Or의 우선순위 주의
    List<SampleUserEntity> findByNameAndAddress(String name, String address);

    // - Like, NotLike, StartingWith, EndingWith, Containing: Like 연산에 대하여 사용, 필드 뒤에 사용
    List<SampleUserEntity> findByAddressContaning(String address);

}