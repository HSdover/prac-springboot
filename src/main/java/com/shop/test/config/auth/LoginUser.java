package com.shop.test.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //이 어노테이션이 생성될 수 있는 위치를 지정(PARAMETER 옵션은 메소드의 파라미터에만 사용 가능)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
