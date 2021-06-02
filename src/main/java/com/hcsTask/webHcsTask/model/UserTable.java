package com.hcsTask.webHcsTask.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usertable")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowId;
    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserLastName")
    private String userLastName;

    @Column(name = "UserAddress")
    private String userAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "UserId")

    private List<Request> request =new ArrayList<>();

    public UserTable() {
    }

    public UserTable(String userName, String userLastName, String userAddress) {
        userName = userName;
        userLastName = userLastName;
        userAddress = userAddress;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        userLastName = userLastName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        userAddress = userAddress;
    }
}
