package com.example.kakao.domain.tag.dto;

import com.example.kakao.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Builder
public class TagDto {
    private String name;

    public static TagDto from(Tag tag) {
        TagDto tagDto;
        if (tag == null) {
            tagDto = null;
        } else {
            tagDto = TagDto.builder()
                    .name(tag.getName())
                    .build();
        }
        return tagDto;
    }

    public static List<TagDto> from(Set<Tag> tags) {
        List<TagDto> tagDtos = new ArrayList<>();
        for (Tag tag : tags) {
            TagDto tagDto = TagDto.builder()
                    .name(tag.getName()).build();
            tagDtos.add(tagDto);
        }
        return tagDtos;
    }

    public static Set<Tag> convertTagDtoListToTagSet(List<TagDto> tagDtoList) {
        Set<Tag> tagSet = new HashSet<>();
        for (TagDto tagDto : tagDtoList) {
            tagSet.add(new Tag(tagDto.getName()));
        }
        return tagSet;
    }
}
