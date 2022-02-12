package SerializationDemo;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoEmpLib;
import Pojo.PojoSpouseLib;

public class EmployeeSpouseDetails {

	@Test

	public void serialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		PojoSpouseLib sLib= new PojoSpouseLib("abc", 95654, 121);

		PojoEmpLib eLib= new PojoEmpLib("rahul", 102, 88978, sLib);

		ObjectMapper mapper = new ObjectMapper();

		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./EmpSpouseDetails.json"), eLib);
	}
}
