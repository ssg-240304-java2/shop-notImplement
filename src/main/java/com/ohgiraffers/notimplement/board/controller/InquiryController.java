package com.ohgiraffers.notimplement.board.controller;

import com.ohgiraffers.notimplement.board.model.dto.BoardDTO;
import com.ohgiraffers.notimplement.board.model.service.InquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }


    @GetMapping("/inquiry/write")
    public String write(Model model) {
        model.addAttribute("boardDTO",null);
        return "userPage/board/test";
    }

    // 1:1문의등록(사용자) requestbody->modelAttribute로 수정
    @PostMapping("/inquiry")
    @ResponseBody
    public String saveInquiry(HttpServletRequest request,@ModelAttribute BoardDTO boardDTO) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");
        boardDTO.setUserId(userId);
        log.info("InquiryController : {} ===========> ",boardDTO.toString());
        boolean isSave = inquiryService.saveInquiry(boardDTO);
        return "redirect:/user/inquiry";
    }

    // 1:1문의 내용 수정
    @PutMapping("/inquiry")
    public String updateInquiry(@ModelAttribute BoardDTO boardDTO) {
        boolean isUpdate = inquiryService.updateInquiry(boardDTO);
        return "수정결과 : "+isUpdate;
    }

    @DeleteMapping("/inquiry/{boardSeq}")
    @ResponseBody
    public String deleteInquiry(@PathVariable int boardSeq) {
        boolean isDelete = inquiryService.deleteInquiry(boardSeq);
        return "삭제결과 : " + isDelete;
    }

    // 목록조회(관리자)
    @GetMapping("/admin/inquiry")
    public String showAdminInquiry(@RequestParam(required = false) String status, @RequestParam(required = false) String strDate, @RequestParam(required = false) String endDate, Model model) {

        List<BoardDTO> boardList = inquiryService.showBoardList(status, strDate,endDate,null);
        model.addAttribute("boardList",boardList);

        return "adminPage/board/inquiryList";
    }

    // 목록조회(사용자)
    @GetMapping("/user/inquiry")
    public String showUserInquiry(HttpServletRequest request, @RequestParam(required = false) String status, @RequestParam(required = false) String strDate, @RequestParam(required = false) String endDate, Model model) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");
        List<BoardDTO> boardList = inquiryService.showBoardList(status, strDate,endDate,userId);
        model.addAttribute("boardList",boardList);
        return "userPage/board/inquiryList";
    }

    // 상세조회
    @GetMapping("/admin/inquiry/{boardSeq}")
    public String findInquiry(@PathVariable int boardSeq, Model model) {
        BoardDTO boardDTO = inquiryService.findByBoardSeq(boardSeq);
        model.addAttribute("boardDTO",boardDTO);
//        return "userPage/board/testDisplay";
        return "adminPage/board/inquiryDetail";
    }

    //사용자 상세조회
    @GetMapping("/inquiry/{boardSeq}")
    public String findUserInquiry(@PathVariable int boardSeq, Model model) {
        BoardDTO boardDTO = inquiryService.findByBoardSeq(boardSeq);
        model.addAttribute("boardDTO",boardDTO);
        return "userPage/board/testDisplay";
//        return "adminPage/board/inquiryDetail";
    }


    @PostMapping("/admin/inquiry/answer")
    @ResponseBody
    public String saveInquiryAnswer(@ModelAttribute BoardDTO boardDTO) {
        boolean isSave = inquiryService.saveInquiryAnswer(boardDTO);
        return "redirect:/admin/inquiry";
    }

    @GetMapping("/inquiry/notAnswerCount")
    public String getCountNotAnswer() {
        int count = inquiryService.getCountNotAnswer();
        return "미답변 문의 갯수 : " + count + "개";
    }
}
