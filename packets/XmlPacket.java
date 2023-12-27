package packets;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlPacket implements BasePacket
{
    // Create a DocumentBuilderFactory
    DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder _builder;
    Document _document;

    public XmlPacket()
    {
        try
        {
            _builder = _factory.newDocumentBuilder();
            _document = _builder.newDocument();

            Element rootElement = _document.createElement("data");
            _document.appendChild(rootElement);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public String GetData()
    {
        try
        {
            // Use a transformer to convert the document to a string
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(_document);
            java.io.StringWriter writer = new java.io.StringWriter();
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
            transformer.transform(source, result);

            // Return the string representation of the document
            return writer.toString();
        }
        catch (javax.xml.transform.TransformerException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void SetData(byte[] data) 
    {
        String xmlString = new String(data, java.nio.charset.StandardCharsets.UTF_8);
        try
        {
            InputSource is = new InputSource(new StringReader(xmlString));
            _document = _builder.parse(is);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void SetUChar(byte value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.appendChild(_document.createTextNode(String.valueOf(value)));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetInt32(int value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.appendChild(_document.createTextNode(String.valueOf(value)));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetInt16(short value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.appendChild(_document.createTextNode(String.valueOf(value)));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetFloat3(float x, float y, float z, String key)
    {
        // Check if the document is null or key is empty
        if (_document == null || key == null || key.isEmpty())
        {
            throw new IllegalArgumentException("Invalid arguments");
        }

        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.setAttribute("x", String.valueOf(x));
        element.setAttribute("y", String.valueOf(y));
        element.setAttribute("z", String.valueOf(z));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetBoolean(boolean value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.appendChild(_document.createTextNode(String.valueOf(value)));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetIVec2(int x, int y, String key)
    {
        // Check if the document is null or key is empty
        if (_document == null || key == null || key.isEmpty())
        {
            throw new IllegalArgumentException("Invalid arguments");
        }

        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.setAttribute("x", String.valueOf(x));
        element.setAttribute("y", String.valueOf(y));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetIVec3(int x, int y, int z, String key)
    {
        // Check if the document is null or key is empty
        if (_document == null || key == null || key.isEmpty())
        {
            throw new IllegalArgumentException("Invalid arguments");
        }

        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.setAttribute("x", String.valueOf(x));
        element.setAttribute("y", String.valueOf(y));
        element.setAttribute("z", String.valueOf(z));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetString(String value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);
        element.appendChild(_document.createTextNode(value));
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public void SetChunk(short[][][] value, String key)
    {
        // Create or update the element with the specified key
        Element element = _document.createElement(key);

        // Create sub-elements for each dimension of the 3D array
        for (int i = 0; i < value.length; i++)
        {
            Element dim1Element = _document.createElement("dim1");
            for (int j = 0; j < value[i].length; j++)
            {
                Element dim2Element = _document.createElement("dim2");
                for (int k = 0; k < value[i][j].length; k++)
                {
                    Element dim3Element = _document.createElement("dim3");
                    dim3Element.appendChild(_document.createTextNode(String.valueOf(value[i][j][k])));
                    dim2Element.appendChild(dim3Element);
                }
                dim1Element.appendChild(dim2Element);
            }
            element.appendChild(dim1Element);
        }
        _document.getDocumentElement().appendChild(element);
    }

    @Override
    public byte GetUChar(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0) {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Get the text content and parse it as a byte
            String valueStr = element.getTextContent();
            try
            {
                return Byte.parseByte(valueStr);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return (byte)0;
            }
        }
        else
        {
            System.out.println("Key not found in document");
            return (byte)0;
        }
    }

    @Override
    public int GetInt32(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0) {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Get the text content and parse it as a byte
            String valueStr = element.getTextContent();
            try
            {
                return Integer.parseInt(valueStr);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return (int)0;
            }
        }
        else
        {
            System.out.println("Key not found in document");
            return (int)0;
        }
    }

    @Override
    public short GetInt16(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0) {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Get the text content and parse it as a byte
            String valueStr = element.getTextContent();
            try
            {
                return Short.parseShort(valueStr);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return (short)0;
            }
        }
        else
        {
            System.out.println("Key not found in document");
            return (short)0;
        }
    }

    @Override
    public float[] GetFloat3(String key)
    {
        float[] data = new float[3];

        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Extract values from attributes
            data[0] = Float.parseFloat(element.getAttribute("x"));
            data[1] = Float.parseFloat(element.getAttribute("y"));
            data[2] = Float.parseFloat(element.getAttribute("z"));
        }
        else
        {
            System.out.println("Key not found in document");
        }
        return data;
    }

    @Override
    public boolean GetBoolean(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Get the text content and parse it as a byte
            String valueStr = element.getTextContent();
            try
            {
                return Boolean.parseBoolean(valueStr);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        else
        {
            System.out.println("Key not found in document");
            return false;
        }
    }

    @Override
    public int[] GetIVec2(String key)
    {
        int[] data = new int[2];

        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Extract values from attributes
            data[0] = Integer.parseInt(element.getAttribute("x"));
            data[1] = Integer.parseInt(element.getAttribute("y"));
        }
        else
        {
            System.out.println("Key not found in document");
        }
        return data;
    }

    @Override
    public int[] GetIVec3(String key)
    {
        int[] data = new int[3];

        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Extract values from attributes
            data[0] = Integer.parseInt(element.getAttribute("x"));
            data[1] = Integer.parseInt(element.getAttribute("y"));
            data[2] = Integer.parseInt(element.getAttribute("z"));
        }
        else
        {
            System.out.println("Key not found in document");
        }
        return data;
    }

    @Override
    public String GetString(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Get the text content and parse it as a byte
            String valueStr = element.getTextContent();
            try
            {
                return valueStr;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return "";
            }
        }
        else
        {
            System.out.println("Key not found in document");
            return "";
        }
    }

    @Override
    public short[][][] GetChunk(String key)
    {
        // Get a NodeList of elements with the specified key
        NodeList nodeList = _document.getElementsByTagName(key);

        // Check if the key exists in the document
        if (nodeList.getLength() > 0)
        {
            // Get the first element with the specified key
            Element element = (Element) nodeList.item(0);

            // Extract values from sub-elements
            NodeList dim1Nodes = element.getElementsByTagName("dim1");
            int dim1Length = dim1Nodes.getLength();
            short[][][] result = new short[dim1Length][][];

            for (int i = 0; i < dim1Length; i++)
            {
                Element dim1Element = (Element) dim1Nodes.item(i);

                NodeList dim2Nodes = dim1Element.getElementsByTagName("dim2");
                int dim2Length = dim2Nodes.getLength();
                result[i] = new short[dim2Length][];

                for (int j = 0; j < dim2Length; j++)
                {
                    Element dim2Element = (Element) dim2Nodes.item(j);

                    NodeList dim3Nodes = dim2Element.getElementsByTagName("dim3");
                    int dim3Length = dim3Nodes.getLength();
                    result[i][j] = new short[dim3Length];

                    for (int k = 0; k < dim3Length; k++)
                    {
                        Element dim3Element = (Element) dim3Nodes.item(k);
                        result[i][j][k] = Short.parseShort(dim3Element.getTextContent());
                    }
                }
            }

            return result;
        }
        else
        {
            System.out.println("Key not found in document");
            return null;
        }
    }
}
