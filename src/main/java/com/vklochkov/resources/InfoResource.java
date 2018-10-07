package com.vklochkov.resources;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.dao.InfoDAO;
import com.vklochkov.dao.InfoDAOImpl;
import com.vklochkov.model.Info;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("/info")
public class InfoResource {
    private InfoDAO infoDAO;

    public InfoResource () throws SQLException {
        this.infoDAO = new InfoDAOImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InfoBean getInfo () {
        Info info = this.infoDAO.getInfo();
        return new InfoBean(info.getShopName(), info.getFoundationDate(), info.getAuthor(), info.getAbout());
    }
}
