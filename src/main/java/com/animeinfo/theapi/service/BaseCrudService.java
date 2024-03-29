package com.animeinfo.theapi.service;

import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.theapi.exception.BusinessException;
import com.animeinfo.theapi.model.IEntidade;
import com.animeinfo.theapi.util.Reflexao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseCrudService<
        ENTIDADE extends IEntidade<PK_TYPE>,
        PK_TYPE,
        REPOSITORY extends CrudRepository<ENTIDADE, PK_TYPE>
        > implements CrudService<ENTIDADE, PK_TYPE> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected REPOSITORY repository;

    @Override
    public ENTIDADE incluir(ENTIDADE modelo) {
        if(Reflexao.isEntidadeHavePkGenerated(modelo)) {
            modelo.setId(null);
        }
        this.validarCamposObrigatorios(modelo);
        this.validarDados(modelo);
        this.prepararParaIncluir(modelo);
        ENTIDADE entidadeIncluido = this.gravarDados(modelo);
        return entidadeIncluido;
    }

    abstract protected void prepararParaIncluir(ENTIDADE entidade);

    private ENTIDADE gravarDados(ENTIDADE entidade) {
        return repository.save(entidade);
    }

    abstract protected void validarDados(ENTIDADE entidade);

    abstract protected void validarCamposObrigatorios(ENTIDADE entidade);

    @Override
    public ENTIDADE alterar(ENTIDADE entidade, PK_TYPE id) {
        this.validarCamposObrigatorios(entidade);
        this.validarDados(entidade);

        ENTIDADE entidadeBD = recuperarEntidadeOuGeraErro(id);
        entidade.setId(id);

        return this.gravarDados(entidade);
    }

    protected ENTIDADE recuperarEntidadeOuGeraErro(PK_TYPE id) {
        ENTIDADE entidade = repository
                .findById(id)
                .orElseThrow(
                        () -> new BusinessException(SistemaMessageCode.ERRO_REGISTRO_NAO_ENCONTRADO)
                );
        return entidade;
    }

    @Override
    public ENTIDADE excluir(PK_TYPE id) {
        ENTIDADE entidadeExcluir = this.recuperarEntidadeOuGeraErro(id);
        this.repository.delete(entidadeExcluir);
        return entidadeExcluir;
    }

    @Override
    public ENTIDADE obterPeloId(PK_TYPE id) {
        return this.recuperarEntidadeOuGeraErro(id);
    }

    @Override
    public List<ENTIDADE> listarTodos() {
        return (List<ENTIDADE>) repository.findAll();
    }
    public List<ENTIDADE> getDados(int offset, int limit) {
        List<ENTIDADE> dadosPaginados = new ArrayList<>();
        Iterator<ENTIDADE> iterator = repository.findAll().iterator();

        int count = 0;
        while (iterator.hasNext() && count < offset + limit) {
            if (count >= offset) {
                dadosPaginados.add(iterator.next());
            } else {
                iterator.next();
            }
            count++;
        }

        return dadosPaginados;
    }
}
