package com.shop.test.web.service.posts;

import com.shop.test.web.domain.posts.PostsRepository;
import com.shop.test.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    //final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복이 생성해줌
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}
