package com.chungchun.website.notice.repository;

import com.chungchun.website.notice.common.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer> {
}