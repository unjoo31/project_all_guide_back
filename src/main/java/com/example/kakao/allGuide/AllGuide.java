package com.example.kakao.allGuide;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="all_guide_tb")
public class AllGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String picUrl;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String browserName;

    @Builder
    public AllGuide(int id, String picUrl, String title, String browserName) {
        this.id = id;
        this.picUrl = picUrl;
        this.title = title;
        this.browserName = browserName;
    }  
}
