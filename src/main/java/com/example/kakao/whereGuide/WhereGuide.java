package com.example.kakao.whereGuide;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.kakao.HashMenu.HashMenu;
import com.example.kakao.category.Category;
import com.example.kakao.keywordFirst.KeywordFirst;
import com.example.kakao.keywordSecond.KeywordSecond;
import com.example.kakao.menu.Menu;
import com.example.kakao.region.Region;
import com.example.kakao.user.User;
import com.example.kakao.whereStore.WhereStore;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @OneToMany(mappedBy = "whereGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WhereStore> whereStoreList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(nullable = false)
    private int orderPrice;
    @JsonIgnore
    @OneToMany(mappedBy = "whereGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HashMenu> hashMenuList = new ArrayList<>();
    @OneToMany(mappedBy = "whereGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordFirst> keywordFirstList = new ArrayList<>();
    @OneToMany(mappedBy = "whereGuide", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordSecond> keywordSecondList = new ArrayList<>();

    @Builder
    public WhereGuide(int id, Category category, Region region, List<WhereStore> whereStoreList, User user,
            int orderPrice, List<HashMenu> hashMenuList, List<KeywordFirst> keywordFirstList,
            List<KeywordSecond> keywordSecondList) {
        this.id = id;
        this.category = category;
        this.region = region;
        this.whereStoreList = whereStoreList;
        this.user = user;
        this.orderPrice = orderPrice;
        this.hashMenuList = hashMenuList;
        this.keywordFirstList = keywordFirstList;
        this.keywordSecondList = keywordSecondList;
    } 
}
