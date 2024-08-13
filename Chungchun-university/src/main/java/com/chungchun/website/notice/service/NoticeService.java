package com.chungchun.website.notice.service;

import com.chungchun.website.notice.model.Notice;
import com.chungchun.website.notice.model.NoticeDTO;
import com.chungchun.website.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional( readOnly = true)

public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final ModelMapper modelMapper;

    public Page<NoticeDTO> findAllNotices(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("noticeNo").descending());

        Page<Notice> foundAllNotices = noticeRepository.findAll(pageable);
        log.info("공지사항 수: {}", foundAllNotices.getTotalElements());

        return foundAllNotices.map(notice -> modelMapper.map(notice, NoticeDTO.class));
    }
}
