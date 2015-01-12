package cenaamigos;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
	public class CenaAmigos {
		public static void main (String [] args){
			
			//variables
			int numRecetas, numIngred, numGramo, numUnidad;
			String nombreRec, prepara, nombreIngre, modo;
			
			Scanner sc = new Scanner (System.in);
			ArrayList<Receta> recetas = new ArrayList<Receta>();
			ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
			
	
			System.out.println("¿cuantas recetas quieres crear?");
			numRecetas = sc.nextInt();
			
			for(int r=0; r<numRecetas; r++){
				Receta receta = new Receta();
				System.out.println("dime el nombre de la receta");
				nombreRec = sc.next();
				receta.setNombreReceta(nombreRec);
				
				System.out.println("dime la preparacion");
				prepara = sc.next();
				receta.setPreparacion(prepara);
				
				System.out.println("dime el numero de ingredientes");
				numIngred = sc.nextInt();
				
				for (int i=0; i<numIngred; i++){
					Ingrediente ingrediente = new Ingrediente();
					
					System.out.println("dime el nombre del ingrediente");
					nombreIngre = sc.next();
					ingrediente.setNombreIngrediente(nombreIngre);
					
					System.out.println("es en gramos o unidades gr/un");
					modo = sc.next();
					
					if (modo.equalsIgnoreCase("gr")){
						ingrediente.setEnGramos(true);
					}
					else{
						ingrediente.setEnGramos(false);
					}	
					if (ingrediente.getEnGramos()==true){
						System.out.println("dime la cantidad en gramos");
						numGramo = sc.nextInt();
						ingrediente.setCantidadGramos(numGramo);
					}
					else{
						System.out.println("dime la cantidad en unidades");
						numUnidad = sc.nextInt();
						ingrediente.setCantidadUnidad(numUnidad);
					}
					ingredientes.add(ingrediente);
				}
				receta.setIngredientes(ingredientes);
				recetas.add(receta);
			}
			try {
					File crear = new File("./listaRecetas.txt");
					
					FileWriter escribir = new FileWriter(crear);
					
					for (int a=0; a<recetas.size();a++){
						ingredientes = recetas.get(a).getIngredientes();
						escribir.write(recetas.get(a).getNombreReceta()+";");
						for (int z=0; z<ingredientes.size();z++){
							escribir.write(ingredientes.get(z).getNombreIngrediente()+"*");
							escribir.write(ingredientes.get(z).getCantidadGramos()+"*");
							escribir.write(ingredientes.get(z).getCantidadUnidad()+"*");
							escribir.write(ingredientes.get(z).getEnGramos()+"#");
							
						}
							escribir.write(recetas.get(a).getPreparacion()+"\n");
					}
					escribir.close();
					}
			catch(IOException e)
			{
			System.out.println("Error: "+e);
			}
			//FileInputStream leer = new FileInputStream("./listaRecetas.txt");
			
			Scanner linea = new Scanner("listaRecetas.txt");
			
			if (linea.hasNextLine()){
				String concoma = linea.nextLine();
				String[] sep1 = null;
				String[] sep2 = null;
				String[] sep3 = null;
				
				while (linea.hasNextLine()){
					sep1=concoma.split(";");
					System.out.println("-El nombre de la receta es: " + sep1[0]);
					String ingredientess=sep1[1];
					sep2=ingredientess.split("#");
					
					for(int cant=0;cant<sep2.length;cant++){
						String ingrediente =sep2[cant];
						sep3=ingrediente.split("\\*");
				
						System.out.print(sep3[0] + ", ");
						if(Integer.parseInt(sep3[1])!=-1)
				
						System.out.print(sep3[1] + "gramos\n");
				
						else System.out.print(sep3[2] + "unidades\n");
					}
					System.out.println("-la preparacion es: " + sep1[2]);
					concoma = linea.nextLine();
				}
			}
		}
	}
