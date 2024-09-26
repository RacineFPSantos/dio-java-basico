package desafiodiopoo.dominio.main;

import java.time.LocalDate;

import desafiodiopoo.dominio.model.Curso;
import desafiodiopoo.dominio.model.Mentoria;

public class DesafioDioPOO {
	public void TestarDominio() {
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("descrição curso Java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso JavaScript");
		curso2.setDescricao("descrição curso JavaScript");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("Curso JavaScript");
		mentoria1.setDescricao("descrição curso JavaScript");
		mentoria1.setData(LocalDate.now());
		
		Mentoria mentoria2 = new Mentoria();
		mentoria2.setTitulo("Curso JavaScript");
		mentoria2.setDescricao("descrição curso JavaScript");
		mentoria2.setData(LocalDate.now());
		
		System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria1);
		System.out.println(mentoria2);
	}
}
