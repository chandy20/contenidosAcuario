/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author Conditop
 */
public class SubfamiliaVO {
    private int subf_id;
    private String subf_descripcion;
    private int fami_id;

    public SubfamiliaVO() {
    }

    public int getSubf_id() {
        return subf_id;
    }

    public void setSubf_id(int subf_id) {
        this.subf_id = subf_id;
    }

    public String getSubf_descripcion() {
        return subf_descripcion;
    }

    public void setSubf_descripcion(String subf_descripcion) {
        this.subf_descripcion = subf_descripcion;
    }

    public int getFami_id() {
        return fami_id;
    }

    public void setFami_id(int fami_id) {
        this.fami_id = fami_id;
    }
    
    
}
