package dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Producto;

public class DaoProducto {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";

	public DaoProducto()
	{
		
	}
	
	public int agregarProducto(Producto Producto) {
		String query = "INSERT INTO Productos (Codigo, nombre, Precio, Stock, IdCategoria) VALUES (" + Producto.getCodigo() + ", '" + Producto.getNombre() + "', " + Producto.getPrecio() + ", " + Producto.getStock() + ", " + Producto.getIdCategoria() + ")";
		Connection cn = null;
		int filas = 0;
		try 
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		return filas;
	}
	

	public int modificarProducto(Producto c) {
	    Connection cn = null;
	    int filas = 0;
	    try {
	        cn = DriverManager.getConnection(host+dbName, user, pass);
	        String query = "UPDATE Productos SET nombre=? WHERE Codigo=?";
	        PreparedStatement ps = cn.prepareStatement(query);
	        ps.setString(1, c.getNombre());
	        ps.setInt(2, c.getCodigo());
	        ps.executeUpdate();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
        return filas;
	}
	
	public Producto obtenerProducto(int id) {
		Producto c = new Producto();
		
		Connection cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM Productos WHERE Codigo=" + id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			c.setCodigo(rs.getInt("Codigo"));
			c.setNombre(rs.getString("nombre"));
			c.setPrecio(rs.getDouble("nombre"));
			c.setStock(rs.getInt("nombre"));
			c.setIdCategoria(rs.getInt("nombre"));
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		return c;
	}
	
	public ArrayList<Producto> obtenerTodosLosProductos(){
		ArrayList<Producto> lProductos = new ArrayList<Producto>();
		Connection cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM Productos";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Producto c = new Producto();
				c.setCodigo(rs.getInt("Codigo"));
				c.setNombre(rs.getString("nombre"));
				c.setPrecio(rs.getDouble("precio"));
				c.setStock(rs.getInt("Stock"));
				c.setIdCategoria(rs.getInt("IdCategoria"));
				lProductos.add(c);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lProductos;
	}
	
	public int bajaProducto(int Codigo) {
	    String query = "DELETE FROM Productos WHERE Codigo = " + Codigo;
	    Connection cn = null;
	    int filas = 0;
	    try 
	    {
	        cn = DriverManager.getConnection(host+dbName, user, pass);
	        Statement st = cn.createStatement();
	        filas = st.executeUpdate(query);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	    return filas;
	}
	
	public void ejecutarSPAgregarProducto(Producto producto) {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
	        CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto (?,?,?,?,?)");
			cst.setInt(1, producto.getCodigo());
			cst.setString(2,producto.getNombre());
			cst.setDouble(3,producto.getPrecio());
			cst.setInt(4,producto.getStock());
			cst.setInt(5,producto.getIdCategoria());
			cst.execute();
		}
		catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
