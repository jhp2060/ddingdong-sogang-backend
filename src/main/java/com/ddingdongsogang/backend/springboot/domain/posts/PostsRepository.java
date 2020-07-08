package com.ddingdongsogang.backend.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// MyBatis의 DAO와 같은 개념. DB 계층의 접근자.
// JpaRepository<Entity클래스, PK타입>을 상속하면, 기본 CRUD 메소드가 자동으로 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
