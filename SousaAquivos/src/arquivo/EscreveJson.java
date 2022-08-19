package arquivo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJson {
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Antonio Mauricio");
		usuario1.setCpf("068.384.113-00");
		usuario1.setLogin("sousa");
		usuario1.setSenha("123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Lucas Emanuel");
		usuario2.setCpf("087.387.123-00");
		usuario2.setLogin("sousa1");
		usuario2.setSenha("123");
		
		List<Usuario>usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser =  gson.toJson(usuarios);
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\lucas\\eclipse-workspace\\SousaAquivos\\src\\arquivo\\filejson.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		
		//---------------------lendo Geson--------------------------
		FileReader fileReader = new FileReader("C:\\Users\\lucas\\eclipse-workspace\\SousaAquivos\\src\\arquivo\\filejson.json");
		JsonArray jsonArray =  (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listusuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listusuarios.add(usuario);
			
		}
		System.out.println("leitura do aquivo json"+ listusuarios);
		
		
		
	}

}
