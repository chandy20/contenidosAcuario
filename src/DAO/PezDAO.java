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
            pstm = cn.getConnection().prepareStatement("INSERT INTO `pez`(`pez_nombComun`, `pez_nombCientifico`, `pez_distribucion`, `pez_alimentacion`, `pez_generalidades`, `pez_curiosidades`, `pez_estado`)"
                       + " VALUES ('" +  pVO.getPez_nombComun() + "','" + pVO.getPez_nombCientifico() + "','" + pVO.getPez_distribucion() + "','" + pVO.getPez_alimentacion() + "','" + pVO.getPez_generalidades() + "','" + pVO.getPez_curiosidades() +"', 1)");
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
        System.out.println("actualizando la joda");
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("UPDATE `pez` SET  `pez_nombComun` = '" + pVO.getPez_nombComun() + "', `pez_nombCientifico` = '" + pVO.getPez_nombCientifico() + "', `pez_distribucion` = '" + pVO.getPez_distribucion() + "', `pez_alimentacion` = '" + pVO.getPez_alimentacion() + "', `pez_generalidades` = '" + pVO.getPez_generalidades() + "', `pez_curiosidades` = '" + pVO.getPez_curiosidades() + "' WHERE pez_id =" + pVO.getPez_id());
            if (pstm.executeUpdate() == 1) {
                r = true;
                System.out.println(r);
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
                pVO.setPez_nombComun(res.getString("pez_nombcomun"));
                pVO.setPez_nombCientifico(res.getString("pez_nombcientifico"));
                pVO.setPez_distribucion(res.getString("pez_distribucion"));
                pVO.setPez_alimentacion(res.getString("pez_alimentacion"));
                pVO.setPez_generalidades(res.getString("pez_generalidades"));
                pVO.setPez_curiosidades(res.getString("pez_curiosidades"));
                pVO.setPez_estado(res.getBoolean("pez_estado"));
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
            pstm = cn.getConnection().prepareStatement("SELECT pez_id FROM pez WHERE pez_nombComun LIKE '" + name + "'");
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
            pstm = cn.getConnection().prepareStatement("SELECT pez_id FROM pez WHERE pez_nombComun LIKE '" + name + "' AND pez_id <> " + pez + "");
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
