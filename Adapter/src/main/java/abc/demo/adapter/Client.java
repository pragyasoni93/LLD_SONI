package abc.demo.adapter;

import abc.demo.adapter.Adaptee.XMLProdcuer;
import abc.demo.adapter.Adapter.XMLToJSONAdapter;
import abc.demo.adapter.Target.DataProcessor;

public class Client {
    public static void main(String[] args) {
        DataProcessor xmlProcessor = new XMLToJSONAdapter(new XMLProdcuer());
        System.out.println(xmlProcessor.getJsonData());
    }
}
