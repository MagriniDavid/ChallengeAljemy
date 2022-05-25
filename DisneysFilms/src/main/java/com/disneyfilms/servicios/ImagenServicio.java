package com.disneyfilms.servicios;

import com.disneyfilms.entidades.Imagen;
import com.disneyfilms.repositorios.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicio {
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    public Imagen guardar(MultipartFile archivo) throws Exception{
        if (archivo != null) {
            Imagen imagen = new Imagen();
            imagen.setMime(archivo.getContentType());
            imagen.setNombre(archivo.getName());
            imagen.setContenido(archivo.getBytes());
            
            return imagenRepositorio.save(imagen);
        } else {
            return null;
        }
    }
}
