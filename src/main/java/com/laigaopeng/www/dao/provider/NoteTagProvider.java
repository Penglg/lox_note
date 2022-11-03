package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.NoteTag;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class NoteTagProvider extends SQL {

    public String updateNoteTag(@Param("noteTag")NoteTag noteTag) {
        return new SQL() {{
            UPDATE("note_tag");

            if (!EmptyCheckerUtil.isIntegerEmpty(noteTag.getTagId())) {
                SET("tag_id = #{noteTag.tagId}");
            }
            WHERE("id = #{noteTag.id}");
        }}.toString();
    }

    public String deleteNoteTag(@Param("noteTag") NoteTag noteTag) {
        return new SQL() {{
            DELETE_FROM("note_tag");

            if (!EmptyCheckerUtil.isIntegerEmpty(noteTag.getNoteId())) {
                WHERE("id = #{noteTag.id}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(noteTag.getNoteId())) {
                WHERE("note_id = #{noteTag.noteId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(noteTag.getTagId())) {
                WHERE("tag_id = #{noteTag.tagId}");
            }
        }}.toString();
    }
}
