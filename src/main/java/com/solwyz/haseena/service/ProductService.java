package com.solwyz.haseena.service;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.solwyz.haseena.entity.Category;

import com.solwyz.haseena.entity.Product;

import com.solwyz.haseena.repo.CategoryRepository;

import com.solwyz.haseena.repo.ProductRepository;

@Service

public class ProductService {

	@Autowired

	private ProductRepository productRepository;

	@Autowired

	private CategoryRepository categoryRepository;

	@Autowired

	private CloudinaryService cloudinaryService; 

	public Product addProduct(MultipartFile file, String productName, String productDescription, int productPrice,
			double offer, int productOfferPrice, List<String> sizes, Long categoryId) throws IOException {

		Product product = new Product();
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		product.setOffer(offer);
		product.setProductOfferPrice(productOfferPrice);
		product.setSizes(sizes);

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
		product.setCategory(category);


		String imageUrl = cloudinaryService.uploadFile(file); // Make sure this is implemented
		product.setImageUrl(imageUrl);

		return productRepository.save(product); // ✅ RETURN statement added
	}

	public List<Product> getAllProduct() {

		return productRepository.findAll();

	}

	public Product getProductById(Long id) {

		return productRepository.findById(id)

				.orElseThrow(() -> new RuntimeException("product not found " + id));

	}

	public void deleteChildCategory(Long id) {

		if (!productRepository.existsById(id)) {

			throw new RuntimeException("product with ID " + id + " does not exist");

		}

		productRepository.deleteById(id);

	}

	public List<Product> getProductsByCategory(Long categoryId) {

		return productRepository.findByCategoryId(categoryId);

	}

	public Product updateProduct(Long id, MultipartFile file, String productName, String productDescription,
			int productPrice, double offer, int productOfferPrice, List<String> sizes, Long categoryId)
			throws IOException {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		product.setOffer(offer);
		product.setProductOfferPrice(productOfferPrice);
		product.setSizes(sizes);


		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
		product.setCategory(category);


		if (file != null && !file.isEmpty()) {
			String imageUrl = cloudinaryService.uploadFile(file);
			product.setImageUrl(imageUrl);
		}

		return productRepository.save(product);
	}

	public List<Product> getSimilarProducts(Long productId) {
	    Product currentProduct = productRepository.findById(productId)
	        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

	    return productRepository.findByCategoryAndIdNot(currentProduct.getCategory(), productId);
	}


}
