package com.example.transporte.models.services;

import com.example.transporte.models.dao.IUsuarioDao;
import com.example.transporte.models.dao.Rol;
import com.example.transporte.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**@Service("jpaUserDetailsService")*/
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		
        Usuario usuario = usuarioDao.findByNombre(nombreUsuario);
        
        if(usuario == null) {
        	logger.error("Error en el Login: no existe el usuario '" + nombreUsuario + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + nombreUsuario + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        logger.info("Role: ".concat(usuario.getRol().getNombre()));
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        
        if(authorities.isEmpty()) {
        	logger.error("Error en el Login: Usuario '" + nombreUsuario + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + nombreUsuario + "' no tiene roles asignados!");
        }
        
		return new User(usuario.getNombre(), usuario.getClave(), usuario.isHabilitado(), true, true, true, authorities);
	}

}
