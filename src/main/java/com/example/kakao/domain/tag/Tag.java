package com.example.kakao.domain.tag;


import com.example.kakao.domain.divepost.Divepost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(name = "tag_name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Divepost> diveposts = new ArrayList<>();

    @Builder
    public Tag(String name)
    {
        this.name = name;
    }
    // 생성자, getter, setter, toString 등의 메소드
}