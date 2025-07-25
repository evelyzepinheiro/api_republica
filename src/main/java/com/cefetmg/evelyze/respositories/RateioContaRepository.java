package com.cefetmg.evelyze.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefetmg.evelyze.entities.RateioConta;
import com.cefetmg.evelyze.entities.SituacaoRateio;

public interface RateioContaRepository extends JpaRepository<RateioConta, Long> {

	List<RateioConta> findByMoradorIdAndSituacao(Long moradorId, SituacaoRateio emAberto);
}
