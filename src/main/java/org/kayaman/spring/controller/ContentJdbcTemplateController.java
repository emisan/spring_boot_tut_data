package org.kayaman.spring.controller;

import org.kayaman.spring.model.Content;
import org.kayaman.spring.model.Status;
import org.kayaman.spring.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Java JDBC based template in spring for CRUD on a table named 'content'.
 *
 * @author Hayri Emrah Kayaman
 */
@Repository
public class ContentJdbcTemplateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Content mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getTimestamp("created").toLocalDateTime(),
                rs.getTimestamp("updated").toLocalDateTime(),
                rs.getString("url")
        );
    }

    private boolean requiredPropertiesNotNull(final Content content) {
        return content != null && content.title() != null && content.status() != null
                && content.contentType() != null && content.created() != null;
    }

    public List<Content> getAll() {
        final String sql = "select * from Content";
        return jdbcTemplate.query(sql, ContentJdbcTemplateController::mapRow);
    }

    public void insert(final Content content) {
        final String sql =
                "insert into content (title, description, status, content_type, created, updated, url) " +
                        "values (?, ?, ?, ?, ?, ?, ?)";
        if (requiredPropertiesNotNull(content))
        {
            jdbcTemplate.update(sql, content.title(), content.description(),
                    content.status().toString(), content.contentType().toString(), content.created(), content.updated(),
                    content.url());
        }
        else {
            throw new IllegalArgumentException("Insert: Required fields of a content are not set " +
                    "or appear to be null.");
        }
    }

    public void update(final Content content, final Integer contentId) {
        final String sql =
                "update content set title=?, description=?, status=?, content_type=?, created=?, updated=?, url=? " +
                        "where id=?";
        if (contentId != null && requiredPropertiesNotNull(content))
        {
            jdbcTemplate.update(sql, content.title(), content.description(),
                    content.status().toString(), content.contentType().toString(), content.created(), content.updated(),
                    content.url(), contentId);
        }
        else {
            throw new IllegalArgumentException("Update: Required fields of a content are not set " +
                    "or id to update is null.");
        }
    }

    public void delete(final Integer contentId) {

        final String sql =
                "delete from Content where id=?";
        if (contentId != null)
        {
            jdbcTemplate.update(sql, contentId);
        }
        else {
            throw new IllegalArgumentException("Delete: id to delete must not be null.");
        }
    }

    public Content getById(final Integer contentId) {

        Content content = null;
        final String sql =
                "select * from Content where id=" + contentId;
        if (contentId != null)
        {
            content = jdbcTemplate.queryForObject(sql, ContentJdbcTemplateController::mapRow);
        }
        else {
            throw new IllegalArgumentException("GetById: id to select must not be null.");
        }
        return content;
    }

}
