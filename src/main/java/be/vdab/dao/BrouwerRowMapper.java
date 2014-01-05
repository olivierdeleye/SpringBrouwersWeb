package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

public class BrouwerRowMapper implements RowMapper <Brouwer> {

	@Override
	public Brouwer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		return new Brouwer(resultSet.getLong("brouwerNr"), resultSet.getString("naam"), resultSet.getInt("omzet"),
			new Adres(resultSet.getString("straat"), resultSet.getString("huisNr"),resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
			
	}

}
