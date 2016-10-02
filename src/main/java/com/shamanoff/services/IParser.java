package com.shamanoff.services;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface IParser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;

}
