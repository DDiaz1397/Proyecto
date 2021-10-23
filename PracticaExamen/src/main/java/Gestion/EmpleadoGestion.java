package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Empleado;


public class EmpleadoGestion {
    
    
    private static final String SQL_INSERT_EMPLEADO= "insert into empleado (idEmpleado,"
            + "primapellido,segapellido,nombre,fechaIngreso,FechaNac,edad, sexo, telefono, email) values (?,?,?,?,?,?,?,?,?,?)";
    
    public static boolean insertar (Empleado empleado){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_EMPLEADO);
            sentencia.setString(1, empleado.getIdEmpleado());
            sentencia.setString(2, empleado.getPrimapellido());
            sentencia.setString(3, empleado.getSegpellido());
            sentencia.setString(4, empleado.getNombre());
            sentencia.setObject(5, empleado.getFechaIngreso());
            sentencia.setObject(6, empleado.getFechaNac());
            sentencia.setInt   (7, empleado.getEdad());
            sentencia.setString(8, empleado.getSexo());
            sentencia.setString(9, empleado.getTelefono());
            sentencia.setString(10, empleado.getEmail());
            
           
            
            return sentencia.executeUpdate()>0; 
            
        }catch (SQLException ex){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_SELECT_EMPLEADO = "select * from empleado where idEmpleado=?";
    
    public static Empleado getEmpleado (String idEmpleado){
        
        Empleado empleado = null;
        
        try{
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_EMPLEADO);
            consulta.setString(1, idEmpleado);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()){
                empleado= new Empleado(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getDate(5),
                        datos.getDate(6),
                        datos.getInt(7),
                        datos.getString(8).charAt(0)
                        datos.getString(9),
                        datos.getString(10)
                        
                );
            }
            
        }catch (SQLException ex){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return empleado;
        
    }
    
    private static final String SQL_UPDATE_EMPLEADO = "update empleado set idEmpleado=?,"
            + "primapellido=?,segapellido=?,nombre=?,fechaIngreso=?,FechaNac=?,edad=?, sexo=?, telefono=?, email=? where idEmpleado=?";
    
    public static boolean actualiza (Empleado empleado){
        
        try{
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_EMPLEADO);
            sentencia.setString(1, empleado.getIdEmpleado());
            sentencia.setString(2, empleado.getPrimapellido());
            sentencia.setString(3, empleado.getSegpellido());
            entencia.setString(4, empleado.getNombre());
            sentencia.setObject(5, empleado.getFechaIngreso());
            sentencia.setObject(6, empleado.getFechaNac());
            sentencia.setInt(7, empleado.getEdad() );
            sentencia.setString(8, ""+empleado.getSexo() );
            sentencia.setString(9, empleado.getTelefono() );
            sentencia.setString(10, empleado.getEmail() );

            
            
            return sentencia.executeUpdate()>0;
            
        }catch(SQLException ex){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return false;
                
    }
    
    private static final String SQL_DELETE_EMPLEADO= "delete from empleado where idEmpleado=?";
    
    public static boolean eliminar (Empleado empleado){
        
        try{
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_EMPLEADO);
            consulta.setString(1, empleado.getIdEmpleado());
            
            return consulta.executeUpdate()>0; 
            
        }catch (Exception ex){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return false;
    }
 
    private static final String SQL_SELECT_EMPLEADO= "Select * from empleado";
    
    public static ArrayList<Empleado> getEmpleado(){
        
        ArrayList<Empleado> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_EMPLEADO);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Empleado (
                        
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getString(8).charAt(0)
                        rs.getString(9),
                        rs.getString(10)
            }
            
        }catch (SQLException ex){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
 
}
