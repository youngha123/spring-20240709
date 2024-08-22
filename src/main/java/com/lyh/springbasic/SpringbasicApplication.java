package com.lyh.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lyh.springbasic.dto.Lombok;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicApplication.class, args);
	}

	void  lombokExample() {
		
		Lombok lombok = new Lombok("a", "b", "c", false, false);
		lombok.getField1();
		lombok.setField3(null);

		// lombok = new Lombok();
		lombok = new Lombok("d", "e");

		// 기본형 boolean일 경우 getter 메서드 이름은 isXXX()
		lombok.isField4();
		// 참조형 Boolean일 경우 getter 메소드 이름은 getXXX()
		lombok.getField5();
	}

}
