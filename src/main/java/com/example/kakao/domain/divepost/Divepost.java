package com.example.kakao.domain.divepost;

import com.example.kakao.domain.feedback.Feedback;
import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.tag.Tag;
import com.example.kakao.domain.user.User;
import com.example.kakao.global.types.DiveType;
import com.example.kakao.global.types.EntryType;
import com.example.kakao.global.types.WaterFlowType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Divepost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dive_type")
    private DiveType diveType;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    private Point point;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "star")
    private Integer star;

    @Column(name = "text")
    private String text;

    @Column(name = "eyesight")
    private Integer eyesight; //시야 (미터)

    @Column(name = "dive_entry")
    private EntryType diveEntry;
    //enum??

    @Column(name = "surface_flow")
    private WaterFlowType surfaceFlow;
    //enum

    @Column(name = "deep_flow")
    private WaterFlowType deepFlow;

    @Column(name = "water_temp")
    private Double waterTemp;

    @Column(name = "temp")
    private Double temp;

    @Column(name = "dive_time")
    private Integer diveTime; //분

    @Column(name = "before_intake")
    private Integer beforeIntake; //bar

    @Column(name = "after_intake")
    private Integer afterIntake; //bar

    @Column(name = "max_depth")
    private Integer maxDepth; //미터

    @Column(name = "point_depth")
    private Integer pointDepth; //미터

    @Column(name = "decompression")
    private Integer decompression; //감압시간

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @OneToMany(mappedBy = "divepost")
    private List<Feedback> feedbacks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "divepost_tag",
            joinColumns = @JoinColumn(name = "divepost_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
}
