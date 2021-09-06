package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@RequiredArgsConstructor
@AllArgsConstructor
public class AppUsers implements UserDetails {

	private User user;
	private List<AuthGroup> authGroups;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authGroups == null) {
			return Collections.emptySet();
		}
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authGroups.forEach(authGroup -> {
			authorities.add(new SimpleGrantedAuthority(authGroup.getAuthGroup()));
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return
				true;
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
