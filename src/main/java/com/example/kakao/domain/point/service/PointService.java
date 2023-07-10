package com.example.kakao.domain.point.service;

import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.point.PointRepository;
import com.example.kakao.domain.point.dto.PointDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    @Transactional
    public List<PointDto> findAllPoints(){
        List<Point> pointList = pointRepository.findAll();
        List<PointDto> pointDtoList = new ArrayList<>();
        for (Point point : pointList) {
            pointDtoList.add(PointDto.from(point));
        }
        return pointDtoList;
    }
}
