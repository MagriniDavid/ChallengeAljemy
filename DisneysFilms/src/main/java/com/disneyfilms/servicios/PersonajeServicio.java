package com.disneyfilms.servicios;

import com.disneyfilms.entidades.Imagen;
import com.disneyfilms.entidades.Personaje;
import com.disneyfilms.repositorios.PersonajeRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonajeServicio {

    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    
    @Autowired
    private ImagenServicio imagenServicio;
    
    public Personaje buscarPorId(String id) throws Exception, Exception, Exception {
        Optional<Personaje> respuesta = personajeRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Personaje personaje = respuesta.get();
            return personaje;
        } else {
            throw new Exception("No se encontro el personaje.");
        }
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void crearPersonaje(MultipartFile foto,String nombre, int edad, float peso, String historia)throws Exception {
        Personaje personaje = new Personaje();
        Imagen imagen = imagenServicio.guardar(foto);
        personaje.setImagen(imagen);
        personaje.setNombre(nombre);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistoria(historia);
        personajeRepositorio.save(personaje);
    } 
    @Transactional(rollbackFor = Exception.class)
    public void modificarPersonaje(String id,MultipartFile foto,String nombre, int edad, float peso, String historia)throws Exception {
        Personaje personaje = buscarPorId(id);
        Imagen imagen = imagenServicio.guardar(foto);
        personaje.setImagen(imagen);
        personaje.setNombre(nombre);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistoria(historia);
        personajeRepositorio.save(personaje);
    } 
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminarPersonaje(String id){
       personajeRepositorio.deleteById(id);
     }
    
}
