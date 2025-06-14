package com.mythovac.backend.mapper;

import com.mythovac.backend.entity.ScoresComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoresCommentMapper {
    @Select("SELECT * FROM scores_comment")
    List<ScoresComment> getScoresComment();

    @Select("SELECT * FROM scores_comment WHERE sid = #{sid}")
    List<ScoresComment> getScoresCommentBySid(Long sid);

    @Select("SELECT * FROM scores_comment WHERE uid = #{uid}")
    List<ScoresComment> getScoresCommentByUid(Long uid);

    @Select("SELECT * FROM scores_comment WHERE sid = #{sid} AND uid = #{uid}")
    ScoresComment getScoresCommentBySidAndUid(Long sid, Long uid);

    @Insert("INSERT INTO scores_comment (sid, uid, score, comment, time)" +
            " VALUES (#{sid}, #{uid}, ${score}, #{comment}, ${time})")
    void insertScoresComment(ScoresComment scoresComment);

    @Update("UPDATE scores_comment " +
            "SET score = #{score}, comment = #{comment}, time = #{time} " +
            "WHERE sid = #{sid} AND uid = #{uid}")
    void updateScoresComment(ScoresComment scoresComment);

    @Delete("DELETE FROM scores_comment WHERE sid = #{sid}")
    void deleteScoresCommentBySid(Long sid);

    @Delete("DELETE FROM scores_comment WHERE sid = #{sid} AND uid = #{uid}")
    void deleteScoresCommentBySidAndUid(Long sid, Long uid);

}
