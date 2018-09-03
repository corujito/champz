package com.corujito.champz.rest.service;

import java.io.InputStream;

public interface ICSVImporterService {

    public void importCsv(String filename) throws Exception;

    public void importCsv(InputStream inputStream) throws Exception;
}
