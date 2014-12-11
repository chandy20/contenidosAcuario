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
import objetos.FamiliaVO;

/**
 *
 * @author Conditop
 */
public class FamiliaDAO {

    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;
    
    public FamiliaDAO() {
        cn = new Conexion();
    }
    
    public ArrayList<FamiliaVO> fliasList(int orden) throws SQLException {
        ArrayList<FamiliaVO> flias = new ArrayList<FamiliaVO>();
        FamiliaVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM familia WHERE orde_id = "+orden+"");
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new FamiliaVO();
                oVO.setFami_id(res.getInt("fami_id"));
                oVO.setFami_descripcion(res.getString("fami_descripcion"));
                flias.add(oVO);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return flias;
    }
    
    public ArrayList<FamiliaVO> fliasList() throws SQLException {
        ArrayList<FamiliaVO> flias = new ArrayList<FamiliaVO>();
        FamiliaVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM familia ");
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new FamiliaVO();
                oVO.setFami_id(res.getInt("fami_id"));
                oVO.setFami_descripcion(res.getString("fami_descripcion"));
                oVO.setOrde_id(res.getInt("orde_id"));
                flias.add(oVO);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return flias;
    }
    
    public boolean FamilyRegister(FamiliaVO fVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `familia`(`fami_descripcion`, `orde_id`) VALUES  ('"+fVO.getFami_descripcion()+"',"+fVO.getOrde_id()+")");
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
    
    public boolean FamilyUpdate(FamiliaVO fVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("UPDATE `familia` SET `fami_descripcion` = '"+fVO.getFami_descripcion()+"', `orde_id` = "+fVO.getOrde_id()+" WHERE fami_id = "+fVO.getFami_id());
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
    
    public boolean getFamilyDescripcion(FamiliaVO fVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT fami_id FROM familia WHERE fami_descripcion LIKE '" + fVO.getFami_descripcion() + "' AND orde_id = "+fVO.getOrde_id()+"");
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
    
    public boolean getFamilyDescripcionEdit(FamiliaVO fVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT fami_id FROM familia WHERE fami_descripcion LIKE '" + fVO.getFami_descripcion() + "' AND orde_id = "+fVO.getOrde_id()+" AND fami_id <> "+fVO.getFami_id());
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
