package com.feastforward.leftoverfoodapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.feastforward.leftoverfoodapp.model.Donation;
import com.feastforward.leftoverfoodapp.repository.DonationRepository;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow your frontend to call this API
public class DonationController {

    @Autowired
    private DonationRepository donationRepository;

    // --- Upload new donation ---
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDonation(
        @RequestParam("foodType") String foodType,
        @RequestParam("quantity") String quantity,
        @RequestParam("address") String address,
        @RequestParam("pickupTime") String pickupTime,
        @RequestParam("foodPhoto") MultipartFile foodPhoto){

        try {
        // Save file
        String uploadDir = System.getProperty("user.dir") + "/uploads/"; // points to project root
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String filePath = uploadDir + foodPhoto.getOriginalFilename();
        foodPhoto.transferTo(new File(filePath));

        // Save donation info in DB
        String webPath = "/uploads/" + foodPhoto.getOriginalFilename();
        Donation donation = new Donation(foodType, quantity, address, pickupTime, webPath, null);
        donationRepository.save(donation);

        return ResponseEntity.ok("Donation saved successfully with image: " + filePath);

    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
    }
}

    // --- Get all donations ---
    @GetMapping("/all")
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = donationRepository.findAll();
        return ResponseEntity.ok(donations);
    }
}
