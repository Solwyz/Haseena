//package com.solwyz.haseena.controller;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//
//import java.io.IOException;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.solwyz.haseena.service.ImageUploadService;
//
//@RestController
//@RequestMapping("/api/images")
//public class ImageController {
//
//    @Autowired
//    private ImageUploadService imageUploadService;
//
//    @Operation(summary = "Upload image to Cloudinary")
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Successfully uploaded"),
//        @ApiResponse(responseCode = "400", description = "Missing or invalid image"),
//        @ApiResponse(responseCode = "500", description = "Upload failed")
//    })
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> uploadImage(
//            @Parameter(description = "Image file to upload",
//                       required = true,
//                       content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
//                                          schema = @Schema(type = "string", format = "binary")))
//            @RequestParam("file") MultipartFile file) {
//
//        if (file == null || file.isEmpty()) {
//            return ResponseEntity.badRequest().body(Map.of("error", "Image file is required"));
//        }
//
//        try {
//            String imageUrl = imageUploadService.uploadImage(file);
//            return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
//        } catch (IOException e) {
//            return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(Map.of("error", "Image upload failed"));
//        }
//    }
//}
//
////
////import java.io.IOException;
////import java.util.Map;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.solwyz.haseena.service.ImageUploadService;
////
////@RestController
////@RequestMapping("/api/images")
////public class ImageController {
////
////    @Autowired
////    private ImageUploadService imageUploadService;
////
////    @PostMapping("/upload")
////    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
////        if (file == null || file.isEmpty()) {
////            return ResponseEntity.badRequest().body(Map.of("error", "Image file is required"));
////        }
////
////        try {
////            String imageUrl = imageUploadService.uploadImage(file);
////            return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
////        } catch (IOException e) {
////            return ResponseEntity
////                .status(HttpStatus.INTERNAL_SERVER_ERROR)
////                .body(Map.of("error", "Image upload failed"));
////        }
////    }
////
////}
