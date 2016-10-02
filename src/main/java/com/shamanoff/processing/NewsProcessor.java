package com.shamanoff.processing;


import com.shamanoff.domain.News;

import javax.xml.bind.JAXBException;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicLong;

public class NewsProcessor extends JAXBProcessor<News> {

    private static final String TAG_NAME = "item";

    private AtomicLong counter = new AtomicLong(1);

    private PrintStream printStream;

    public NewsProcessor(PrintStream printStream) throws JAXBException {
        super(News.class, TAG_NAME);
        this.printStream = printStream;
    }
    @Override
    public void doWork(News element) {
        StringBuffer buf = new StringBuffer()
                .append(counter.getAndIncrement())
                .append(": ")
                .append(element.toString());
        printStream.println(buf);
    }
}
