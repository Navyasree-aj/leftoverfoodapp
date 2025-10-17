package com.feastforward.leftoverfoodapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private String quantity;
    private String address;
    private String pickupTime;
    private String imagePath; // uploaded image path

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor; // link donation to donor

    public Donation() {}

    public Donation(String foodName, String quantity, String address, String pickupTime, String imagePath, User donor) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.address = address;
        this.pickupTime = pickupTime;
        this.imagePath = imagePath;
        this.donor = donor;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPickupTime() { return pickupTime; }
    public void setPickupTime(String pickupTime) { this.pickupTime = pickupTime; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public User getDonor() { return donor; }
    public void setDonor(User donor) { this.donor = donor; }
}
