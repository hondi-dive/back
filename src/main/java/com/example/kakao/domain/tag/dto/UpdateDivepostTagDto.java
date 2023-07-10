package com.example.kakao.domain.tag.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateDivepostTagDto {

    private Integer id;
    private String title;
    private String content;
    private TagDto tag;
}
