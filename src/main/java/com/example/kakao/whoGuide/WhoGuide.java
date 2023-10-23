package com.example.kakao.whoGuide;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.category.Category;
import com.example.kakao.keywordFirst.KeywordFirst;
import com.example.kakao.keywordSecond.KeywordSecond;
import com.example.kakao.user.User;
import com.example.kakao.whereGuide.WhereGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="who_guide_tb")
public class WhoGuide {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
    @Column(nullable = false)
    private String picUrlFirst;
    @Column(nullable = true)
    private String picUrlSecond;
    @Column(nullable = true)
    private String picUrlThird;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "whoGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordFirst> keywordFirstList = new ArrayList<>();
    @OneToMany(mappedBy = "whoGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordSecond> keywordSecondList = new ArrayList<>();

    @Builder
    public WhoGuide(int id, Category category, String picUrlFirst, String picUrlSecond, String picUrlThird,
            String title, String content, User user, List<KeywordFirst> keywordFirstList,
            List<KeywordSecond> keywordSecondList) {
        this.id = id;
        this.category = category;
        this.picUrlFirst = picUrlFirst;
        this.picUrlSecond = picUrlSecond;
        this.picUrlThird = picUrlThird;
        this.title = title;
        this.content = content;
        this.user = user;
        this.keywordFirstList = keywordFirstList;
        this.keywordSecondList = keywordSecondList;
    } 
}
