package com.example.kakao.domain.user;

import com.example.kakao.global.types.RoleType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "image_uri")
    private String imageUri;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;

//    @Column(name = "e_mail")
//    private String eMail;

    public User(){}
    @Builder
    public User(String userName, String imageUri, RoleType roleType){
        this.userName = userName;
        this.imageUri = imageUri;
        this.roleType = roleType;
    };
}
