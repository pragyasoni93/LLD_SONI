package abc.demo.adapter.Adapter;

import abc.demo.adapter.Adaptee.XMLProdcuer;
import abc.demo.adapter.Target.DataProcessor;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.XML;


public class XMLToJSONAdapter implements DataProcessor {
    private XMLProdcuer xmlProdcuer;

    public XMLToJSONAdapter(XMLProdcuer xmlProdcuer){
        this.xmlProdcuer = xmlProdcuer;
    }


    @Override
    public String getJsonData() {
        String xmlData = xmlProdcuer.getXMLData();
        JSONObject jsonobj = XML.toJSONObject(xmlData);
        return jsonobj.toString();
    }
}
