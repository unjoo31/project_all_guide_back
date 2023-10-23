package com.example.kakao.keywordSecond;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.keywordThird.KeywordThird;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whoGuide.WhoGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="keyword_second_tb")
public class KeywordSecond {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String keywordSecondName;
    @ManyToOne(fetch = FetchType.LAZY)
    private AllGuide allGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhoGuide whoGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private KeywordThird keywordThird;

    @Builder
    public KeywordSecond(int id, String keywordSecondName, AllGuide allGuide, WhoGuide whoGuide, WhereGuide whereGuide,
            KeywordThird keywordThird) {
        this.id = id;
        this.keywordSecondName = keywordSecondName;
        this.allGuide = allGuide;
        this.whoGuide = whoGuide;
        this.whereGuide = whereGuide;
        this.keywordThird = keywordThird;
    }    
}
