package com.ssafy.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ssafy.mvc.board.dto.BoardDto;
import com.ssafy.mvc.board.service.BoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        // Retrieve the list of articles from the service
        Map<String, String> map1 = new HashMap<>();
        map1.put("pgno", "1");
        map1.put("key", "1");
        map1.put("word", "1");
//        List<BoardDto> articles = boardService.listArticle(map1);
//        model.addAttribute("articles", articles);

        return "board/list"; // Return the name of the JSP/Thymeleaf template
    }

    @GetMapping("/view")
    public String view(int articleNo, Model model) throws Exception {
        // Retrieve the article by articleNo from the service
        BoardDto article = boardService.getArticle(articleNo);
        model.addAttribute("article", article);

        return "board/view";
    }

    @GetMapping("/mvwrite")
    public String mvWrite() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardDto boardDto, RedirectAttributes redirectAttributes) throws Exception {
        // Save the new article using the service
    	System.out.println("in###");
    	System.out.println(boardDto);
        boardService.writeArticle(boardDto);
        // Redirect to the list page
        redirectAttributes.addFlashAttribute("message", "Article created successfully!");
        return "redirect:/board/list";
    }

    @GetMapping("/modify/{articleNo}")
    public String getModify(@PathVariable("articleNo") String articleNo, Model model) throws Exception {
        BoardDto boardDto = boardService.getArticle(Integer.parseInt(articleNo));
        model.addAttribute("article", boardDto);
        return "board/modify";
    }


    @PostMapping("/modify")
    public String modify(@ModelAttribute BoardDto boardDto) throws Exception {
    	System.out.println(boardDto);
        boardService.modifyArticle(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{articleNo}")
    public String delete(@PathVariable("articleNo") String articleNo) throws Exception {
        boardService.deleteArticle(Integer.parseInt(articleNo));
        return "redirect:/";
    }

    // delete as well
    // ...


}
