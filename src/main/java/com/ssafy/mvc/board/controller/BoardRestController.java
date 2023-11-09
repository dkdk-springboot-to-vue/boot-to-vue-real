package com.ssafy.mvc.board.controller;

import com.ssafy.mvc.board.dto.BoardDto;
import com.ssafy.mvc.board.dto.ReplyDto;
import com.ssafy.mvc.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {
    final private BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list/{pgno}/{key}/{word}")
    public Map<String, Object> getList(@PathVariable("pgno") String pgno, @PathVariable("key") String key, @PathVariable("word") String word ) throws Exception {
        Map<String, String> map1 = new HashMap<>();
        map1.put("pgno", pgno);
        map1.put("key", key);
        map1.put("word", word);

        Map<String, Object> map = new HashMap<>();
        List<BoardDto> list = boardService.listArticle(map1);
        map.put("list", list);

        return map;
    }

    @PostMapping("/modify")
    public Map<String, Object> getModify(@RequestBody BoardDto boardDto) throws Exception {
        Map<String, Object> map = new HashMap<>();
        boardService.modifyArticle(boardDto);
        return map;
    }

    @GetMapping("/view/{articleNo}")
    public Map<String, Object> getView(@PathVariable("articleNo") String articleNo) throws Exception {
        Map<String, Object> map = new HashMap<>();
        BoardDto boardDto = boardService.getArticle(Integer.parseInt(articleNo));
        map.put("board", boardDto);
        return map;
    }

    @PostMapping("/write")
    public Map<String, Object> write(@RequestBody BoardDto boardDto) throws Exception{
        Map<String, Object> map = new HashMap<>();
        boardService.writeArticle(boardDto);
        return map;
    }

    @PostMapping("/reply")
    public Map<String, Object> reply(@RequestBody ReplyDto replyDto) throws Exception{
        Map<String, Object> map = new HashMap<>();
        boardService.addReply(replyDto);
        return map;
    }


    //  아래는 ----- form으로 만 이동
//    @GetMapping("/write")
//    public String getWrite() {
//
//        return "/board/write";
//    }
//    @PostMapping("/modify")
//    public String Modify() throws Exception{
//        return "";
//    }

}
