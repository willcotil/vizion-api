package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraArquivos.ObraArquivos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraArquivosRepo extends JpaRepository<ObraArquivos, Integer>{
}
