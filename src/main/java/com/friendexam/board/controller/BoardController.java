package com.friendexam.board.controller;

import com.friendexam.board.domain.Board;
import com.friendexam.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "list";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam Long id) {
        Board board = boardService.getBoardById(id).orElse(null);
        model.addAttribute("board", board);
        return "view";
    }

    @GetMapping("/writeform")
    public String writeForm() {
        return "writeform";
    }

    @PostMapping("/write")
    public String write(Board board) {
        boardService.saveBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/updateform")
    public String updateForm(Model model, @RequestParam Long id) {
        Board board = boardService.getBoardById(id).orElse(null);
        model.addAttribute("board", board);
        return "updateform";
    }

    @PostMapping("/update")
    public String update(Board board) {
        boardService.saveBoard(board);
        return "redirect:/view?id=" + board.getId();
    }

    @GetMapping("/deleteform")
    public String deleteForm(Model model, @RequestParam Long id) {
        model.addAttribute("id", id);
        return "deleteform";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, @RequestParam String password) {
        Board board = boardService.getBoardById(id).orElse(null);
        if (board != null && board.getPassword().equals(password)) {
            boardService.deleteBoard(id);
        }
        return "redirect:/list";
    }
}