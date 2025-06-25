package com.solwyz.haseena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.solwyz.haseena.entity.NewsAndUpdate;
import com.solwyz.haseena.repo.NewsAndUpdateRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NewsAndUpdateService {

	@Autowired
	private NewsAndUpdateRepository newsRepo;

	@Autowired
	private Cloudinary cloudinary;

	public NewsAndUpdate addNews(NewsAndUpdate news, MultipartFile imageFile) {
		try {
			Map<String, Object> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());

			String imageUrl = (String) uploadResult.get("secure_url");
			news.setImage(imageUrl);

			return newsRepo.save(news);
		} catch (IOException e) {
			throw new RuntimeException("Failed to upload image to Cloudinary", e);
		}
	}

	public List<NewsAndUpdate> getAllNews() {
		return newsRepo.findAll();
	}

	public NewsAndUpdate getNewsById(Long id) {
		return newsRepo.findById(id).orElse(null);
	}

	public NewsAndUpdate updateNews(Long id, String title, String description, String shortDescription,
			MultipartFile imageFile) {
		NewsAndUpdate news = newsRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("News not found with ID: " + id));

		news.setTitle(title);
		news.setDescription(description);
		news.setShortDescription(shortDescription);

		if (imageFile != null && !imageFile.isEmpty()) {
			try {
				Map<String, Object> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(),
						ObjectUtils.emptyMap());

				String imageUrl = (String) uploadResult.get("secure_url");
				news.setImage(imageUrl);
			} catch (IOException e) {
				throw new RuntimeException("Failed to upload image to Cloudinary", e);
			}
		}

		return newsRepo.save(news);
	}

	public void deleteNews(Long id) {
		newsRepo.deleteById(id);
	}

}
