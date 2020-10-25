# Study-Securit-Project
## Spring Boot(Gradle), Oauth, JPA(MySQL)
### Spring Security, Google, Facebook, Naver Login
- - -

## 프로젝트 구성

![1](/src/main/resources/static/201026-1.png)<br><br>

### Class
![2](/src/main/resources/static/201026-2.png)<br>

- - -

## Login Page

![3](/src/main/resources/static/201026-3.png)<br>

- - -

## Security 회원가입 & 로그인
### 스프링 시큐리티 + BCryptPasswordEncoder

![4](/src/main/resources/static/201026-4.gif)<br>


### DB(암호화 해시 함수)
![5](/src/main/resources/static/201026-5.png)<br>

- - -

## Google OAuth 로그인 & 조회
![6](/src/main/resources/static/201026-6.gif)<br>

### Oauth User Data
```json
{
  "id": 10,
  "email": "vividswan@gmail.com",
  "role": "ROLE_USER",
  "providerId": "google",
  "createDate": "2020-10-25T15:19:57.850+00:00"
}
```

- - -

## Facebook OAuth 로그인 & 조회
![7](/src/main/resources/static/201026-7.gif)<br>

### Oauth User Data

```json
{
  "id": 11,
  "email": "vividswan@naver.com",
  "role": "ROLE_USER",
  "providerId": "facebook",
  "createDate": "2020-10-25T15:23:15.176+00:00"
}
```

- - -

## Naver 로그인 & 조회
![8](/src/main/resources/static/201026-8.gif)<br>

### Oauth User Data
```json
{
  "id": 12,
  "email": "vividswan@naver.com",
  "role": "ROLE_USER",
  "providerId": "naver",
  "createDate": "2020-10-25T15:23:57.527+00:00"
}
```

- - -
