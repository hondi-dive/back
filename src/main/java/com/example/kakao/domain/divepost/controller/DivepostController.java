package com.example.kakao.domain.divepost.controller;

import com.example.kakao.domain.divepost.dto.CreateDivepostReqDto;
import com.example.kakao.domain.divepost.dto.DivepostAbbResDto;
import com.example.kakao.domain.divepost.dto.DivepostDto;
import com.example.kakao.domain.divepost.service.DivepostService;
import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.UserRepository;
import com.example.kakao.global.securityV1.cookie.CookieUtil;
import com.example.kakao.global.types.DiveType;
import com.example.kakao.global.types.RoleType;
import com.example.kakao.global.utils.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diveposts")
public class DivepostController {

    private final DivepostService divepostService;
    private final UserRepository userRepository;
    private final CookieUtil cookieUtil;

    @Value("${app.base-url}")
    private String baseUrl;
    private String defaultUserImgUrl = baseUrl + "/imgStorage/" + "defaultUserImg.jpeg";

    @GetMapping("/{pointId}")
    public DivepostAbbResDto findAllFeed(@PathVariable Integer pointId, @RequestParam(required = false) String category) {
        DiveType diveType = Objects.isNull(category) ? null : DiveType.of(category);
        return divepostService.findAllDivepostFeedByPointId(pointId, diveType);
    }

    @GetMapping("/{divepostId}/detail")
    public DivepostDto findDivepostDetail(@PathVariable Integer divepostId) {
        return divepostService.findDivepostDetailById(divepostId);
    }

    @PostMapping
    public ResponseEntity createDivepost(@RequestPart CreateDivepostReqDto contents,
                                         @RequestPart(required = false) MultipartFile imgFile) throws IOException {
        String userName = contents.getUserName();
        if (Objects.isNull(userName))
            userName = "JaeHyuk";
        User user = userRepository.findByUserName(userName).orElse(null);
        if (Objects.isNull(user)) {
            User newUser = new User(userName, defaultUserImgUrl, RoleType.USER);
            userRepository.save(newUser);
            user = newUser;
        }
        System.out.println("USERINFO : " + user.getUserName() + " " + user.getId());
        if (imgFile != null) {
            if (imgFile.getContentType() == null ||
                    (!imgFile.getContentType().equals("image/jpeg") && !imgFile.getContentType().equals("image/png"))) {
                throw new RuntimeException();
            }
        }
        System.out.println(imgFile.getName() + " : " + imgFile.getContentType() + " " + imgFile.getSize());
        System.out.println(contents);
        divepostService.saveDivepost(contents, imgFile, user);

        return new ResponseEntity(HttpStatus.CREATED);
    }

}
