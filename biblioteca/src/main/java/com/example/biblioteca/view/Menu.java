package com.example.biblioteca.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Tables;
import com.example.biblioteca.controller.Controller;

import java.util.List;
import java.util.ArrayList;


public class Menu {
    private Scanner scanner;
    private List<Livro> livros;

    conectar();
    criarTable();

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.livros = new ArrayList<>();
    }

    public void exibirMenu() {
        int opcao;

        
        do {
            System.out.println("Seja bem vindo a biblioteca de livros:\n\n");
            System.out.println("Escolha a opçao desejada:\n\n");
            System.out.println("1. Cadastrar livros");
            System.out.println("2. Listar Livros");;
            System.out.println("3. emprestar livro");
            System.out.println("4. devolver livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    addLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    emprestar();
                    break;
                case 4:
                    devolver();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void fecharScanner() {
        scanner.close();
    }
}
