package com.shop.test.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//LoginUser 어노테이션을 생성함으로써 HttpSession user가 필요한 곳에서 불러올 수 있고 이 값이 변하더라도 여기서만 수정해주면 모든 코드에 적용 가능
//코드의 유지/보수나 재사용을 편리하게 만들어줌
@Target(ElementType.PARAMETER)  //이 어노테이션이 생성될 수 있는 위치를 지정(PARAMETER 옵션은 메소드의 파라미터에만 사용 가능)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
