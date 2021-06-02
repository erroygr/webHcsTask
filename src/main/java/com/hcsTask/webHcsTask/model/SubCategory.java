package com.hcsTask.webHcsTask.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SubCategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Category_id")
    private Category category;

    @Column(name = "SubCategoryName")
    private String subCategoryName ;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SubCategoryId")
    private List<Request> requestList =new ArrayList<>();

    public SubCategory() {
    }

    public SubCategory(Category category,
                       String subCategoryName) {
        this.category = category;
        this.subCategoryName = subCategoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }
}
