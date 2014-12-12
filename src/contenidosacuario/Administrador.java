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
        orden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                familia.removeAllItems();
                familia.addItem("Seleccione la familia");
                subfamilia.removeAllItems();
                subfamilia.addItem("Seleccione la subfamilia");
                if (orders.size() > 0) {
//                    System.out.println("select orden " + orden.getSelectedIndex());
                    if (orden.getSelectedIndex() > 0) {
                        OrdenVO oVO = (OrdenVO) orders.get(orden.getSelectedIndex() - 1);
                        try {
                            flias = fDAO.fliasList(oVO.getOrde_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (flias != null) {
                            for (int i = 0; i < flias.size(); i++) {
                                familia.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            flias = null;
                        }
                    }
                } else {
                    flias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
        //ajax de subfamilia
        familia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                subfamilia.removeAllItems();
                subfamilia.addItem("Seleccione la subfamilia");
                if (flias.size() > 0) {
//                    System.out.println("select familia " + familia.getSelectedIndex());
                    if (familia.getSelectedIndex() > 0) {
                        FamiliaVO fVO = (FamiliaVO) flias.get(familia.getSelectedIndex() - 1);
                        try {
                            subflias = sDAO.SubfliasList(fVO.getFami_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (subflias != null) {
                            for (int i = 0; i < subflias.size(); i++) {
                                subfamilia.addItem(((SubfamiliaVO) subflias.get(i)).getSubf_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            subflias = null;
                        }
                    }
                } else {
                    subflias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
        //ajax para creacion de subfamilias
        orden1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                familia2.removeAllItems();
                familia2.addItem("Seleccione la familia");
                if (orders.size() > 0) {
//                    System.out.println("select orden " + orden.getSelectedIndex());
                    if (orden1.getSelectedIndex() > 0) {
                        OrdenVO oVO = (OrdenVO) orders.get(orden1.getSelectedIndex() - 1);
                        try {
                            flias = fDAO.fliasList(oVO.getOrde_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (flias != null) {
                            for (int i = 0; i < flias.size(); i++) {
                                familia2.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            flias = null;
                        }
                    }
                } else {
                    flias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
        //ajax para la edicion de subfamilias
        orden3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                familia3.removeAllItems();
                familia3.addItem("Seleccione la familia");
                if (orders.size() > 0) {
//                    System.out.println("select orden " + orden.getSelectedIndex());
                    if (orden3.getSelectedIndex() > 0) {
                        OrdenVO oVO = (OrdenVO) orders.get(orden3.getSelectedIndex() - 1);
                        try {
                            flias = fDAO.fliasList(oVO.getOrde_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (flias != null) {
                            for (int i = 0; i < flias.size(); i++) {
                                familia3.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            flias = null;
                        }
                    }
                } else {
                    flias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
        //ajax para la edicion de peces
        orden2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                familia1.removeAllItems();
                familia1.addItem("Seleccione la familia");
                subfamilia1.removeAllItems();
                subfamilia1.addItem("Seleccione la subfamilia");
                if (orders.size() > 0) {
//                    System.out.println("select orden " + orden.getSelectedIndex());
                    if (orden2.getSelectedIndex() > 0) {
                        OrdenVO oVO = (OrdenVO) orders.get(orden2.getSelectedIndex() - 1);
                        try {
                            flias = fDAO.fliasList(oVO.getOrde_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (flias != null) {
                            for (int i = 0; i < flias.size(); i++) {
                                familia1.addItem(((FamiliaVO) flias.get(i)).getFami_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            flias = null;
                        }
                    }
                } else {
                    flias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
        //ajax de subfamilia
        familia1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                subfamilia1.removeAllItems();
                subfamilia1.addItem("Seleccione la subfamilia");
                if (flias.size() > 0) {
//                    System.out.println("select familia " + familia.getSelectedIndex());
                    if (familia1.getSelectedIndex() > 0) {
                        FamiliaVO fVO = (FamiliaVO) flias.get(familia1.getSelectedIndex() - 1);
                        try {
                            subflias = sDAO.SubfliasList(fVO.getFami_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (subflias != null) {
                            for (int i = 0; i < subflias.size(); i++) {
                                subfamilia1.addItem(((SubfamiliaVO) subflias.get(i)).getSubf_descripcion());
                            }
//                        for (int i = 0; i < Subeventos.size(); i = i + 2) {
//                            lisSubids.add(Subeventos.get(i));
//                        }
                        } else {
                            subflias = null;
                        }
                    }
                } else {
                    subflias = null;
//                    jLabel1.setText("NO EXISTEN EVENTOS ACTIVOS");
                }
            }
        });
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
        delete = new javax.swing.JButton();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        orden = new javax.swing.JComboBox();
        familia = new javax.swing.JComboBox();
        subfamilia = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        nombrepez = new javax.swing.JTextField();
        nombrecomun = new javax.swing.JTextField();
        nombrecientifico = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        biotipo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        distribucion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        forma = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        coloracion = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        tamano = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        temperatura = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        agua = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        acuario = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        alimentacion = new javax.swing.JTextArea();
        crearpez = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        comportamiento = new javax.swing.JTextArea();
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
        fotosgenerales = new javax.swing.JButton();
        editarpez = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        orden2 = new javax.swing.JComboBox();
        familia1 = new javax.swing.JComboBox();
        subfamilia1 = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        nombrepez1 = new javax.swing.JTextField();
        nombrecomun1 = new javax.swing.JTextField();
        nombrecientifico1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        biotipo1 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        distribucion1 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        forma1 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        coloracion1 = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        tamano1 = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        temperatura1 = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        agua1 = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        acuario1 = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        alimentacion1 = new javax.swing.JTextArea();
        editpez = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        comportamiento1 = new javax.swing.JTextArea();
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
        imagengeneral5 = new javax.swing.JLabel();
        examinaryguardar1 = new javax.swing.JButton();
        namefish2 = new javax.swing.JLabel();
        namefish3 = new javax.swing.JLabel();
        namefish4 = new javax.swing.JLabel();
        namefish5 = new javax.swing.JLabel();
        namefish6 = new javax.swing.JLabel();
        namefish7 = new javax.swing.JLabel();
        namefish8 = new javax.swing.JLabel();
        namefish9 = new javax.swing.JLabel();
        namefish10 = new javax.swing.JLabel();
        imagengeneral1 = new javax.swing.JLabel();
        imagengeneral2 = new javax.swing.JLabel();
        imagengeneral3 = new javax.swing.JLabel();
        imagengeneral4 = new javax.swing.JLabel();
        imagengeneral10 = new javax.swing.JLabel();
        imagengeneral6 = new javax.swing.JLabel();
        imagengeneral7 = new javax.swing.JLabel();
        imagengeneral8 = new javax.swing.JLabel();
        imagengeneral9 = new javax.swing.JLabel();
        examinaryguardar2 = new javax.swing.JButton();
        examinaryguardar3 = new javax.swing.JButton();
        examinaryguardar4 = new javax.swing.JButton();
        examinaryguardar5 = new javax.swing.JButton();
        examinaryguardar6 = new javax.swing.JButton();
        examinaryguardar7 = new javax.swing.JButton();
        examinaryguardar8 = new javax.swing.JButton();
        examinaryguardar9 = new javax.swing.JButton();
        examinaryguardar10 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        crear = new javax.swing.JMenuItem();
        listar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
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

        delete.setText("Eliminar");
        lista.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        lista.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

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

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setText("Nombre");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel10.setText("Nombre común");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel11.setText("Nombre científico");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel12.setText("Biótopo");

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel13.setText("Clasificación");

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel14.setText("Orden");

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel15.setText("Familia");

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel16.setText("Subfamilia");

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel17.setText("Distribución");

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel18.setText("Forma");

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel19.setText("Tamaño");

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel20.setText("Temperatura");

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel21.setText("Agua");

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel22.setText("Acuario");

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel23.setText("Alimentación");

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel24.setText("Coloración");

        biotipo.setColumns(20);
        biotipo.setRows(5);
        jScrollPane2.setViewportView(biotipo);

        distribucion.setColumns(20);
        distribucion.setRows(5);
        jScrollPane3.setViewportView(distribucion);

        forma.setColumns(20);
        forma.setRows(5);
        jScrollPane4.setViewportView(forma);

        coloracion.setColumns(20);
        coloracion.setRows(5);
        jScrollPane5.setViewportView(coloracion);

        tamano.setColumns(20);
        tamano.setRows(5);
        jScrollPane6.setViewportView(tamano);

        temperatura.setColumns(20);
        temperatura.setRows(5);
        jScrollPane7.setViewportView(temperatura);

        agua.setColumns(20);
        agua.setRows(5);
        jScrollPane8.setViewportView(agua);

        acuario.setColumns(20);
        acuario.setRows(5);
        jScrollPane9.setViewportView(acuario);

        alimentacion.setColumns(20);
        alimentacion.setRows(5);
        jScrollPane10.setViewportView(alimentacion);

        crearpez.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        crearpez.setText("CREAR");
        crearpez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearpezActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel25.setText("Comportamiento");

        comportamiento.setColumns(20);
        comportamiento.setRows(5);
        jScrollPane11.setViewportView(comportamiento);

        javax.swing.GroupLayout addpezLayout = new javax.swing.GroupLayout(addpez);
        addpez.setLayout(addpezLayout);
        addpezLayout.setHorizontalGroup(
            addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpezLayout.createSequentialGroup()
                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nombrepez, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(187, 187, 187)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addComponent(nombrecomun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(familia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(nombrecientifico)
                            .addComponent(subfamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel8))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel12)
                                .addGap(151, 151, 151)
                                .addComponent(jLabel17))
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addGap(466, 466, 466)
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
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombrecientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(subfamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombrecomun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(familia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
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
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombrepez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addpezLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addpezLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addpezLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(addpezLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addpezLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(crearpez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                "Nombre", "Nombre común", "Nombre científico", "Habilitado"
            }
        ));
        tablapeces.setFocusable(false);
        jScrollPane12.setViewportView(tablapeces);

        listapeces.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 760, 180));

        habilitarpeces.setText("HABILITAR");
        habilitarpeces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarpecesActionPerformed(evt);
            }
        });
        listapeces.add(habilitarpeces, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        editarpeces.setText("Editar");
        editarpeces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarpecesActionPerformed(evt);
            }
        });
        listapeces.add(editarpeces, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        fotoprinc.setText("FOTO PRINCIPAL");
        fotoprinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotoprincActionPerformed(evt);
            }
        });
        listapeces.add(fotoprinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, -1));

        fotosgenerales.setText("FOTOS PANTALLA");
        fotosgenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotosgeneralesActionPerformed(evt);
            }
        });
        listapeces.add(fotosgenerales, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

        editarpez.setPreferredSize(new java.awt.Dimension(767, 615));

        jLabel38.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel38.setText("EDITAR PEZ");

        jLabel39.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel39.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel40.setText("Nombre común");

        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel41.setText("Nombre científico");

        jLabel42.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel42.setText("Biótopo");

        jLabel43.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel43.setText("Clasificación");

        jLabel44.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel44.setText("Orden");

        jLabel45.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel45.setText("Familia");

        jLabel46.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel46.setText("Subfamilia");

        jLabel47.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel47.setText("Distribución");

        jLabel48.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel48.setText("Forma");

        jLabel49.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel49.setText("Tamaño");

        jLabel50.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel50.setText("Temperatura");

        jLabel51.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel51.setText("Agua");

        jLabel52.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel52.setText("Acuario");

        jLabel53.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel53.setText("Alimentación");

        jLabel54.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel54.setText("Coloración");

        biotipo1.setColumns(20);
        biotipo1.setRows(5);
        jScrollPane13.setViewportView(biotipo1);

        distribucion1.setColumns(20);
        distribucion1.setRows(5);
        jScrollPane14.setViewportView(distribucion1);

        forma1.setColumns(20);
        forma1.setRows(5);
        jScrollPane15.setViewportView(forma1);

        coloracion1.setColumns(20);
        coloracion1.setRows(5);
        jScrollPane16.setViewportView(coloracion1);

        tamano1.setColumns(20);
        tamano1.setRows(5);
        jScrollPane17.setViewportView(tamano1);

        temperatura1.setColumns(20);
        temperatura1.setRows(5);
        jScrollPane18.setViewportView(temperatura1);

        agua1.setColumns(20);
        agua1.setRows(5);
        jScrollPane19.setViewportView(agua1);

        acuario1.setColumns(20);
        acuario1.setRows(5);
        jScrollPane20.setViewportView(acuario1);

        alimentacion1.setColumns(20);
        alimentacion1.setRows(5);
        jScrollPane21.setViewportView(alimentacion1);

        editpez.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        editpez.setText("FINALIZAR");
        editpez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpezActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel55.setText("Comportamiento");

        comportamiento1.setColumns(20);
        comportamiento1.setRows(5);
        jScrollPane22.setViewportView(comportamiento1);

        javax.swing.GroupLayout editarpezLayout = new javax.swing.GroupLayout(editarpez);
        editarpez.setLayout(editarpezLayout);
        editarpezLayout.setHorizontalGroup(
            editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarpezLayout.createSequentialGroup()
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nombrepez1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(orden2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(187, 187, 187)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel45))
                            .addComponent(nombrecomun1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(familia1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel46)
                            .addComponent(jLabel41)
                            .addComponent(nombrecientifico1)
                            .addComponent(subfamilia1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel38))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel42)
                                .addGap(151, 151, 151)
                                .addComponent(jLabel47))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)
                            .addComponent(jLabel49)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(editpez)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editarpezLayout.setVerticalGroup(
            editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombrecientifico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(subfamilia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombrecomun1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(familia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editarpezLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel54)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarpezLayout.createSequentialGroup()
                                    .addComponent(jLabel49)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombrepez1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(orden2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editarpezLayout.createSequentialGroup()
                            .addComponent(jLabel53)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editarpezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editarpezLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editarpezLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(editarpezLayout.createSequentialGroup()
                            .addComponent(jLabel55)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editarpezLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(editpez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            fotopantalla.add(namefishgeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 40));

            namefish1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish1.setText("1");
            fotopantalla.add(namefish1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 20, -1));

            imagengeneral5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral5.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 190, 130));

            examinaryguardar1.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar1.setText("EXAMINAR & GUARDAR");
            examinaryguardar1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar1ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

            namefish2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish2.setText("2");
            fotopantalla.add(namefish2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 10, -1));

            namefish3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish3.setText("3");
            fotopantalla.add(namefish3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 10, -1));

            namefish4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish4.setText("4");
            fotopantalla.add(namefish4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 10, -1));

            namefish5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish5.setText("5");
            fotopantalla.add(namefish5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, 10, -1));

            namefish6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish6.setText("6");
            fotopantalla.add(namefish6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 10, -1));

            namefish7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish7.setText("7");
            fotopantalla.add(namefish7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 10, -1));

            namefish8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish8.setText("8");
            fotopantalla.add(namefish8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 10, -1));

            namefish9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish9.setText("9");
            fotopantalla.add(namefish9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 10, -1));

            namefish10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
            namefish10.setText("10");
            fotopantalla.add(namefish10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 530, 20, -1));

            imagengeneral1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 190, 130));

            imagengeneral2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 190, 130));

            imagengeneral3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 190, 130));

            imagengeneral4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral4.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 190, 130));

            imagengeneral10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral10.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 590, 190, 130));

            imagengeneral6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral6.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 190, 130));

            imagengeneral7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral7.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 190, 130));

            imagengeneral8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral8.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, 190, 130));

            imagengeneral9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            imagengeneral9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagengeneral9.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            fotopantalla.add(imagengeneral9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 190, 130));

            examinaryguardar2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar2.setText("EXAMINAR & GUARDAR");
            examinaryguardar2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar2ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

            examinaryguardar3.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar3.setText("EXAMINAR & GUARDAR");
            examinaryguardar3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar3ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, -1));

            examinaryguardar4.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar4.setText("EXAMINAR & GUARDAR");
            examinaryguardar4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar4ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, -1, -1));

            examinaryguardar5.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar5.setText("EXAMINAR & GUARDAR");
            examinaryguardar5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar5ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 410, -1, -1));

            examinaryguardar6.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar6.setText("EXAMINAR & GUARDAR");
            examinaryguardar6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar6ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 750, -1, -1));

            examinaryguardar7.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar7.setText("EXAMINAR & GUARDAR");
            examinaryguardar7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar7ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 750, -1, -1));

            examinaryguardar8.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar8.setText("EXAMINAR & GUARDAR");
            examinaryguardar8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar8ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 750, -1, -1));

            examinaryguardar9.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar9.setText("EXAMINAR & GUARDAR");
            examinaryguardar9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar9ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 750, -1, -1));

            examinaryguardar10.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
            examinaryguardar10.setText("EXAMINAR & GUARDAR");
            examinaryguardar10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    examinaryguardar10ActionPerformed(evt);
                }
            });
            fotopantalla.add(examinaryguardar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 750, -1, -1));

            jLabel68.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
            jLabel68.setText("FOTOS PANTALLA");
            fotopantalla.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

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

            jMenu3.setText("Clasificación");

            jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
            jMenuItem4.setText("Crear Orden");
            jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem4ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem4);

            jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userList.png"))); // NOI18N
            jMenuItem3.setText("Lista Ordenes");
            jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem3ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem3);

            jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/about.png"))); // NOI18N
            jMenuItem7.setText("Crear Familia");
            jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem7ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem7);

            jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userList.png"))); // NOI18N
            jMenuItem8.setText("Lista Familias");
            jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem8ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem8);

            jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/about.png"))); // NOI18N
            jMenuItem9.setText("Crear Subfamilia");
            jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem9ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem9);

            jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
            jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userList.png"))); // NOI18N
            jMenuItem10.setText("Lista Subfamilias");
            jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem10ActionPerformed(evt);
                }
            });
            jMenu3.add(jMenuItem10);

            menu.add(jMenu3);

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
                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
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
                    .addComponent(addpez, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE))
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
                        .addComponent(editarpez, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
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
                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
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
                    .addComponent(addpez, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
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
                        .addComponent(editarpez, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
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
        try {
            orders = oDAO.orderList();
            orden.removeAllItems();
            orden.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                orden.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setContentPane(addpez);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void crearpezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearpezActionPerformed
        if (!nombrepez.getText().trim().equals("") == true && !nombrecomun.getText().trim().equals("") == true && !nombrecientifico.getText().trim().equals("") == true && subfamilia.getSelectedIndex() > 0) { //&& !biotipo.getText().trim().equals("") == true && !distribucion.getText().trim().equals("") == true && !forma.getText().trim().equals("") == true && !coloracion.getText().trim().equals("") == true && !tamano.getText().trim().equals("") == true && !temperatura.getText().trim().equals("") == true && !acuario.getText().trim().equals("") == true && !agua.getText().trim().equals("") == true && !alimentacion.getText().trim().equals("") == true
            boolean fish;
            try {
                fish = pDAO.getFishName(nombrepez.getText());
                if (fish == true) {
                    JOptionPane.showMessageDialog(rootPane, "El nombre del pez ya existe");
                } else {
                    PezVO pez = new PezVO();
                    pez.setPez_nombre(nombrepez.getText());
                    pez.setPez_nombComun(nombrecomun.getText());
                    pez.setPez_nombCientifico(nombrecientifico.getText());
                    pez.setSubf_id(((SubfamiliaVO) subflias.get(subfamilia.getSelectedIndex() - 1)).getSubf_id());//capturar el id de la subfamilia de la lista
                    pez.setPez_distribucion(distribucion.getText());
                    pez.setPez_agua(agua.getText());
                    pez.setPez_alimentacion(alimentacion.getText());
                    pez.setPez_biotopo(biotipo.getText());
                    pez.setPez_coloracion(coloracion.getText());
                    pez.setPez_comportamiento(comportamiento.getText());
                    pez.setPez_forma(forma.getText());
                    pez.setPez_tamano(tamano.getText());
                    pez.setPez_tempreatura(temperatura.getText());
                    pez.setPez_estado(true);
                    pez.setPez_acuario(acuario.getText());
                    try {
                        boolean sw = (boolean) pDAO.fishRegister(pez);
                        if (sw == true) {
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
            JOptionPane.showMessageDialog(rootPane, "Los campos nombre, nombre común, nombre cientifico, orden, familia y subfamilia son obligatorios");
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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.setContentPane(ordenpane);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        pintartablaordenes();
        this.setContentPane(listaordenes);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            orders = oDAO.orderList();
            ordenfamilia.removeAllItems();
            ordenfamilia.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                ordenfamilia.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setContentPane(familiapane);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            orders = oDAO.orderList();
            orden1.removeAllItems();
            orden1.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                orden1.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setContentPane(subfamiliapane);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void editarpecesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarpecesActionPerformed
        try {
            orders = oDAO.orderList();
            orden2.removeAllItems();
            orden2.addItem("Seleccione el orden");
            for (int i = 0; i < orders.size(); i++) {
                orden2.addItem(((OrdenVO) orders.get(i)).getOrde_descripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        //llenando campos 
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                nombrepez1.setText(((PezVO) fishes.get(x)).getPez_nombre());
                nombrecomun1.setText(((PezVO) fishes.get(x)).getPez_nombComun());
                nombrecientifico1.setText(((PezVO) fishes.get(x)).getPez_nombCientifico());
                biotipo1.setText(((PezVO) fishes.get(x)).getPez_biotopo());
                distribucion1.setText(((PezVO) fishes.get(x)).getPez_distribucion());
                forma1.setText(((PezVO) fishes.get(x)).getPez_forma());
                coloracion1.setText(((PezVO) fishes.get(x)).getPez_coloracion());
                tamano.setText(((PezVO) fishes.get(x)).getPez_tamano());
                temperatura1.setText(((PezVO) fishes.get(x)).getPez_tempreatura());
                agua1.setText(((PezVO) fishes.get(x)).getPez_agua());
                acuario1.setText(((PezVO) fishes.get(x)).getPez_acuario());
                alimentacion1.setText(((PezVO) fishes.get(x)).getPez_alimentacion());
                comportamiento1.setText(((PezVO) fishes.get(x)).getPez_comportamiento());
                try {
                    ArrayList datos = (ArrayList) sDAO.getfamilyAndOrder(((PezVO) fishes.get(x)).getSubf_id());
                    for (int i = 0; i < orders.size(); i++) {
                        if (((OrdenVO) orders.get(i)).getOrde_id() == ((int) datos.get(1))) {
                            int j = i + 1;
                            orden2.setSelectedIndex(j);
                        }
                    }
                    for (int i = 0; i < flias.size(); i++) {
                        if (((FamiliaVO) flias.get(i)).getFami_id() == ((int) datos.get(0))) {
                            int j = i + 1;
                            familia1.setSelectedIndex(j);
                        }
                    }
                    for (int i = 0; i < subflias.size(); i++) {
                        if (((SubfamiliaVO) subflias.get(i)).getSubf_id() == ((PezVO) fishes.get(x)).getSubf_id()) {
                            int j = i + 1;
                            subfamilia1.setSelectedIndex(j);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        if (!nombrepez1.getText().trim().equals("") == true && !nombrecomun1.getText().trim().equals("") == true && !nombrecientifico1.getText().trim().equals("") == true && subfamilia1.getSelectedIndex() > 0) { //&& !biotipo.getText().trim().equals("") == true && !distribucion.getText().trim().equals("") == true && !forma.getText().trim().equals("") == true && !coloracion.getText().trim().equals("") == true && !tamano.getText().trim().equals("") == true && !temperatura.getText().trim().equals("") == true && !acuario.getText().trim().equals("") == true && !agua.getText().trim().equals("") == true && !alimentacion.getText().trim().equals("") == true
            boolean fish;
            try {
                fish = pDAO.getFishNameEdit(nombrepez1.getText(), id_pezeditado);
                if (fish == true) {
                    JOptionPane.showMessageDialog(rootPane, "El nombre del pez ya existe");
                } else {
                    PezVO pez = new PezVO();
                    pez.setPez_id(id_pezeditado);
                    pez.setPez_nombre(nombrepez1.getText());
                    pez.setPez_nombComun(nombrecomun1.getText());
                    pez.setPez_nombCientifico(nombrecientifico1.getText());
                    pez.setSubf_id(((SubfamiliaVO) subflias.get(subfamilia1.getSelectedIndex() - 1)).getSubf_id());//capturar el id de la subfamilia de la lista
                    pez.setPez_distribucion(distribucion1.getText());
                    pez.setPez_agua(agua1.getText());
                    pez.setPez_alimentacion(alimentacion1.getText());
                    pez.setPez_biotopo(biotipo1.getText());
                    pez.setPez_coloracion(coloracion1.getText());
                    pez.setPez_comportamiento(comportamiento1.getText());
                    pez.setPez_forma(forma1.getText());
                    pez.setPez_tamano(tamano1.getText());
                    pez.setPez_tempreatura(temperatura1.getText());
                    pez.setPez_acuario(acuario1.getText());
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
            JOptionPane.showMessageDialog(rootPane, "Los campos nombre, nombre común, nombre cientifico, orden, familia y subfamilia son obligatorios");
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

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        pintartablafamilias();
        this.setContentPane(listafamilias);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        pintartablasubfamilias();
        this.setContentPane(listasubfamilias);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void alamcenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamcenarActionPerformed
        if (!ruta.getText().trim().equals("") == true) {
            try {
                byte[] readData = new byte[1024];
                FileInputStream archivofoto = new FileInputStream(ruta.getText());
                File directorio = new File("c:\\acuario\\" + id_pezeditado);
                if (directorio.mkdirs()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish.getText() + ".png";
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
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish.getText() + ".png";
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
//            foto = foto.getScaledInstance(700, 300, Image.SCALE_DEFAULT);
            imagenprincipal.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_examinarActionPerformed

    private void fotoprincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotoprincActionPerformed
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                namefish.setText(((PezVO) fishes.get(x)).getPez_nombre());
                try {
                    FotoVO f = (FotoVO) phDAO.getRutaPrincipal(id_pezeditado);
                    System.out.println("Foto" + f.getFoto_id());
                    if (f != null) {
                        ruta.setText(f.getFoto_ruta());
                        Image foto = getToolkit().getImage(ruta.getText());
//            System.out.println("alto "+String.valueOf());
//            foto = foto.getScaledInstance(700, 300, Image.SCALE_DEFAULT);
                        imagenprincipal.setIcon(new ImageIcon(foto));
                        id_fotoeditada = f.getFoto_id();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
//                
                this.setContentPane(fotoprincipal);
            }
        }
    }//GEN-LAST:event_fotoprincActionPerformed

    private void examinaryguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar1ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish1.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish1.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral1.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish1.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral1.setIcon(new ImageIcon(foto));

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
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish2.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish2.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral2.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish2.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral2.setIcon(new ImageIcon(foto));

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
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish3.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish3.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral3.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish3.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral3.setIcon(new ImageIcon(foto));

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
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish4.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish4.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral4.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish4.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral4.setIcon(new ImageIcon(foto));

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
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish5.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish5.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral5.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish5.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral5.setIcon(new ImageIcon(foto));

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

    private void examinaryguardar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar6ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish6.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish6.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral6.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish6.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral6.setIcon(new ImageIcon(foto));

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar6ActionPerformed

    private void examinaryguardar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar7ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish7.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish7.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral7.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish7.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral7.setIcon(new ImageIcon(foto));

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar7ActionPerformed

    private void examinaryguardar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar8ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish8.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish8.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral8.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish8.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral8.setIcon(new ImageIcon(foto));

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar8ActionPerformed

    private void examinaryguardar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar9ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish9.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish9.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral9.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish9.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral9.setIcon(new ImageIcon(foto));

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar9ActionPerformed

    private void examinaryguardar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinaryguardar10ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *.jpg", "jpg", "jpeg");
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
                File directorio = new File("c:\\acuario\\" + id_pezeditado + "\\" + namefish10.getText() + ".jpg");

                if (!directorio.exists()) {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish10.getText() + ".jpg";
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
                            JOptionPane.showMessageDialog(rootPane, "La imagen se guardo correctamente.");
                            Image foto = getToolkit().getImage(rutadisco);
                            foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                            imagengeneral10.setIcon(new ImageIcon(foto));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "La imagen no pudo ser guardada, por favor intente nuevamente. \n Si el problema persiste contacte al desarrollador. ");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String rutadisco = "c:\\\\acuario\\\\" + id_pezeditado + "\\\\" + namefish10.getText() + ".jpg";
                    FileOutputStream envio = new FileOutputStream(rutadisco);
                    try {
                        int i = archivofoto.read(readData);
                        while (i != -1) {
                            envio.write(readData, 0, i);
                            i = archivofoto.read(readData);
                        }
                        archivofoto.close();
                        envio.close();

                        JOptionPane.showMessageDialog(rootPane, "La imagen se actualizo correctamente.");//rutadisco
                        Image foto = getToolkit().getImage(rutadisco);
                        foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                        imagengeneral10.setIcon(new ImageIcon(foto));

                    } catch (IOException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //fin almacena
        }
    }//GEN-LAST:event_examinaryguardar10ActionPerformed

    private void fotosgeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotosgeneralesActionPerformed
        int x = -1;
        x = tablapeces.getSelectedRow();
//        System.out.println("pisicion de la fila " + x);
        if (x >= 0) {
            imagengeneral1.setIcon(null);
            imagengeneral2.setIcon(null);
            imagengeneral3.setIcon(null);
            imagengeneral4.setIcon(null);
            imagengeneral5.setIcon(null);
            imagengeneral6.setIcon(null);
            imagengeneral7.setIcon(null);
            imagengeneral8.setIcon(null);
            imagengeneral9.setIcon(null);
            imagengeneral10.setIcon(null);
            if (fishes.size() > 0) {
                id_pezeditado = ((PezVO) fishes.get(x)).getPez_id();
                namefishgeneral.setText(((PezVO) fishes.get(x)).getPez_nombre());

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
                                if(f.getFoto_ruta().contains("1.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral1.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("2.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral2.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("3.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral3.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("4.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral4.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("5.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral5.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("6.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral6.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("7.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral7.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("8.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral8.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("9.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral9.setIcon(new ImageIcon(foto));
                                }
                                if(f.getFoto_ruta().contains("10.jpg")==true){
                                    Image foto = getToolkit().getImage(f.getFoto_ruta());
                                    foto = foto.getScaledInstance(190, 130, Image.SCALE_DEFAULT);
                                    imagengeneral10.setIcon(new ImageIcon(foto));
                                }
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
    }//GEN-LAST:event_fotosgeneralesActionPerformed

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
        String[] fila = new String[4];
        for (PezVO pVO : fishes) {
            fila[0] = pVO.getPez_nombre();
            fila[1] = pVO.getPez_nombComun();
            fila[2] = pVO.getPez_nombCientifico();
            if (pVO.isPez_estado() == true) {
                fila[3] = "Si";
            } else {
                fila[3] = "No";
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
    private javax.swing.JTextArea acuario;
    private javax.swing.JTextArea acuario1;
    private javax.swing.JPanel addUser;
    private javax.swing.JPanel addpez;
    private javax.swing.JTextArea agua;
    private javax.swing.JTextArea agua1;
    private javax.swing.JButton alamcenar;
    private javax.swing.JTextArea alimentacion;
    private javax.swing.JTextArea alimentacion1;
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField apellidos1;
    private javax.swing.JTextArea biotipo;
    private javax.swing.JTextArea biotipo1;
    private javax.swing.JTextArea coloracion;
    private javax.swing.JTextArea coloracion1;
    private javax.swing.JTextArea comportamiento;
    private javax.swing.JTextArea comportamiento1;
    private javax.swing.JLabel confirmar;
    private javax.swing.JLabel confirmar1;
    private javax.swing.JMenuItem crear;
    private javax.swing.JButton crearfamilia;
    private javax.swing.JButton crearorden;
    private javax.swing.JButton crearpez;
    private javax.swing.JButton crearsubfamilia;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JTextField descripcionfamilia;
    private javax.swing.JTextField descripcionfamilia1;
    private javax.swing.JTextField descripcionorden;
    private javax.swing.JTextField descripcionorden2;
    private javax.swing.JTextField descripcionsubfamilia;
    private javax.swing.JTextField descripcionsubfamilia1;
    private javax.swing.JTextArea distribucion;
    private javax.swing.JTextArea distribucion1;
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
    private javax.swing.JButton examinaryguardar10;
    private javax.swing.JButton examinaryguardar2;
    private javax.swing.JButton examinaryguardar3;
    private javax.swing.JButton examinaryguardar4;
    private javax.swing.JButton examinaryguardar5;
    private javax.swing.JButton examinaryguardar6;
    private javax.swing.JButton examinaryguardar7;
    private javax.swing.JButton examinaryguardar8;
    private javax.swing.JButton examinaryguardar9;
    private javax.swing.JComboBox familia;
    private javax.swing.JComboBox familia1;
    private javax.swing.JComboBox familia2;
    private javax.swing.JComboBox familia3;
    private javax.swing.JPanel familiapane;
    private javax.swing.JPanel familiapaneedit;
    private javax.swing.JButton finalizarfamilia;
    private javax.swing.JButton finalizarorden;
    private javax.swing.JButton finalizarsubfamilia;
    private javax.swing.JTextArea forma;
    private javax.swing.JTextArea forma1;
    private javax.swing.JPanel fotopantalla;
    private javax.swing.JButton fotoprinc;
    private javax.swing.JPanel fotoprincipal;
    private javax.swing.JButton fotosgenerales;
    private javax.swing.JButton habilitarpeces;
    private javax.swing.JLabel idpez;
    private javax.swing.JLabel imagengeneral1;
    private javax.swing.JLabel imagengeneral10;
    private javax.swing.JLabel imagengeneral2;
    private javax.swing.JLabel imagengeneral3;
    private javax.swing.JLabel imagengeneral4;
    private javax.swing.JLabel imagengeneral5;
    private javax.swing.JLabel imagengeneral6;
    private javax.swing.JLabel imagengeneral7;
    private javax.swing.JLabel imagengeneral8;
    private javax.swing.JLabel imagengeneral9;
    private javax.swing.JLabel imagenprincipal;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
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
    private javax.swing.JLabel namefish10;
    private javax.swing.JLabel namefish2;
    private javax.swing.JLabel namefish3;
    private javax.swing.JLabel namefish4;
    private javax.swing.JLabel namefish5;
    private javax.swing.JLabel namefish6;
    private javax.swing.JLabel namefish7;
    private javax.swing.JLabel namefish8;
    private javax.swing.JLabel namefish9;
    private javax.swing.JLabel namefishgeneral;
    private javax.swing.JLabel names;
    private javax.swing.JLabel names1;
    private javax.swing.JTextField nombrecientifico;
    private javax.swing.JTextField nombrecientifico1;
    private javax.swing.JTextField nombrecomun;
    private javax.swing.JTextField nombrecomun1;
    private javax.swing.JTextField nombrepez;
    private javax.swing.JTextField nombrepez1;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField nombres1;
    private javax.swing.JComboBox orden;
    private javax.swing.JComboBox orden1;
    private javax.swing.JComboBox orden2;
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
    private javax.swing.JLabel ruta;
    private javax.swing.JLabel rutadisco;
    private javax.swing.JComboBox subfamilia;
    private javax.swing.JComboBox subfamilia1;
    private javax.swing.JPanel subfamiliapane;
    private javax.swing.JPanel subfamiliapaneedit;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablafamilias;
    private javax.swing.JTable tablaordenes;
    private javax.swing.JTable tablapeces;
    private javax.swing.JTable tablasubfamilias;
    private javax.swing.JTextArea tamano;
    private javax.swing.JTextArea tamano1;
    private javax.swing.JTextArea temperatura;
    private javax.swing.JTextArea temperatura1;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}
