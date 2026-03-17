package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleVenduJdbcImpl implements ArticleVenduDao {

    private static final String INSERT = "insert into numero article vendu (Numero) values (?)";
    private static final String SELECT = "select * from numero article";
    private static final String DELETE = "delete from numero article where numero = ?";
    private static final String SELECT_BY_NUMERO = "select * from genre where numero = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(ArticleVendu.class));
    }

    @Override
    public void createArticleVendu(ArticleVendu articleVendu) {
        jdbcTemplate.update(INSERT, articleVendu);
    }

    @Override
    public void deleteArticleVendu(int noArticle) {
        jdbcTemplate.update(DELETE, noArticle);
    }

    @Override
    public ArticleVendu getArticleByNumero(int noArticle) {
        return jdbcTemplate.queryForObject(SELECT_BY_NUMERO, new BeanPropertyRowMapper<>(ArticleVendu.class), noArticle);
    }
}