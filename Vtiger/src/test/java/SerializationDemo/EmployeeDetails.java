package SerializationDemo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoLibrary;

public class EmployeeDetails {

	@Test
	public void serializatio() throws JsonGenerationException, JsonMappingException, IOException
	{
		//create an object of PojoLibrary and pass the value
		PojoLibrary pObj = new PojoLibrary("rahul", 121, 878986, "123iamrrajat@gmail.com");

		ObjectMapper mapper = new ObjectMapper();

		//print json value on consol
		//System.out.println(mapper.writeValueAsString(pObj));

		//generate json file
		mapper.writeValue(new File("./jsonData.json"), pObj);

		//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pObj));

	}
}
