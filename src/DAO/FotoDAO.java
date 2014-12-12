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
import objetos.FotoVO;

/**
 *
 * @author User
 */
public class FotoDAO {
    
    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;
    
    public FotoDAO() {
        cn = new Conexion();
    }
    
    public boolean FotoRegister(FotoVO fVO) throws SQLException {
//        System.out.println("fVO" +fVO.getFoto_ruta());
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `foto`(`foto_ruta`, `pez_id`, `tipo`) VALUES ('"+fVO.getFoto_ruta()+"',"+fVO.getPez_id()+","+fVO.isTipo()+")");
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
    
    public boolean FotoUpdate(FotoVO fVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `foto`(`foto_ruta`, `pez_id`, `tipo`) VALUES ('"+fVO.getFoto_ruta()+"',"+fVO.getPez_id()+","+fVO.isTipo()+")");
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
    
    public FotoVO getRutaPrincipal(int pez) throws SQLException {
        FotoVO r = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT `foto_id`, `foto_ruta` FROM `foto` WHERE `pez_id` = "+pez+" AND `tipo` = "+ true);
            res = pstm.executeQuery();
            while (res.next()) {
                r = new FotoVO();
                r.setFoto_id(res.getInt("foto_id"));
                r.setFoto_ruta(res.getString("foto_ruta"));
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
    
    public ArrayList<FotoVO> ListFotosJPG(int pez) throws SQLException {
        ArrayList<FotoVO> flias = new ArrayList<FotoVO>();
        FotoVO oVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT * FROM foto WHERE pez_id = "+pez+" AND tipo = "+false);
            res = pstm.executeQuery();
            while (res.next()) {
                oVO = new FotoVO();
                oVO.setFoto_id(res.getInt("foto_id"));
                oVO.setFoto_ruta(res.getString("foto_ruta"));
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
}
