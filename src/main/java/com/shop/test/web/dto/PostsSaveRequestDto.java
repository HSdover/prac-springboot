package com.shop.test.web.dto;

import com.shop.test.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Entity 클래스와 거의 유사한 형태지만 Dto를 생성해야하는 이유
//절대로 Entity 클래스를 Request/Response 클래스로 사용해선 안됨
// -> DB와 맞닿는 핵심 클래스 View단과 DB단을 확실하게 분리하기 위해서 View단은 Dto, DB단은 Entity로 객체를 사용한다.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
