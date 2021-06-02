package com.hcsTask.webHcsTask.repo;

import com.hcsTask.webHcsTask.model.Category;
import com.hcsTask.webHcsTask.model.MasterTable;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
   public Category findByCategoryName(String categoryName);
}
