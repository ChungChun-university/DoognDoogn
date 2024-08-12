package com.chungchun.website.likes.repository;
import com.chungchun.website.likes.model.Like;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
    Optional<Like> findByUserAndPost(User user, Post post);

    boolean existsByUserAndPost(User user, Post post);

    // User 객체를 사용하여 Like 목록을 찾는 메소드
    List<Like> findByUser(User user);

    // userNo를 사용하여 Like 목록을 찾는 메소드
    List<Like> findByUser_UserNo(int userNo); // User의 userNo 속성을 사용

    void deleteByUser_UserNoAndPost_PostNo(int userNo, int postNo);
}
