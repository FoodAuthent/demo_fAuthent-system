package org.foodauthent.impl.file;

import java.io.InputStream;

import org.foodauthent.model.FaObjectSet;

public interface Importer {
    FaObjectSet importData(InputStream stream);
}
