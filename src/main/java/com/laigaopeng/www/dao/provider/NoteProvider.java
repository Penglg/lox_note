package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class NoteProvider extends SQL {

    public String updateNote(@Param("note") Note note) {
        return new SQL() {{
            UPDATE("note");

            if (!EmptyCheckerUtil.isStringEmpty(note.getTitle())) {
                SET("title = #{note.tile}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(note.getContent())) {
                SET("content = #{note.content}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(note.getLikes())) {
                SET("likes = #{note.likes}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(note.getCollect())) {
                SET("collect = #{note.collect}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(note.getSectionId())) {
                SET("section_id = #{note.sectionId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(note.getLegal())) {
                SET("legal = #{not.legal}");
            }
            WHERE("id = #{note.id}");
        }}.toString();
    }

    public String listNote(@Param("sectionId") Integer sectionId, @Param("legal")Integer legal) {
        return new SQL() {{
            SELECT("*");
            FROM("account");
            if (!EmptyCheckerUtil.isIntegerEmpty(sectionId)) {
                WHERE("section_id = #{sectionId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(legal)) {
                WHERE ("legal = #{legal}");
            }
        }}.toString();
    }
}
