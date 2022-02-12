package SerializationDemo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoLibrary;

public class Deserialization {

	@Test

	public void deserializa() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();

		PojoLibrary pObj = mapper.readValue(new File("./jsonData.json"), PojoLibrary.class);

		System.out.println(pObj.getName());
		System.out.println(pObj.email);
		System.out.println(pObj.phoneNo);
		System.out.println(pObj.id);


	}
}
