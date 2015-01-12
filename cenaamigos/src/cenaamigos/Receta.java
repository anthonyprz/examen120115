package cenaamigos;
import java.util.ArrayList;
public class Receta {
	private String nombreReceta;
	private ArrayList<Ingrediente> ingredientes;
	private String preparacion;
	//getters
	public String getNombreReceta(){
		return this.nombreReceta;
	}
	public ArrayList<Ingrediente> getIngredientes (){
		return this.ingredientes;
	}
	public String getPreparacion(){
		return this.preparacion;
	}
	//setters
	public void setNombreReceta(String nombreReceta){
		this.nombreReceta = nombreReceta;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes){
		this.ingredientes = ingredientes;
	}
	public void setPreparacion(String preparacion){
		this.preparacion = preparacion;
	}
}
