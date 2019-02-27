package springfive.cms.domain.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.vo.NewsRequest;

@RestController
@RequestMapping(value = "${app.api.news.controller}")
public class NewsResource {

    @GetMapping(value = "${app.api.news.id}")
    public ResponseEntity<News> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    public ResponseEntity<News> newNews(NewsRequest news) {
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "${app.api.news.id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id) {
    }

    @PutMapping(value = "${app.api.news.id}")
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest news) {
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value = "${app.api.news.review}")
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId) {
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value = "${app.api.news.revised}")
    public ResponseEntity<List<News>> revisedNews() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

}