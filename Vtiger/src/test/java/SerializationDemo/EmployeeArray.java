package SerializationDemo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoArrayLib;

public class EmployeeArray {

	@Test

	public void serialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[] arr= {777, 888, 999};
		PojoArrayLib obj= new PojoArrayLib("rahul", 102, "rahul@gmail.com", arr);

		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(new File("./pojoArr.json"), obj);

		//mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./PojoArr.json"), obj);
	}
}
