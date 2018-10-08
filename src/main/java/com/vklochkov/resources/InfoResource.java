package com.vklochkov.resources;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.dao.InfoDAO;
import com.vklochkov.dao.InfoDAOImpl;
import com.vklochkov.ds.InfoDS;
import com.vklochkov.model.Info;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class InfoResource {
    private InfoDAO infoDAO;

    public InfoResource () {
        this.infoDAO = new InfoDAOImpl(new InfoDS());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InfoBean getInfo () {
        Info info = this.infoDAO.getInfo();
        return new InfoBean(info.getShopName(), info.getFoundationDate(), info.getAuthor(), info.getAbout());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InfoBean saveInfo(Info info) {
        Info savedInfo = this.infoDAO.saveInfo(info);
        return new InfoBean(savedInfo.getShopName(), savedInfo.getFoundationDate(), savedInfo.getAuthor(), savedInfo.getAbout());
    }
}
