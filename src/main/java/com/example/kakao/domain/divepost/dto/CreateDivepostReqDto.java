package com.example.kakao.domain.divepost.dto;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDivepostReqDto {
    private String category;
    private String userName;
    private Integer pointId;
    private LocalDateTime date;
    private Integer star;
    private String text;
    private Integer eyesight;
    private String diveEntry;
    private String surfaceFlow;
    private String deepFlow;
    private Double waterTemp;
    private Double temp;
    private Integer diveTime;
    private Integer beforeIntake;
    private Integer afterIntake;
    private Integer maxDepth;
    private Integer pointDepth;
    private Integer decompression;

    @Override
    public String toString() {
        return "CreateDivepostReqDto{" +
                "pointId =" + pointId + '\n' +
                "category=" + category + '\n' +
                "date=" + date + '\n' +
                "star=" + star + '\n' +
                "text=" + text + '\n' +
                "eyesight=" + eyesight + '\n' +
                "diveEntry=" + diveEntry + '\n' +
                "surfaceFlow=" + surfaceFlow + '\n' +
                "deepFlow=" + deepFlow + '\n' +
                "waterTemp=" + waterTemp + '\n' +
                "temp=" + temp + '\n' +
                "diveTime=" + diveTime + '\n' +
                "beforeIntank=" + beforeIntake + '\n' +
                "afterIntank=" + afterIntake + '\n' +
                "maxDepth=" + maxDepth + '\n' +
                "pointDepth=" + pointDepth + '\n' +
                "decompression=" + decompression +
                '}';
    }
}
