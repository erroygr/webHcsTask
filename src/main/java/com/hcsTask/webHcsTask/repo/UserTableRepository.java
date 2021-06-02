package com.hcsTask.webHcsTask.repo;

import com.hcsTask.webHcsTask.model.UserTable;
import org.springframework.data.repository.CrudRepository;

public interface UserTableRepository extends CrudRepository<UserTable, Long>  {
    UserTable findByUserLastName(String userName);
}
