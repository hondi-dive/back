package com.example.kakao.global;

import com.example.kakao.domain.divepost.Divepost;
import com.example.kakao.domain.divepost.DivepostRepository;
import com.example.kakao.domain.divepost.service.DivepostService;
import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.point.PointRepository;
import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.UserRepository;
import com.example.kakao.global.types.DiveType;
import com.example.kakao.global.types.EntryType;
import com.example.kakao.global.types.RoleType;
import com.example.kakao.global.types.WaterFlowType;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Component
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private DivepostRepository divepostRepository;
    @Autowired
    private EntityManager entityManager;

    @Value("${app.base-url}")
    private String baseUrl;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        String imgPath = baseUrl + "/imgStorage/";
        String defaultUserImgUrl = baseUrl + "/imgStorage/" + "defaultUserImg.jpeg";
        // 유저 초기 데이터 입력
        if (!userRepository.findByUserName("BlueStar").isPresent()) {
            User user2 = User.builder()
                    .userName("BlueStar")
                    .imageUri(defaultUserImgUrl)
                    .roleType(RoleType.of("ROLE_USER"))
                    .build();
            userRepository.save(user2);
        }

        if (!userRepository.findByUserName("LinLin").isPresent()) {
            User user3 = User.builder()
                    .userName("LinLin")
                    .imageUri(defaultUserImgUrl)
                    .roleType(RoleType.of("ROLE_USER"))
                    .build();
            userRepository.save(user3);
        }

        if (!userRepository.findByUserName("JiMing").isPresent()) {
            User user4 = User.builder()
                    .userName("JiMing")
                    .imageUri(defaultUserImgUrl)
                    .roleType(RoleType.of("ROLE_USER"))
                    .build();
            userRepository.save(user4);
        }

        if (!userRepository.findByUserName("JiHyuk").isPresent()) {
            User user5 = User.builder()
                    .userName("JiHyuk")
                    .imageUri(defaultUserImgUrl)
                    .roleType(RoleType.of("ROLE_USER"))
                    .build();
            userRepository.save(user5);
        }

        // 포인트 더미데이터
        if (!pointRepository.findByName("판포포구").isPresent()) {
            Point point1 = Point.builder()
                    .name("판포포구")
                    .latitude(33.365216)
                    .longitude(126.200269)
                    .build();
            pointRepository.save(point1);
        }
        if (!pointRepository.findByName("월령포구").isPresent()) {
            Point point2 = Point.builder()
                    .name("월령포구")
                    .latitude(33.365216)
                    .longitude(126.200269)
                    .build();
            pointRepository.save(point2);
        }
        if (!pointRepository.findByName("범섬").isPresent()) {
            Point point3 = Point.builder()
                    .name("범섬")
                    .latitude(33.3218354)
                    .longitude(126.516717)
                    .build();
            pointRepository.save(point3);
        }
        Point point4;
        if (!pointRepository.findByName("황우지선녀탕").isPresent()) {
            point4 = Point.builder()
                    .name("황우지선녀탕")
                    .latitude(33.239479)
                    .longitude(126.548912)
                    .build();
            point4 = pointRepository.save(point4); // Point 객체를 저장하고 반환된 저장된 Point 객체를 사용
        }
        else {
            point4 = pointRepository.findByName("황우지선녀탕").get(); // 이미 저장된 Point 객체 사용
        }
        if (!pointRepository.findByName("월령포구").isPresent()) {
            Point point30 = Point.builder()
                    .name("월령포구")
                    .latitude(33.24152)
                    .longitude(126.463248)
                    .build();
            pointRepository.save(point30);
        }
        if (!pointRepository.findByName("김녕포구").isPresent()) {
            Point point5 = Point.builder()
                    .name("김녕포구")
                    .latitude(33.557752)
                    .longitude(126.758989)
                    .build();
            pointRepository.save(point5);
        }
        if (!pointRepository.findByName("김녕해변").isPresent()) {
            Point point6 = Point.builder()
                    .name("김녕해변")
                    .latitude(33.557752)
                    .longitude(126.758989)
                    .build();
            pointRepository.save(point6);
        }
        if (!pointRepository.findByName("중문해수욕장").isPresent()) {
            Point point7 = Point.builder()
                    .name("중문해수욕장")
                    .latitude(33.243064)
                    .longitude(126.412131)
                    .build();
            pointRepository.save(point7);
        }
        if (!pointRepository.findByName("함덕해변").isPresent()) {
            Point point8 = Point.builder()
                    .name("함덕해변")
                    .latitude(33.243064)
                    .longitude(126.412131)
                    .build();
            pointRepository.save(point8);
        }
        if (!pointRepository.findByName("이호테우해변").isPresent()) {
            Point point9 = Point.builder()
                    .name("이호테우해변")
                    .latitude(33.498197)
                    .longitude(126.452930)
                    .build();
            pointRepository.save(point9);
        }
        if (!pointRepository.findByName("협재해변").isPresent()) {
            Point point10 = Point.builder()
                    .name("협재해변")
                    .latitude(33.294390)
                    .longitude(126.239582)
                    .build();
            pointRepository.save(point10);
        }
        if (!pointRepository.findByName("다이빙포인트").isPresent()) {
            Point point11 = Point.builder()
                    .name("다이빙포인트")
                    .latitude(33.294390)
                    .longitude(126.239582)
                    .build();
            pointRepository.save(point11);
        }

        if (!userRepository.findByUserName("JaeHyuk").isPresent()) {
            User user1 = User.builder()
                    .userName("JaeHyuk")
                    .imageUri(defaultUserImgUrl)
                    .roleType(RoleType.of("ROLE_USER"))
                    .build();
            userRepository.save(user1);
        }

        Divepost post1 = Divepost.builder()
                .user(userRepository.findById(1).get())
                .point(point4)
                .diveType(DiveType.SNORKEL)
                .date(LocalDateTime.now())
                .star(1)
                .text("선녕탕 엄청 크게 기대하고 갔는데 입장금지된지 오래됬다고 하네요 ㅠㅠ\n#너무졸띠")
                .imgUrl(imgPath + "sample1.jpeg").build();
        divepostRepository.save(post1);

        Divepost post2 = Divepost.builder()
                .user(userRepository.findById(2).get())
                .point(point4)
                .diveType(DiveType.SNORKEL)
                .date(LocalDateTime.now().minusDays(1))
                .text("구름톤 짱재밌다 진짜재밌다 너무너무재밌다")
                .star(4)
                .imgUrl(imgPath + "sample2.jpeg").build();
        divepostRepository.save(post2);

        Divepost post3 = Divepost.builder()
                .user(userRepository.findById(3).get())
                .point(point4)
                .diveType(DiveType.SNORKEL)
                .star(3)
                .date(LocalDateTime.now().minusDays(2))
                .imgUrl(imgPath + "sample3.jpeg").build();
        divepostRepository.save(post3);

        Divepost post4 = Divepost.builder()
                .user(userRepository.findById(4).get())
                .point(point4)
                .diveType(DiveType.SNORKEL)
                .date(LocalDateTime.now().minusHours(1))
                .star(5)
                .imgUrl(imgPath + "sample4.jpeg").build();
        divepostRepository.save(post4);

        Divepost post5 = Divepost.builder()
                .user(userRepository.findById(1).get())
                .point(point4)
                .diveType(DiveType.FREEDIVE)
                .date(LocalDateTime.now().minusHours(10))
                .deepFlow(WaterFlowType.MIDDLE)
                .diveEntry(EntryType.BEATCH)
                .eyesight(20)
                .star(5)
                .text("너무너무재미있었습니다!!")
                .imgUrl(imgPath + "sample5.jpeg").build();
        divepostRepository.save(post5);
        // ...
    }
}
