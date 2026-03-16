package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleVenduJdbcImpl implements ArticleVenduDao {

    private static final String INSERT = "insert into numéro article vendu (Numero) values (?)";
    private static final String SELECT = "select * from numéro article";
    private static final String DELETE = "delete from numéro article where id = ?";
    private static final String SELECT_BY_ID = "select * from genre where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(ArticleVendu.class));
    }

    @Override
    public void createArticleVendu(ArticleVendu articleVendu) {

    }

    @Override
    public void deleteArticleVendu(int noArticle) {

    }

    @Override
    public ArticleVendu getArticleById(int noArticle) {
        return null;
    }
}
