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
                SET("title = #{note.title}");
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
                SET("legal = #{note.legal}");
            }
            WHERE("id = #{note.id}");
        }}.toString();
    }

    public String listNote(@Param("sectionId") Integer sectionId, @Param("legal")Integer legal, @Param("begin")
            Integer begin, @Param("pageSize")Integer pageSize) {
        return new SQL() {{
            SELECT("*");
            FROM("note");
            if (!EmptyCheckerUtil.isIntegerEmpty(sectionId)) {
                WHERE("section_id = #{sectionId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(legal)) {
                WHERE ("legal = #{legal}");
            }
            LIMIT("#{begin}, #{pageSize}");
        }}.toString();
    }

    public String countNote(@Param("note") Note note) {
        return new SQL() {{
            SELECT("count(*)");
            FROM("note");
            if (!EmptyCheckerUtil.isIntegerEmpty((note.getSectionId()))) {
                WHERE("section_id = #{note.sectionId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty((note.getLegal()))) {
                WHERE("legal = #{note.legal}");
            }
        }}.toString();
    }
}
