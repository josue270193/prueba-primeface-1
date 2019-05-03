package com.josue.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.annotation.ManagedBean;
import java.io.IOException;

@ManagedBean
public class Formulario {

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private UploadedFile archivo = null;

    @Getter
    private StreamedContent descarga = null;

    public void limpiarArchivo() {
        archivo = null;
        descarga = null;
    }

    public void upload2(FileUploadEvent event) throws IOException {
        this.setArchivo(event.getFile());
        if (this.archivo != null) {
            this.descarga = new DefaultStreamedContent(
                    this.archivo.getInputstream(),
                    this.archivo.getContentType(),
                    this.archivo.getFileName()
            );
            upload();
        }
    }

    public void upload() throws IOException {
        String fileName = this.archivo.getFileName();
        String contentType = this.archivo.getContentType();
        byte[] contents = this.archivo.getContents();

        StringBuffer mensaje = new StringBuffer();
        mensaje.append("Hola");
        if (this.getArchivo() != null) {
            mensaje.append(" - Archivo: ")
                    .append(this.getArchivo().getFileName())
                    .append(" + ")
                    .append(this.getArchivo().getContentType())
            ;
        }
        System.out.println(mensaje.toString());
    }

    public String show() {
        StringBuffer mensaje = new StringBuffer();
        mensaje.append("Hola");
        if (this.getArchivo() != null) {
            mensaje.append(" - Archivo: ")
                    .append(this.getArchivo().getFileName())
                    .append(" + ")
                    .append(this.getArchivo().getContentType())
            ;
        }
        mensaje.append(" - Nombre: ")
                .append(this.getNombre())
        ;

        System.out.println(mensaje.toString());
        return mensaje.toString();
    }
}
