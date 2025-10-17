package com.feastforward.leftoverfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.feastforward.leftoverfoodapp.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
