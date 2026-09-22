package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;


public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";

	public DaoCategoria()
	{
		
	}
	
	public int agregarCategoria(Categoria categoria) {
		String query = "Insert into categoria(idcategoria, nombre) values (" + categoria.getIdCategoria() + ", '" + categoria.getNombre() +"')";
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
	

	public int modificarCategoria(Categoria c) {
	    Connection cn = null;
	    int filas = 0;
	    try {
	        cn = DriverManager.getConnection(host+dbName, user, pass);
	        String query = "UPDATE categoria SET nombre=? WHERE idcategoria=?";
	        PreparedStatement ps = cn.prepareStatement(query);
	        ps.setString(1, c.getNombre());
	        ps.setInt(2, c.getIdCategoria());
	        ps.executeUpdate();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
        return filas;
	}
	
	public Categoria obtenerCategoria(int id) {
		Categoria c = new Categoria();
		
		Connection cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM categoria WHERE idcategoria=" + id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			c.setIdCategoria(rs.getInt("idcategoria"));
			c.setNombre(rs.getString("nombre"));
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		return c;
	}
	
	public ArrayList<Categoria> obtenerTodasLasCategorias(){
		ArrayList<Categoria> lCategorias = new ArrayList<Categoria>();
		Connection cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM categoria";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("idcategoria"));
				c.setNombre(rs.getString("nombre"));
				lCategorias.add(c);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lCategorias;
	}
	
	public int bajaCategoria(int idCategoria) {
	    String query = "DELETE FROM categoria WHERE idcategoria = " + idCategoria;
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
	

}
