package com.example.kakao.domain.divepost.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class DivepostAbbResDto {
    private String pointName;
    private List<DivepostFeedDto> divePostList;

}
