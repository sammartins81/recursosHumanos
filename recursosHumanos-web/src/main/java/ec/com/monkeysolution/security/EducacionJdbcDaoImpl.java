package ec.com.monkeysolution.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContextException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class EducacionJdbcDaoImpl extends JdbcDaoImpl {
	
	@SuppressWarnings("rawtypes")
	private MappingSqlQuery usersByUsernameMapping;

	@Override
	protected void initDao() throws ApplicationContextException {
		super.initDao();
		this.usersByUsernameMapping = new CustomUsersByUsernameMapping(
				getDataSource());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		return usersByUsernameMapping.execute(username);
	}

	@Override
	protected UserDetails createUserDetails(String username,
			UserDetails userFromUserQuery,
			List<GrantedAuthority> combinedAuthorities) {

		UserDetails u = super.createUserDetails(username, userFromUserQuery,
				combinedAuthorities);
		EducacionUserSecurity user = new EducacionUserSecurity(u.getUsername(),
				u.getPassword(), u.isEnabled(), u.isAccountNonExpired(),
				u.isCredentialsNonExpired(), u.isAccountNonLocked(),
				u.getAuthorities());
		EducacionUserSecurity customUserFromUserQuery = (EducacionUserSecurity) userFromUserQuery;
		user.setNombreCompleto(customUserFromUserQuery.getNombreCompleto());
		return user;
	}

	@SuppressWarnings("rawtypes")
	private class CustomUsersByUsernameMapping extends MappingSqlQuery {
		protected CustomUsersByUsernameMapping(DataSource dataSource) {
			super(dataSource, getUsersByUsernameQuery());
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			String username = rs.getString(1);
			String password = rs.getString(2);
			String nombreUsuario = rs.getString(3);
			EducacionUserSecurity user = new EducacionUserSecurity(username,
					password, true, true, true, true,
					AuthorityUtils.NO_AUTHORITIES);
			user.setNombreCompleto(nombreUsuario);
			return user;
		}
	}
}
