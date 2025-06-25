package com.solwyz.haseena.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.solwyz.haseena.entity.Product;
import com.solwyz.haseena.pojo.response.ApiResponse;
import com.solwyz.haseena.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity addProduct(@RequestParam("file") MultipartFile file,
			@RequestParam("productName") String productName,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("productPrice") int productPrice, @RequestParam("offer") double offer,
			@RequestParam("productOfferPrice") int productOfferPrice, @RequestParam("sizes") List<String> sizes,
			@RequestParam("categoryId") Long categoryId) throws IOException {
		Product savedProduct = productService.addProduct(file, productName, productDescription, productPrice, offer,
				productOfferPrice, sizes, categoryId);
		return ResponseEntity.ok(savedProduct);
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Product>>> getAllProduct() {
		List<Product> childCategory = productService.getAllProduct();
		return ResponseEntity.ok(new ApiResponse<>("success", childCategory));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse<List<Product>>> getProductsByCategory(@PathVariable Long categoryId) {
		List<Product> products = productService.getProductsByCategory(categoryId);
		return ResponseEntity.ok(new ApiResponse<>("success", products));
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestParam("file") MultipartFile file,
			@RequestParam("productName") String productName,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("productPrice") int productPrice, @RequestParam("offer") double offer,
			@RequestParam("productOfferPrice") int productOfferPrice, @RequestParam("sizes") List<String> sizes,
			@RequestParam("categoryId") Long categoryId) throws IOException {

		Product updatedProduct = productService.updateProduct(id, file, productName, productDescription, productPrice,
				offer, productOfferPrice, sizes, categoryId);

		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteChildCategory(id);
		return ResponseEntity.ok("product deleted successfully");
	}
	
	@GetMapping("/similar/{productId}")
	public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable Long productId) {
	    List<Product> similarProducts = productService.getSimilarProducts(productId);
	    return ResponseEntity.ok(similarProducts);
	}

	
}
