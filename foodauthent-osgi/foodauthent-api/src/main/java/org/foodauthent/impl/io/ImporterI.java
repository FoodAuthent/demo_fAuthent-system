package org.foodauthent.impl.io;

import java.io.File;

import org.foodauthent.model.FaObjectSet;

public interface ImporterI {
    
    FaObjectSet importData(File file);
}
