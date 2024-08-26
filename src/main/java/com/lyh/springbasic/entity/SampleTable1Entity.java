package com.lyh.springbasic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity : RDBMS의 테이블과 매핑되는 ORM의 클래스 
// - 웹 애플리케이션 서버와 데이터베이스 서버 간의 데이터 전송 및 관리를 위한 객체

// Entity 클래스의 경우 완벽한 캡슐화를 지향
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Entity
// - 해당 클래스를 Entity 클래스로 지정
// - JPA에서 데이터 관리를 위해 사용되는 주된 객체
@Entity
// @Table
// - 해당 Entity 클래스를 RDBMS의 테이블과 매핑시키는 어노테이션
// - 만약 java의 class명과 RDBMS의 table명이 동일하다면 유추하여 매핑
// - 이름이 서로 다르면 name 속성으로 매핑할 table명을 지정할 수 있음
@Table
// sample_table1_entity
public class SampleTable1Entity {
    private String sampleId;
    private Integer sampleColumn;
}
