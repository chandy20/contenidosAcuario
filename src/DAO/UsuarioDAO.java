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

    public boolean userRegister(UsuarioVO uVO) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("INSERT INTO `usuario`(`usua_nombres`, `usua_apellidos`, `usua_documento`, `usua_usuario`, `usua_contrasena`) VALUES ('" + uVO.getUsua_nombres() + "','" + uVO.getUsua_apellidos() + "','" + uVO.getUsua_documento() + "','" + uVO.getUsua_usuario() + "','" + uVO.getUsua_contrasena() + "')");
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

    public boolean getUserName(String username) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT usua_id FROM usuario WHERE usua_usuario = '" + username + "'");
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

    public boolean getUserDoc(String doc) throws SQLException {
        boolean r = false;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT usua_id FROM usuario WHERE usua_documento = '" + doc + "'");
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

    public ArrayList<UsuarioVO> userList() throws SQLException {
        ArrayList<UsuarioVO> users = new ArrayList<UsuarioVO>();
        UsuarioVO uVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT usua_nombres, usua_apellidos, usua_documento, usua_usuario FROM usuario");
            res = pstm.executeQuery();
            while (res.next()) {
                uVO = new UsuarioVO();
                uVO.setUsua_nombres(res.getString("usua_nombres"));
                uVO.setUsua_apellidos(res.getString("usua_apellidos"));
                uVO.setUsua_documento(res.getString("usua_documento"));
                uVO.setUsua_usuario(res.getString("usua_usuario"));
                users.add(uVO);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return users;
    }

    public UsuarioVO getData(String doc) throws SQLException {
        UsuarioVO uVO = null;
        try {
            stm = cn.getConnection().createStatement();
            pstm = cn.getConnection().prepareStatement("SELECT usua_nombres, usua_apellidos, usua_documento, usua_usuario FROM usuario WHERE usua_documento = '" + doc + "'");
            res = pstm.executeQuery();
            while (res.next()) {
                uVO = new UsuarioVO();
                uVO.setUsua_nombres(res.getString("usua_nombres"));
                uVO.setUsua_apellidos(res.getString("usua_apellidos"));
                uVO.setUsua_documento(res.getString("usua_documento"));
                uVO.setUsua_usuario(res.getString("usua_usuario"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            stm.close();
            pstm.close();
        }
        cn.desconectar();
        return uVO;
    }
}
