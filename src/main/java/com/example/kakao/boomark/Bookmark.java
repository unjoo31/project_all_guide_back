package com.example.kakao.boomark;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.category.Category;
import com.example.kakao.region.Region;
import com.example.kakao.user.User;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whereStore.WhereStore;
import com.example.kakao.whoGuide.WhoGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="bookmark_tb")
public class Bookmark {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private AllGuide allGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhoGuide whoGuide;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;

    @Builder
    public Bookmark(int id, User user, AllGuide allGuide, WhoGuide whoGuide, WhereGuide whereGuide) {
        this.id = id;
        this.user = user;
        this.allGuide = allGuide;
        this.whoGuide = whoGuide;
        this.whereGuide = whereGuide;
    }    
}
