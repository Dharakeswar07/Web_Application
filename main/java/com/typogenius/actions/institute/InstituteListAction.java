package com.typogenius.actions.institute;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.InstituteDAO;
import com.typogenius.models.Institute;
import org.apache.struts2.json.annotations.JSON;

public class InstituteListAction extends ActionSupport {

    private List<Institute> instituteList;
    private Institute institute;
    private String id;

    @Override
    public String execute() {
        instituteList = InstituteDAO.getInstance().getInstituteList();
        return SUCCESS;
    }

    public String getInstituteDetails() {
        if (id != null && !id.isEmpty()) {
            institute = InstituteDAO.getInstance().getInstituteById(id);
        }
        return SUCCESS;
    }

    @JSON
    public List<Institute> getInstituteList() {
        return instituteList;
    }

    @JSON
    public Institute getInstitute() {
        return institute;
    }

    public void setId(String id) {
        this.id = id;
    }
}
