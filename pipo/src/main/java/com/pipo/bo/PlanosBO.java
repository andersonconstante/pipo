package com.pipo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipo.custom.planos.FormPlano;
import com.pipo.modelo.Empresa;
import com.pipo.repository.PlanoRepository;
import com.pipo.utils.EmailUtils;
import com.pipo.utils.PlanosEnum;

public class PlanosBO {

//	@Autowired
//	private PlanoRepository planoRepository;
	
//	public void  cadastrarPlanoEuropa(FormPlano plano) {
//	
//		boolean emailValido = EmailUtils.isEmailValido(plano.getEmail());
//		plano.setDescricaoPlano(PlanosEnum.EUROPA.getDescricao());
//		
//		if(!plano.getNome().isEmpty() && !plano.getCpf().isEmpty() && emailValido == true) {
//			planoRepository.save(plano);
//		}else {
////			"Não foi possível cadastrar o colaborador, dados inválidos"
//		}
//			
//	}
	
//	public void  cadastrarPlanoPampulha(FormPlano plano) {
//		
//		plano.setDescricaoPlano(PlanosEnum.PAMPULHA.getDescricao());
//		
//		if(!plano.getNome().isEmpty() && !plano.getCpf().isEmpty() && !plano.getEndereço().isEmpty()) {
//			planoRepository.save(plano);
//		}else {
////			"Não foi possível cadastrar o colaborador, dados inválidos"
//		}
//			
//	}
//	
//	public void  cadastrarPlanoOdontoDental(FormPlano plano) {
//		
//		plano.setDescricaoPlano(PlanosEnum.DENTAL_SORRISO.getDescricao());
//		boolean isAlturaOk = plano.getAltura() > 0 && plano.getAltura() < 2.5 ? true : false;
//		boolean isPesoOk = plano.getPeso() > 0 && plano.getPeso() < 250 ? true : false;
//		
//		if(!plano.getNome().isEmpty() && !plano.getCpf().isEmpty() && isAlturaOk && isPesoOk) {
//			planoRepository.save(plano);
//		}
//		else {
////			"Não foi possível cadastrar o colaborador, dados inválidos"
//		}
//		
//	}
//	
//	public void  cadastrarPlanoSaudeMentalMenteSaCorpoSao(FormPlano plano) {
//		
//		plano.setDescricaoPlano(PlanosEnum.MENTESA_CORPOSAO.getDescricao());
//		boolean isHorasMeditadasOk = plano.getHorasMeditadas() >= 0 && plano.getHorasMeditadas() < 168 ? true : false;		
//		
//		if(!plano.getCpf().isEmpty() && isHorasMeditadasOk) {
//			planoRepository.save(plano);
//		}
//		else {
////			"Não foi possível cadastrar o colaborador, dados inválidos"
//		}
		
//	}
//	
//	public void cadastrarColaboradorNoPlano(FormPlano plano, Empresa cliente) {
//		
//		
//		List<Long> planos = cliente.getPlano();
//
//		for(Long planoColaborador : planos) {
//			planoColaborador.longValue();
//		}
//	}
}
