package cenaamigos;
public class Ingrediente {
	private String nombreIngrediente;
	private int cantidadGramos;
	private int cantidadUnidad;
	private boolean enGramos;
	//getters
	public String getNombreIngrediente (){
		return this.nombreIngrediente;
	}
	public int getCantidadGramos(){
		return this.cantidadGramos;
	}
	public int getCantidadUnidad(){
		return this.cantidadUnidad;
	}
	public boolean getEnGramos (){
		return this.enGramos;
	}
	//setters
	public void setNombreIngrediente (String nombreIngrediente){
		this.nombreIngrediente = nombreIngrediente;
	}
	public void setCantidadGramos (int cantidadGramos){
		this.cantidadGramos = cantidadGramos;
	}
	public void setCantidadUnidad (int cantidadUnidad){
		this.cantidadUnidad = cantidadUnidad;
	}
	public void setEnGramos (boolean enGramos){
		this.enGramos = enGramos;
	}       
}
