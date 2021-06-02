package com.hcsTask.webHcsTask.repo;

import com.hcsTask.webHcsTask.model.Category;
import com.hcsTask.webHcsTask.model.MasterTable;
import com.hcsTask.webHcsTask.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>  {
    SubCategory findBySubCategoryName(String SubCategoryName);

}
