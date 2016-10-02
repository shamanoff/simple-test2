package com.shamanoff.processing;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TagEngine {

    private Map<String, TagProcessor> processorMap = new HashMap<>();



    public TagEngine add(TagProcessor processor) {
        for(String tag : processor.getTagPath().split("/")){
            processorMap.put(tag,processor);
        }
        return this;
    }

    public void process(String fileName) throws FileNotFoundException,
            TransformerException, XMLStreamException {
        process(new FileInputStream(fileName));
    }

    public void process(InputStream inputStream) throws FileNotFoundException,
            XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader streamReader = factory.createXMLStreamReader(inputStream);
        Stack<String> tagStack = new Stack<>();

        streamReader.nextTag();
        while (streamReader.hasNext()) {
            int eventType = streamReader.next();
            if(eventType == XMLStreamConstants.START_ELEMENT) {
                tagStack.push(streamReader.getLocalName());

                if(processorMap.containsKey(tagStack.peek())) {
                    TagProcessor t = processorMap.get(tagStack.peek());
                    t.process(streamReader);
                    if(!tagStack.empty())tagStack.pop();
                }


            } else if(eventType == XMLStreamConstants.END_ELEMENT) {
                if(!tagStack.empty()) tagStack.pop();
            }
        }
    }

}
