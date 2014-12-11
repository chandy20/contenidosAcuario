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
import objetos.SubfamiliaVO;

/**
 *
 * @author Conditop
 */
public class SubfamiliaDAO {
    
    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;
    
    public SubfamiliaDAO() {
        cn = new Conexion();
    }
    
    public ArrayList<SubfamiliaVO> SubfliasList(int fami) throws SQLException {
        ArrayList<SubfamiliaVO> flias = new ArrayList<SubfamiliaVO>();
        SubfamiliaVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM subfamilia WHERE fami_id = "+fami+"");
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new SubfamiliaVO();
                oVO.setSubf_id(res.getInt("subf_id"));
                oVO.setSubf_descripcion(res.getString("subf_descripcion"));
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
    
    public ArrayList<SubfamiliaVO> SubfliasList() throws SQLException {
        ArrayList<SubfamiliaVO> flias = new ArrayList<SubfamiliaVO>();
        SubfamiliaVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM subfamilia ");
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new SubfamiliaVO();
                oVO.setSubf_id(res.getInt("subf_id"));
                oVO.setSubf_descripcion(res.getString("subf_descripcion"));
                oVO.setFami_id(res.getInt("fami_id"));
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
    
    public boolean SubFamilyRegister(SubfamiliaVO sVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `subfamilia`(`subf_descripcion`, `fami_id`) VALUES ('"+sVO.getSubf_descripcion()+"',"+sVO.getFami_id()+")");
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
    
    public boolean SubFamilyUpdate(SubfamiliaVO sVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("UPDATE `subfamilia` SET `subf_descripcion` = '"+sVO.getSubf_descripcion()+"', `fami_id` = "+sVO.getFami_id()+" WHERE subf_id = "+sVO.getSubf_id());
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
    
    public boolean getSubFamilyDescripcion(SubfamiliaVO sVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT subf_id FROM subfamilia WHERE subf_descripcion LIKE '" + sVO.getSubf_descripcion() + "' AND fami_id = "+sVO.getFami_id()+"");
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
    
    public boolean getSubFamilyDescripcionEdit(SubfamiliaVO sVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT subf_id FROM subfamilia WHERE subf_descripcion LIKE '" + sVO.getSubf_descripcion() + "' AND fami_id = "+sVO.getFami_id()+" AND subf_id <> "+sVO.getSubf_id());
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
    
    public ArrayList getfamilyAndOrder(int subf_id) throws SQLException {
        ArrayList r = new ArrayList();
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT f.fami_id, o.orde_id FROM subfamilia s INNER JOIN familia f ON f.fami_id = s.fami_id INNER JOIN orden o ON o.orde_id = f.orde_id WHERE s.subf_id = "+subf_id+"");
            res = pstm.executeQuery();
            while (res.next()) {
                r.add(res.getInt("fami_id"));
                r.add(res.getInt("orde_id"));
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
