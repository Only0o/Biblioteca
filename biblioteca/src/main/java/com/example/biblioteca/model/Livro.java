package com.example.biblioteca.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public class Livro  {

    private int Idlivro;
    private String Nome;
    private String Autor;
    private int Paginas;
    private int Ano;

    public Livro(int Idlivro, String Nome, String Autor, int Paginas, int Ano) {
        this.Idlivro = Idlivro;
        this.Nome = Nome;
        this.Autor = Autor;
        this.Paginas = Paginas;
        this.Ano = Ano;
    }

    // Getters
    public int getIdlivro() {
        return Idlivro;
    }

    public String getNome() {
        return Nome;
    }

    public String getAutor() {
        return Autor;
    }

    public int getPaginas() {
        return Paginas;
    }

    public int getAno() {
        return Ano;
    }

    // Setters
    public static int setIdlivro(int Idlivro) {
        return Idlivro;
    }

    public static String setNome(String Nome) {
        return Nome;
    }

    public static String setAutor(String Autor) {
        return Autor;
    }


    public static int setPaginas(int Paginas) {
        return Paginas;
    }

    public static String setStatus(String Ano) {
        return Ano;
    }
}
