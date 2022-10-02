public class JSONSerialization {
    /**
     * JSON Serialization/Deserialization with Jackson
     *
     * - In Java, the most popular library for doing this is called Jackson. Jackson uses Java annotations to help
     * it get the metadata needed for serialization and deserialization.
     *
     * - To serialize the annotated Java object, you call the ObjectMapper.writeObject() method, passing in the
     * annotated Java object. Jackson will convert the object to a JSON string.
     *
     * - To deserialize the JSON string, pass it into the ObjectMapper.readValue() method. This method also has an
     * argument for the type of Java class that should be created. Jackson will create an instance of that class
     * and fill it in using the information from the JSON string.
     *
     *
     * XML Serialization/Deserialization with JAXB
     *
     * Just like Jackson, JAXB uses Java annotations to tell it how to serialize and deserialize Java objects.
     * The only difference is the format of the output — XML in this case instead of JSON — and the methods used to do the conversions.
     * In JAXB, you use the Marshaller.marshal method to serialize to XML, and you use the Unmarshaller.unmarshal
     * method to deserialize back into a Java class. By the way "marshal" is another way of saying "serialize".
     */
}
