package com.hcsTask.webHcsTask.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MasterTable")
public class MasterTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowId;
    @Column(name = "MasterNAME")
    private String masterName;

    @Column(name = "MasterLastName")
    private String masterLastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MasterId")
    private List<Request> requestList =new ArrayList<>();

    public MasterTable() {
    }

    public MasterTable(String masterName, String masterLastName) {
        this.masterName = masterName;
        this.masterLastName = masterLastName;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

    public void setMasterLastName(String masterLastName) {
        this.masterLastName = masterLastName;
    }
}
