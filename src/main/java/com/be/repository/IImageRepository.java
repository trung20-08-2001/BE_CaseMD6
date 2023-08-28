package com.be.repository;

import com.be.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image,Integer> {
}
