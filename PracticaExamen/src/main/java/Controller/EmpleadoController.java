package Controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import Gestion.EmpleadoGestion;
import Modelo.Empleado;
import java.util.ArrayList;





    

@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {


    public EmpleadoController() {
    }
    
    public String inserta (){
        
        if (EmpleadoGestion.insertar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:identificacion",mensaje);
            return "edita.xhtml";
        } 
    }
    
    public String modifica (){
        
        if (EmpleadoGestion.actualiza(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:identificacion",mensaje);
            return "edita.xhtml";
        }
    }
    
    public String elimina (){
        
        if (EmpleadoGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion",mensaje);
            return "edita.xhtml";
        }
    }
    
    public String edita (String idEmpleado){
        
        Empleado empleado = (Empleado) EmpleadoGestion.getEmpleado(idEmpleado);
        
        if (empleado!=null){
            this.setIdEmpleado(empleado.getIdEmpleado());
            this.setPrimapellido(empleado.getPrimapellido());
            this.setSegpellido(empleado.getSegpellido());
            this.setNombre(empleado.getNombre());
            this.setFechaIngrreso(empleado.getFechaIngrreso());
            this.setFechaNac(empleado.getFechaNac());
            this.setEdad(empleado.getEdad());
            this.setSexo(empleado.getSexo());
            this.setTelefono(empleado.getTelefono());
            this.setEmail(empleado.getEmail());
            return "edita.xhtml";
        }else{
              FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm",mensaje);
            return "list.xhtml";
        }
    }
    
    public ArrayList<Object> getEmpleado(){
        
        return EmpleadoGestion.getEmpleado();
        
    }
    
}


