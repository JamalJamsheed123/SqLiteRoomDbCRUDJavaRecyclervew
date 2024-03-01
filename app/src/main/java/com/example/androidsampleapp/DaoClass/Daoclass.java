package com.example.androidsampleapp.DaoClass;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidsampleapp.EntityClass.PurchaseModel;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(PurchaseModel model);

    //Select All Data
    @Query("select * from  Purchase")
    List<PurchaseModel> getAllData();

    //DELETE DATA
    @Query("delete from Purchase where `id`= :id")
    void deleteData(int id);

    //Update Data

    @Query("update Purchase SET customerName= :customername ,productName =:productname, quantity =:quantity, purchaseDate =:purchasedate, contactNumber =:contactnumber, outletLocation =:outletlocation where `id`= :id")
    void updateData(String customername, String productname, String quantity, String purchasedate, String contactnumber, String outletlocation , int id);


}
