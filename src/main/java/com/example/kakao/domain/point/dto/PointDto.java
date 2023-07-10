package com.example.kakao.domain.point.dto;

import com.example.kakao.domain.point.Point;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {
    private Integer pointId;
    private String name;
    private Double latitude;
    private Double longitude;

    public static PointDto from(Point point) {
        return PointDto.builder()
                .pointId(point.getId())
                .name(point.getName())
                .latitude(point.getLatitude())
                .longitude(point.getLongitude())
                .build();
    }
}
