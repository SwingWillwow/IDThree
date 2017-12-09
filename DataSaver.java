
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class DataSaver {
    public static void saveData(List<Employee> employeeList){
        /*

         */
        try{
            File file = new File("employeeSaveData.xml");
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("employeeList");
            for (Employee e : employeeList) {
                Element employee = document.createElement("employee");
                Element id = document.createElement("id");
                id.setTextContent(Integer.toString(e.getId()));
                Element educationLevel = document.createElement("educationLevel");
                educationLevel.setTextContent(Character.toString(e.getEducationLevel()));
                Element sex = document.createElement("sex");
                sex.setTextContent(Character.toString(e.getSex()));
                Element englishLevel = document.createElement("englishLevel");
                englishLevel.setTextContent(Integer.toString(e.getEnglishLevel()));
                Element characterType = document.createElement("characterType");
                characterType.setTextContent(Integer.toString(e.getCharacterType()));
                Element postType = document.createElement("postType");
                postType.setTextContent(Integer.toString(e.getPostType()));
                Element classType = document.createElement("classType");
                classType.setTextContent(Character.toString(e.getClassType()));
                employee.appendChild(id);
                employee.appendChild(educationLevel);
                employee.appendChild(sex);
                employee.appendChild(englishLevel);
                employee.appendChild(characterType);
                employee.appendChild(postType);
                employee.appendChild(classType);
                root.appendChild(employee);
            }
            document.appendChild(root);
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document),new StreamResult(file));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
