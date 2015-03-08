/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenidosacuario;

import DAO.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import objetos.*;

/**
 *
 * @author Alex
 */
public class Administrador extends javax.swing.JFrame {

    UsuarioDAO uDAO = new UsuarioDAO();
    PezDAO pDAO = new PezDAO();
    OrdenDAO oDAO = new OrdenDAO();
    FamiliaDAO fDAO = new FamiliaDAO();
    SubfamiliaDAO sDAO = new SubfamiliaDAO();
    FotoDAO phDAO = new FotoDAO();
    DefaultTableModel dftm;
    DefaultTableModel dftm2;
    ArrayList<PezVO> fishes = new ArrayList<PezVO>();
    ArrayList<OrdenVO> orders = new ArrayList<OrdenVO>();
    ArrayList<FamiliaVO> flias = new ArrayList<FamiliaVO>();
    ArrayList<SubfamiliaVO> subflias = new ArrayList<SubfamiliaVO>();
    ArrayList<FotoVO> fotos = new ArrayList<FotoVO>();
    int id_pezeditado = 0, id_ordeneditado = 0, id_familiaeditado = 0, id_subfamiliaeditado = 0, id_fotoeditada = 0;

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        this.setContentPane(inicio);
//        orden.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                familia.removeAllItems();
//                familia.addItem("Seleccione la familia");
//                subfamilia.removeAllItems();
//                subfamilia.addItem("Seleccione la subfamilia");
//                if (orders.size() > 0) {
////                    System.out.println("select orden " + orden.getSelectedIndex());
//                    if (orden.getSelectedIndex() > 0) {
//                        OrdenVO oVO = (OrdenVO) orders.get(orden.getSelectedIndex() - 1);
//                        try {
//                            flias = fDAO.fliasList(oVO.getOrde_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (flias != null) {
//                            for (int i = 0; i < flias.size(); i++) {
//                                familia.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            flias = null;
//                        }
//                    }
//                } else {
//                    flias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
        //ajax de subfamilia
//        familia.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                subfamilia.removeAllItems();
//                subfamilia.addItem("Seleccione la subfamilia");
//                if (flias.size() > 0) {
////                    System.out.println("select familia " + familia.getSelectedIndex());
//                    if (familia.getSelectedIndex() > 0) {
//                        FamiliaVO fVO = (FamiliaVO) flias.get(familia.getSelectedIndex() - 1);
//                        try {
//                            subflias = sDAO.SubfliasList(fVO.getFami_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (subflias != null) {
//                            for (int i = 0; i < subflias.size(); i++) {
//                                subfamilia.addItem(((SubfamiliaVO) subflias.get(i)).getSubf_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            subflias = null;
//                        }
//                    }
//                } else {
//                    subflias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
        //ajax para creacion de subfamilias
//        orden1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                familia2.removeAllItems();
//                familia2.addItem("Seleccione la familia");
//                if (orders.size() > 0) {
////                    System.out.println("select orden " + orden.getSelectedIndex());
//                    if (orden1.getSelectedIndex() > 0) {
//                        OrdenVO oVO = (OrdenVO) orders.get(orden1.getSelectedIndex() - 1);
//                        try {
//                            flias = fDAO.fliasList(oVO.getOrde_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (flias != null) {
//                            for (int i = 0; i < flias.size(); i++) {
//                                familia2.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            flias = null;
//                        }
//                    }
//                } else {
//                    flias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
        //ajax para la edicion de subfamilias
//        orden3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                familia3.removeAllItems();
//                familia3.addItem("Seleccione la familia");
//                if (orders.size() > 0) {
////                    System.out.println("select orden " + orden.getSelectedIndex());
//                    if (orden3.getSelectedIndex() > 0) {
//                        OrdenVO oVO = (OrdenVO) orders.get(orden3.getSelectedIndex() - 1);
//                        try {
//                            flias = fDAO.fliasList(oVO.getOrde_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (flias != null) {
//                            for (int i = 0; i < flias.size(); i++) {
//                                familia3.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            flias = null;
//                        }
//                    }
//                } else {
//                    flias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
        //ajax para la edicion de peces
//        orden2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                familia1.removeAllItems();
//                familia1.addItem("Seleccione la familia");
//                subfamilia1.removeAllItems();
//                subfamilia1.addItem("Seleccione la subfamilia");
//                if (orders.size() > 0) {
////                    System.out.println("select orden " + orden.getSelectedIndex());
//                    if (orden2.getSelectedIndex() > 0) {
//                        OrdenVO oVO = (OrdenVO) orders.get(orden2.getSelectedIndex() - 1);
//                        try {
//                            flias = fDAO.fliasList(oVO.getOrde_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (flias != null) {
//                            for (int i = 0; i < flias.size(); i++) {
//                                familia1.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            flias = null;
//                        }
//                    }
//                } else {
//                    flias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
        //ajax de subfamilia
//        familia1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                subfamilia1.removeAllItems();
//                subfamilia1.addItem("Seleccione la subfamilia");
//                if (flias.size() > 0) {
////                    System.out.println("select familia " + familia.getSelectedIndex());
//                    if (familia1.getSelectedIndex() > 0) {
//                        FamiliaVO fVO = (FamiliaVO) flias.get(familia1.getSelectedIndex() - 1);
//                        try {
//                            subflias = sDAO.SubfliasList(fVO.getFami_id());
//                        } catch (SQLException ex) {
//                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        if (subflias != null) {
//                            for (int i = 0; i < subflias.size(); i++) {
//                                subfamilia1.addItem(((SubfamiliaVO) subflias.get(i)).getSubf_descripcion());
//                            }
////                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
////                            lisSubids.add(Subeventos.get(i));
////                        }
//                        } else {
//                            subflias = null;
//                        }
//                    }
//                } else {
//                    subflias = null;
////                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
//                }
//            }
//        });
    }

    public void alineamiento() {
        create.setLocation(516, 408);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        addUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        names = new javax.swing.JLabel();
        apellidos = new javax.swing.JTextField();
        lastName = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        doc = new javax.swing.JLabel();
        documento = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        confirmar = new javax.swing.JLabel();
        passwordConfirm = new javax.swing.JTextField();
        inicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lista = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        editar = new javax.swing.JPanel();
        nombres1 = new javax.swing.JTextField();
        names1 = new javax.swing.JLabel();
        lastName1 = new javax.swing.JLabel();
        apellidos1 = new javax.swing.JTextField();
        user1 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        pass1 = new javax.swing.JLabel();
        doc1 = new javax.swing.JLabel();
        documento1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edition = new javax.swing.JButton();
        passwordConfirm1 = new javax.swing.JPasswordField();
        confirmar1 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        addpez = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nombrecomun = new javax.swing.JTextField();
        nombrecientifico = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pez_distribucion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        alimentacion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        generalidades = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        curiosidades = new javax.swing.JTextArea();
        crearpez = new javax.swing.JButton();
        ordenpane = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        descripcionorden = new javax.swing.JTextField();
        crearorden = new javax.swing.JButton();
        ordenpaneedit = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        descripcionorden2 = new javax.swing.JTextField();
        finalizarorden = new javax.swing.JButton();
        familiapane = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        descripcionfamilia = new javax.swing.JTextField();
        crearfamilia = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        ordenfamilia = new javax.swing.JComboBox();
        subfamiliapane = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        descripcionsubfamilia = new javax.swing.JTextField();
        crearsubfamilia = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        orden1 = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        familia2 = new javax.swing.JComboBox();
        listapeces = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablapeces = new javax.swing.JTable();
        habilitarpeces = new javax.swing.JButton();
        editarpeces = new javax.swing.JButton();
        fotoprinc = new javax.swing.JButton();
        videosGenerales = new javax.swing.JButton();
        videoInactividad = new javax.swing.JButton();
        editarpez = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        nombrecomun1 = new javax.swing.JTextField();
        nombrecientifico1 = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        pez_distribucion1 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        pez_alimentacion1 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        pez_generalidades1 = new javax.swing.JTextArea();
        editpez = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        pez_curiosidades1 = new javax.swing.JTextArea();
        listaordenes = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tablaordenes = new javax.swing.JTable();
        editarorden = new javax.swing.JButton();
        listafamilias = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tablafamilias = new javax.swing.JTable();
        editarfamilia = new javax.swing.JButton();
        familiapaneedit = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        descripcionfamilia1 = new javax.swing.JTextField();
        finalizarfamilia = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        ordenfamilia1 = new javax.swing.JComboBox();
        listasubfamilias = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tablasubfamilias = new javax.swing.JTable();
        editarsubfamilia = new javax.swing.JButton();
        subfamiliapaneedit = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        descripcionsubfamilia1 = new javax.swing.JTextField();
        finalizarsubfamilia = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        orden3 = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        familia3 = new javax.swing.JComboBox();
        fotoprincipal = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        namefish = new javax.swing.JLabel();
        alamcenar = new javax.swing.JButton();
        imagenprincipal = new javax.swing.JLabel();
        examinar = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        rutadisco = new javax.swing.JLabel();
        idpez = new javax.swing.JLabel();
        fotopantalla = new javax.swing.JPanel();
        namefishgeneral = new javax.swing.JLabel();
        namefish1 = new javax.swing.JLabel();
        examinaryguardar1 = new javax.swing.JButton();
        namefish2 = new javax.swing.JLabel();
        namefish3 = new javax.swing.JLabel();
        namefish4 = new javax.swing.JLabel();
        namefish5 = new javax.swing.JLabel();
        examinaryguardar2 = new javax.swing.JButton();
        examinaryguardar3 = new javax.swing.JButton();
        examinaryguardar4 = new javax.swing.JButton();
        examinaryguardar5 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        crear = new javax.swing.JMenuItem();
        listar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addUser.setMaximumSize(new java.awt.Dimension(1024, 768));
        addUser.setMinimumSize(new java.awt.Dimension(1024, 768));
        addUser.setPreferredSize(new java.awt.Dimension(1024, 768));
        addUser.setRequestFocusEnabled(false);
        addUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Usuario");
        addUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 119, 1132, -1));

        nombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 128, -1));

        names.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        names.setText("Nombres");
        addUser.add(names, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 128, -1));

        lastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastName.setText("Apellidos");
        addUser.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setText("Usuario");
        addUser.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 128, -1));

        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.setText("Contraseña");
        addUser.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, 20));

        doc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doc.setText("Documento");
        addUser.add(doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, 20));

        documento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 128, -1));

        create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        create.setText("Crear");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        addUser.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 100, -1));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 128, -1));

        confirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmar.setText("Confirmar");
        addUser.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, 20));

        passwordConfirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addUser.add(passwordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 128, -1));

        inicio.setMaximumSize(new java.awt.Dimension(1024, 768));
        inicio.setMinimumSize(new java.awt.Dimension(1024, 768));
        inicio.setPreferredSize(new java.awt.Dimension(1024, 768));
        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_mundoaventura.png"))); // NOI18N
        inicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1110, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido en el menú superior encontraras las opciones para el manejo del acuario");
        inicio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1110, -1));

        lista.setMaximumSize(new java.awt.Dimension(1024, 768));
        lista.setMinimumSize(new java.awt.Dimension(1024, 768));
        lista.setPreferredSize(new java.awt.Dimension(1024, 768));
        lista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista de Usuarios");
        lista.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1110, -1));

        tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "Documento", "Nombre de Usuario"
            }
        ));
        tabla.setFocusable(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setHeaderValue("Apellidos");
            tabla.getColumnModel().getColumn(2).setHeaderValue("Documento");
            tabla.getColumnModel().getColumn(3).setHeaderValue("Nombre de Usuario");
        }

        lista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 470, 110));

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        lista.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        editar.setMaximumSize(new java.awt.Dimension(1024, 768));
        editar.setMinimumSize(new java.awt.Dimension(1024, 768));
        editar.setName(""); // NOI18N
        editar.setPreferredSize(new java.awt.Dimension(1024, 768));
        editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombres1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(nombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 128, -1));

        names1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        names1.setText("Nombres");
        editar.add(names1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        lastName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastName1.setText("Apellidos");
        editar.add(lastName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        apellidos1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(apellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 128, -1));

        user1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user1.setText("Usuario");
        editar.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        username1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 128, -1));

        pass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass1.setText("Contraseña");
        editar.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, 20));

        doc1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doc1.setText("Documento");
        editar.add(doc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, 20));

        documento1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(documento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 128, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Editar Usuario");
        editar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1110, -1));

        edition.setText("Editar");
        edition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editionActionPerformed(evt);
            }
        });
        editar.add(edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        passwordConfirm1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(passwordConfirm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 128, -1));

        confirmar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmar1.setText("Confirmar");
        editar.add(confirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, 20));

        password1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 128, -1));

        addpez.setPreferredSize(new java.awt.Dimension(767, 615));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel8.setText("CREAR PEZ");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel10.setText("Nombre común");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel11.setText("Nombre científico");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel17.setText("Me encuentro en");

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel18.setText("Que Como");

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel19.setText("Mis Curiosidades");

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel24.setText("Generalidades");

        pez_distribucion.setColumns(20);
        pez_distribucion.setRows(5);
        jScrollPane3.setViewportView(pez_distribucion);

        alimentacion.setColumns(20);
        alimentacion.setRows(5);
        jScrollPane4.setViewportView(alimentacion);

        generalidades.setColumns(20);
        generalidades.setRows(5);
        jScrollPane5.setViewportView(generalidades);

        curiosidades.setColumns(20);
        curiosidades.setRows(5);
        jScrollPane6.setViewportView(curiosidades);

        crearpez.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        crearpez.setText("CREAR");
        crearpez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearpezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addpezLayout = new javax.swing.GroupLayout(addpez);
        addpez.setLayout(addpezLayout);
        addpezLayout.setHorizontalGroup(
            addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpezLayout.createSequentialGroup()
                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel8))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addGap(102, 102, 102)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel17))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombrecomun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(nombrecientifico, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(479, 479, 479)
                        .addComponent(crearpez)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addpezLayout.setVerticalGroup(
            addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpezLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombrecientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombrecomun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addpezLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addpezLayout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(crearpez)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        ordenpane.setMaximumSize(new java.awt.Dimension(1024, 768));
        ordenpane.setMinimumSize(new java.awt.Dimension(1024, 768));
        ordenpane.setPreferredSize(new java.awt.Dimension(1024, 768));
        ordenpane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel27.setText("CREAR ORDEN");
        ordenpane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel26.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel26.setText("Descripcion");
        ordenpane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        descripcionorden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ordenpane.add(descripcionorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 210, 30));

        crearorden.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        crearorden.setText("CREAR");
        crearorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearordenActionPerformed(evt);
            }
        });
        ordenpane.add(crearorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        ordenpaneedit.setMaximumSize(new java.awt.Dimension(1024, 768));
        ordenpaneedit.setMinimumSize(new java.awt.Dimension(1024, 768));
        ordenpaneedit.setPreferredSize(new java.awt.Dimension(1024, 768));
        ordenpaneedit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel28.setText("EDITAR ORDEN");
        ordenpaneedit.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel29.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel29.setText("Descripcion");
        ordenpaneedit.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        descripcionorden2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ordenpaneedit.add(descripcionorden2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 210, 30));

        finalizarorden.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        finalizarorden.setText("FINALIZAR");
        finalizarorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarordenActionPerformed(evt);
            }
        });
        ordenpaneedit.add(finalizarorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        familiapane.setMaximumSize(new java.awt.Dimension(1024, 768));
        familiapane.setMinimumSize(new java.awt.Dimension(1024, 768));
        familiapane.setPreferredSize(new java.awt.Dimension(1024, 768));
        familiapane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel30.setText("CREAR FAMILIA");
        familiapane.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel31.setText("Orden");
        familiapane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        descripcionfamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        familiapane.add(descripcionfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 210, 30));

        crearfamilia.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        crearfamilia.setText("CREAR");
        crearfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearfamiliaActionPerformed(evt);
            }
        });
        familiapane.add(crearfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel32.setText("Descripcion");
        familiapane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        ordenfamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        familiapane.add(ordenfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 210, 30));

        subfamiliapane.setMaximumSize(new java.awt.Dimension(1024, 768));
        subfamiliapane.setMinimumSize(new java.awt.Dimension(1024, 768));
        subfamiliapane.setPreferredSize(new java.awt.Dimension(1024, 768));
        subfamiliapane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel33.setText("CREAR SUBFAMILIA");
        subfamiliapane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel34.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel34.setText("Orden");
        subfamiliapane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        descripcionsubfamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapane.add(descripcionsubfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 210, 30));

        crearsubfamilia.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        crearsubfamilia.setText("CREAR");
        crearsubfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearsubfamiliaActionPerformed(evt);
            }
        });
        subfamiliapane.add(crearsubfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        jLabel35.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel35.setText("Descripcion");
        subfamiliapane.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        orden1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapane.add(orden1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 210, 30));

        jLabel36.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel36.setText("Familia");
        subfamiliapane.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        familia2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapane.add(familia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 210, 30));

        listapeces.setMaximumSize(new java.awt.Dimension(1024, 768));
        listapeces.setMinimumSize(new java.awt.Dimension(1024, 768));
        listapeces.setPreferredSize(new java.awt.Dimension(1024, 768));
        listapeces.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Lista de peces");
        listapeces.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 910, -1));

        tablapeces.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablapeces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre común", "Nombre científico", "Habilitado"
            }
        ));
        tablapeces.setFocusable(false);
        jScrollPane12.setViewportView(tablapeces);

        listapeces.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 750, 290));

        habilitarpeces.setText("HABILITAR");
        habilitarpeces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarpecesActionPerformed(evt);
            }
        });
        listapeces.add(habilitarpeces, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        editarpeces.setText("EDITAR");
        editarpeces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarpecesActionPerformed(evt);
            }
        });
        listapeces.add(editarpeces, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        fotoprinc.setText("FOTO PRINCIPAL");
        fotoprinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotoprincActionPerformed(evt);
            }
        });
        listapeces.add(fotoprinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        videosGenerales.setText("VIDEOS PEZ");
        videosGenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videosGeneralesActionPerformed(evt);
            }
        });
        listapeces.add(videosGenerales, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, -1));

        videoInactividad.setText("VIDEO INACTIVIDAD");
        videoInactividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoInactividadActionPerformed(evt);
            }
        });
        listapeces.add(videoInactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, -1, -1));

        editarpez.setPreferredSize(new java.awt.Dimension(767, 615));

        jLabel38.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel38.setText("EDITAR PEZ");

        jLabel40.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel40.setText("Nombre común");

        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel41.setText("Nombre científico");

        pez_distribucion1.setColumns(20);
        pez_distribucion1.setRows(5);
        jScrollPane14.setViewportView(pez_distribucion1);

        pez_alimentacion1.setColumns(20);
        pez_alimentacion1.setRows(5);
        jScrollPane15.setViewportView(pez_alimentacion1);

        pez_generalidades1.setColumns(20);
        pez_generalidades1.setRows(5);
        jScrollPane16.setViewportView(pez_generalidades1);

        editpez.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        editpez.setText("EDITAR");
        editpez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpezActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel20.setText("Me encuentro en");

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel21.setText("Que Como");

        jLabel25.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel25.setText("Generalidades");

        jLabel39.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel39.setText("Curiosidades");

        pez_curiosidades1.setColumns(20);
        pez_curiosidades1.setRows(5);
        jScrollPane17.setViewportView(pez_curiosidades1);

        javax.swing.GroupLayout editarpezLayout = new javax.swing.GroupLayout(editarpez);
        editarpez.setLayout(editarpezLayout);
        editarpezLayout.setHorizontalGroup(
            editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarpezLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel20)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel25)))
                        .addGap(74, 74, 74)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel39))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombrecomun1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                                .addGap(188, 188, 188)
                                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombrecientifico1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(editarpezLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel41)))
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(217, 217, 217))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                .addComponent(editpez)
                                .addGap(328, 328, 328)))))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        editarpezLayout.setVerticalGroup(
            editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombrecientifico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(nombrecomun1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90)
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(editarpezLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(editarpezLayout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(editarpezLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editpez)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        listaordenes.setMaximumSize(new java.awt.Dimension(1024, 768));
        listaordenes.setMinimumSize(new java.awt.Dimension(1024, 768));
        listaordenes.setPreferredSize(new java.awt.Dimension(1024, 768));
        listaordenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("LISTA DE ORDENES");
        listaordenes.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 770, -1));

        tablaordenes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaordenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaordenes.setFocusable(false);
        jScrollPane23.setViewportView(tablaordenes);

        listaordenes.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 470, 110));

        editarorden.setText("Editar");
        editarorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarordenActionPerformed(evt);
            }
        });
        listaordenes.add(editarorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        listafamilias.setMaximumSize(new java.awt.Dimension(1024, 768));
        listafamilias.setMinimumSize(new java.awt.Dimension(1024, 768));
        listafamilias.setPreferredSize(new java.awt.Dimension(1024, 768));
        listafamilias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("LISTA DE FAMILIAS");
        listafamilias.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 770, -1));

        tablafamilias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablafamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Orden"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablafamilias.setFocusable(false);
        jScrollPane24.setViewportView(tablafamilias);

        listafamilias.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 470, 110));

        editarfamilia.setText("Editar");
        editarfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarfamiliaActionPerformed(evt);
            }
        });
        listafamilias.add(editarfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        familiapaneedit.setMaximumSize(new java.awt.Dimension(1024, 768));
        familiapaneedit.setMinimumSize(new java.awt.Dimension(1024, 768));
        familiapaneedit.setPreferredSize(new java.awt.Dimension(1024, 768));
        familiapaneedit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel58.setText("EDITAR FAMILIA");
        familiapaneedit.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel59.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel59.setText("Orden");
        familiapaneedit.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        descripcionfamilia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        familiapaneedit.add(descripcionfamilia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 210, 30));

        finalizarfamilia.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        finalizarfamilia.setText("FINALIZAR");
        finalizarfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarfamiliaActionPerformed(evt);
            }
        });
        familiapaneedit.add(finalizarfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        jLabel60.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel60.setText("Descripcion");
        familiapaneedit.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        ordenfamilia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        familiapaneedit.add(ordenfamilia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 210, 30));

        listasubfamilias.setMaximumSize(new java.awt.Dimension(1024, 768));
        listasubfamilias.setMinimumSize(new java.awt.Dimension(1024, 768));
        listasubfamilias.setPreferredSize(new java.awt.Dimension(1024, 768));
        listasubfamilias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("LISTA DE SUBFAMILIAS");
        listasubfamilias.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 770, -1));

        tablasubfamilias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablasubfamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Familia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablasubfamilias.setFocusable(false);
        jScrollPane25.setViewportView(tablasubfamilias);

        listasubfamilias.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 470, 110));

        editarsubfamilia.setText("Editar");
        editarsubfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarsubfamiliaActionPerformed(evt);
            }
        });
        listasubfamilias.add(editarsubfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        subfamiliapaneedit.setMaximumSize(new java.awt.Dimension(1024, 768));
        subfamiliapaneedit.setMinimumSize(new java.awt.Dimension(1024, 768));
        subfamiliapaneedit.setPreferredSize(new java.awt.Dimension(1024, 768));
        subfamiliapaneedit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel62.setText("EDITAR SUBFAMILIA");
        subfamiliapaneedit.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel63.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel63.setText("Orden");
        subfamiliapaneedit.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        descripcionsubfamilia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapaneedit.add(descripcionsubfamilia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 210, 30));

        finalizarsubfamilia.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        finalizarsubfamilia.setText("FINALIZAR");
        finalizarsubfamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarsubfamiliaActionPerformed(evt);
            }
        });
        subfamiliapaneedit.add(finalizarsubfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        jLabel64.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel64.setText("Descripcion");
        subfamiliapaneedit.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        orden3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapaneedit.add(orden3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 210, 30));

        jLabel65.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel65.setText("Familia");
        subfamiliapaneedit.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        familia3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfamiliapaneedit.add(familia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 210, 30));

        fotoprincipal.setMaximumSize(new java.awt.Dimension(1024, 768));
        fotoprincipal.setMinimumSize(new java.awt.Dimension(1024, 768));
        fotoprincipal.setPreferredSize(new java.awt.Dimension(1024, 768));
        fotoprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel66.setText("FOTO PRINCIPAL");
        fotoprincipal.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        namefish.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        namefish.setText("Descripcion");
        fotoprincipal.add(namefish, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        alamcenar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alamcenar.setText("GUARDAR");
        alamcenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamcenarActionPerformed(evt);
            }
        });
        fotoprincipal.add(alamcenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, -1, -1));

        imagenprincipal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imagenprincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotoprincipal.add(imagenprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 700, 300));

        examinar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        examinar.setText("EXAMINAR");
        examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarActionPerformed(evt);
            }
        });
        fotoprincipal.add(examinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, -1, -1));

        ruta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ruta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotoprincipal.add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 650, 20));

        rutadisco.setText("C:\\Acuario\\");
            fotoprincipal.add(rutadisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, -1, -1));
            fotoprincipal.add(idpez, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, -1, -1));

            fotopantalla.setMaximumSize(new java.awt.Dimension(1024, 768));
            fotopantalla.setMinimumSize(new java.awt.Dimension(1024, 768));
            fotopantalla.setPreferredSize(new java.awt.Dimension(1024, 768));
            fotopantalla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            namefishgeneral.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
            namefishgeneral.setText("DESCRIPCION");
            fotopantalla.add(namefishgeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 40));

            namefish1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish1.setText("Vivo en");
            fotopantalla.add(namefish1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 70, -1));

            examinaryguardar1.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar1.setText("EXAMINAR & GUARDAR");
            examinaryguardar1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar1ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

            namefish2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish2.setText("Mi cuerpo es");
            fotopantalla.add(namefish2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 100, -1));

            namefish3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish3.setText("Mis medidas son");
            fotopantalla.add(namefish3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 120, -1));

            namefish4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish4.setText("Temperatura");
            fotopantalla.add(namefish4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 130, -1));

            namefish5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish5.setText("General");
            fotopantalla.add(namefish5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, 80, -1));

            examinaryguardar2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar2.setText("EXAMINAR & GUARDAR");
            examinaryguardar2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar2ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

            examinaryguardar3.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar3.setText("EXAMINAR & GUARDAR");
            examinaryguardar3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar3ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

            examinaryguardar4.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar4.setText("EXAMINAR & GUARDAR");
            examinaryguardar4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar4ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

            examinaryguardar5.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar5.setText("EXAMINAR & GUARDAR");
            examinaryguardar5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar5ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, -1, -1));

            jLabel68.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
            jLabel68.setText("VIDEOS");
            fotopantalla.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

            jMenu1.setText("Usuarios");

            crear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userAdd.png"))); // NOI18N
            crear.setText("Crear Usuario");
            crear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    crearActionPerformed(evt);
                }
            });
            jMenu1.add(crear);

            listar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
            listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userList.png"))); // NOI18N
            listar.setText("Listar Usuarios");
            listar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    listarActionPerformed(evt);
                }
            });
            jMenu1.add(listar);

            menu.add(jMenu1);

            jMenu2.setText("Peces");

            jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
            jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fishAdd.png"))); // NOI18N
            jMenuItem1.setText("Crear Pez");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
            jMenu2.add(jMenuItem1);

            jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
            jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userList.png"))); // NOI18N
            jMenuItem2.setText("Listar Peces");
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
                }
            });
            jMenu2.add(jMenuItem2);

            menu.add(jMenu2);

            jMenu4.setText("Ayuda");

            jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/about.png"))); // NOI18N
            jMenuItem6.setText("Acerca de...");
            jMenu4.add(jMenuItem6);

            menu.add(jMenu4);

            setJMenuBar(menu);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addpez, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ordenpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ordenpaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(familiapane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(subfamiliapane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listapeces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editarpez, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listaordenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listafamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(familiapaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listasubfamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(subfamiliapaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fotoprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fotopantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addpez, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ordenpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ordenpaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(familiapane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(subfamiliapane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(listapeces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editarpez, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(listaordenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(listafamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(familiapaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(listasubfamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(subfamiliapaneedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(fotoprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(fotopantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        // TODO add your handling code here:
        this.setContentPane(addUser);
    }//GEN-LAST:event_crearActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        String name = nombres.getText();
        String ape = apellidos.getText();
        String doc = documento.getText();
        String user = username.getText();
        String pass = password.getText();
        String passConf = passwordConfirm.getText();
        String name2 = name.trim();
        String ape2 = ape.trim();
        String doc2 = doc.trim();
        String user2 = user.trim();
        String pass2 = pass.trim();
        String passConf2 = passConf.trim();
        if (name2.equals("") || ape2.equals("") || doc2.equals("") || user2.equals("") || pass2.equals("") || passConf2.equals("")) {
            if (name2.equals("")) {
                nombres.setText("");
            }
            if (ape2.equals("")) {
                apellidos.setText("");
            }
            if (doc2.equals("")) {
                documento.setText("");
            }
            if (user2.equals("")) {
                username.setText("");
            }
            if (pass2.equals("")) {
                password.setText("");
            }
            if (passConf2.equals("")) {
                passwordConfirm.setText("");
            }
            JOptionPane.showMessageDialog(rootPane, "No debe dejar ningun campo vacío \n o con solo espacios en blanco");
        } else {
            if (pass.equals(passConf)) {
                UsuarioVO uVO = new UsuarioVO();
                uVO.setUsua_nombres(name);
                uVO.setUsua_apellidos(ape);
                uVO.setUsua_documento(doc);
                uVO.setUsua_usuario(user);
                uVO.setUsua_contrasena(pass);
                try {
                    boolean usuario = uDAO.getUserName(user); // miro si el nombre de usuario ya esta registrado en la BD
                    boolean docum = uDAO.getUserDoc(doc); //miro su el documento ya existe en la BD
                    if (usuario != true) {
                        if (docum != true) {
                            boolean crear = uDAO.userRegister(uVO);
                            if (crear == true) {
                                nombres.setText("");
                                apellidos.setText("");
                                documento.setText("");
                                username.setText("");
                                password.setText("");
                                JOptionPane.showMessageDialog(rootPane, "Usuario creado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Error al crear el usuario, por favor intente nuevamente.\n Si el problema persiste contacte con el desarrollador.");
                            }
                        } else {
                            documento.setText("");
                            JOptionPane.showMessageDialog(rootPane, "Error el numero de documento ya esta registrado en la base de datos");
                        }
                    } else {
                        username.setText("");
                        JOptionPane.showMessageDialog(rootPane, "Error el nombre de usuario ya esta registrado en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                password.setText("");
                passwordConfirm.setText("");
                JOptionPane.showMessageDialog(rootPane, "La contraseña y su confirmación no coinciden");
            }
        }
    }//GEN-LAST:event_createActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        // TODO add your handling code here:
        this.setContentPane(lista);
        dftm = (DefaultTableModel) this.tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            dftm.removeRow(i);
            i -= 1;
        }
        ArrayList<UsuarioVO> users = new ArrayList<UsuarioVO>();
        try {
            users = uDAO.userList();
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] fila = new String[4];
        for (UsuarioVO uVO : users) {
            fila[0] = uVO.getUsua_nombres();
            fila[1] = uVO.getUsua_apellidos();
            fila[2] = uVO.getUsua_documento();
            fila[3] = uVO.getUsua_usuario();
            dftm.addRow(fila);
        }
        lista.setVisible(true);
    }//GEN-LAST:event_listarActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int x = tabla.getSelectedRow();
        Object[] fila = new String[4];
        fila[0] = tabla.getValueAt(x, 2);
        UsuarioVO uVO = new UsuarioVO();
        try {
            uVO = uDAO.getData((String) fila[0]);
            this.setContentPane(editar);
            nombres1.setText(uVO.getUsua_nombres());
            apellidos1.setText(uVO.getUsua_apellidos());
            documento1.setText(uVO.getUsua_documento());
            username1.setText(uVO.getUsua_usuario());
            documento1.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editActionPerformed

    private void editionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionActionPerformed
        String nom = nombres1.getText();
        String ape = apellidos1.getText();
        String doc = documento1.getText();
        String user = username1.getText();
        String pass = passwordConfirm1.getText();
        String passConf = passwordConfirm1.getText();

    }//GEN-LAST:event_editionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setContentPane(addpez);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void crearpezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearpezActionPerformed
        if (!nombrecomun.getText().trim().equals("") == true && !nombrecientifico.getText().trim().equals("") == true) { //&& !biotipo.getText().trim().equals("") == true && !distribucion.getText().trim().equals("") == true && !forma.getText().trim().equals("") == true && !coloracion.getText().trim().equals("") == true && !tamano.getText().trim().equals("") == true && !temperatura.getText().trim().equals("") == true && !acuario.getText().trim().equals("") == true && !agua.getText().trim().equals("") == true && !alimentacion.getText().trim().equals("") == true
            boolean fish;
            try {
                fish = pDAO.getFishName(nombrecomun.getText());
                if (fish == true) {
                    JOptionPane.showMessageDialog(rootPane, "El nombre del pez ya existe");
                } else {
                    PezVO pez = new PezVO();
                    pez.setPez_nombComun(nombrecomun.getText());
                    pez.setPez_nombCientifico(nombrecientifico.getText());
                    pez.setPez_distribucion(pez_distribucion.getText());
                    pez.setPez_alimentacion(alimentacion.getText());
                    pez.setPez_generalidades(generalidades.getText());
                    pez.setPez_curiosidades(curiosidades.getText());
                    pez.setPez_estado(true);
                    try {
                        boolean sw = (boolean) pDAO.fishRegister(pez);
                        if (sw == true) {
                            nombrecomun.setText("");
                            nombrecientifico.setText("");
                            pez_distribucion.setText("");
                            alimentacion.setText("");
                            generalidades.setText("");
                            curiosidades.setText("");
                            JOptionPane.showMessageDialog(rootPane, "Pez creado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El pez no pudo ser creado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los campos, nombre común, nombre cientifico");
        }
    }//GEN-LAST:event_crearpezActionPerformed

    private void crearordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearordenActionPerformed

        if (!descripcionorden.getText().trim().equals("") == true) {
            try {
                boolean existe = oDAO.getOrderDescripcion(descripcionorden.getText());
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La orden ya fue creada");
                } else {
                    OrdenVO orVO = new OrdenVO();
                    orVO.setOrde_descripcion(descripcionorden.getText());
                    try {
                        boolean insert = oDAO.orderRegister(orVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "Orden creada correctamente");
                            descripcionorden.setText("");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La orden no pudo ser creada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo descripcion es obligatorio");
        }
    }//GEN-LAST:event_crearordenActionPerformed

    private void finalizarordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarordenActionPerformed
        if (!descripcionorden2.getText().trim().equals("") == true) {
            try {
                boolean existe = oDAO.getOrderDescripcionEdit(descripcionorden2.getText(), id_ordeneditado);
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La orden ya fue creada");
                } else {
                    OrdenVO orVO = new OrdenVO();
                    orVO.setOrde_descripcion(descripcionorden2.getText());
                    try {
                        boolean insert = oDAO.orderRegister(orVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "Orden actualizada correctamente");
                            descripcionorden.setText("");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La orden no pudo ser actualizada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            pintartablaordenes();
            this.setContentPane(listaordenes);
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo descripcion es obligatorio");
        }
    }//GEN-LAST:event_finalizarordenActionPerformed

    private void crearfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearfamiliaActionPerformed
        if (ordenfamilia.getSelectedIndex() > 0 && !descripcionfamilia.getText().trim().equals("") == true) {
            FamiliaVO fami = new FamiliaVO();
            fami.setFami_descripcion(descripcionfamilia.getText());
            fami.setOrde_id(((OrdenVO) orders.get(ordenfamilia.getSelectedIndex() - 1)).getOrde_id());
            try {
                boolean existe = fDAO.getFamilyDescripcion(fami);
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La familia ya existe");
                } else {
                    boolean insert = fDAO.FamilyRegister(fami);
                    if (insert == true) {
                        JOptionPane.showMessageDialog(rootPane, "Familia creada correctamente");
                        ordenfamilia.setSelectedIndex(0);
                        descripcionfamilia.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La familia no pudo ser creada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo orden y descripcion son obligatorios");
        }
    }//GEN-LAST:event_crearfamiliaActionPerformed

    private void crearsubfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearsubfamiliaActionPerformed
        if (orden1.getSelectedIndex() > 0 && familia2.getSelectedIndex() > 0 && !descripcionsubfamilia.getText().trim().equals("") == true) {
            SubfamiliaVO sfami = new SubfamiliaVO();
            sfami.setSubf_descripcion(descripcionsubfamilia.getText());
            sfami.setFami_id(((FamiliaVO) flias.get(familia2.getSelectedIndex() - 1)).getFami_id());
            try {
                boolean existe = sDAO.getSubFamilyDescripcion(sfami);
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La subfamilia ya existe");
                } else {
                    boolean insert = sDAO.SubFamilyRegister(sfami);
                    if (insert == true) {
                        JOptionPane.showMessageDialog(rootPane, "Subfamilia creada correctamente");
                        orden1.setSelectedIndex(0);
                        familia2.setSelectedIndex(0);
                        descripcionsubfamilia.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La subfamilia no pudo ser creada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo orden, familia y descripcion son obligatorios");
        }
    }//GEN-LAST:event_crearsubfamiliaActionPerformed

    private void editarpecesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarpecesActionPerformed
        //llenando campos 
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                nombrecomun1.setText(((PezVO) fishes.get(x)).getPez_nombComun());
                nombrecientifico1.setText(((PezVO) fishes.get(x)).getPez_nombCientifico());
                pez_distribucion1.setText(((PezVO) fishes.get(x)).getPez_distribucion());
                pez_alimentacion1.setText(((PezVO) fishes.get(x)).getPez_alimentacion());
                pez_generalidades1.setText(((PezVO) fishes.get(x)).getPez_alimentacion());
                pez_curiosidades1.setText(((PezVO) fishes.get(x)).getPez_curiosidades());
            }
            this.setContentPane(editarpez);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione el pez que desea editar");
        }
    }//GEN-LAST:event_editarpecesActionPerformed

    private void habilitarpecesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarpecesActionPerformed

        //llenando campos 
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                boolean estadoActual = ((PezVO) fishes.get(x)).isPez_estado();
                if (estadoActual == true) {
                    try {
                        boolean update = pDAO.fishUpdateStatus(id_pezeditado, false);
                        if (update == true) {
                            JOptionPane.showMessageDialog(rootPane, "Se deshabilito el pez correctamente");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El pez no pudo ser deshabilitado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        boolean update = pDAO.fishUpdateStatus(id_pezeditado, true);
                        if (update == true) {
                            JOptionPane.showMessageDialog(rootPane, "Se habilito el pez correctamente");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El pez no pudo ser habilitado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            pintartablapeces();
            this.setContentPane(listapeces);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione el pez que desea habilitar o deshabilitar");
        }
    }//GEN-LAST:event_habilitarpecesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        pintartablapeces();
        this.setContentPane(listapeces);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void editpezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpezActionPerformed
        if (!nombrecomun1.getText().trim().equals("") == true && !nombrecientifico1.getText().trim().equals("") == true) { //&& !biotipo.getText().trim().equals("") == true && !distribucion.getText().trim().equals("") == true && !forma.getText().trim().equals("") == true && !coloracion.getText().trim().equals("") == true && !tamano.getText().trim().equals("") == true && !temperatura.getText().trim().equals("") == true && !acuario.getText().trim().equals("") == true && !agua.getText().trim().equals("") == true && !alimentacion.getText().trim().equals("") == true
            boolean fish;
            try {
                fish = pDAO.getFishNameEdit(nombrecomun1.getText(), id_pezeditado);
                if (fish == true) {
                    JOptionPane.showMessageDialog(rootPane, "El nombre del pez ya existe");
                } else {
                    PezVO pez = new PezVO();
                    pez.setPez_id(id_pezeditado);
                    pez.setPez_nombComun(nombrecomun1.getText());
                    pez.setPez_nombCientifico(nombrecientifico1.getText());
                    pez.setPez_alimentacion(pez_alimentacion1.getText());
                    pez.setPez_distribucion(pez_distribucion1.getText());
                    pez.setPez_curiosidades(pez_curiosidades1.getText());
                    pez.setPez_generalidades(pez_generalidades1.getText());

                    try {
                        boolean sw = (boolean) pDAO.fishUpdate(pez);
                        if (sw == true) {
                            JOptionPane.showMessageDialog(rootPane, "Pez Actualizado correctamente");
                            pintartablapeces();
                            this.setContentPane(listapeces);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El pez no pudo ser actualizado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los campos nombre común, nombre cientifico son obligatorios");
        }
    }//GEN-LAST:event_editpezActionPerformed

    private void editarordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarordenActionPerformed
        int x = -1;
        x = tablaordenes.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (orders.size() > 0) {
                id_ordeneditado = ((OrdenVO) orders.get(x)).getOrde_id();
                descripcionorden2.setText(((OrdenVO) orders.get(x)).getOrde_descripcion());
            }
            this.setContentPane(ordenpaneedit);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione la orden que desea editar");
        }
    }//GEN-LAST:event_editarordenActionPerformed

    private void editarfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarfamiliaActionPerformed
        try {
            orders = oDAO.orderList();
            ordenfamilia1.removeAllItems();
            ordenfamilia1.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                ordenfamilia1.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        int x = -1;
        x = tablafamilias.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (flias.size() > 0) {
                id_familiaeditado = ((FamiliaVO) flias.get(x)).getFami_id();
                descripcionfamilia1.setText(((FamiliaVO) flias.get(x)).getFami_descripcion());
                for (int i = 0; i < orders.size(); i++) {
                    if (((OrdenVO) orders.get(i)).getOrde_id() == (((FamiliaVO) flias.get(x)).getOrde_id())) {
                        int j = i + 1;
                        ordenfamilia1.setSelectedIndex(j);
                    }
                }
            }
            this.setContentPane(familiapaneedit);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione la familia que desea editar");
        }
    }//GEN-LAST:event_editarfamiliaActionPerformed

    private void finalizarfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarfamiliaActionPerformed
        if (ordenfamilia1.getSelectedIndex() > 0 && !descripcionfamilia1.getText().trim().equals("") == true) {
            FamiliaVO fami = new FamiliaVO();
            fami.setFami_id(id_familiaeditado);
            fami.setFami_descripcion(descripcionfamilia1.getText());
            fami.setOrde_id(((OrdenVO) orders.get(ordenfamilia1.getSelectedIndex() - 1)).getOrde_id());
            try {
                boolean existe = fDAO.getFamilyDescripcionEdit(fami);
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La familia ya existe");
                } else {
                    boolean insert = fDAO.FamilyUpdate(fami);
                    if (insert == true) {
                        JOptionPane.showMessageDialog(rootPane, "Familia actualizada correctamente");
                        ordenfamilia1.setSelectedIndex(0);
                        descripcionfamilia1.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La familia no pudo ser actualizada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            pintartablafamilias();
            this.setContentPane(listafamilias);
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo orden y descripcion son obligatorios");
        }
    }//GEN-LAST:event_finalizarfamiliaActionPerformed

    private void editarsubfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarsubfamiliaActionPerformed
        try {
            orders = oDAO.orderList();
            orden3.removeAllItems();
            orden3.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                orden3.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        int x = -1;
        x = tablasubfamilias.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (subflias.size() > 0) {
                id_subfamiliaeditado = ((SubfamiliaVO) subflias.get(x)).getSubf_id();
                descripcionsubfamilia1.setText(((SubfamiliaVO) subflias.get(x)).getSubf_descripcion());
                try {
                    ArrayList datos = sDAO.getfamilyAndOrder(id_subfamiliaeditado);

                    for (int i = 0; i < orders.size(); i++) {
                        if (((OrdenVO) orders.get(i)).getOrde_id() == (((int) datos.get(1)))) {
                            int j = i + 1;
                            orden3.setSelectedIndex(j);
                        }
                    }

                    for (int i = 0; i < flias.size(); i++) {
                        if (((FamiliaVO) flias.get(i)).getFami_id() == (((int) datos.get(0)))) {
                            int j = i + 1;
                            familia3.setSelectedIndex(j);
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.setContentPane(subfamiliapaneedit);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione la familia que desea editar");
        }
    }//GEN-LAST:event_editarsubfamiliaActionPerformed

    private void finalizarsubfamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarsubfamiliaActionPerformed
        if (orden3.getSelectedIndex() > 0 && familia3.getSelectedIndex() > 0 && !descripcionsubfamilia1.getText().trim().equals("") == true) {
            SubfamiliaVO sfami = new SubfamiliaVO();
            sfami.setSubf_id(id_subfamiliaeditado);
            sfami.setSubf_descripcion(descripcionsubfamilia1.getText());
            sfami.setFami_id(((FamiliaVO) flias.get(familia3.getSelectedIndex() - 1)).getFami_id());
            try {
                boolean existe = sDAO.getSubFamilyDescripcionEdit(sfami);
                if (existe == true) {
                    JOptionPane.showMessageDialog(rootPane, "La subfamilia ya existe");
                } else {
                    boolean insert = sDAO.SubFamilyUpdate(sfami);
                    if (insert == true) {
                        JOptionPane.showMessageDialog(rootPane, "Subfamilia actualizada correctamente");
                        orden3.setSelectedIndex(0);
                        familia3.setSelectedIndex(0);
                        descripcionsubfamilia1.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La subfamilia no pudo ser actualizada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            pintartablasubfamilias();
            this.setContentPane(listasubfamilias);
        } else {
            JOptionPane.showMessageDialog(rootPane, "El campo orden, familia y descripcion son obligatorios");
        }
    }//GEN-LAST:event_finalizarsubfamiliaActionPerformed

    private void alamcenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamcenarActionPerformed
        if (!ruta.getText().trim().equals("") == true) {
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(ruta.getText());
                File directorio = new File("C:\\acuario\\" + id_pezeditado);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish.getText() + ".png";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(true);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "La imagen principal se guardo correctamente.");
                            imagenprincipal.setIcon(null);
                            ruta.setText("");
                            pintartablapeces();
                            this.setContentPane(listapeces);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                            imagenprincipal.setIcon(null);
                            ruta.setText("");
                            pintartablapeces();
                            this.setContentPane(listapeces);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish.getText() + ".png";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen principal se actualizo correctamente.");
                        imagenprincipal.setIcon(null);
                        ruta.setText("");
                        pintartablapeces();
                        this.setContentPane(listapeces);

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe examinar una imagen, es obligatoria");
        }
    }//GEN-LAST:event_alamcenarActionPerformed

    private void examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarActionPerformed

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.png", "png");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            ruta.setText(String.valueOf(file));
            Image foto = getToolkit().getImage(ruta.getText());
//            System.out.println("alto "+String.valueOf());
            foto = foto.getScaledInstance(700, 300, Image.SCALE_DEFAULT);
            imagenprincipal.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_examinarActionPerformed

    private void fotoprincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotoprincActionPerformed
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x > 0) {
            imagenprincipal.setIcon(null);
            ruta.setText("");
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                try {
                    FotoVO f = (FotoVO) phDAO.getRutaPrincipal(id_pezeditado);
//                    System.out.println("Foto" + f.getFoto_id());
                    if (f != null) {
                        ruta.setText(f.getFoto_ruta());
                        Image foto = getToolkit().getImage(ruta.getText());
//            System.out.println("alto "+String.valueOf());
                        foto = foto.getScaledInstance(700, 300, Image.SCALE_DEFAULT);
                        imagenprincipal.setIcon(new ImageIcon(foto));
                        id_fotoeditada = f.getFoto_id();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
//                
                this.setContentPane(fotoprincipal);
            }
        }else{
           JOptionPane.showMessageDialog(rootPane, "Por favor seleccione un pez para la foto principal."); 
        }
    }//GEN-LAST:event_fotoprincActionPerformed

    private void examinaryguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar1ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\" + id_pezeditado + "\\videos\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\\\vivo.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\vivo.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar1ActionPerformed

    private void examinaryguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar2ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\" + id_pezeditado + "\\videos\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\\\cuerpo.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\cuerpo.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar2ActionPerformed

    private void examinaryguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar3ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\" + id_pezeditado + "\\videos\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\\\medidas.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\medidas.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }

    }//GEN-LAST:event_examinaryguardar3ActionPerformed

    private void examinaryguardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar4ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\" + id_pezeditado + "\\videos\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\\\temperatura.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\temperatura.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }

    }//GEN-LAST:event_examinaryguardar4ActionPerformed

    private void examinaryguardar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar5ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\" + id_pezeditado + "\\videos\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\\\general.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                    String rutadisco = "C:\\\\acuario\\\\" + id_pezeditado + "\\\\videos\\general.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");//rutadisco

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar5ActionPerformed

    private void videosGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosGeneralesActionPerformed
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
//                String prueba = "adfsdh";
//                if(prueba.contains("df")==true){
//                    System.out.println("se encontro");
//                }
//                else{
//                    System.out.println("rechazo");
//                }
                try {
                    fotos = phDAO.ListFotosJPG(id_pezeditado);
                    if (fotos.size() > 0) {
                        for (int i = 0; i < fotos.size(); i++) {
                            FotoVO f = (FotoVO) fotos.get(i);
                            if (f != null) {

                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.setContentPane(fotopantalla);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un pez");
        }
    }//GEN-LAST:event_videosGeneralesActionPerformed

    private void videoInactividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoInactividadActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.mpg", "mpg", "mpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);//.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        int ventana = archivo.showOpenDialog(rootPane);
        String rutaselect = "";
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            rutaselect = String.valueOf(file);
            //se almacena
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(rutaselect);
                File directorio = new File("C:\\\\acuario\\");

                if (!directorio.exists()) {
                    directorio.mkdirs();
                    String rutadisco = "C:\\\\acuario\\\\inactividad.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();
                        FotoVO fVO = new FotoVO();
                        fVO.setFoto_ruta(rutadisco);
                        fVO.setPez_id(id_pezeditado);
                        fVO.setTipo(false);
                        boolean insert = phDAO.FotoRegister(fVO);
                        if (insert == true) {
                            JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El video no pudo ser guardado, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "C:\\\\acuario\\\\inactividad.mpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "El video se guardó correctamente.");//rutadisco

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_videoInactividadActionPerformed

    private void pintartablapeces() {
        dftm2 = (DefaultTableModel) this.tablapeces.getModel();
        for (int i = 0; i < tablapeces.getRowCount(); i++) {
            dftm2.removeRow(i);
            i -= 1;
        }
        try {
            fishes = pDAO.fishList();
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] fila = new String[3];
        for (PezVO pVO : fishes) {
            fila[0] = pVO.getPez_nombComun();
            fila[1] = pVO.getPez_nombCientifico();
            if (pVO.isPez_estado() == true) {
                fila[2] = "Si";
            } else {
                fila[2] = "No";
            }
            dftm2.addRow(fila);
        }
    }

    private void pintartablaordenes() {
        dftm2 = (DefaultTableModel) this.tablaordenes.getModel();
        for (int i = 0; i < tablaordenes.getRowCount(); i++) {
            dftm2.removeRow(i);
            i -= 1;
        }
        try {
            orders = oDAO.orderList();
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] fila = new String[1];
        for (OrdenVO oVO : orders) {
            fila[0] = oVO.getOrde_descripcion();
            dftm2.addRow(fila);
        }
    }

    private void pintartablafamilias() {
        dftm2 = (DefaultTableModel) this.tablafamilias.getModel();
        for (int i = 0; i < tablafamilias.getRowCount(); i++) {
            dftm2.removeRow(i);
            i -= 1;
        }
        try {
            flias = fDAO.fliasList();
            orders = oDAO.orderList();
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] fila = new String[2];
        for (FamiliaVO fVO : flias) {
            fila[0] = fVO.getFami_descripcion();
            for (OrdenVO oVO : orders) {
                if (fVO.getOrde_id() == oVO.getOrde_id()) {
                    fila[1] = oVO.getOrde_descripcion();
                }
            }
            dftm2.addRow(fila);
        }
    }

    private void pintartablasubfamilias() {
        dftm2 = (DefaultTableModel) this.tablasubfamilias.getModel();
        for (int i = 0; i < tablasubfamilias.getRowCount(); i++) {
            dftm2.removeRow(i);
            i -= 1;
        }
        try {
            subflias = sDAO.SubfliasList();
            flias = fDAO.fliasList();
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] fila = new String[2];
        for (SubfamiliaVO sVO : subflias) {
            fila[0] = sVO.getSubf_descripcion();
            for (FamiliaVO fVO : flias) {
                if (sVO.getFami_id() == fVO.getFami_id()) {
                    fila[1] = fVO.getFami_descripcion();
                }
            }
            dftm2.addRow(fila);
        }
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel addpez;
    private javax.swing.JButton alamcenar;
    private javax.swing.JTextArea alimentacion;
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField apellidos1;
    private javax.swing.JLabel confirmar;
    private javax.swing.JLabel confirmar1;
    private javax.swing.JMenuItem crear;
    private javax.swing.JButton crearfamilia;
    private javax.swing.JButton crearorden;
    private javax.swing.JButton crearpez;
    private javax.swing.JButton crearsubfamilia;
    private javax.swing.JButton create;
    private javax.swing.JTextArea curiosidades;
    private javax.swing.JTextField descripcionfamilia;
    private javax.swing.JTextField descripcionfamilia1;
    private javax.swing.JTextField descripcionorden;
    private javax.swing.JTextField descripcionorden2;
    private javax.swing.JTextField descripcionsubfamilia;
    private javax.swing.JTextField descripcionsubfamilia1;
    private javax.swing.JLabel doc;
    private javax.swing.JLabel doc1;
    private javax.swing.JTextField documento;
    private javax.swing.JTextField documento1;
    private javax.swing.JButton edit;
    private javax.swing.JPanel editar;
    private javax.swing.JButton editarfamilia;
    private javax.swing.JButton editarorden;
    private javax.swing.JButton editarpeces;
    private javax.swing.JPanel editarpez;
    private javax.swing.JButton editarsubfamilia;
    private javax.swing.JButton edition;
    private javax.swing.JButton editpez;
    private javax.swing.JButton examinar;
    private javax.swing.JButton examinaryguardar1;
    private javax.swing.JButton examinaryguardar2;
    private javax.swing.JButton examinaryguardar3;
    private javax.swing.JButton examinaryguardar4;
    private javax.swing.JButton examinaryguardar5;
    private javax.swing.JComboBox familia2;
    private javax.swing.JComboBox familia3;
    private javax.swing.JPanel familiapane;
    private javax.swing.JPanel familiapaneedit;
    private javax.swing.JButton finalizarfamilia;
    private javax.swing.JButton finalizarorden;
    private javax.swing.JButton finalizarsubfamilia;
    private javax.swing.JPanel fotopantalla;
    private javax.swing.JButton fotoprinc;
    private javax.swing.JPanel fotoprincipal;
    private javax.swing.JTextArea generalidades;
    private javax.swing.JButton habilitarpeces;
    private javax.swing.JLabel idpez;
    private javax.swing.JLabel imagenprincipal;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel lastName1;
    private javax.swing.JPanel lista;
    private javax.swing.JPanel listafamilias;
    private javax.swing.JPanel listaordenes;
    private javax.swing.JPanel listapeces;
    private javax.swing.JMenuItem listar;
    private javax.swing.JPanel listasubfamilias;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel namefish;
    private javax.swing.JLabel namefish1;
    private javax.swing.JLabel namefish2;
    private javax.swing.JLabel namefish3;
    private javax.swing.JLabel namefish4;
    private javax.swing.JLabel namefish5;
    private javax.swing.JLabel namefishgeneral;
    private javax.swing.JLabel names;
    private javax.swing.JLabel names1;
    private javax.swing.JTextField nombrecientifico;
    private javax.swing.JTextField nombrecientifico1;
    private javax.swing.JTextField nombrecomun;
    private javax.swing.JTextField nombrecomun1;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField nombres1;
    private javax.swing.JComboBox orden1;
    private javax.swing.JComboBox orden3;
    private javax.swing.JComboBox ordenfamilia;
    private javax.swing.JComboBox ordenfamilia1;
    private javax.swing.JPanel ordenpane;
    private javax.swing.JPanel ordenpaneedit;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel pass1;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField passwordConfirm;
    private javax.swing.JPasswordField passwordConfirm1;
    private javax.swing.JTextArea pez_alimentacion1;
    private javax.swing.JTextArea pez_curiosidades1;
    private javax.swing.JTextArea pez_distribucion;
    private javax.swing.JTextArea pez_distribucion1;
    private javax.swing.JTextArea pez_generalidades1;
    private javax.swing.JLabel ruta;
    private javax.swing.JLabel rutadisco;
    private javax.swing.JPanel subfamiliapane;
    private javax.swing.JPanel subfamiliapaneedit;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablafamilias;
    private javax.swing.JTable tablaordenes;
    private javax.swing.JTable tablapeces;
    private javax.swing.JTable tablasubfamilias;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    private javax.swing.JButton videoInactividad;
    private javax.swing.JButton videosGenerales;
    // End of variables declaration//GEN-END:variables
}
