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
import objetos.OrdenVO;

/**
 *
 * @author Conditop
 */
public class OrdenDAO {

    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;
    
    public OrdenDAO() {
        cn = new Conexion();
    }
    
    public ArrayList<OrdenVO> orderList() throws SQLException {
        ArrayList<OrdenVO> orders = new ArrayList<OrdenVO>();
        OrdenVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM orden");
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new OrdenVO();
                oVO.setOrde_id(res.getInt("orde_id"));
                oVO.setOrde_descripcion(res.getString("orde_descripcion"));
                orders.add(oVO);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return orders;
    }
    
    public boolean orderRegister(OrdenVO oVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `orden`(`orde_descripcion`) VALUES ('"+oVO.getOrde_descripcion()+"')");
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
    
    public boolean getOrderDescripcion(String name) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT orde_id FROM orden WHERE orde_descripcion LIKE '" + name + "'");
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
    
    public boolean getOrderDescripcionEdit(String name, int id) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT orde_id FROM orden WHERE orde_descripcion LIKE '" + name + "' AND orde_id <> "+id);
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
