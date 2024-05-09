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

public interface Tables  {

  public static Connection conexion = null;

  public static boolean hayConection() {
    return (conexion != null);
  }

  public static Connection conectar() {
    try {
      Class.forName("org.h2.Driver");
      // Estabelece a conexão com o banco de dados H2 em memória
      DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(Tables.class.getName()).log(Level.SEVERE, null, ex);
    }
    return conexion;
  }

  public static void criarTable() {
    if (hayConection()) {
      Statement sql;
      try {
        sql = conexion.createStatement();
        String sqlString = "CREATE TABLE IF NOT EXISTS Livro " +
                "(IdLivro INT PRIMARY KEY AUTO_INCREMENT, " +
                "Nome VARCHAR(255) NOT NULL, " +
                "Autor VARCHAR(255) NOT NULL, " +
                "Paginas INT, " +
                "Ano int(255))";
        sql.execute(sqlString);
      } catch (SQLException ex) {
        Logger.getLogger(Tables.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }

  public static void desconectar() {
    try {
      if (conexion != null) {
        conexion.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(Tables.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static ResultSet iniciarSQL(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'executarSQL'");
  }
}
