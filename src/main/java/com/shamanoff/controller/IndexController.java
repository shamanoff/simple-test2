package com.shamanoff.controller;

import com.shamanoff.domain.News;
import com.shamanoff.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private NewsRepository repository;

    @GetMapping("/news")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<News> newsList = repository.findAll();
        List<News> newsCol1 = new ArrayList<>(newsList.size() / 2);
        List<News> newsCol2 = new ArrayList<>(newsList.size() / 2);

        for (int i = 0; i < newsList.size(); i++) {
            if (i % 2 == 0) {
                newsCol1.add(newsList.get(i));
            } else {
                newsCol2.add(newsList.get(i));
            }
        }

        mv.addObject("newsCol1", newsCol1);
        mv.addObject("newsCol2", newsCol2);

        return mv;
    }

    @GetMapping("/news/{id}")
    @ResponseBody
    public News newsById(@PathVariable Long id) {
        return new News("testing");
//        return News(id, "Breaking News!", "lenta.ru");
    }
}
