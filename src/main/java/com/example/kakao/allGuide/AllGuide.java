package com.example.kakao.allGuide;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.kakao.HashMenu.HashMenu;
import com.example.kakao.keywordFirst.KeywordFirst;
import com.example.kakao.keywordSecond.KeywordSecond;

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
    @OneToMany(mappedBy = "allGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordFirst> keywordFirstList = new ArrayList<>();
    @OneToMany(mappedBy = "allGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordSecond> keywordSecondList = new ArrayList<>();

    @Builder
    public AllGuide(int id, String picUrl, String title, String browserName, List<KeywordFirst> keywordFirstList,
            List<KeywordSecond> keywordSecondList) {
        this.id = id;
        this.picUrl = picUrl;
        this.title = title;
        this.browserName = browserName;
        this.keywordFirstList = keywordFirstList;
        this.keywordSecondList = keywordSecondList;
    } 
}
