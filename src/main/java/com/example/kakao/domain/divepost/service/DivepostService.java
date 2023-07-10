package com.example.kakao.domain.divepost.service;


import com.example.kakao.domain.divepost.Divepost;
import com.example.kakao.domain.divepost.DivepostRepository;
import com.example.kakao.domain.divepost.dto.*;
import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.point.PointRepository;
import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.UserRepository;
import com.example.kakao.global.fileUploader.FileHandler;
import com.example.kakao.global.types.DiveType;
import com.example.kakao.global.types.EntryType;
import com.example.kakao.global.types.WaterFlowType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DivepostService {
    private final DivepostRepository divepostRepository;
    private final PointRepository pointRepository;
    private final UserRepository userRepository;
    private final FileHandler fileHandler;

    @Transactional(readOnly = true)
    public DivepostAbbResDto findAllDivepostFeedByPointId(Integer pointId, DiveType diveType) {
        Point point = pointRepository.findById(pointId).orElseThrow(() -> new RuntimeException());

        List<Divepost> divePostList;
        if (Objects.isNull(diveType))
            divePostList = divepostRepository.findAllByPointOrderByDateDesc(point);
        else
            divePostList = divepostRepository.findAllByPointAndDiveType(point, diveType);
        List<DivepostFeedDto> resDtoList = new ArrayList<>();

        for (Divepost divepost : divePostList) {
            resDtoList.add(DivepostFeedDto.from(divepost));
        }
       return DivepostAbbResDto.builder()
                .pointName(point.getName())
                .divePostList(resDtoList)
                .build();
    }

    @Transactional
    public DivepostDto findDivepostDetailById(Integer divepostId) {
        return DivepostDto.from(divepostRepository.findById(divepostId).orElse(divepostRepository.findById(1).get()));
    }
    @Transactional
    public void saveDivepost(CreateDivepostReqDto reqDto, MultipartFile multipartFile, User user) {
        String imgUrl = fileHandler.uploadFile(multipartFile);
        Divepost divepost = Divepost.builder()
                .diveType(DiveType.of(reqDto.getCategory()))
                .imgUrl(imgUrl)
                .user(userRepository.findById(Objects.isNull(user.getId()) ? 1 : user.getId()).orElseThrow(() -> new RuntimeException())) //수정필요!
                .point(Objects.nonNull(reqDto.getPointId()) ? pointRepository.findById(reqDto.getPointId()).orElse(null) : null)
                .date(reqDto.getDate())
                .star(reqDto.getStar())
                .text(reqDto.getText())
                .eyesight(reqDto.getEyesight())
                .diveEntry(Objects.isNull(reqDto.getDiveEntry()) ? null : EntryType.of(reqDto.getDiveEntry()))
                .surfaceFlow(Objects.isNull(reqDto.getSurfaceFlow()) ? null : WaterFlowType.of(reqDto.getSurfaceFlow()) )
                .deepFlow(Objects.isNull(reqDto.getSurfaceFlow()) ? null : WaterFlowType.of(reqDto.getDeepFlow()))
                .waterTemp(reqDto.getWaterTemp())
                .temp(reqDto.getTemp())
                .diveTime(reqDto.getDiveTime())
                .beforeIntake(reqDto.getBeforeIntake())
                .afterIntake(reqDto.getAfterIntake())
                .maxDepth(reqDto.getMaxDepth())
                .pointDepth(reqDto.getPointDepth())
                .decompression(reqDto.getDecompression())
                .likeCnt(0)
                .feedbacks(new ArrayList<>())
                .tags(new HashSet<>())
                .build();
        divepostRepository.save(divepost);

    }
}
