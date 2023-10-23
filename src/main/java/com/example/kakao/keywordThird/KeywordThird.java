package com.example.kakao.keywordThird;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.keywordSecond.KeywordSecond;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whoGuide.WhoGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="keyword_third_tb")
public class KeywordThird {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String keywordThirdName;
    @ManyToOne(fetch = FetchType.LAZY)
    private AllGuide allGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhoGuide whoGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;

    @Builder
    public KeywordThird(int id, String keywordThirdName, AllGuide allGuide, WhoGuide whoGuide, WhereGuide whereGuide) {
        this.id = id;
        this.keywordThirdName = keywordThirdName;
        this.allGuide = allGuide;
        this.whoGuide = whoGuide;
        this.whereGuide = whereGuide;
    }   
}
