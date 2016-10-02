package com.shamanoff;

import com.shamanoff.domain.News;
import com.shamanoff.services.IParser;
import com.shamanoff.services.ParserImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class JaxbParserTest {
    private IParser parser;
    private File file;

    @Before
    public void setUp() throws Exception {
        parser = new ParserImpl();
        file = new File("news.xml");
    }

    @Test
    public void testGetObject() throws Exception {
        News news = (News) parser.getObject(file, News.class);
        System.out.println(news);
    }

 /*   @Test
    public void testSaveObject() throws Exception {
        News news = new News();
        news.setTitle("title4");
        news.setLink("lenta.com");








        parser.saveObject(file,news);
    }*/
}
