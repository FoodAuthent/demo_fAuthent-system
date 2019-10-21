package org.foodauthent.data;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class ListFiles {
    
    private ListFiles() {
	//utility class
    }

    public static List<File> listBfrOilFingerprintFiles() {
	File f = new File("files/blobs/bfr/oils");
	return Arrays.asList(f.listFiles());
    }
    
    public static List<File> listEFOilFingerprintFiles() {
	File f = new File("files/blobs/ef/oils");
	return Arrays.asList(f.listFiles());
    }
}
