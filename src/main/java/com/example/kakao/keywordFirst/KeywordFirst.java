package com.example.kakao.keywordFirst;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.keywordSecond.KeywordSecond;
import com.example.kakao.region.Region;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whoGuide.WhoGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="keyword_first_tb")
public class KeywordFirst {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String keywordFirstName;
    @ManyToOne(fetch = FetchType.LAZY)
    private AllGuide allGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhoGuide whoGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private KeywordSecond keywordSecond;

    @Builder
    public KeywordFirst(int id, String keywordFirstName, AllGuide allGuide, WhoGuide whoGuide, WhereGuide whereGuide,
            KeywordSecond keywordSecond) {
        this.id = id;
        this.keywordFirstName = keywordFirstName;
        this.allGuide = allGuide;
        this.whoGuide = whoGuide;
        this.whereGuide = whereGuide;
        this.keywordSecond = keywordSecond;
    }   
}
