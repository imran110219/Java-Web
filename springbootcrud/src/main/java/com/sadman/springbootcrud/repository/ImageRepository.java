package com.sadman.springbootcrud.repository;

import com.sadman.springbootcrud.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
