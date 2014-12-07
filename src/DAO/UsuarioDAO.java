/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import objetos.*;
import contenidosacuario.*;
import java.io.*;

/**
 *
 * @author Enovasoft
 */
public class UsuarioDAO {

    Conexion cn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;

    public UsuarioDAO() {
        cn = new Conexion();
    }

    public UsuarioVO login(String user, String pass) throws SQLException {        
        UsuarioVO uVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT usua_id, usua_nombres, usua_apellidos  FROM usuario WHERE usua_usuario = '" + user + "' AND usua_contrasena = '" + pass + "'");
            res = pstm.executeQuery();
            while (res.next()) {
                uVO = new UsuarioVO();
                uVO.setUsua_id(res.getInt("usua_id"));
                uVO.setUsua_nombres(res.getString("usua_nombres"));
                uVO.setUsua_apellidos(res.getString("usua_apellidos"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
            res.close();
        }
        cn.desconectar();
        return uVO;
    }
}
