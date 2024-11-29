package com.example.umaiuniverse;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContaDao {

    @Query("SELECT * FROM Conta")
    List<Conta> getConta();
    @Query("SELECT * FROM Conta WHERE email=:emailConta")
    Conta buscarEmail(String emailConta);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Conta conta);
    @Update
    void update(Conta conta);
    @Delete
    void delete(Conta conta);

}
