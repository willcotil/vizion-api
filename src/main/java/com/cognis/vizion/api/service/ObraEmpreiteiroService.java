package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.mapper.ObraEmpreiteiroMapper;
import com.cognis.vizion.api.repository.EmpreiteiroRepo;
import com.cognis.vizion.api.repository.ObraEmpreiteiroRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ObraEmpreiteiroService extends BaseService<ObraEmpreiteiro, ObraEmpreiteiroRequest, ObraEmpreiteiroResponse, Integer> {

    private final ObraEmpreiteiroRepo repo;
    private final ObraEmpreiteiroMapper mapper;
    private final EmpreiteiroService empreiteiroService;

    @Override protected JpaRepository<ObraEmpreiteiro, Integer> getRepo() { return repo; }
    @Override protected ObraEmpreiteiroMapper getMapper() { return mapper; }
    @Override protected Class<ObraEmpreiteiro> getEntityClass() { return ObraEmpreiteiro.class; }
    @Override protected Class<ObraEmpreiteiroResponse> getResponseClass() { return ObraEmpreiteiroResponse.class; }

    public void popularEmpreiteiro(Obra entity, Usuario user){
        ObraEmpreiteiroRequest request = new ObraEmpreiteiroRequest(
            entity.getId(),
            empreiteiroService.getIdEmpreiteiro(user),
            entity.getTenant_id(),
            "",
            converteParaLocalDate(entity.getData_inicio()),
            converteParaLocalDate(entity.getData_previsao_entrega()),
            entity.getValor_total_estimado(),
            "ATIVO"
        );
        this.salvar(request);
    }

    private LocalDate converteParaLocalDate(Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
