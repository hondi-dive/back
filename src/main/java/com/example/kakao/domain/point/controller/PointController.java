package com.example.kakao.domain.point.controller;

import com.example.kakao.domain.point.dto.PointDto;
import com.example.kakao.domain.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/points")
public class PointController {

    private final PointService pointService;
    @GetMapping
    public List<PointDto> findAllPoints (){
        return pointService.findAllPoints();
    }
}