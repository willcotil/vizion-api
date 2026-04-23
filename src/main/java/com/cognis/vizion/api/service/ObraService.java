package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.core.obra.state.ObraAcao;
import com.cognis.vizion.api.facade.ObraFacade;
import com.cognis.vizion.api.repository.EnderecoRepo;
import com.cognis.vizion.api.repository.ObraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ObraService extends BaseService<Obra, ObraRequest, ObraResponse, Integer> {
    private final ObraRepo repo;
    private final EnderecoRepo enderecoRepo;
    private final ModelMapper mapper;
    private final ObraFacade obraFacade;

    @Override protected JpaRepository<Obra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Obra> getEntityClass() { return Obra.class; }
    @Override protected Class<ObraResponse> getResponseClass() { return ObraResponse.class; }

    @Override
    @Transactional
    public ObraResponse salvar(ObraRequest request) {
        return salvarOuAtualizar(request, null);
    }

    @Override
    @Transactional
    public ObraResponse atualizar(ObraRequest request, Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        return salvarOuAtualizar(request, id);
    }

    @Transactional
    public ObraResponse transicionarStatus(Integer id, ObraStatusTransitionRequest request) {
        Obra obra = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra nao encontrada: " + id));

        ObraAcao acao = ObraAcao.from(request.acao());
        obraFacade.transicionarStatus(obra, acao);

        return mapper.map(repo.save(obra), ObraResponse.class);
    }

    private ObraResponse salvarOuAtualizar(ObraRequest request, Integer id) {
        Obra entity = id == null
                ? new Obra()
                : repo.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));

        entity.setNome_projeto(request.nome_projeto());
        entity.setData_inicio(request.data_inicio());
        entity.setData_previsao_entrega(request.data_previsao_entrega());
        entity.setValor_total_estimado(request.valor_total_estimado());
        entity.setStatus(request.status());
        entity.setTenant_id(request.tenant_id());

        if (request.id_endereco() != null) {
            Endereco endereco = enderecoRepo.findById(request.id_endereco())
                    .orElseThrow(() -> new RuntimeException("Endereco nao encontrado: " + request.id_endereco()));
            entity.setEndereco(endereco);
        }

        return new ObraResponse(repo.save(entity));
    }
}
