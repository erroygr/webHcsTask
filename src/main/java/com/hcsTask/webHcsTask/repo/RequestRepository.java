package com.hcsTask.webHcsTask.repo;

import com.hcsTask.webHcsTask.model.MasterTable;
import com.hcsTask.webHcsTask.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
