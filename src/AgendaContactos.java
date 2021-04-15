import java.util.*;
/*
 *  @Author - Iñaki T, Unai P, Enrique L 
 * */
public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap();
	}

	public void añadirContacto(Contacto persona) {
		Set<Contacto> posicion = new TreeSet();
		char inicial = persona.getPrimeraLetra();
		if(agenda.isEmpty()){
			posicion.add(persona);
			agenda.put(inicial, posicion);
		}else {
			if(agenda.containsKey(inicial)) {
				posicion = agenda.get(inicial);
				posicion.add(persona);
				agenda.put(inicial, posicion);
			}
		}

	}
	public void contactosEnLetra(Character letra) {
		Set<Contacto> personas = new TreeSet();	
		Set<Map.Entry<Character,Set<Contacto>>> evento = agenda.entrySet();
        Iterator<Map.Entry<Character,Set<Contacto>>> it = evento.iterator();
        while(it.hasNext()) {
        	Map.Entry<Character,Set<Contacto>> entrada = it.next();	
        	if(entrada.getKey().equals(letra)) {
        		personas.addAll(entrada.getValue());
        	}
        }
        System.out.println(personas);
	}

	public void totalContactos() {
		Set<Map.Entry<Character,Set<Contacto>>> evento = agenda.entrySet();
        Iterator<Map.Entry<Character,Set<Contacto>>> it = evento.iterator();
        while(it.hasNext()) {
        	Map.Entry<Character,Set<Contacto>> entrada = it.next();	
        	int num =entrada.getValue().size();
        	int suma = 0;
        	suma = suma + num;
        }
	}

	@Override
	public String toString() {

		String salida = "";
		salida += "AGENDA DE CONTACTOS\n";
		String sinCorchetes = "";
		for(Character key:agenda.keySet()) {
			//Bucle para quitar los corchetes de cada clave del Map
			for(Set<Contacto> cons:agenda.values()) {
				sinCorchetes += cons.toString() + "\n";
			}
			salida += key + "(" + contactosEnLetra(key) + ")\n---------------" + sinCorchetes + "\n";
		}
		return salida;
	}

	public List<Contacto> buscarContactos(String texto) {

		return null;

	}

	public List<Personal> personalesEnLetra(char letra) {
		List<Personal> personales = new ArrayList();
		Set<Map.Entry<Character,Set<Contacto>>> evento = agenda.entrySet();
        Iterator<Map.Entry<Character,Set<Contacto>>> it = evento.iterator();
        while(it.hasNext()) {
        	Map.Entry<Character,Set<Contacto>> entrada = it.next();	
        	if(entrada.getKey().equals(letra)) {
        		Set<Contacto> posicion= new TreeSet();
        		posicion = entrada.getValue();
        		Iterator<Contacto> iit = posicion.iterator();
        		while(iit.hasNext()) {
        			Contacto salida = iit.next();
        			if(salida instanceof Personal) {
        				Personal p = (Personal) salida;
        				personales.add(p);
        			}
        		}
        	}
        }
        return personales;
	}

	public List<Personal> felicitar() {
		List<Personal> personales = new ArrayList();
		Set<Contacto> posicion= new TreeSet();
		Set<Map.Entry<Character,Set<Contacto>>> evento = agenda.entrySet();
        Iterator<Map.Entry<Character,Set<Contacto>>> it = evento.iterator();
        while(it.hasNext()) {
        	Map.Entry<Character,Set<Contacto>> entrada = it.next();	
        	posicion = entrada.getValue();
        		for(int j = 0;j<posicion.size();j++) {
            		Iterator<Contacto> iit = posicion.iterator();
            		while(iit.hasNext()) {
            			Contacto salida = iit.next();
            			if(salida instanceof Personal) {
            				Personal p = (Personal) salida;
            				if((p.esCumpleaños())) {
            					personales.add(p);
            					}
            				}
            			}
        	}
        	
        }
		return personales;
		
	}

	public Map<Relacion,List<String>> personalesPorRelacion() {
		Set<Contacto> posicion= new TreeSet();
		ArrayList<String> valor = new ArrayList();
		TreeMap<Relacion, List<String>> cambio  = new TreeMap();
		Set<Map.Entry<Character,Set<Contacto>>> evento = agenda.entrySet();
        Iterator<Map.Entry<Character,Set<Contacto>>> it = evento.iterator();
        while(it.hasNext()) {
        	Map.Entry<Character,Set<Contacto>> entrada = it.next();	
        	posicion = entrada.getValue();
        	for(int i = 0; i<posicion.size();i++) {
        		Iterator<Contacto> iit = posicion.iterator();
        		while(iit.hasNext()) {
        			Contacto salida = iit.next();
        			if(salida instanceof Personal) {
        				List<String> si = new ArrayList();
        				Personal p = (Personal) salida;
        				String cadena = p.getNombre() + " " +p.getApellidos();;
        				Relacion relacion = p.getRelacion();
        				if(cambio.isEmpty()) {
        				valor.add(cadena);
        				cambio.put(relacion, valor);       				
        				}else {
        					if(cambio.containsKey(relacion)) {
        						si = cambio.get(relacion);
        						si.add(cadena);
        						cambio.put(relacion, si);
        					}
        				}      				
        				}
        			}
        	}
        }
        return cambio;
		
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {

		return null;

	}

}


