package com.kyungmin.exampleSpringSecurity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kyungmin.exampleSpringSecurity.model.Offer;

@Repository("offerDao")
public class OfferDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sql = "select count(*) from offer";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	//Read(name과 일치하는 offer 조회)
	public Offer getOffer(String name) {
		String sql = "select * from offer where name=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {name}, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("offer_id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
		});
	}
	
	//Read(전체 offer 조회)
	public List<Offer> getAllOffer() {
		String sql = "select * from offer";
		return jdbcTemplate.query(sql, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("offer_id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
		});
	}
	
	//Create(새로운 offer 생성)
	public boolean insert(Offer offer) {
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sql = "insert into offer (name, email, text) values (?, ?, ?)";
		return (jdbcTemplate.update(sql, new Object[] {name, email, text}) == 1);
	}
	
	//Update(offer 업데이트)
	public boolean update(Offer offer) {
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sql = "update offer set name=?, email=?, text=? where offer_id=?";
		return (jdbcTemplate.update(sql, new Object[] {name, email, text, id}) == 1);
	}
	
	//Delete(offer 삭제)
	public boolean delete(int id) {
		String sql = "delete from offer where offer_id=?";
		return (jdbcTemplate.update(sql, new Object[] {id}) == 1);
	}
}
