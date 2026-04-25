package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosResponse;
import com.cognis.vizion.api.mapper.ObrasDocumentosMapper;
import com.cognis.vizion.api.repository.ObraRepo;
import com.cognis.vizion.api.repository.ObrasDocumentosRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObrasDocumentosService extends BaseService<ObrasDocumentos, ObrasDocumentosRequest, ObrasDocumentosResponse, Integer> {

    private final ObrasDocumentosRepo repo;
    private final ObraRepo obraRepo;
    private final ObrasDocumentosMapper mapper;

    @Override
    protected JpaRepository<ObrasDocumentos, Integer> getRepo() {
        return repo;
    }

    @Override
    protected ObrasDocumentosMapper getMapper() {
        return mapper;
    }

    @Override
    protected Class<ObrasDocumentos> getEntityClass() {
        return ObrasDocumentos.class;
    }

    @Override
    protected Class<ObrasDocumentosResponse> getResponseClass() {
        return ObrasDocumentosResponse.class;
    }

    @Override
    public ObrasDocumentosResponse salvar(ObrasDocumentosRequest request) {
        return salvarOuAtualizar(request, null);
    }

    @Override
    public ObrasDocumentosResponse atualizar(ObrasDocumentosRequest request, Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        return salvarOuAtualizar(request, id);
    }

    private ObrasDocumentosResponse salvarOuAtualizar(ObrasDocumentosRequest request, Integer id) {
        ObrasDocumentos entity = id == null ? new ObrasDocumentos() : repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));

        entity.setNome_arquivo(request.nome_arquivo());
        entity.setUrl_arquivo(request.url_arquivo());
        entity.setDescricao_arquivo(request.descricao_arquivo());
        entity.setTipo_documento(request.tipo_documento());

        Integer idObra = request.id_obra() != null
                ? request.id_obra()
                : (entity.getObra() != null ? entity.getObra().getId() : null);

        if (idObra == null) {
            throw new RuntimeException("id_obra é obrigatório");
        }

        Obra obra = obraRepo.findById(idObra)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada: " + idObra));
        entity.setObra(obra);
        entity.setTenant_id(obra.getTenant_id());

        return mapper.toResponse(repo.save(entity));
    }
}
