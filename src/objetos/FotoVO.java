/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author User
 */
public class FotoVO {

    private int foto_id;
    private String foto_ruta;
    private int pez_id;
    private boolean tipo;
    
    public FotoVO() {
    }

    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public String getFoto_ruta() {
        return foto_ruta;
    }

    public void setFoto_ruta(String foto_ruta) {
        this.foto_ruta = foto_ruta;
    }

    public int getPez_id() {
        return pez_id;
    }

    public void setPez_id(int pez_id) {
        this.pez_id = pez_id;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
}
