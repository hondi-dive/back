package com.example.kakao.domain.divepost.dto;

import com.example.kakao.domain.divepost.Divepost;
import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.tag.Tag;
import com.example.kakao.domain.tag.dto.TagDto;
import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.dto.UserDto;
import com.example.kakao.global.types.DiveType;
import com.example.kakao.domain.point.dto.PointDto;
import com.example.kakao.global.types.EntryType;
import com.example.kakao.global.types.WaterFlowType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DivepostDto {
    private Integer divepostId;
    private String userName;
    private String category;
    private String imgUrl;
    private String pointName;
    private LocalDateTime date;
    private Integer star;
    private String text;
    private Integer eyesight; //시야 (미터)
    private String diveEntry;
    private String surfaceFlow;
    private String deepFlow;
    private Double waterTemp;
    private Double temp;
    private Integer diveTime; //분
    private Integer beforeIntake; //bar
    private Integer afterIntake; //bar
    private Integer maxDepth; //미터
    private Integer pointDepth; //미터
    private Integer decompression; //감압시간
    private Integer likeCnt;

    public static DivepostDto from(Divepost divepost) {
        return DivepostDto.builder()
                .divepostId(divepost.getId())
                .userName(divepost.getUser().getUserName())
                .category(divepost.getDiveType().getKey())
                .imgUrl(divepost.getImgUrl())
                .pointName(divepost.getPoint().getName())
                .date(divepost.getDate())
                .star(divepost.getStar())
                .text(divepost.getText())
                .eyesight(divepost.getEyesight())
                .diveEntry(Objects.isNull(divepost.getDiveEntry()) ? null : divepost.getDiveEntry().getKey())
                .surfaceFlow(Objects.isNull(divepost.getSurfaceFlow()) ? null : divepost.getSurfaceFlow().getKey())
                .deepFlow(Objects.isNull(divepost.getDeepFlow()) ? null : divepost.getDeepFlow().getKey())
                .waterTemp(divepost.getWaterTemp())
                .temp(divepost.getTemp())
                .diveTime(divepost.getDiveTime())
                .beforeIntake(divepost.getBeforeIntake())
                .afterIntake(divepost.getAfterIntake())
                .maxDepth(divepost.getMaxDepth())
                .pointDepth(divepost.getPointDepth())
                .decompression(divepost.getDecompression())
                .likeCnt(divepost.getLikeCnt())
                .build();
    }
}
