package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	public static void main(String[] args) throws IOException {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("mauricio de sousa");
		pessoa1.setEmail("mauricoSousa@gmail.com");
		pessoa1.setIdade(28);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("lucas Emanuel");
		pessoa2.setEmail("lucasEmanuel@gmail.com");
		pessoa2.setIdade(01);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("isis Emanuelly");
		pessoa3.setEmail("isisEmanuelly@gmail.com");
		pessoa3.setIdade(06);
		
		List<Pessoa>pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\Users\\lucas\\eclipse-workspace\\SousaAquivos\\src\\arquivo\\arquivo.csv");
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa pessoa : pessoas) {
			escrever_no_arquivo.write(pessoa.getNome()+";"+pessoa.getEmail()+";"+pessoa.getIdade()+"\n");
			
			
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
