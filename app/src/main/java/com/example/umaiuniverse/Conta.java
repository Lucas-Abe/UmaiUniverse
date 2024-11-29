package com.example.umaiuniverse;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Conta {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String senha;
    private String email;
    private Date dataNascimento;

    public Conta(){ }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Conta(String nome, Date dataNascimento, String email, String senha){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome=" + nome +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", email=" + email +
                ", senha=" + senha +
                '}';
    }

}
