package ITisme.group.chap06.controller;

import ITisme.group.chap06.domain.Article;
import ITisme.group.chap06.dto.ArticleListViewResponse;
import ITisme.group.chap06.dto.ArticleViewResponse;
import ITisme.group.chap06.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles =blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles",articles);

        return "articles";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article",article);

        return "article";
    }

    @GetMapping("/new-article")
    public String getNewArticle(@RequestParam(required = false) Long id, Model model) {
        if(id == null){
            model.addAttribute("article",new ArticleViewResponse());
        }else{
            Article article = blogService.findById(id);
            model.addAttribute("article",new ArticleViewResponse(article));
        }

        return "new-article";
    }
}
