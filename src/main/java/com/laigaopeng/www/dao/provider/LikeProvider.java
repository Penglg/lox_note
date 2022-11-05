package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Like;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class LikeProvider extends SQL {

    public String deleteLike(@Param("like")Like like) {
        return new SQL() {{
            DELETE_FROM("`like`");

            if (!EmptyCheckerUtil.isIntegerEmpty(like.getId())) {
                WHERE ("id = #{like.id}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(like.getNoteId())) {
                WHERE ("note_id = #{like.noteId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(like.getUserId())) {
                WHERE ("user_id = #{like.userId}");
            }
        }}.toString();
    }

    public String getLike(@Param("like")Like like) {
        return new SQL() {{
            SELECT("*");
            FROM("`like`");

            if (!EmptyCheckerUtil.isIntegerEmpty(like.getId())) {
                WHERE("id = #{like.id}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(like.getUserId())) {
                WHERE("user_id = #{like.userId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(like.getNoteId())) {
                WHERE("note_id = #{like.noteId}");
            }
        }}.toString();
    }
}
