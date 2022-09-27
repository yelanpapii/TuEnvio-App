package com.misiontic.tucita.Common;

import com.misiontic.tucita.Models.Usuario;
import java.util.Collection;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Recoge la informacion del usuario logeado
 * (No se implementara por falta de tiempo)
 * @author Yelan
 */
@Data
public class AppUser implements UserDetails {
    Usuario user;

    public AppUser(Usuario user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return AuthorityUtils.createAuthorityList(this.user.getRoles().toString());
    }

    @Override
    public String getPassword() {
        return this.user.getContraseña();
    }

    @Override
    public String getUsername() {
       return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
