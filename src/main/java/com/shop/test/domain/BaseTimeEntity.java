package com.shop.test.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//모든 Entity의 상위 클래스가 되어 Entity 들의 변경사항을 기록해주는 로그를 자동으로 관리하는 역할
@Getter
@MappedSuperclass   //JPA Entity클래스들이 이 클래스를 상속할때 필드들도 컬럼으로 인식하게 해준다.
@EntityListeners(AuditingEntityListener.class)  //Auditing기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate    //Entity가 생성될때마다 시간을 자동으로 저장해준다.
    private LocalDateTime createdDate;

    @LastModifiedDate   //Entity값이 변경될때마다 시간을 자동으로 저장해준다.
    private LocalDateTime modifiedDate;

}