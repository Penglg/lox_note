package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ApprovalProvider extends SQL {

    public String updateApproval(@Param("approval") Approval approval) {
        return new SQL() {{
            UPDATE("approval");

            if (!EmptyCheckerUtil.isStringEmpty(approval.getContent())) {
                SET("content = #{approval.content}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(approval.getResult())) {
                SET("result = #{approval.result}");
            }
            WHERE("id = #{approval.id}");
        }}.toString();
    }

}
