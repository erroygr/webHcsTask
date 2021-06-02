CREATE TABLE UserTable(
                          Row_id BIGINT NOT NULL AUTO_INCREMENT,
                          UserNAME VARCHAR(100),
                          UserLastName VARCHAR(100),
                          UserAddress VARCHAR(100),
                          PRIMARY KEY(Row_id)
); CREATE TABLE MasterTable(
                               Row_id BIGINT NOT NULL AUTO_INCREMENT,
                               MasterNAME VARCHAR(100),
                               MasterLastName VARCHAR(100),
                               PRIMARY KEY(Row_id)
   ); CREATE TABLE Request(
                              Row_id BIGINT NOT NULL AUTO_INCREMENT,
                              User_id BIGINT NOT NULL,
                              Master_id BIGINT NOT NULL,
                              Category VARCHAR(100),
                              SubCategory VARCHAR(100),
                              RequestDescription VARCHAR(100),
                              RequestSTATUS VARCHAR(50),
                              RequestImagePhoto VARCHAR(100),
                              PRIMARY KEY(Row_id),
                              FOREIGN KEY(User_id) REFERENCES UserTable(Row_id),
                              FOREIGN KEY(Master_id) REFERENCES MasterTable(Row_id)
      );
