/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author CSU22
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Clase de conexión y prueba con SQLite usando JDBC
 * Requisito: sqlite-jdbc-3.36.x.jar agregado a las librerías del proyecto Ant
 */
public class ConexionSQLite {

    // Ruta del archivo de base de datos (se crea automáticamente si no existe)
    private static final String URL = "jdbc:sqlite:mibase.db";

    // ─── Obtener conexión ─────────────────────────────────────────
    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión exitosa a SQLite");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }

    // ─── Crear tabla de ejemplo ───────────────────────────────────
    public static void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS estudiantes ("
                   + "id      INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nombre  TEXT    NOT NULL, "
                   + "nota    REAL    NOT NULL"
                   + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✅ Tabla 'estudiantes' lista");

        } catch (SQLException e) {
            System.out.println("❌ Error al crear tabla: " + e.getMessage());
        }
    }
    
    public static void crearTabla2() {
        String sql = "CREATE TABLE IF NOT EXISTS producticos ("
                   + "id_Producticos      INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nombre  TEXT    NOT NULL, "
                   + "precio    REAL    NOT NULL"
                   + ");";
        
        
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✅ Tabla 'producticos' lista");

        } catch (SQLException e) {
            System.out.println("❌ Error al crear tabla: " + e.getMessage());
        }
    }
    
     public static void crearTabla3() {
        String sql = "CREATE TABLE IF NOT EXISTS comidas ("
                   + "id      INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "comidas  TEXT    NOT NULL, "
                   + "precio    REAL    NOT NULL"
                   + ");";
        
        
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✅ Tabla 'comidas' lista");

        } catch (SQLException e) {
            System.out.println("❌ Error al crear tabla: " + e.getMessage());
        }
    }

    // ─── Insertar un registro ─────────────────────────────────────
    public static void insertar(String nombre, double nota) {
        String sql = "INSERT INTO estudiantes (nombre, nota) "
                + "VALUES ('"
                + nombre + "', "
                + nota + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Insertado: " + nombre + " - " + nota);

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }

    public static void insertar2(String nombre, double precio) {
        String sql = "INSERT INTO producticos (nombre, precio) VALUES ('"
                   + nombre + "', " + precio + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Insertado: " + nombre + " - " + precio);

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }
    
      public static void insertar3(String comidas, double precio) {
        String sql = "INSERT INTO comidas (comidas, precio) VALUES ('"
                   + comidas + "', " + precio + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Insertado: " + comidas + " - " + precio);

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }
    // ─── Consultar todos los registros ────────────────────────────
    public static void consultarTodos() {
        String sql = "SELECT * FROM estudiantes;";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)) {

            System.out.println("\n─── Estudiantes en la BD ───");
            while (rs.next()) {
                System.out.println("ID: "     + rs.getInt("id")
                                 + " | Nombre: " + rs.getString("nombre")
                                 + " | Nota: "   + rs.getDouble("nota"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar: " + e.getMessage());
        }
    }
    
    public static void consultarTodos2() {
        String sql = "SELECT * FROM producticos;";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)) {

            System.out.println("\n─── Estudiantes en la BD ───");
            while (rs.next()) {
                System.out.println("ID_Productos: "     + rs.getInt("id_Producticos")
                                 + " | Nombre: " + rs.getString("nombre")
                                 + " | precio: "   + rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar: " + e.getMessage());
        }
    }
    
    public static void consultarTodos3() {
        String sql = "SELECT * FROM comidas;";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)) {

            System.out.println("\n─── Estudiantes en la BD ───");
            while (rs.next()) {
                System.out.println("ID_comidas: "     + rs.getInt("id")
                                 + " | comidas: " + rs.getString("Comidas")
                                 + " | precio: "   + rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar: " + e.getMessage());
        }
    }

    // ─── Main de prueba ───────────────────────────────────────────
    public static void main(String[] args) {

        conectar();

        crearTabla();
        crearTabla2();
        crearTabla3();
        
        insertar("Ana Gómez",   4.5);
        insertar("Luis Pérez",  3.8);
        insertar("María López", 4.9);
        
        insertar2("control", 200000);
        insertar3("hamburguesa", 30000);

        consultarTodos();
        consultarTodos2();
        consultarTodos3();
        
    }
}
