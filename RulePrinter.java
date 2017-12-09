import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class RulePrinter {
    public void print(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("decisionTree.xml"));
            NodeList list = document.getChildNodes().item(0).getChildNodes();
            printXMLTree(list,"if ");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void printXMLTree(NodeList root,String rule){
        for(int i=0;i<root.getLength();i++){
            String tagName;
            String value;
            String content;
            if(root.item(i) instanceof Element){
                tagName = root.item(i).getNodeName();
                value = ((Element) root.item(i)).getAttribute("value");
                content = root.item(i).getTextContent();
                if(content.equals("N")||content.equals("Y")){
                    String newRule = rule + " and " + tagName + " = " + value+" then "+root.item(i).getTextContent();
                    System.out.println(newRule);
                }
                else {
                    printXMLTree(root.item(i).getChildNodes(), rule + " and " + tagName + " = " + value);
                }
            }
        }
    }
}
