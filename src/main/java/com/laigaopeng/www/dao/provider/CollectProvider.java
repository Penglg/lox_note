package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Collect;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CollectProvider extends SQL {

    public String deleteCollect(@Param("collect")Collect collect) {
        return new SQL() {{
            DELETE_FROM("collect");
            if (!EmptyCheckerUtil.isIntegerEmpty(collect.getId())) {
                WHERE("id = #{collect.id}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(collect.getNoteId())) {
                WHERE("note_id = #{collect.noteId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(collect.getUserId())) {
                WHERE("user_id = #{collect.userId}");
            }
        }}.toString();
    }
}
