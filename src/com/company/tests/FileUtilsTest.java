package com.company.tests;

import com.company.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileUtilsTest {

    FileUtils file = null;
    URL fixtureFileUtils1URL = this.getClass().getResource("./fixtureFileUtils1");


    @Before
    public void setUp() throws Exception {
       this.file = new FileUtils();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readAllLines1() throws URISyntaxException, FileNotFoundException {
        String[] allLines = FileUtils.readAllLines(Paths.get(fixtureFileUtils1URL.toURI()).toString());
        String[] effected1 = {"First line", "Second line", "Third line"};
        assertArrayEquals(effected1, allLines);
    }
}