package com.cognis.vizion.api.core.usuario;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Usuario  extends BaseEntity implements UserDetails{

    @Email
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UsuarioStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuarioRole role;

    @Column(length = 50)
    private String tenant_id;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
