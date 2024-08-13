package com.chungchun.website.notice.controller;

import com.chungchun.website.common.ArticlePage;
import com.chungchun.website.common.PagingButtonInfo;
import com.chungchun.website.notice.model.NoticeDTO;
import com.chungchun.website.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
@Slf4j

public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/noticeDetails")
    public String noticeDetails(@RequestParam(required = false) String noticeNo, Model model, @PageableDefault Pageable pageable) {

        log.info("요청받고");
        Page<NoticeDTO> noticeList;

        noticeList = noticeService.findAllNotices(pageable);

        log.info("noticeList : {}", noticeList);

        PagingButtonInfo paging = ArticlePage.getPagingButtonInfo(noticeList);


        model.addAttribute("paging", paging);
        model.addAttribute("noticeList", noticeList);

        return "notice/noticeDetails";
    }
}
