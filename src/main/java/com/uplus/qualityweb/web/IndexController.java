package com.uplus.qualityweb.web;

import com.uplus.qualityweb.service.posts.PostsService;
import com.uplus.qualityweb.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        List<PostsResponseDto> allPosts = postsService.findAllDesc();
        model.addAttribute("posts", allPosts);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
