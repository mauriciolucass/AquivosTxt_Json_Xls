package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\lucas\\eclipse-workspace\\SousaAquivos\\src\\arquivo\\aquivo_excel.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
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
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();//usado para criar a planilha
		
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("planilha de pessoas jdev Treinamentos");
		int numeroLinha = 0;
		
		 for(Pessoa p : pessoas) {
			 Row linha = linhaPessoa.createRow(numeroLinha++);// criando a linha na planilha
			 int celula = 0;
			 Cell celNome = linha.createCell(celula++);/*celula 1*/
			 celNome.setCellValue(p.getNome());
			 
			 Cell celEmail = linha.createCell(celula++);/*celual 2*/
			 celEmail.setCellValue(p.getEmail());
			 
			 Cell celIdade = linha.createCell(celula++);/*celula 3*/
			 celIdade.setCellValue(p.getIdade());
		
			 
		 }// terminou de monta a planilha 
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);// escreve a planilha em arquivo
		saida.flush();
		saida.close();
		
		
		System.out.println("a plahnilha foi criada !");
	}

}
