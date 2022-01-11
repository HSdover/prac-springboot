package com.shop.test.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //JPA에서도 직접 쿼리로 데이터를 가져올 수 있다.
    //SELECT정도의 조회문은 JPA로도 조회할 수 있지만
    //조인이나 조건이 복잡한 쿼리들은 조회가 어렵기 때문에
    //Mybatis나 querydsl같은 프레임워크를 조회용으로 JPA와 함꼐 사용한다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
