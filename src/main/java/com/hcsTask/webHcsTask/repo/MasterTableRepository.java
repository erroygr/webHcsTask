package com.hcsTask.webHcsTask.repo;

import com.hcsTask.webHcsTask.model.MasterTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MasterTableRepository extends CrudRepository<MasterTable, Long> {
    public MasterTable findByMasterLastName(String lastName);
}
