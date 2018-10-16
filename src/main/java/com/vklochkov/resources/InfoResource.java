package com.vklochkov.resources;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.dao.InfoDAO;
import com.vklochkov.dao.InfoDAOImpl;
import com.vklochkov.ds.InfoDS;

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
        return this.infoDAO.getInfo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InfoBean saveInfo(InfoBean info) {
        return this.infoDAO.saveInfo(info);
    }
}
