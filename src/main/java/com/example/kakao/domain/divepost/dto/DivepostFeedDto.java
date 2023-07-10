package com.example.kakao.domain.divepost.dto;

import com.example.kakao.domain.divepost.Divepost;
import com.example.kakao.domain.feedback.Feedback;
import com.example.kakao.domain.feedback.dto.FeedbackDto;
import com.example.kakao.domain.tag.Tag;
import com.example.kakao.global.types.DiveType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DivepostFeedDto {
    private Integer id;
    private String category;
    private String userName;
    private LocalDateTime date;
    private String imgUrl;

    public static DivepostFeedDto from(Divepost divepost) {
        return DivepostFeedDto.builder()
                .id(divepost.getId())
                .category(divepost.getDiveType().getKey())
                .userName(divepost.getUser().getUserName())
                .date(divepost.getDate())
                .imgUrl(divepost.getImgUrl())
                .build();
        // 다른 필드들도 필요에 따라 추가
    }

//    public static List<DivepostDto> from(List<Divepost> divepostList) {
//        List<DivepostDto> divepostDtoList = new ArrayList<>();
//        for (Divepost divepost : divepostList) {
//            divepostDtoList.add(DivepostDto.from(divepost));
//        }
//        return divepostDtoList;
//    }
}
