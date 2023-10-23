package com.example.kakao.whereGuide;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.category.Category;
import com.example.kakao.menu.Menu;
import com.example.kakao.region.Region;
import com.example.kakao.user.User;
import com.example.kakao.whereStore.WhereStore;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="where_guide_tb")
public class WhereGuide {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToOne(fetch = FetchType.LAZY)
    private Region region;
    @OneToMany(fetch = FetchType.LAZY)
    private WhereStore whereStore;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public WhereGuide(int id, Category category, Region region, WhereStore whereStore, User user) {
        this.id = id;
        this.category = category;
        this.region = region;
        this.whereStore = whereStore;
        this.user = user;
    }   
}
