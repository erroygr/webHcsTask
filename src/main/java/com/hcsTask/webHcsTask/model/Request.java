package com.hcsTask.webHcsTask.model;


import javax.persistence.*;

@Entity
@Table(name = "Request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId")
    private UserTable user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MasterId")
    private MasterTable master;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SubCategoryId")
    private SubCategory subcategory;

    @Column(name = "RequestDescription")
    private String requestdescription;

    @Column(name = "RequestSTATUS")
    private String requeststatus;

    public Request() {
    }

    public Request(UserTable user, MasterTable master,
                   Category category,
                   SubCategory subcategory,
                   String requestdescription,
                   String requeststatus) {
        this.user = user;
        this.master = master;
        this.category = category;
        this.subcategory = subcategory;
        this.requestdescription = requestdescription;
        this.requeststatus = requeststatus;
    }

    public Long getRowid() {
        return rowid;
    }

    public void setRowid(Long rowid) {
        this.rowid = rowid;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    public MasterTable getMaster() {
        return master;
    }

    public void setMaster(MasterTable master) {
        this.master = master;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getRequestdescription() {
        return requestdescription;
    }

    public void setRequestdescription(String requestdescription) {
        this.requestdescription = requestdescription;
    }

    public String getRequeststatus() {
        return requeststatus;
    }

    public void setRequeststatus(String requeststatus) {
        this.requeststatus = requeststatus;
    }
}
