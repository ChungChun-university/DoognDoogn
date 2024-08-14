# DoognDoogn

## 💻 `프로젝트 소개`
> 힘든 삶 속에서 대학생으로 회귀한다면?..
> 청춘 남녀들의 잊지 못할
> 대학생 체험기
> 가상 대학생활을 몸소 체험하며 
> 두근두근함을 느끼는
> 우리는 청춘대🎀
> 두근두근
> 청춘❤


`청춘 남녀들의 잊지 못할 대학생 체험기 가상 대학생활을 몸소 체험하며 두근두근함을 느끼는 우리는 청춘대🎀 두근두근 청춘❤`  

##  ⌨️ `개발 기간`


## 🧑‍🤝‍🧑 `멤버구성`
 - 팀원1 : 지동현
 - 팀원2 : 박성은
 - 팀원3 : 배하은
 - 팀원4 : 이의정

## ⚙️ `개발 환경`




## 📂 `패키지구조(Artifact)` 
```
+---java
|   \---com
|       \---chungchun
|           \---website
|               |   ChungchunUniversityApplication.java
|               |
|               +---auth
|               |   +---controller
|               |   |       AuthController.java
|               |   |
|               |   +---principal
|               |   |       AuthPrincipal.java
|               |   |
|               |   \---service
|               |           AuthService.java
|               |
|               +---comment
|               |   +---controller
|               |   |       CommentController.java
|               |   |
|               |   +---model
|               |   |       Comment.java
|               |   |       CommentDTO.java
|               |   |
|               |   +---repository
|               |   |       CommentRepository.java
|               |   |
|               |   \---service
|               |           CommentService.java
|               |
|               +---common
|               |       ArticlePage.java
|               |       MainController.java
|               |       PagingButtonInfo.java
|               |
|               +---config
|               |       BeanConfiguration.java
|               |
|               +---course
|               |   +---controller
|               |   |       CourseController.java
|               |   |
|               |   +---model
|               |   |       Course.java
|               |   |       CourseDTO.java
|               |   |
|               |   +---repository
|               |   |       CourseRepository.java
|               |   |
|               |   \---service
|               |           CourseService.java
|               |
|               +---likes
|               |   +---controller
|               |   |       LikeController.java
|               |   |       LikeViewController.java
|               |   |
|               |   +---exception
|               |   |       LikeAlreadyExistsException.java
|               |   |       LikeNotFoundException.java
|               |   |
|               |   +---model
|               |   |       Like.java
|               |   |       LikeDTO.java
|               |   |
|               |   +---repository
|               |   |       LikeRepository.java
|               |   |
|               |   +---response
|               |   |       LikeResponse.java
|               |   |
|               |   \---service
|               |           LikeService.java
|               |
|               +---myclass
|               |   +---controller
|               |   |       MyClassController.java
|               |   |
|               |   +---model
|               |   |       MyClass.java
|               |   |       MyClassDTO.java
|               |   |
|               |   +---repository
|               |   |       MyClassRepository.java
|               |   |
|               |   \---service
|               |           MyClassService.java
|               |
|               +---notice
|               |   +---controller
|               |   |       NoticeController.java
|               |   |
|               |   +---model
|               |   |       Notice.java
|               |   |       NoticeDTO.java
|               |   |
|               |   +---repository
|               |   |       NoticeRepository.java
|               |   |
|               |   \---service
|               |           NoticeService.java
|               |
|               +---post
|               |   +---controller
|               |   |       PostController.java
|               |   |
|               |   +---model
|               |   |       Post.java
|               |   |       PostDTO.java
|               |   |
|               |   +---repository
|               |   |       PostRepository.java
|               |   |
|               |   \---service
|               |           PostService.java
|               |
|               +---user
|               |   +---controller
|               |   |       UserController.java
|               |   |       UserSearchRequest.java
|               |   |
|               |   +---model
|               |   |       RoleType.java
|               |   |       User.java
|               |   |       UserDTO.java
|               |   |
|               |   +---repository
|               |   |       UserRepository.java
|               |   |
|               |   \---service
|               |           UserService.java
|               |
|               \---webconfig
|                       CustomAuthenticationSuccessHandler.java
|                       WebSecurityConfig.java
|
\---resources
    |   application.yml
    |
    +---chungchundb
    |       comment.sql
    |       course.sql
    |       data.sql
    |       likes.sql
    |       myclass.sql
    |       notice.sql
    |       post.sql
    |       user.sql
    |
    +---static
    |   |   alert.html
    |   |   alert3.html
    |   |   index.html
    |   |
    |   +---css
    |   |       main.css
    |   |       postDefault.css
    |   |
    |   \---image
    |           bin.png
    |           filledHeart.png
    |           finger.png
    |           h-logo.png
    |           heart.png
    |           loginform.png
    |           logo.png
    |           logo1.png
    |           pink-search.png
    |           pink-wing-left.png
    |           pink-wing-right.png
    |           s-cookie.png
    |           searchPic.PNG
    |           sp-back.png
    |           starline.PNG
    |           user2Image.PNG
    |           수정버튼.png
    |           왕관.png
    |           좋아요.png
    |
    \---templates
        |   main.html
        |
        +---admin
        |       admin.html
        |
        +---auth
        |       login.html
        |
        +---comment
        |       comment.html
        |       createComment.html
        |       myCommentView.html
        |
        +---common
        +---course
        |       courseMain.html
        |
        +---fragments
        |       adminheader.html
        |       header.html
        |       MyPageNav.html
        |       PostNav.html
        |
        +---layout
        |       admindefault.html
        |       default.html
        |       MyPageDefault.html
        |       PostDefault.html
        |
        +---like
        |       my-likes.html
        |
        +---myClass
        |       myClassView.html
        |
        +---myPage
        |       myPage.html
        |
        +---notice
        |       noticeDetails.html
        |       readNotice.html
        |
        +---post
        |       createPost.html
        |       edit.html
        |       myPost.html
        |       postDetails.html
        |       readPost.html
        |
        \---user
                edit.html
                profile.html
                queryId.html
                signUp.html
