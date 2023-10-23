-- user_tb 테이블
INSERT INTO user_tb (pic_url, username, password, email, age, phone_number)
VALUES ('profile_image_1.png', 'unjoo', '1234', 'unjoo31@gmail.com', '2010-08-10', '010-1234-5678');

-- region_tb 테이블
INSERT INTO region_tb (region_name) VALUES ('부산'), ('서울'), ('대구'), ('울산'), ('전주'), ('수원');

-- category_tb 테이블
INSERT INTO category_tb (category_name) VALUES ('건강'), ('여행'), ('반려동물'), ('공부'), ('서류'), ('일상'), ('요리'), ('음식점'), ('카페');

-- menu_tb 테이블
INSERT INTO menu_tb (menu_name, menu_price) VALUES 
('애플시나몬 케이크', '6,000원'), ('초코 브라우니', '6,000원'), ('황치즈 브라우니', '6,000원'),
('에스프레소', '4,500원'), ('아메리카노', '4,500원'), ('카페 라떼', '5,500원'), ('바닐라 라떼', '5,500원'),
('흑임자 라떼', '6,500원'), ('말차 라떼', '5,500원');

-- keyword_tb 테이블
INSERT INTO keyword_tb (keyword_name) VALUES 
('그림'), ('반려동물'), ('건강검진'), ('병원'), ('날씨'), ('겨울여행'), ('이력서 작성방법'), ('화분'), ('크리스마스'),
('카레'), ('조명'), ('이사'), ('자동차'), ('넷플릭스'), ('이직'), ('종류'), ('전구'), ('인테리어'),
('세척'), ('교체하기'), ('분리하기'), ('변경하기'), ('강아지'), ('고양이'), ('햄스터'), ('키우기'), ('산책'), 
('먹이'), ('애견카페'), ('새'), ('용품'), ('목욕'), ('방법');

-- where_store_tb 테이블
INSERT INTO where_store_tb (category_id, region_id, store_name, store_address) 
VALUES (9, 1, '턴어라운드', '부산 부산진구 전포대로200번길 21 1층 턴어라운드');

-- where_guide_tb 테이블
INSERT INTO where_guide_tb (category_id, region_id, user_id, order_price)
VALUES (9, 1, 1, 22000);


-- hash_menu_tb 테이블
INSERT INTO hash_menu_tb (menu_id, where_guide_id, where_store_id) VALUES 
(1, 1, 1), (3, 1, 1), (5, 1, 1), (6, 1, 1);

-- pay_tb 테이블
INSERT INTO pay_tb (user_id, where_guide_id) VALUES (1, 1);

-- all_guide_tb 테이블
INSERT INTO all_guide_tb (pic_url, title, browser_name) 
VALUES ('all_guide_1.png', '스탠딩 조병 전구 변경하기', 'Google');

-- who_guide_tb 테이블
INSERT INTO who_guide_tb (category_id, pic_url_first, pic_url_second, pic_url_third, title, content, user_id) 
VALUES (3, 'who_guide_1.png', 'who_guide_2.png', 'who_guide_3.png', '반려동물 강아지 산책 초보 훈련기', '강아지 첫 산책 시기는 어린 강아지를 데려온 반려인이라면 누구나 하는 고민입니다.
아주 어릴 때는 집에서 장난...책 시기에 관한 고민을 단번에 해결해 줄 글을 준비했습니다.', 1);

-- bookmark_tb 테이블
INSERT INTO bookmark_tb (user_id, all_guide_id, who_guide_id, where_guide_id) VALUES (1, 1, 1, 1);

-- keyword_first_tb 테이블
INSERT INTO keyword_first_tb (keyword_id, all_guide_id, who_guide_id, where_guide_id) VALUES (11, 1, null, null), (23, null, 1, null);

-- keyword_second_tb 테이블
INSERT INTO keyword_second_tb (keyword_id, all_guide_id, who_guide_id, where_guide_id) VALUES (17, 1, null, null), (22, 1, null, null), (27, null, 1, null);
