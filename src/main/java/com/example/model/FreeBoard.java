package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by jins on 2017-04-25.
 */
@Document(indexName = "member", type = "freeboard")
public class FreeBoard {
    @Id
    private String id;
    @Field(type = FieldType.String)
    private String boardId;
    @Field(type = FieldType.String)
    private String uname;
    @Field(type = FieldType.String)
    private String category;
    @Field(type = FieldType.String)
    private String content;
    @Field(type = FieldType.String)
    private String viewCount;
    @Field(type = FieldType.Date)
    private Date wdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }
}
