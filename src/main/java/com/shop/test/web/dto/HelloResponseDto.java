package com.shop.test.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelloResponseDto {
    String name;
    int amount;
}
