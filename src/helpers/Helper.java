/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import index.Index;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author sabagip
 */
public class Helper {
    
    Log log = new Log();

    public static void getFechaGraduacion(JComboBox<?> cmbBoxMesInicioCarrera, JComboBox<?> cmbBoxAnioInicioBeca, JComboBox<?> cmbBoxMesGraduacion, JComboBox<?> cmbBoxAnioGraduacion, JComboBox<?> cmbBoxSemestreInicioBeca, JComboBox<?> cmbBoxTotalSemestres) {
        Calendar graduacion = new GregorianCalendar(Integer.parseInt((String) cmbBoxAnioInicioBeca.getSelectedItem()), 
        cmbBoxMesInicioCarrera.getSelectedIndex(), 1);

        graduacion.add(Calendar.MONTH, - Integer.parseInt(cmbBoxSemestreInicioBeca.getSelectedItem().toString()) * 6);
        graduacion.add(Calendar.MONTH, Integer.parseInt((String) cmbBoxTotalSemestres.getSelectedItem()) * 6);      

        int indexAnioGraduacion = graduacion.get(Calendar.YEAR) - Integer.parseInt(cmbBoxAnioGraduacion.getItemAt(0).toString()) ;

        cmbBoxAnioGraduacion.setSelectedIndex(indexAnioGraduacion);
        cmbBoxMesGraduacion.setSelectedIndex(graduacion.get(Calendar.MONTH));
    }

    public static void getBecaSemestral(JComboBox<?> cmbSemestresTotales, JComboBox<?> cmbSemestreInicioBeca, JTextField txtBecaAutorizada, JTextField txtBecaSemestral) {
        int semestres = Integer.parseInt((String) cmbSemestresTotales.getSelectedItem()) - 
                Integer.parseInt((String) cmbSemestreInicioBeca.getSelectedItem());
        float total = Float.parseFloat(txtBecaAutorizada.getText()) / semestres;
        txtBecaSemestral.setText(total + "");
    }
    /**
     * Carga una imagen dentro de un label y la adapta al tamaño de la etiqueta
     * @param etiqueta Etiqueta donde se pondrá la imagen
     * @param ruta Ruta de la imagen que se pondrá en la etiqueta
     */
    public void cargaImagenLocal(JLabel etiqueta, String ruta){
        ImageIcon fot = new ImageIcon(getClass().getResource(ruta));
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }
    
    public void cargaImagenExterna(JLabel etiqueta, Path path){
        ImageIcon fot = new ImageIcon(path.toString());
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }

    /**
     * Agrega un JPanel a un JScrollPane 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param spnlParentesco JScrollPane donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JScrollPane spnlParentesco) {
        //spnlParentesco.setViewportView(componente);
        //spnlParentesco.getViewport().add(componente);
        spnlParentesco.getViewport().add(componente, -1);
        //spnlParentesco.validate();
    }
    
    /**
     * Agrega un JPanel a otro Jpanel 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param spnlParentesco JScrollPane donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JPanel panel) {
        panel.add(componente);
        //panel.validate();
    }

    public boolean validaEmail(String cadena1, String cadena2) {
        if(cadena1.equals(cadena2))
            return true;
        else
            return false;
    }

    public String creaFolio(String iniciales, long contador) {
        String folio = "";
        String result = "";
        if(contador < 10){
            folio = "00000" + contador;
        }
        if(contador > 9 && contador < 100){
            folio = "0000" + contador;
        }
        if(contador > 99 && contador < 1-000){
            folio = "000" + contador;
        }
        if(contador > 999 && contador < 10-000){
            folio = "00" + contador;
        }
        if(contador > 9-999 && contador < 100-000){
            folio = "0" + contador;
        }
        if(contador > 99-999 && contador < 1-000-000){
            folio = "00" + contador;
        }
        
        result = iniciales + folio;
        return result;
        
    }

    public boolean validaFechaNacimiento(JTextField txtFechaNacimiento, JPanel vista) {
        boolean response = false;
        Pattern patron = null;
        Matcher matcher;
        patron = Pattern.compile("^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        
        if(txtFechaNacimiento.getText().length() > 0){
            matcher = patron.matcher(txtFechaNacimiento.getText());
            if(!matcher.matches()){
                txtFechaNacimiento.setBackground(Color.ORANGE);
                JOptionPane.showMessageDialog(vista, "Fecha de nacimiento incorrecta");
            }
            else
                response = true;
            
        }
        else{
            response = true;
        }
        
        
        return response;
    }
    
    /**
     * Crea la ruta del archivo y lo guarda
     * @param folioBecario Folio que tendrá el becario
     * @param tipoDocumento Tipo de documento que se guardará
     * @param archivo Archivo que se pretende copiar
     * @return Archivo con los datos de 
     */
    public Path CopiaArchivoADestino(String folioBecario, String tipoDocumento, File archivo){
        String sistemaOperativo = System.getProperty("os.name");
        String rutaPrincipal = null;
        String separador = System.getProperty("file.separator");
        String extension = archivo.getName().substring(archivo.getName().length() - 3, archivo.getName().length());
        
        if(sistemaOperativo.toLowerCase().contains("win")){
            rutaPrincipal = Index.RUTA_BASE_WINDOWS;
        }
        if(sistemaOperativo.toLowerCase().contains("lin")){
            rutaPrincipal = Index.RUTA_BASE_LINUX;
        }
        //Se verifica si ya existe el directorio del nuevo becario y si no, lo crea
        verificaDirectorio(Paths.get(rutaPrincipal + folioBecario));
        
        
        Path de = Paths.get(archivo.getAbsolutePath());
        Path a = Paths.get(rutaPrincipal + folioBecario + separador + tipoDocumento + folioBecario + extension);
        try {
            Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            a = null;
            log.crearLog("No se pudo copiar el archivo " + archivo.getName() + "    " + ex.getMessage());
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
        
    }

    private void verificaDirectorio(Path rutaDirectorio) {
        if(!Files.exists(rutaDirectorio)){
            try {
                Files.createDirectory(rutaDirectorio);
            } catch (IOException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void validaRutaInicial() {
        String sistemaOperativo = System.getProperty("os.name");
        String rutaPrincipal = null;
        
        if(sistemaOperativo.toLowerCase().contains("win")){
            rutaPrincipal = Index.RUTA_BASE_WINDOWS;
        }
        if(sistemaOperativo.toLowerCase().contains("lin")){
            rutaPrincipal = Index.RUTA_BASE_LINUX;
        }
        
        if(!Files.exists(Paths.get(rutaPrincipal))){
            try {
                Files.createDirectory(Paths.get(rutaPrincipal));
            } catch (IOException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
