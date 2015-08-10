import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Principal {
	
	
	static String rutaUrgencias = "J:\\DIGITALIZACIÓN\\01 INFORMES URG (Colectiva)\\04 ASOCIADO";
	static String rutaDoc = "J:\\DIGITALIZACIÓN\\00 DOCUMENTACION\\04 Asociado";
	static String rutaXedoc = "J:\\DIGITALIZACIÓN\\00 DOCUMENTACION\\05 XEDOC ORIGINALES";
	
	static File[] directoriosAnualesUrgencias;
	static File[] directoriosAnualesDoc;
	static File[] directoriosAnualesXedoc;

	static public void main(String args[]){
		
		Principal principal = new Principal();
		directoriosAnualesUrgencias = principal.getDirectoriosAnuales(rutaUrgencias);
		directoriosAnualesDoc = principal.getDirectoriosAnuales(rutaDoc);
		directoriosAnualesXedoc = principal.getDirectoriosAnuales(rutaXedoc);
		
		principal.printCarpetas(directoriosAnualesUrgencias);
		principal.printCarpetas(directoriosAnualesDoc);
		principal.printCarpetas(directoriosAnualesXedoc);
		
		
		
		/* 
		for(int i=0;i<directoriosAnualesUrgencias.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesUrgencias[i].getAbsolutePath());
			
			System.out.println(directoriosAnualesUrgencias[i].getName());
			for(int j=0;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());
				
				File[] carpetasDias = carpetasMeses[j].listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						// TODO Auto-generated method stub
						return pathname.isDirectory();
					}
				});
				for(int z=0;z<carpetasDias.length;z++){
					
					File ficheroEstadistica = new File(carpetasDias[z].getAbsoluteFile() + "\\estadistica.txt");
					
					System.out.println("Comprobamos que el fichero existe: ");
					System.out.println(ficheroEstadistica.getAbsolutePath());
					if(!ficheroEstadistica.exists()){
						
						String nombreCarpeta = carpetasDias[z].getName();
						
						if(!nombreCarpeta.contains(".db")){
							EstadisticaDia estadistica = principal.getNumeroDeDocumentosSubidosDia(carpetasDias[z].getAbsoluteFile());
							estadistica.imprimeDatos();
							
							
							if(carpetasDias[z].getName().length() > 8 && carpetasDias[z].getName().charAt(8) == ' '
									&& carpetasDias[z].getName().charAt(0) == '2' && carpetasDias[z].getName().charAt(1) == '0'){
								principal.mueveCarpetas(carpetasDias[z]);
							}
							
						}
					}
					
				}
				
			}
			System.out.println();
		}
		
		*/

		
	//	for(int i=0;i<directoriosAnualesDoc.length;i++){
		for(int i=1;i<directoriosAnualesDoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesDoc[i].getAbsolutePath());
			
			System.out.println(directoriosAnualesDoc[i].getName());
	//		for(int j=0;j<carpetasMeses.length;j++){
			for(int j=5;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());
				
				File[] carpetasDias = carpetasMeses[j].listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						// TODO Auto-generated method stub
						return pathname.isDirectory();
					}
				});
				System.out.println("Numero de carpetas: " + carpetasDias.length );
				for(int z=0;z<carpetasDias.length;z++){
					
					String nombreCarpeta = carpetasDias[z].getName();
					
					if(!nombreCarpeta.contains(".db") ){
						

						EstadisticaDia estadistica = principal.getNumeroDeDocumentosSubidosDia(carpetasDias[z].getAbsoluteFile());
						estadistica.imprimeDatos();


						if(carpetasDias[z].getName().length() > 8 && carpetasDias[z].getName().charAt(8) == ' '
								&& carpetasDias[z].getName().charAt(0) == '2' && carpetasDias[z].getName().charAt(1) == '0'){
							principal.mueveCarpetas(carpetasDias[z]);
						}

					}
					

				}
				
			}
			System.out.println();
		}
		
		
		
		for(int i=0;i<directoriosAnualesXedoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesXedoc[i].getAbsolutePath());
			
			System.out.println(directoriosAnualesXedoc[i].getName());
			for(int j=0;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());
				File[] carpetasDias = carpetasMeses[j].listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						// TODO Auto-generated method stub
						return pathname.isDirectory();
					}
				});
				for(int z=0;z<carpetasDias.length;z++){
					
					File ficheroEstadistica = new File(carpetasDias[z].getAbsoluteFile() + "\\estadistica.txt");
					
					
					if(!ficheroEstadistica.exists()){
						
						String nombreCarpeta = carpetasDias[z].getName();
						
						if(!nombreCarpeta.contains(".db")){
							EstadisticaDia estadistica = principal.getNumeroDeDocumentosSubidosDia(carpetasDias[z].getAbsoluteFile());
							estadistica.imprimeDatos();
							
							
							if(carpetasDias[z].getName().length() > 8 && carpetasDias[z].getName().charAt(8) == ' '
									&& carpetasDias[z].getName().charAt(0) == '2' && carpetasDias[z].getName().charAt(1) == '0'){
								principal.mueveCarpetas(carpetasDias[z]);
							}
							
						}
					}
				}
			}
			System.out.println();
		}
		
		
		
		for(int i=0;i<directoriosAnualesUrgencias.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesUrgencias[i].getAbsolutePath());

			for(int j=0;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());

					System.out.println(carpetasMeses[j].getName());
					String registros = principal.creaEstadisticaMensual(carpetasMeses[j]);
					principal.creaTxtEstadisticaMensual(carpetasMeses[j], registros);


			}
		}
		
		
		for(int i=0;i<directoriosAnualesDoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesDoc[i].getAbsolutePath());

			for(int j=0;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());

					System.out.println(carpetasMeses[j].getName());
					String registros = principal.creaEstadisticaMensual(carpetasMeses[j]);
					principal.creaTxtEstadisticaMensual(carpetasMeses[j], registros);


			}
		}
		
		
		
		
		for(int i=0;i<directoriosAnualesXedoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesXedoc[i].getAbsolutePath());

			for(int j=0;j<carpetasMeses.length;j++){
				System.out.println(carpetasMeses[j].getName());

					System.out.println(carpetasMeses[j].getName());
					String registros = principal.creaEstadisticaMensual(carpetasMeses[j]);
					principal.creaTxtEstadisticaMensual(carpetasMeses[j], registros);


			}
		}
		
		
		for(int i=0;i<directoriosAnualesUrgencias.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesUrgencias[i].getAbsolutePath());
			
			String registros = principal.creaEstadisticaAnual(carpetasMeses);
			principal.creaTxtEstadisticaAnual(directoriosAnualesUrgencias[i], registros);
		}
		
		
		
		for(int i=0;i<directoriosAnualesDoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesDoc[i].getAbsolutePath());
			
			String registros = principal.creaEstadisticaAnual(carpetasMeses);
			principal.creaTxtEstadisticaAnual(directoriosAnualesDoc[i], registros);
		}
		
		
		
		
		for(int i=0;i<directoriosAnualesXedoc.length;i++){
			File[] carpetasMeses = principal.getDirectoriosMensuales(directoriosAnualesXedoc[i].getAbsolutePath());
			
			String registros = principal.creaEstadisticaAnual(carpetasMeses);
			principal.creaTxtEstadisticaAnual(directoriosAnualesXedoc[i], registros);
		}
		
		
		/*
		File ruta = new File("J:\\DIGITALIZACIÓN\\00 DOCUMENTACION\\04 Asociado\\2015\\05 Mayo\\19");
		Principal principal = new Principal();
		EstadisticaDia estadistica = principal.getNumeroDeDocumentosSubidosDia(ruta);
		estadistica.imprimeDatos();
		*/
	}
	
	private String creaEstadisticaAnual(File[] carpetasMeses){
		
		String registros = "";
		
		for(int i=0;i<carpetasMeses.length;i++){
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		 

		      
		      try {
		    	  
				if(!carpetasMeses[i].getName().contains("estadis") && !carpetasMeses[i].getName().contains(".db")){
			         archivo = new File (carpetasMeses[i].getAbsoluteFile() + "\\estadistica.txt");
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);
			 
			         // Lectura del fichero
			         String linea;
			         while((linea=br.readLine())!=null){
			        	registros = registros + linea  + "\r\n"; 
			            System.out.println("Leida esta linea " + linea);
			         }
				}
		    	  
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).

		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
		}
		
		registros = registros.substring(0,registros.length()-2);
		
		return registros;
	}
	
	private void creaTxtEstadisticaAnual(File carpetaAño, String registros){
		String ruta = carpetaAño.getAbsolutePath();
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta + "\\estadistica.txt");
            
            pw = new PrintWriter(fichero);
            pw.println(registros);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	
	private String creaEstadisticaMensual(File carpetaMes){
		File[] carpetasDias = carpetaMes.listFiles();
		
		String registros = "";
		
		for(int i=0;i<carpetasDias.length;i++){
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		 

		      
		      try {
		    	  
				if(!carpetasDias[i].getName().contains("estadis") && !carpetasDias[i].getName().contains(".db")){
			         archivo = new File (carpetasDias[i].getAbsoluteFile() + "\\estadistica.txt");
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);
			 
			         // Lectura del fichero
			         String linea;
			         while((linea=br.readLine())!=null){
			        	registros = registros + linea + "\r\n"; 
			            System.out.println("Leida esta linea " + linea);
			         }
				}
		    	  
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).

		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }

		}
		
		registros = registros.substring(0,registros.length()-2);
		
		return registros;
	}
	
	private void creaTxtEstadisticaMensual(File carpetaMes, String registros){
		
		String ruta = carpetaMes.getAbsolutePath();
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta + "\\estadistica.txt");
            
            pw = new PrintWriter(fichero);
            pw.println(registros);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

	}
	
	private void mueveCarpetas(File ficheroViejo){
		String nombreFecha = ficheroViejo.getName().substring(0,8);
		String nombreCarpeta = ficheroViejo.getName();
		
		String rutaAsociados = ficheroViejo.getParentFile().getParentFile().getAbsolutePath();
		
		String año = nombreFecha.substring(0,4);
		String mes = nombreFecha.substring(4,6);
		String dia = nombreFecha.substring(6,8);
		
		mes = getNombreMes(Integer.valueOf(mes)-1);
		
		String nombreNuevo = "\\" + mes + "\\" + dia;
		rutaAsociados = rutaAsociados + nombreNuevo;
		File nuevo = new File(rutaAsociados);
		nuevo.mkdirs();
		
		rutaAsociados = rutaAsociados + "\\" + nombreCarpeta;
		
		System.out.println("V: " + ficheroViejo.getAbsolutePath());
		System.out.println("N: " + rutaAsociados);
		
		nuevo = new File(rutaAsociados);
		
		
		
		if(ficheroViejo.renameTo(nuevo)){
			System.out.println("Cambiado");
		}
		else{
			System.out.println("Imposible mover");
		}
	}
	
	
	private File[] getDirectoriosAnuales(String ruta){
		
		File[] carpetas = new File(ruta).listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.isDirectory();
			}
		});
		int numAños = 0;
		
		for(int i=0;i<carpetas.length;i++){
			if(carpetas[i].getName().length() == 4 && 
					(carpetas[i].getName().charAt(0) == '2' && carpetas[i].getName().charAt(1) == '0')){
				numAños++;
			}
		}
		
		File[] carpetasFinales = new File[numAños];
		for(int i=0;i<carpetas.length;i++){
			if(carpetas[i].getName().length() == 4 && 
					(carpetas[i].getName().charAt(0) == '2' && carpetas[i].getName().charAt(1) == '0')){
				
				carpetasFinales[i] = carpetas[i];
			}
		}
		
		return carpetasFinales;
	}
	
	
	private File[] getDirectoriosMensuales(String ruta){
		File[] carpetas = new File(ruta).listFiles();
		
		int numMeses = 0;
		
		for(int i=0;i<carpetas.length;i++){
			if(	carpetas[i].getName().charAt(2) == ' ' ){
				numMeses++;
			}
		}
		
		File[] carpetasFinales = new File[numMeses];
		for(int i=0;i<numMeses;i++){
			carpetasFinales[i] = carpetas[i];
		}
		
		
		return carpetasFinales;
	}
	
	void printCarpetas(File[] directorios ){
		
		System.out.println();
		for(int i=0;i<directorios.length;i++){
			System.out.println(directorios[i].getName());
		}
	}
	
	
	private EstadisticaDia getNumeroDeDocumentosSubidosDia( File rutaDia){
		
		System.out.println(rutaDia);
		
		int numeroArchivos = 0;
		EstadisticaDia estadisticaDia;
		
		String dia = rutaDia.getName();
		String mes = rutaDia.getParentFile().getName();
		
		mes = mes.substring(0,2);
		
		String año = rutaDia.getParentFile().getParentFile().getName();
				
		
		int diaI = Integer.valueOf(dia);
		int mesI = Integer.valueOf(mes);
		int añoI = Integer.valueOf(año);
		
		if(dia.length() <2){
			dia = "0" + dia;
		}
		if(mes.length() <2){
			dia = "0" + mes;
		}
		
		String fecha = año + mes + dia;
		
		Calendar calendario = new GregorianCalendar(añoI, mesI - 1, diaI);
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		
		if(rutaDia.exists()){
			numeroArchivos = getNumeroFicherosDirectorio( rutaDia);
			
			estadisticaDia = new EstadisticaDia(fecha, String.valueOf(numeroArchivos), getDiaSemana(diaSemana));
			crearFicheroTxt(rutaDia,estadisticaDia);
			
			return estadisticaDia;
		}
			
		
		return null;
	}
	
	
	
	private int getNumeroFicherosDirectorio(File directorio){
		
		int numeroFicheros = 0;
		
		File fichero[] = directorio.listFiles();
		for(int i=0;i<fichero.length;i++){
			if(fichero[i].isDirectory()){
				numeroFicheros = numeroFicheros + getNumeroFicherosDirectorio(fichero[i]);
			}
			else{
				numeroFicheros++;
			}
		}
		
		return numeroFicheros;
	}
	
	
	
	private String getNombreMes(int mes){
		
		String nombre = "";
		
		switch(mes){
		case 0:	nombre = "01 Enero";break;
		case 1:	nombre = "02 Febrero";break;
		case 2:	nombre = "03 Marzo";break;
		case 3:	nombre = "04 Abril";break;
		case 4:	nombre = "05 Mayo";break;
		case 5:	nombre = "06 Junio";break;
		case 6:	nombre = "07 Julio";break;
		case 7:	nombre = "08 Agosto";break;
		case 8:	nombre = "09 Septiembre";break;
		case 9:	nombre = "10 Octubre";break;
		case 10:	nombre = "11 Noviembre";break;
		case 11:	nombre = "12 Diciembre";break;
		}
		
		return nombre;
	}
	
	
	private String getDiaSemana(int d){
		
		String cadena = "";
		switch (d) {
		case 1:
			cadena = "Domingo";
			break;
		case 2:
			cadena = "Lunes";
			break;
		case 3:
			cadena = "Martes";
			break;
		case 4:
			cadena = "Miércoles";
			break;
		case 5:
			cadena = "Jueves";
			break;
		case 6:
			cadena = "Viernes";
			break;
		case 7:
			cadena = "Sábado";
			break;

		default:
			break;
		}
		
		System.out.println("El dia es " + cadena);
		
		return cadena;
	}
	
	
	private void crearFicheroTxt(File directorio, EstadisticaDia estadistica){
		
		String ruta = directorio.getAbsolutePath();
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta + "\\estadistica.txt");
            
            pw = new PrintWriter(fichero);
            pw.println(estadistica.fecha + ";" + estadistica.numeroFicheros + ";" + estadistica.diaSemana);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

	}
	
}
