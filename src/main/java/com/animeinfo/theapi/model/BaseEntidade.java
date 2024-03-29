package com.animeinfo.theapi.model;

import com.animeinfo.theapi.util.Reflexao;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseEntidade<PK_TYPE> implements IEntidade<PK_TYPE>{
    protected PK_TYPE compositePkEntidadeObject;
    private Class<PK_TYPE> persistentClass;

    public BaseEntidade() {
    }

    private Class<PK_TYPE> getActualTypeArgument() {
        if(Objects.isNull(this.persistentClass)){
            this.persistentClass = (Class<PK_TYPE>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            this.compositePkEntidadeObject = (PK_TYPE) Reflexao.getNewObjectFromType(this.persistentClass);
        }
        return this.persistentClass;
    }


    @Override
    public String getTabelaNome() {
        return Reflexao.getJPATableName(this);
    }

    @Override
    public PK_TYPE getId() {
        return (PK_TYPE) Reflexao.getJPATablePkObject(getActualTypeArgument(),this);
    }

    public String getIdHash(){
        return Reflexao.getJPATablePkHash(getActualTypeArgument(), this);
    }

    public PK_TYPE getIdFromHash(String hash){
        return Reflexao.getJPATablePkObjectFromHash(getActualTypeArgument(), this.compositePkEntidadeObject, hash);
    }

    @Override
    public void setId(PK_TYPE id) {
        Reflexao.setJPATablePkObject(getActualTypeArgument(), this,id);
    }

    public PK_TYPE getCompositePkEntidadeObject() {
        return compositePkEntidadeObject;
    }

    public void setCompositePkEntidadeObject(PK_TYPE compositePkEntidadeObject) {
        this.compositePkEntidadeObject = compositePkEntidadeObject;
    }
}