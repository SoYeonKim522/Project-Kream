# KREAM

### 0814
 - 로그인 화면 완성
 - 회원가입 화면 완성
 
### 0815
- bottom nav 틀 생성
- home fragment 화면 10%
- shop fragment 화면 60%

### 0816
- 로그인 액티비티에서 세부 기능 생성
    - 이메일/비번 validation 에 따른 뷰 변화
    - 입력 조건을 모두 만족해야지만 로그인/가입하기 버튼 활성화시키기
- 로그인, 회원가입 API 연동 코드 작성 (아직 API 100% 완성 전이라 테스트는 못함)
- shop 탭 화면 70%까지 완성

### 0817
- 로그인, 회원가입 API 연동 테스트 & 분기처리 완료
- 홈 프래그먼트 레이아웃 40% 까지 완성- 이미지 슬라이드 추가 (viewpager)
- bottom nav - 클릭 효과 생성

### 0818
- shop 탭 세부카테고리 연동 완료 : 필터링 버튼 클릭하면 그에 해당하는 세부카테고리 이미지 보여주도록 생성
- shop 탭 전체 상품 리스트 보여주는 API와 연동 완료
- Home 탭 레이아웃 70% 완성
  - ~~이미지 viewpager 자동 슬라이드 위한 스레드 - NPE 로 인해 수정 필요~~

### 0819
- 상품상세페이지 레이아웃 50% 완성
- 상품상세보기 api 연동 완료

### 0820
- 상품 상세 페이지 레이아웃 80% 완성
- 상품 거래 체결 내역 보기, 상품 판매 입찰 내역 보기, 상품 구매 입찰 내역 보기 api 연동 완료
- 같은 브랜드의 추천 상품 보기 api 연동 완료
- shop 탭에서 상품 클릭 시 상품상세 페이지로 이동하도록 설정
- shop 탭 필터링 버튼 - 중복 체크 불가하도록 하는 기능 해결 못함

### 0821
- 사이즈별 즉시 구매 가격 api 연동 완료 
  ('모든 사이즈' 버튼 클릭시에는 모든 데이터가 나오지만, 구매 버튼 클릭시에는 '모든 사이즈'에 대한 가격은 나오지 않도록 함)
- 사이즈별 즉시 퍈매 가격 api 연동 완료
   -> '모든 사이즈', '구매', '판매' 버튼 기능을 모두 구현하려면 버튼들에 하나의 클릭리스너를 사용해야 했기 때문에 기존코드에서 수정
- ~~bottom sheet fragment 에서 사이즈 클릭했을 때 bottom sheet 닫히도록 하는 기능은 미해결~~

### 0822
- 홈 탭 - 상품 광고 조회 api, 테마별 상품 조회 api, 배너 이미지 조회 api 반영
- my 탭 레이아웃 80% 완성

### 0823
- 로그인 하지 않은 경우 -  마이페이지로 이동하지 않고, 시세 보이지 않도록 구현
- 상품별 사이즈 api 연동 완료 (관심상품 담을 때 사용됨)
- 구매 사이즈 선택하면 선택한 사이즈와 해당 가격이 상품 페이지에 반영되도록 구현
