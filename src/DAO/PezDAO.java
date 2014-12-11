/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import contenidosacuario.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetos.PezVO;

/**
 *
 * @author Enovasoft
 */
public class PezDAO {

    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;

    public PezDAO() {
        cn = new Conexion();
    }

    public boolean fishRegister(PezVO pVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `pez`(`pez_nombre`, `pez_nombComun`, `pez_nombCientifico`, `pez_biotopo`, `pez_distribucion`, `pez_forma`, `pez_coloracion`, `pez_tamano`, `pez_temperatura`, `pez_agua`, `pez_alimentacion`, `pez_comportamiento`, `pez_estado`, `subf_id`, `pez_acuario`)"
                    + " VALUES ('" + pVO.getPez_nombre() + "','" + pVO.getPez_nombComun() + "','" + pVO.getPez_nombCientifico() + "','" + pVO.getPez_biotopo() + "','" + pVO.getPez_distribucion() + "','" + pVO.getPez_forma() + "','" + pVO.getPez_coloracion() + "','" + pVO.getPez_tamano() + "','" + pVO.getPez_tempreatura() + "','" + pVO.getPez_agua() + "','" + pVO.getPez_alimentacion() + "','" + pVO.getPez_comportamiento() + "'," + pVO.isPez_estado() + "," + pVO.getSubf_id() + ",'" + pVO.getPez_acuario() + "')");
            if (pstm.executeUpdate() == 1) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return r;
    }

    public boolean fishUpdate(PezVO pVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("UPDATE `pez` SET `pez_nombre` = '" + pVO.getPez_nombre() + "', `pez_nombComun` = '" + pVO.getPez_nombComun() + "', `pez_nombCientifico` = '" + pVO.getPez_nombCientifico() + "', `pez_biotopo` = '" + pVO.getPez_biotopo() + "', `pez_distribucion` = '" + pVO.getPez_distribucion() + "', `pez_forma` = '" + pVO.getPez_forma() + "', `pez_coloracion` = '" + pVO.getPez_coloracion() + "', `pez_tamano` = '" + pVO.getPez_tamano() + "', `pez_temperatura` = '" + pVO.getPez_tempreatura() + "', `pez_agua` = '" + pVO.getPez_agua() + "', `pez_alimentacion` = '" + pVO.getPez_alimentacion() + "', `pez_comportamiento` = '" + pVO.getPez_comportamiento() + "', `subf_id` = " + pVO.getSubf_id() + ", `pez_acuario` = '" + pVO.getPez_acuario() + "' WHERE pez_id =" + pVO.getPez_id());
            if (pstm.executeUpdate() == 1) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return r;
    }

    public boolean fishUpdateStatus(int pez, boolean estado) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("UPDATE `pez` SET `pez_estado` = " + estado + " WHERE pez_id =" + pez);
            if (pstm.executeUpdate() == 1) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return r;
    }

    public ArrayList<PezVO> fishList() throws SQLException {
        ArrayList<PezVO> fish = new ArrayList<PezVO>();
        PezVO pVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM pez");
            res = pstm.executeQuery();
            while (res.next()) {
                pVO = new PezVO();
                pVO.setPez_id(res.getInt("pez_id"));
                pVO.setPez_nombre(res.getString("pez_nombre"));
                pVO.setPez_nombComun(res.getString("pez_nombcomun"));
                pVO.setPez_nombCientifico(res.getString("pez_nombcientifico"));
                pVO.setSubf_id(res.getInt("subf_id"));//capturar el id de la subfamilia de la lista
                pVO.setPez_distribucion(res.getString("pez_distribucion"));
                pVO.setPez_agua(res.getString("pez_agua"));
                pVO.setPez_alimentacion(res.getString("pez_alimentacion"));
                pVO.setPez_biotopo(res.getString("pez_biotopo"));
                pVO.setPez_coloracion(res.getString("pez_coloracion"));
                pVO.setPez_comportamiento(res.getString("pez_comportamiento"));
                pVO.setPez_forma(res.getString("pez_forma"));
                pVO.setPez_tamano(res.getString("pez_tamano"));
                pVO.setPez_tempreatura(res.getString("pez_temperatura"));
                pVO.setPez_estado(res.getBoolean("pez_estado"));
                pVO.setPez_acuario(res.getString("pez_acuario"));
                fish.add(pVO);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return fish;
    }

    public boolean getFishName(String name) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT pez_id FROM pez WHERE pez_nombre LIKE '" + name + "'");
            res = pstm.executeQuery();
            while (res.next()) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return r;
    }

    public boolean getFishNameEdit(String name, int pez) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT pez_id FROM pez WHERE pez_nombre LIKE '" + name + "' AND pez_id <> " + pez + "");
            res = pstm.executeQuery();
            while (res.next()) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return r;
    }

}
