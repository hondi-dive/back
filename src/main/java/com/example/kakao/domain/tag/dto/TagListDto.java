package com.example.kakao.domain.tag.dto;

import com.example.kakao.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class TagListDto {
    List<TagDto> tags;

    public static TagListDto from(List<Tag> tags) {
        List<TagDto> tagDtos = new ArrayList<>();
        for (Tag tag : tags) {
            tagDtos.add(TagDto.from(tag));
        }
        return TagListDto.builder()
                .tags(tagDtos)
                .build();
    }
}
