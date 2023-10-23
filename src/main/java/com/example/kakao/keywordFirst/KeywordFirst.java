package com.example.kakao.keywordFirst;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;

import com.example.kakao.Keyword.Keyword;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Keyword keyword;
    @ManyToOne(fetch = FetchType.LAZY)
    private AllGuide allGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhoGuide whoGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;

    @Builder
    public KeywordFirst(int id, Keyword keyword, AllGuide allGuide, WhoGuide whoGuide, WhereGuide whereGuide) {
        this.id = id;
        this.keyword = keyword;
        this.allGuide = allGuide;
        this.whoGuide = whoGuide;
        this.whereGuide = whereGuide;
    }
}
