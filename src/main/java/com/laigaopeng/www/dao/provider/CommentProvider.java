package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Comment;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CommentProvider extends SQL {

    public String deleteComment(@Param("comment")Comment comment) {
        return new SQL() {{
            DELETE_FROM("comment");

            if (EmptyCheckerUtil.isIntegerEmpty(comment.getId())) {
                WHERE("id = #{comment.id}");
            }
            if (EmptyCheckerUtil.isIntegerEmpty(comment.getNoteId())) {
                WHERE("note_id = #{comment.noteId}");
            }
            if (EmptyCheckerUtil.isIntegerEmpty(comment.getUserId())) {
                WHERE("user_id = #{comment.userId}");
            }
        }}.toString();
    }
}
