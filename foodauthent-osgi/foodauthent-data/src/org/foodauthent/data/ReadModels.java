package org.foodauthent.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.Sample;
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class ReadModels {

    private ReadModels() {
	// utility class
    }

    public static List<FileMetadata> readBfrOilFileMetadata() {
	File json = new File("files/filemetadata/bfr/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<FileMetadata>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<FileMetadata> readEFOilFileMetadata() {
	File json = new File("files/filemetadata/ef/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<FileMetadata>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

   public static List<Product> readOilProducts() {
	File json = new File("files/products/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<Product>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<Sample> readBfrOilSamples() {
	File json = new File("files/samples/bfr/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<Sample>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<Sample> readEFOilSamples() {
	File json = new File("files/samples/ef/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<Sample>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<Fingerprint> readBfrOilFingerprints() {
	File json = new File("files/fingerprints/bfr/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<Fingerprint>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<Fingerprint> readEFOilFingerprints() {
	File json = new File("files/fingerprints/ef/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<Fingerprint>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<FingerprintSet> readBfrOilFingerprintSets() {
	File json = new File("files/fingerprintsets/bfr/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<FingerprintSet>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

    public static List<FingerprintSet> readEFOilFingerprintSets() {
	File json = new File("files/fingerprintsets/ef/oils.json");
	try {
	    return ObjectMapperUtil.getObjectMapper().readValue(json, new TypeReference<List<FingerprintSet>>() {
	    });
	} catch (IOException e) {
	    // TODO
	    throw new RuntimeException(e);
	}
    }

}
