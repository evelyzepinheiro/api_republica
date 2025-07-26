package com.cefetmg.evelyze.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.SituacaoConta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByDataVencimentoBetween(LocalDate inicio, LocalDate fim);
    List<Conta> findBySituacao(SituacaoConta situacao);
    @Query("SELECT c FROM Conta c LEFT JOIN FETCH c.rateios WHERE c.id = :id")
    Optional<Conta> findByIdWithRateios(@Param("id") Long id);
    @Query("SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.rateios")
    List<Conta> findAllWithRateios();
}