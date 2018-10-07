package com.vklochkov.resources;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.ds.InfoDS;
import com.vklochkov.model.Info;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class InfoResource {
    private InfoDS infoDS;

    public InfoResource () {
        this.infoDS = new InfoDS();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InfoBean getInfo () {
        Info info = this.infoDS.getInfo();
        return new InfoBean(info.getShopName(), info.getFoundationDate(), info.getAuthor(), info.getAbout());
    }
}
