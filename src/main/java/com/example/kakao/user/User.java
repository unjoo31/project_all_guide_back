package com.example.kakao.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;

import com.example.kakao.region.Region;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="user_tb")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private String picUrl;
    @Column(nullable = true)
    private String username;
    @Column(length = 100, nullable = false, unique = true)
    private String email; // 인증시 필요한 필드
    @Column(length = 100, nullable = false)
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    private Region region;
    @Column(nullable = true)
    private Date age;
    @Column(nullable = true)
    private String phoneNumber;

    @Builder
    public User(int id, String picUrl, String username, String email, String password, Region region, Date age,
            String phoneNumber) {
        this.id = id;
        this.picUrl = picUrl;
        this.username = username;
        this.email = email;
        this.password = password;
        this.region = region;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    
}
