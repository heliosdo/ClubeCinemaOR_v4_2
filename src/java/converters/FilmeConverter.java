package converters;

import entities.Filme; 
import javax.faces.convert.FacesConverter; 
import javax.inject.Named; 


@FacesConverter (forClass = Filme.class) 
@Named 
public class FilmeConverter extends EntityConverter<Filme>{
	
    public FilmeConverter() { 
	super(Filme.class) ; 
    }
}
