package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {


	public String fName, lName, email, password;

	public void jsonReader() throws IOException, ParseException {
		String path = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";
		File srcFile = new File(path);

		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));


		for (Object jsonElement : jArray) {
			JSONObject person = (JSONObject) jsonElement;
			fName = (String) person.get("firstname");
			System.out.println(fName);

			lName = (String) person.get("lastname");
			System.out.println(lName);


			email = (String) person.get("email");
			System.out.println(email);

			password = (String) person.get("password");
			System.out.println(password);
		}
	}

}
