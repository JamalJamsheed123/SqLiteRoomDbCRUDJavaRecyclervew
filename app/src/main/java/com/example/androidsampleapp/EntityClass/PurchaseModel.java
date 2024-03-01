package com.example.androidsampleapp.EntityClass;



import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Purchase")
public class PurchaseModel {

    //Primary Key
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "customerName")
    private String customerName;
    @ColumnInfo(name = "productName")
    private String productName;
    @ColumnInfo(name = "quantity")
    private String quantity;
    @ColumnInfo(name = "purchaseDate")
    private String purchaseDate;
    @ColumnInfo(name = "contactNumber")
    private String contactNumber;
    @ColumnInfo(name = "outletLocation")
    private String outletLocation;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getQuantity(){
        return quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public String getPurchaseDate(){
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    public String getOutletLocation(){
        return outletLocation;
    }
    public void setOutletLocation(String outletLocation){
        this.outletLocation = outletLocation;
    }

    public PurchaseModel(String customerName, String productName, String quantity, String purchaseDate, String contactNumber, String outletLocation) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.contactNumber = contactNumber;
        this.outletLocation = outletLocation;
    }

    public PurchaseModel(){}
}
