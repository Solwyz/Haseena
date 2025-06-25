package com.solwyz.haseena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.solwyz.haseena.entity.NewsAndUpdate;
import com.solwyz.haseena.pojo.response.ApiResponse;
import com.solwyz.haseena.service.NewsAndUpdateService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/news")
public class NewsAndUpdateController {

	@Autowired
	private NewsAndUpdateService newsService;

	@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<NewsAndUpdate> addNews(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("shortDescription") String shortDescription,
			@RequestParam("image") MultipartFile imageFile) {

		NewsAndUpdate news = new NewsAndUpdate();
		news.setTitle(title);
		news.setDescription(description);
		news.setShortDescription(shortDescription);

		NewsAndUpdate savedNews = newsService.addNews(news, imageFile);
		return ResponseEntity.ok(savedNews);
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<NewsAndUpdate>>> getAllNews() {
		List<NewsAndUpdate> newsList = newsService.getAllNews();
		return ResponseEntity.ok(new ApiResponse<>("success", newsList));
	}

	@GetMapping("/{id}")
	public ResponseEntity<NewsAndUpdate> getNewsById(@PathVariable Long id) {
		return ResponseEntity.ok(newsService.getNewsById(id));
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<NewsAndUpdate> updateNews(@PathVariable Long id, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("shortDescription") String shortDescription,
			@RequestParam(value = "image", required = false) MultipartFile imageFile) {

		NewsAndUpdate updatedNews = newsService.updateNews(id, title, description, shortDescription, imageFile);
		return ResponseEntity.ok(updatedNews);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteNews(@PathVariable Long id) {
		newsService.deleteNews(id);
		return ResponseEntity.ok("News deleted successfully");
	}
}
