package com.example.kakao.whereStore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.kakao.HashMenu.HashMenu;
import com.example.kakao.category.Category;
import com.example.kakao.menu.Menu;
import com.example.kakao.region.Region;
import com.example.kakao.user.User;
import com.example.kakao.whereGuide.WhereGuide;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="where_store_tb")
public class WhereStore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToOne(fetch = FetchType.LAZY)
    private Region region;
    @Column(nullable = false)
    private String storeName;
    @Column(nullable = false)
    private String storeAddress;
    @Column(nullable = false)
    private String picUrl;
    @JsonIgnore
    @OneToMany(mappedBy = "whereStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HashMenu> hashMenuList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "where_guide_id")
    private WhereGuide whereGuide;

    @Builder
    public WhereStore(int id, Category category, Region region, String storeName, String storeAddress, String picUrl,
            List<HashMenu> hashMenuList, WhereGuide whereGuide) {
        this.id = id;
        this.category = category;
        this.region = region;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.picUrl = picUrl;
        this.hashMenuList = hashMenuList;
        this.whereGuide = whereGuide;
    }
}
