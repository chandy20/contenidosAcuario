/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Alex
 */
public class UsuarioVO {

    public UsuarioVO() {
    }
    int usua_id;
    String usua_nombres;
    String usua_apellidos;
    String usua_documento;
    String usua_usuario;
    String usua_contrasena;

    public int getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(int usua_id) {
        this.usua_id = usua_id;
    }

    public String getUsua_nombres() {
        return usua_nombres;
    }

    public void setUsua_nombres(String usua_nombres) {
        this.usua_nombres = usua_nombres;
    }

    public String getUsua_apellidos() {
        return usua_apellidos;
    }

    public void setUsua_apellidos(String usua_apellidos) {
        this.usua_apellidos = usua_apellidos;
    }

    public String getUsua_documento() {
        return usua_documento;
    }

    public void setUsua_documento(String usua_documento) {
        this.usua_documento = usua_documento;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_contrasena() {
        return usua_contrasena;
    }

    public void setUsua_contrasena(String usua_contrasena) {
        this.usua_contrasena = usua_contrasena;
    }

}
