/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.commons;

import info.chili.spring.SpringContext;
import java.io.File;
import org.apache.tika.Tika;

/**
 *
 * @author ayalamanchili
 */
//TODO rename it to be more apprioriate
public class FileUtils {

    public enum DOC_EXTENSIONS {

        PDF, DOC, DOCX, TXT, RTF, XLS, XLSX
    };

    public enum IMG_EXTENSIONS {

        JPG, JPEG, GIF, PNG
    };

    public static String getFileContentType(File file) {
        try {
            //TODO use java 7 Files.probeContentType(path).
            Tika tika = (Tika) SpringContext.getBean("tika");
            return tika.detect(file);
        } catch (Exception ex) {
            //making fail safe for java version <7 and unsupporeted patforms
            ex.printStackTrace();
            return null;
        }
    }

    public static String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1, filename.length());
    }

    public static boolean isImage(String filename) {
        for (IMG_EXTENSIONS ext : IMG_EXTENSIONS.values()) {
            if (ext.name().equalsIgnoreCase(getFileExtension(filename))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDocument(String filename) {
        for (DOC_EXTENSIONS ext : DOC_EXTENSIONS.values()) {
            if (ext.name().equalsIgnoreCase(getFileExtension(filename))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPDF(String filename) {
        if (getFileExtension(filename).equalsIgnoreCase(DOC_EXTENSIONS.PDF.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWordDoc(String filename) {
        if (getFileExtension(filename).equalsIgnoreCase(DOC_EXTENSIONS.DOC.name()) || getFileExtension(filename).equalsIgnoreCase(DOC_EXTENSIONS.DOCX.name())) {
            return true;
        } else {
            return false;
        }
    }
}
