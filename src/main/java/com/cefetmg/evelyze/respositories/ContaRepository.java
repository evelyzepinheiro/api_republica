package com.cefetmg.evelyze.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.SituacaoConta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByDataVencimentoBetween(LocalDate inicio, LocalDate fim);
    List<Conta> findBySituacao(SituacaoConta situacao);
}