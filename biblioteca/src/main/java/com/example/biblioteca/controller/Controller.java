package com.example.biblioteca.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.example.biblioteca.model.Livro;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.example.biblioteca.model.Tables;


public class Controller{
    DefaultTableModel modelo = new DefaultTableModel();

    protected int IdLivro;
    protected String Nome;
    protected String Autor;
    protected int Paginas;
    protected int Ano;

    private List<Livro> biblioteca;

    public Controller() {
        this.biblioteca = new ArrayList<>();
    }

    
    
    // Inserir Livros 
    public boolean addLivro() {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)){
            // SQL para inserção
            String SQL = "INSERT INTO Livro (IdLivro, Nome, Autor, Paginas, Ano) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conexao.prepareStatement(SQL)) {
                pstmt.setInt(1, IdLivro);
                pstmt.setString(2, Nome);
                pstmt.setString(3, Autor);
                pstmt.setInt(4, Paginas);
                pstmt.setInt(5, Ano);

                pstmt.executeUpdate();

                System.out.println("Dados inseridos!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        }
    }

    // Mostrar Livros 
    public void listarLivros() {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String SQL = "SELECT IdLivro, Nome, Autor, Ano FROM Livro";

            try (PreparedStatement pstmt = conexao.prepareStatement(SQL)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int IdLivro = rs.getInt("IdLivro");
                        String Nome = rs.getString("Nome");
                        String Autor = rs.getString("Autor");
                        int Paginas = rs.getInt("Paginas");
                        int Ano = rs.getInt("Ano");

                        System.out.println("IdLivro: " + IdLivro);
                        System.out.println("Nome: " + Nome);
                        System.out.println("Autor: " + Autor);
                        System.out.println("Paginas: " + Paginas);
                        System.out.println("Ano: " + Ano);
                        System.out.println("-------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    // Emprestar
    public void emprestar(String Status, int IdLivro) {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            // SQL para atualização
            String sql = "UPDATE Livro SET Status = ? WHERE IdLivro = ?";

            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, Status);
                pstmt.setInt(2, IdLivro);

                pstmt.executeUpdate();

                System.out.println("Dados alterados com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao emprestar livro: " + e.getMessage());
        }
    }

    // Devolver
    public void devolver(String Status, int IdLivro) {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            // SQL para atualização
            String sql = "UPDATE Livro SET Status = ? WHERE IdLivro = ?";

            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, Status);
                pstmt.setInt(2, IdLivro);

                pstmt.executeUpdate();

                System.out.println("Dados alterados com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }
   


}