public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }public class XmlUtils {
    private XmlUtils() {

    }

    public static Map<String, Object> xmlToMap(String str) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new StringReader(str));
            return xmlToMap(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> xmlToMap(Document doc){
        Map<String, Object> map = new HashMap<String, Object>();
        if(doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if(CollectionUtils.isNotEmpty(list)){
                map.put(e.getName(), xmlToMap(e));
            }else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xmlToMap(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(CollectionUtils.isNotEmpty(list)){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = xmlToMap(iter);
                    getMapData(map, m, mapList, iter, "1");
                }
                else{
                    getMapData(map, null, mapList, iter, "2");
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>J_1I_F4IF_SHLP_EXIT_LICNUMBER</title>
<style type="text/css">
.code{ font-family:"Courier New", Courier, monospace; color:#000; font-size:14px; background-color:#F2F4F7 }
  .codeComment {font-family:"Courier New", Courier, monospace; color:#0000F0; font-size:14px; background-color:#F2F4F7 }
  .normalBold{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px; font-weight:800 }
  .normalBoldLarge{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:16px; font-weight:800 }
</style>
<style type="text/css">
  .normal{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px }
  .footer{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px; text-align: center }
  h2{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:16px; font-weight:800 }
  h3{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:14px; font-weight:800 }
  .outerTable{
   background-color:#E0E7ED;
   width:100%;
   border-top-width: thin;
   border-right-width: thin;
   border-right-width: thin;
   border-left-width: thin;
   border-top-style: solid;
   border-right-style: solid;
   border-bottom-style: solid;
   border-left-style: solid;
  }
  .innerTable{
   background-color:#F2F4F7;
   width:100%;
   border-top-width: thin;
   border-right-width: thin;
   border-bottom-width: thin;
   border-left-width: thin;
   border-top-style: solid;
   border-right-style: solid;
   border-bottom-style: solid;
   border-left-style: solid;
  }
</style>
</head>
<body>
<table class="outerTable">
  <tr class="normalBoldLarge">
     <td><h2>Code listing for function J_1I_F4IF_SHLP_EXIT_LICNUMBER</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION J_1I_F4IF_SHLP_EXIT_LICNUMBER.<br />
<br />
ENDFUNCTION.<br />
            </div>
          </td>
        </tr>
      </table>
      </td>
      </tr>
   <tr>
<td class="footer">Extracted by Mass Download version 1.4.1 - E.G.Mellodew. 1998-2022. Sap Release 731</td>
   </tr>
</table>
</body>
</html>
