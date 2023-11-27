package com.animeinfo.animeInfo.model;

import com.animeinfo.theapi.model.IEntidade;
import com.animeinfo.theapi.model.annotation.PkComposite;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@PkComposite
@Table(name = "TBL_USER")
public class Credencial implements IEntidade<Long> {
    @SequenceGenerator(
            name = "user_gerador_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_gerador_sequence"
    )
    @Id
    @Column(name = "UserID")
    private Long id;
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "Roles")
    private List<String> roles;

    @Column(name = "accessToken")
    private String accessToken;

    @Column(name = "expiresIn")
    private Long expiresIn;

    @Column(name = "regreshToken")
    private String refreshToken;

    @Column(name = "refreshExpiresIn")
    private Long refreshExpiresIn;

    @Column(name = "statusAtivo")
    private boolean statusAtivo;

    @Column(name = "senha")
    private String senha;

    @Override
    public String getTabelaNome() {
        return "Credential";
    }

    @Override
    public String getIdHash() {
        return null;
    }

    @Override
    public Long getIdFromHash(String hash) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Credencial credencial = (Credencial) o;
        return id != null && Objects.equals(id, credencial.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
